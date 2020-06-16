package com.zfwl.zhengfeishop.bean;

/**
 * Created by 修梦 on 2020/6/9.
 * Describe:我的收藏商品的bean
 */
public class CollectShopBean {
    public String nameShop;
    public String subtractCollect;
    public String priceCollect;
    public boolean isSelect;


    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }


    public String getSubtractCollect() {
        return subtractCollect;
    }

    public void setSubtractCollect(String subtractCollect) {
        this.subtractCollect = subtractCollect;
    }

    public String getPriceCollect() {
        return priceCollect;
    }

    public void setPriceCollect(String priceCollect) {
        this.priceCollect = priceCollect;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
