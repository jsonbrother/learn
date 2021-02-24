package com.priv.model;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author Json
 * @date 2021/2/24 22:55
 */
public class RightDetail {

    @ExcelProperty(index = 0)
    private String rightDetailCode;

    @ExcelProperty(index = 1)
    private String rightDetailName;

    @ExcelProperty(index = 2)
    private String rightDetailShortName;

    @ExcelProperty(index = 3)
    private String price;

    @ExcelProperty(index = 4)
    private String companyName;

    public String getRightDetailCode() {
        return rightDetailCode;
    }

    public void setRightDetailCode(String rightDetailCode) {
        this.rightDetailCode = rightDetailCode;
    }

    public String getRightDetailName() {
        return rightDetailName;
    }

    public void setRightDetailName(String rightDetailName) {
        this.rightDetailName = rightDetailName;
    }

    public String getRightDetailShortName() {
        return rightDetailShortName;
    }

    public void setRightDetailShortName(String rightDetailShortName) {
        this.rightDetailShortName = rightDetailShortName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "RightDetail{" +
                "rightDetailCode='" + rightDetailCode + '\'' +
                ", rightDetailName='" + rightDetailName + '\'' +
                ", rightDetailShortName='" + rightDetailShortName + '\'' +
                ", price='" + price + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

}
