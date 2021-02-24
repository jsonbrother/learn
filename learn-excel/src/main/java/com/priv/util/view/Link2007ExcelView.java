package com.priv.util.view;

import com.priv.util.excel.EasyExcelUtil;

/**
 * 多sheet多列表组合填充视图 链式模式
 *
 * @author Json
 * @date 2021/2/24 22:59
 */
public class Link2007ExcelView extends BaseExcelView {

    public static void main(String[] args) {

        // 文件名称
        String fileName = FILE_PATH + "link" + System.currentTimeMillis() + ".xlsx";

        // 自定义工厂 链式填充
        EasyExcelUtil.writeWithSheets(fileName, TEMPLATE_FILE_NAME)
                .writeTemplate(getHeadMap())
                .writeTemplate("fs", queryFinStatsVOList())
                .writeTemplateNext()
                .writeTemplate("fsd", queryFinStatsDtlVOList())
                .finish();

    }
}
