package com.nanfriends.english.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SProblem extends Base {

    @SerializedName("data")
    private List<DataBean> dataX;

    public List<DataBean> getDataX() {
        return dataX;
    }

    public void setDataX(List<DataBean> dataX) {
        this.dataX = dataX;
    }

    public static class DataBean implements Serializable {
        /**
         * a : a
         * addtime : 1540602602162
         * answer : qweq
         * b : b
         * c : c
         * d : d
         * id : 1
         * jiexi : ewqe
         * level : 0
         * question : eqwe
         * tid : 9
         * tx : 0
         */

        private String a;
        private String addtime;
        private String answer;
        private String b;
        private String c;
        private String d;
        private int id;
        private String jiexi;
        private int level;
        private String question;
        private int tid;
        private int tx;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJiexi() {
            return jiexi;
        }

        public void setJiexi(String jiexi) {
            this.jiexi = jiexi;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getTx() {
            return tx;
        }

        public void setTx(int tx) {
            this.tx = tx;
        }
    }
}
