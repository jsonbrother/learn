package com.priv.controller;

import com.alibaba.excel.event.AnalysisEventListener;
import com.priv.listener.BaseExcelListener;
import com.priv.model.RightDetail;
import com.priv.service.IBaseBatchService;
import com.priv.util.JsonUtils;
import com.priv.util.excel.EasyExcelUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Json
 * @date 2021/2/24 22:54
 */
@RestController
@RequestMapping("/easy/excel")
public class DemoExcelController {

    private final IBaseBatchService baseBatchService;

    @Autowired
    public DemoExcelController(IBaseBatchService baseBatchService) {
        this.baseBatchService = baseBatchService;
    }

    /**
     * 同步读取
     */
    @GetMapping("/syncRead")
    public String syncRead(@RequestParam String filePath) {

        String fileName = "E:\\tmp\\excel-file\\" + filePath;
        List<RightDetail> list = EasyExcelUtil.syncReadModel(fileName, RightDetail.class);

        return JsonUtils.objectToJson(list);
    }

    /**
     * 异步读取
     */
    @GetMapping("/asyncRead")
    public String asyncRead(@RequestParam String filePath) {

        String fileName = "E:\\tmp\\excel-file\\" + filePath;
        AnalysisEventListener<T> listener = new BaseExcelListener<>(baseBatchService);
        EasyExcelUtil.asyncReadModel(fileName, listener, RightDetail.class);

        return "success";
    }

    /*@GetMapping("/write")
    public void writeTemplate() {
        EasyExcelUtil.writeWithSheets("")
                .writeModel(Object.class, null, "")
                .write(null, null, "")
                .finish();
    }*/


    /**
     * 模板下载
     */
    @GetMapping("/write")
    public void writeTemplate(HttpServletRequest request) {
        String templateFileName = "E:\\tmp\\excel-file\\模板\\权益明细报表模板.xlsx";

        String filePath = "C:\\Users\\Json\\Downloads\\（下载）权益明细报表.xlsx";
        // EasyExcelUtil.write(filePath, RightDetail.class, getList(), 0, "sheet1");
        EasyExcelUtil.writeTemplate(filePath, templateFileName, getList());
    }

    /**
     * 获得输出流对象
     *
     * @param fileName 文件名称
     * @param response 响应对象
     * @return 输出流
     * @throws Exception 异常信息
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response)
            throws Exception {
        try {
            fileName = URLEncoder.encode(fileName, "utf-8");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            //此处指定了文件类型为xls，如果是xls的，请自行替换修改
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e) {
            throw new Exception("导出文件失败！");
        }
    }

    private List<RightDetail> getList() {
        // 模拟数据从excel中先读取
        String fileName = "E:\\tmp\\excel-file\\权益明细报表.xlsx";
        return EasyExcelUtil.syncReadModel(fileName, RightDetail.class);
    }
}
