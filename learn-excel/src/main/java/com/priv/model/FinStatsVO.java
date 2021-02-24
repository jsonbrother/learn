package com.priv.model;

/**
 * @author Json
 * @date 2021/2/24 22:55
 */
public class FinStatsVO {

    private String orderType;
    private String orderSource;
    private String productName;
    private String attractions;
    private String incomeNum;
    private String incomeAmount;
    private String refundNum;
    private String refundAmount;
    private String outcomeNum;
    private String outcomeAmount;
    private String realizeProfit;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAttractions() {
        return attractions;
    }

    public void setAttractions(String attractions) {
        this.attractions = attractions;
    }

    public String getIncomeNum() {
        return incomeNum;
    }

    public void setIncomeNum(String incomeNum) {
        this.incomeNum = incomeNum;
    }

    public String getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getOutcomeNum() {
        return outcomeNum;
    }

    public void setOutcomeNum(String outcomeNum) {
        this.outcomeNum = outcomeNum;
    }

    public String getOutcomeAmount() {
        return outcomeAmount;
    }

    public void setOutcomeAmount(String outcomeAmount) {
        this.outcomeAmount = outcomeAmount;
    }

    public String getRealizeProfit() {
        return realizeProfit;
    }

    public void setRealizeProfit(String realizeProfit) {
        this.realizeProfit = realizeProfit;
    }

    @Override
    public String toString() {
        return "FinStatsVO{" +
                "orderType='" + orderType + '\'' +
                ", orderSource='" + orderSource + '\'' +
                ", productName='" + productName + '\'' +
                ", attractions='" + attractions + '\'' +
                ", incomeNum='" + incomeNum + '\'' +
                ", incomeAmount='" + incomeAmount + '\'' +
                ", refundNum='" + refundNum + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", outcomeNum='" + outcomeNum + '\'' +
                ", outcomeAmount='" + outcomeAmount + '\'' +
                ", realizeProfit='" + realizeProfit + '\'' +
                '}';
    }
}
