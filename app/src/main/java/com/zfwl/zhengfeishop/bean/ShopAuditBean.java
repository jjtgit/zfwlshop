package com.zfwl.zhengfeishop.bean;

import java.util.List;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:
 */
public class ShopAuditBean {

    /**
     * msg : success
     * total : 2
     * code : 0
     * rows : [{"searchValue":null,"createBy":null,"createTime":1509790861,"updateBy":null,"updateTime":null,"remark":null,"beginTime":null,"endTime":null,"params":{},"pageNum":null,"pageSize":null,"orderByColumn":null,"goodsId":303,"goodsName":"戴尔（DELL）灵越 13-7370-R1505S 13.3英寸轻薄笔记本电脑（i5-8250U 8G 128G","sn":"0080","brandId":152,"categoryId":494,"goodsType":"NORMAL","weight":2110,"marketEnable":1,"intro":"<p><img src=\"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/01A330BD121741EC8268C5F02F2DA31E.jpg\" title=\"show.jpg\" alt=\"show.jpg\"><img src=\"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/1AEA2E0153B04FAEAA196F185D0AA0E5.jpg\" title=\"show.jpg\" alt=\"show.jpg\"><img src=\"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/A659AB82541448A799C5E651AFAC1238.jpg\" title=\"show.jpg\" alt=\"show.jpg\"><\/p>","price":6099,"cost":3000,"mktprice":6804,"haveSpec":0,"lastModify":1535700218,"viewCount":0,"buyCount":1,"disabled":1,"quantity":99,"enableQuantity":99,"point":0,"pageTitle":"戴尔（DELL）灵越 13-7370-R1505S 13.3英寸轻薄笔记本电脑（i5-8250U 8G 128G","metaKeywords":"戴尔（DELL）灵越 13-7370-R1505S 13.3英寸轻薄笔记本电脑（i5-8250U 8G 128G","metaDescription":"戴尔（DELL）灵越 13-7370-R1505S 13.3英寸轻薄笔记本电脑（i5-8250U 8G 128G","grade":100,"thumbnail":"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/D3EF5E6F04074EE2A8A8C761BDDA2036.jpg_300x300","big":"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/D3EF5E6F04074EE2A8A8C761BDDA2036.jpg_800x800","small":"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/D3EF5E6F04074EE2A8A8C761BDDA2036.jpg_400x400","original":"http://javashop-statics.oss-cn-beijing.aliyuncs.com/demo/D3EF5E6F04074EE2A8A8C761BDDA2036.jpg","sellerId":18,"shopCatId":32,"commentNum":0,"templateId":0,"goodsTransfeeCharge":1,"sellerName":"数码家电","isAuth":0,"authMessage":null,"selfOperated":0,"underMessage":null,"priority":1},{"searchValue":null,"createBy":null,"createTime":1586399070,"updateBy":null,"updateTime":null,"remark":null,"beginTime":null,"endTime":null,"params":{},"pageNum":null,"pageSize":null,"orderByColumn":null,"goodsId":335,"goodsName":"asd","sn":"1123123","brandId":3,"categoryId":6,"goodsType":"NORMAL","weight":0.5,"marketEnable":1,"intro":"","price":19,"cost":10,"mktprice":19,"haveSpec":0,"lastModify":1586399070,"viewCount":0,"buyCount":0,"disabled":1,"quantity":100,"enableQuantity":100,"point":null,"pageTitle":"asd","metaKeywords":"asd","metaDescription":"asd","grade":100,"thumbnail":"http://localhost:7000/statics/attachment/goods/2020/4/9/10/24198153.png_300x300.png","big":"http://localhost:7000/statics/attachment/goods/2020/4/9/10/24198153.png_800x800.png","small":"http://localhost:7000/statics/attachment/goods/2020/4/9/10/24198153.png_400x400.png","original":"http://localhost:7000/statics/attachment/goods/2020/4/9/10/24198153.png","sellerId":15,"shopCatId":2,"commentNum":0,"templateId":0,"goodsTransfeeCharge":1,"sellerName":"食品酒水","isAuth":0,"authMessage":null,"selfOperated":0,"underMessage":null,"priority":1}]
     * pageNum : 1
     */

    private String msg;
    private int total;
    private int code;
    private int pageNum;
    private List<RowsBean> rows;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {


        private Object searchValue;
        private Object createBy;
        private int createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private Object beginTime;
        private Object endTime;
        private ParamsBean params;
        private Object pageNum;
        private Object pageSize;
        private Object orderByColumn;
        private int goodsId;
        private String goodsName;
        private String sn;
        private int brandId;
        private int categoryId;
        private String goodsType;
        private int weight;
        private int marketEnable;
        private String intro;
        private int price;
        private int cost;
        private int mktprice;
        private int haveSpec;
        private int lastModify;
        private int viewCount;
        private int buyCount;
        private int disabled;
        private int quantity;
        private int enableQuantity;
        private int point;
        private String pageTitle;
        private String metaKeywords;
        private String metaDescription;
        private int grade;
        private String thumbnail;
        private String big;
        private String small;
        private String original;
        private int sellerId;
        private int shopCatId;
        private int commentNum;
        private int templateId;
        private int goodsTransfeeCharge;
        private String sellerName;
        private int isAuth;
        private Object authMessage;
        private int selfOperated;
        private Object underMessage;
        private int priority;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(Object beginTime) {
            this.beginTime = beginTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public Object getPageNum() {
            return pageNum;
        }

        public void setPageNum(Object pageNum) {
            this.pageNum = pageNum;
        }

        public Object getPageSize() {
            return pageSize;
        }

        public void setPageSize(Object pageSize) {
            this.pageSize = pageSize;
        }

        public Object getOrderByColumn() {
            return orderByColumn;
        }

        public void setOrderByColumn(Object orderByColumn) {
            this.orderByColumn = orderByColumn;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getMarketEnable() {
            return marketEnable;
        }

        public void setMarketEnable(int marketEnable) {
            this.marketEnable = marketEnable;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getMktprice() {
            return mktprice;
        }

        public void setMktprice(int mktprice) {
            this.mktprice = mktprice;
        }

        public int getHaveSpec() {
            return haveSpec;
        }

        public void setHaveSpec(int haveSpec) {
            this.haveSpec = haveSpec;
        }

        public int getLastModify() {
            return lastModify;
        }

        public void setLastModify(int lastModify) {
            this.lastModify = lastModify;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public int getBuyCount() {
            return buyCount;
        }

        public void setBuyCount(int buyCount) {
            this.buyCount = buyCount;
        }

        public int getDisabled() {
            return disabled;
        }

        public void setDisabled(int disabled) {
            this.disabled = disabled;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getEnableQuantity() {
            return enableQuantity;
        }

        public void setEnableQuantity(int enableQuantity) {
            this.enableQuantity = enableQuantity;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public String getPageTitle() {
            return pageTitle;
        }

        public void setPageTitle(String pageTitle) {
            this.pageTitle = pageTitle;
        }

        public String getMetaKeywords() {
            return metaKeywords;
        }

        public void setMetaKeywords(String metaKeywords) {
            this.metaKeywords = metaKeywords;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public int getShopCatId() {
            return shopCatId;
        }

        public void setShopCatId(int shopCatId) {
            this.shopCatId = shopCatId;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public int getTemplateId() {
            return templateId;
        }

        public void setTemplateId(int templateId) {
            this.templateId = templateId;
        }

        public int getGoodsTransfeeCharge() {
            return goodsTransfeeCharge;
        }

        public void setGoodsTransfeeCharge(int goodsTransfeeCharge) {
            this.goodsTransfeeCharge = goodsTransfeeCharge;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public int getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(int isAuth) {
            this.isAuth = isAuth;
        }

        public Object getAuthMessage() {
            return authMessage;
        }

        public void setAuthMessage(Object authMessage) {
            this.authMessage = authMessage;
        }

        public int getSelfOperated() {
            return selfOperated;
        }

        public void setSelfOperated(int selfOperated) {
            this.selfOperated = selfOperated;
        }

        public Object getUnderMessage() {
            return underMessage;
        }

        public void setUnderMessage(Object underMessage) {
            this.underMessage = underMessage;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public static class ParamsBean {
        }
    }
}
