package com.priv.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.metadata.CellData;
import com.priv.service.IBaseBatchService;
import com.priv.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Json
 * @date 2021/2/1 15:32
 */
public class BaseExcelListener<T> extends AnalysisEventListener<T> {

    private final static Logger logger = LoggerFactory.getLogger(BaseExcelListener.class);

    private final IBaseBatchService baseService;

    /**
     * 注意BaseExcelListener不能被spring管理
     * 所以每次创建Listener的时候需要把spring管理的类传进来
     */
    public BaseExcelListener(IBaseBatchService baseService) {
        this.baseService = baseService;
    }

    /**
     * 如果数据量过大 可分批次读取保存
     * 每次读取100条数据就进行保存操作
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 数据存储集合对象
     * 由于每次读都是新 new BaseExcelListener() 所以这个list不会存在线程安全问题
     */
    private final List<T> rows = new ArrayList<>();

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        logger.info("解析到一条头数据:{}", JsonUtils.objectToJson(headMap));
    }

    @Override
    public void invoke(T data, AnalysisContext analysisContext) {
        logger.info("解析到一条数据:{}", JsonUtils.objectToJson(data));
        rows.add(data);

        // 实际数据量比较大时 rows里的数据可以存到一定量之后进行批量处理
        // 然后清空列表 以防止内存占用过多造成OOM
        if (rows.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            rows.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        logger.info("所有数据解析完成！");
    }

    /**
     * @param exception 具体异常
     * @param context   分析上下文
     * @throws Exception 异常信息
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        logger.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException) exception;
            logger.error("第{}行，第{}列解析异常，数据为:{}", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex(), excelDataConvertException.getCellData());
        }
    }

    public void saveData() {
        logger.info("{}条数据，开始存储数据库！", rows.size());

        //保存数据 调用具体service方法 建议:service为批处理
        baseService.batchSaveData(rows);

        logger.info("存储数据库成功！");
    }
}
