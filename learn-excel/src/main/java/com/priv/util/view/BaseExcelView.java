package com.priv.util.view;

import com.priv.model.FinStatsDtlVO;
import com.priv.model.FinStatsVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Json
 * @date 2021/2/24 22:59
 */
public class BaseExcelView {

    /**
     * 视图模板地址
     */
    static final String TEMPLATE_FILE_NAME = "E:\\tmp\\excel-file\\模板\\99财务视图模板.xlsx";

    /**
     * 文件下载地址
     */
    static final String FILE_PATH = "E:\\tmp\\excel-file\\";


    /**
     * 模拟测试表头数据
     */
    static Map<String, Object> getHeadMap() {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("startData", "20200901");
        map.put("endData", "20201130");
        map.put("companyName", "上海都市旅游卡公司");
        return map;
    }

    /**
     * 模拟测试财务统计数据
     */
    static List<FinStatsVO> queryFinStatsVOList() {
        List<FinStatsVO> list = new ArrayList<>();

        FinStatsVO vo1 = new FinStatsVO();
        vo1.setOrderType("城市订单");
        vo1.setOrderSource("金华");
        vo1.setProductName("99玩上海年卡");
        vo1.setAttractions("上海_黄浦江游览快线");
        vo1.setIncomeNum("4");
        vo1.setIncomeAmount("366");
        vo1.setRefundNum("0");
        vo1.setRefundAmount("0");
        vo1.setOutcomeNum("4");
        vo1.setOutcomeAmount("160");
        vo1.setRealizeProfit("176");
        list.add(vo1);

        FinStatsVO vo2 = new FinStatsVO();
        vo2.setOrderType("城市订单");
        vo2.setOrderSource("金华");
        vo2.setProductName("99玩上海年卡");
        vo2.setAttractions("爱文艺1_长三角PASS1_总权益");
        vo2.setIncomeNum("0");
        vo2.setIncomeAmount("0");
        vo2.setRefundNum("0");
        vo2.setRefundAmount("0");
        vo2.setOutcomeNum("2");
        vo2.setOutcomeAmount("80");
        vo2.setRealizeProfit("-80");
        list.add(vo2);

        FinStatsVO vo3 = new FinStatsVO();
        vo3.setOrderType("城市订单");
        vo3.setOrderSource("南通");
        vo3.setProductName("99玩金华年卡");
        vo3.setAttractions("上海_结算_金华总权益99");
        vo3.setIncomeNum("4");
        vo3.setIncomeAmount("366");
        vo3.setRefundNum("0");
        vo3.setRefundAmount("0");
        vo3.setOutcomeNum("4");
        vo3.setOutcomeAmount("320");
        vo3.setRealizeProfit("16");
        list.add(vo3);

        return list;
    }

    /**
     * 模拟测试财务明细数据
     */
    static List<FinStatsDtlVO> queryFinStatsDtlVOList() {
        List<FinStatsDtlVO> list = new ArrayList<>();

        FinStatsDtlVO vo1 = new FinStatsDtlVO();
        vo1.setOrderType("城市订单");
        vo1.setOrderCode("jinhua-E000000160074536726070");
        vo1.setProductName("99玩上海年卡");
        vo1.setRightCode("LVYOUKAAWY003B9AE151");
        vo1.setSendTime("20201007125557");
        vo1.setAmount("84");
        vo1.setHolderName("王一楠");
        vo1.setContactTel("135*****901");
        vo1.setHolderIcon("33088*********9326");
        list.add(vo1);

        FinStatsDtlVO vo2 = new FinStatsDtlVO();
        vo2.setOrderType("城市订单");
        vo2.setOrderCode("jinhua-E000000160074536726071");
        vo2.setProductName("99玩上海年卡");
        vo2.setRightCode("LVYOUKAAWY003B9AE152");
        vo2.setSendTime("20201007125941");
        vo2.setAmount("84");
        vo2.setHolderName("王立水");
        vo2.setContactTel("138*****848");
        vo2.setHolderIcon("33082*********4515");
        list.add(vo2);

        FinStatsDtlVO vo3 = new FinStatsDtlVO();
        vo3.setOrderType("城市订单");
        vo3.setOrderCode("jinhua-E000000160074536726072");
        vo3.setProductName("99玩上海年卡");
        vo3.setRightCode("LVYOUKAAWY003B9AE153");
        vo3.setSendTime("20201007130114");
        vo3.setAmount("84");
        vo3.setHolderName("无名");
        vo3.setContactTel("137*****023");
        vo3.setHolderIcon("52252*********0020");
        list.add(vo3);

        FinStatsDtlVO vo4 = new FinStatsDtlVO();
        vo4.setOrderType("城市订单");
        vo4.setOrderCode("jinhua-E000000160082761447939");
        vo4.setProductName("99玩上海年卡");
        vo4.setRightCode("LVYOUKAAWY003B9ADCA0");
        vo4.setSendTime("20200923161713");
        vo4.setAmount("84");
        vo4.setHolderName("项毓飞");
        vo4.setContactTel("188*****597");
        vo4.setHolderIcon("33078*********1841");
        list.add(vo4);

        return list;
    }
}
