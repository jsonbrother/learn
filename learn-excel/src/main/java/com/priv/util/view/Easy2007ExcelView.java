package com.priv.util.view;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;

/**
 * 多sheet多列表组合填充视图
 *
 * @author Json
 * @date 2021/2/24 22:59
 */
public class Easy2007ExcelView extends BaseExcelView {


    public static void main(String[] args) {

        // 文件名称
        String fileName = FILE_PATH + "easy" + System.currentTimeMillis() + ".xlsx";
        // 定义excel文件
        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(TEMPLATE_FILE_NAME).build();
        // 定义填写配置 （垂直:VERTICAL 水平:HORIZONTAL） 默认垂直
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();

        // 填充第一页财务统计数据
        WriteSheet sheetOne = EasyExcel.writerSheet(0).build();
        excelWriter.fill(getHeadMap(), sheetOne);
        excelWriter.fill(new FillWrapper("fs", queryFinStatsVOList()), sheetOne);

        // 填充第二页财务明细数据
        WriteSheet sheetTwo = EasyExcel.writerSheet(1).build();
        excelWriter.fill(new FillWrapper("fsd", queryFinStatsDtlVOList()), sheetTwo);

        // 关闭流
        excelWriter.finish();
    }

}
