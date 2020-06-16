package com.zfwl.zhengfeishop.bean;

/**
 * Created by 修梦 on 2020/6/9.
 * Describe:收藏的店铺的adapter
 */
public class StoreAdapterBean {
    public String nameShopStore;
    public String attentionStore;
    private String labelStore1;
    public String labelStore2;
    public boolean isSelect;

    public String getNameShopStore() {
        return nameShopStore;
    }

    public void setNameShopStore(String nameShopStore) {
        this.nameShopStore = nameShopStore;
    }

    public String getAttentionStore() {
        return attentionStore;
    }

    public void setAttentionStore(String attentionStore) {
        this.attentionStore = attentionStore;
    }

    public String getLabelStore1() {
        return labelStore1;
    }

    public void setLabelStore1(String labelStore1) {
        this.labelStore1 = labelStore1;
    }

    public String getLabelStore2() {
        return labelStore2;
    }

    public void setLabelStore2(String labelStore2) {
        this.labelStore2 = labelStore2;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
