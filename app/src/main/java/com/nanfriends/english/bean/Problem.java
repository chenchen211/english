package com.nanfriends.english.bean;

public class Problem {
    private String title;
    private String answer;
    private Option option;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    private class Option{
        private String option_A;
        private String option_B;
        private String option_C;
        private String option_D;

        public String getOption_A() {
            return option_A;
        }

        public void setOption_A(String option_A) {
            this.option_A = option_A;
        }

        public String getOption_B() {
            return option_B;
        }

        public void setOption_B(String option_B) {
            this.option_B = option_B;
        }

        public String getOption_C() {
            return option_C;
        }

        public void setOption_C(String option_C) {
            this.option_C = option_C;
        }

        public String getOption_D() {
            return option_D;
        }

        public void setOption_D(String option_D) {
            this.option_D = option_D;
        }
    }
}

