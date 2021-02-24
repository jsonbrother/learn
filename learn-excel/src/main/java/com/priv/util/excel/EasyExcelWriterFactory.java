package com.priv.util.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.fill.FillWrapper;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

/**
 * 自定义EasyExcel写工厂
 *
 * @author Json
 * @date 2021/2/24 22:59
 */
public class EasyExcelWriterFactory {

    private int sheetNo = 0;
    private ExcelWriter excelWriter = null;

    public EasyExcelWriterFactory(OutputStream outputStream) {
        excelWriter = EasyExcel.write(outputStream).build();
    }

    public EasyExcelWriterFactory(File file) {
        excelWriter = EasyExcel.write(file).build();
    }

    public EasyExcelWriterFactory(String filePath) {
        excelWriter = EasyExcel.write(filePath).build();
    }

    public EasyExcelWriterFactory(String filePath, String templateFileName) {
        excelWriter = EasyExcel.write(filePath).withTemplate(templateFileName).build();
    }

    /**
     * 链式模板表头写入
     *
     * @param headClazz 表头格式
     * @param data      数据 List<ExcelModel> 或者List<List<Object>>
     * @return 自定义工厂
     */
    public EasyExcelWriterFactory writeModel(Class headClazz, List data, String sheetName) {
        excelWriter.write(data, EasyExcel.writerSheet(this.sheetNo++, sheetName).head(headClazz).build());
        return this;
    }

    /**
     * 链式自定义表头写入
     *
     * @param head      表头
     * @param data      数据 List<ExcelModel> 或者List<List<Object>>
     * @param sheetName 页名称
     * @return 自定义工厂
     */
    public EasyExcelWriterFactory write(List<List<String>> head, List data, String sheetName) {
        excelWriter.write(data, EasyExcel.writerSheet(this.sheetNo++, sheetName).head(head).build());
        return this;
    }

    /**
     * 链式excel模板多列表填充
     *
     * @param data 数据 List<ExcelModel> 或者List<List<Object>> 或者 Map<Object,Object>
     * @return 自定义工厂
     */
    public EasyExcelWriterFactory writeTemplate(Object data) {
        excelWriter.fill(data, EasyExcel.writerSheet(this.sheetNo).build());
        return this;
    }

    /**
     * 链式excel模板多列表填充
     *
     * @param key  列表数据取值前缀
     * @param data 数据 List<ExcelModel> 或者List<List<Object>>
     * @return 自定义工厂
     */
    public EasyExcelWriterFactory writeTemplate(String key, List data) {
        excelWriter.fill(new FillWrapper(key, data), EasyExcel.writerSheet(this.sheetNo).build());
        return this;
    }

    /**
     * 链式excel模板填充下一页
     *
     * @return 自定义工厂
     */
    public EasyExcelWriterFactory writeTemplateNext() {
        this.sheetNo++;
        return this;
    }


    public void finish() {
        excelWriter.finish();
    }

}
