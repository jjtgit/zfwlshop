package com.zfwl.zhengfeishop.bean;

/**
 * Created by 修梦 on 2020/6/8.
 * Describe:Eventbus实体类
 */
public class SiteEventBean {
    private String namesite;
    private String cellphonesite;
    private String titlesite;

    public SiteEventBean(String namesite, String cellphonesite, String titlesite) {
        this.namesite = namesite;
        this.cellphonesite = cellphonesite;
        this.titlesite = titlesite;
    }

    public String getNamesite() {
        return namesite;
    }

    public void setNamesite(String namesite) {
        this.namesite = namesite;
    }

    public String getCellphonesite() {
        return cellphonesite;
    }

    public void setCellphonesite(String cellphonesite) {
        this.cellphonesite = cellphonesite;
    }

    public String getTitlesite() {
        return titlesite;
    }

    public void setTitlesite(String titlesite) {
        this.titlesite = titlesite;
    }
}
