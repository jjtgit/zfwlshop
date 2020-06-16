package com.zfwl.zhengfeishop.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/22.
 * Describe:分类侧换的数据
 */
public class ClassSideslipBean {
    private List<DatasBean> datas;

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements Serializable {
        /**
         * id : 56
         * showName : 清新
         */

        private String id;
        private String showName;
        private boolean chick;   //标识

        public boolean isChick() {
            return chick;
        }

        public void setChick(boolean chick) {
            this.chick = chick;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShowName() {
            return showName;
        }

        public void setShowName(String showName) {
            this.showName = showName;
        }
    }
}
