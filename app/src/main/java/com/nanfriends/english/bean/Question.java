package com.nanfriends.english.bean;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Question extends Base{

    @SerializedName("data")
    private List<DataBean> dataX;

    public List<DataBean> getDataX() {
        return dataX;
    }

    public void setDataX(List<DataBean> dataX) {
        this.dataX = dataX;
    }

    public static class DataBean  implements Serializable {
        /**
         * id : 16
         * level : 1
         * path : upload/475201eaace3a8893a5ebaea210d30e3.jpg
         * time : 1540624758891
         * title : 23123
         * tx : 1
         */

        private int id;
        private int level;
        private String path;
        private long time;
        private String title;
        private int tx;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTx() {
            return tx;
        }

        public void setTx(int tx) {
            this.tx = tx;
        }
    }
}
