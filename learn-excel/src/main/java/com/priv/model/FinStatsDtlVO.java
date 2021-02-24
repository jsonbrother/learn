package com.priv.model;

/**
 * @author Json
 * @date 2021/2/24 22:55
 */
public class FinStatsDtlVO {

    private String orderType;
    private String orderCode;
    private String productName;
    private String rightCode;
    private String sendTime;
    private String amount;
    private String holderName;
    private String contactTel;
    private String holderIcon;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getHolderIcon() {
        return holderIcon;
    }

    public void setHolderIcon(String holderIcon) {
        this.holderIcon = holderIcon;
    }

    @Override
    public String toString() {
        return "FinStatsDtlVO{" +
                "orderType='" + orderType + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", productName='" + productName + '\'' +
                ", rightCode='" + rightCode + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", amount='" + amount + '\'' +
                ", holderName='" + holderName + '\'' +
                ", contactTel='" + contactTel + '\'' +
                ", holderIcon='" + holderIcon + '\'' +
                '}';
    }

}
