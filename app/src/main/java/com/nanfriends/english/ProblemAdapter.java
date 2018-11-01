package com.nanfriends.english;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.nanfriends.english.bean.SProblem;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class ProblemAdapter extends CommonAdapter<SProblem.DataBean> {

    public ProblemAdapter(Context context, int layoutId, List<SProblem.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(final ViewHolder holder, final SProblem.DataBean problem, int position) {
        holder.setText(R.id.problem_title,problem.getQuestion());
        holder.setText(R.id.anwser_a,"A. "+problem.getA());
        holder.setText(R.id.anwser_b,"B. "+problem.getB());
        holder.setText(R.id.anwser_c,"C. "+problem.getC());
        holder.setText(R.id.anwser_d,"D. "+problem.getD());
        RadioGroup radioGroup = (RadioGroup) holder.getView(R.id.options);
        final String text = "答案：" + problem.getAnswer() + "\n解析：" + problem.getJiexi();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView textView = (TextView) holder.getView(R.id.answer);
                textView.setText(text);
                textView.setVisibility(View.VISIBLE);
                RadioButton checkRadio = (RadioButton) holder.getView(i);
                String checkOption = "A";
                switch (i){
                    case R.id.anwser_a:
                        checkOption = "A";
                        break;
                    case R.id.anwser_b:
                        checkOption = "B";
                        break;
                    case R.id.anwser_c:
                        checkOption = "C";
                        break;
                    case R.id.anwser_d:
                        checkOption = "D";
                        break;
                }
                if(checkOption.equals(problem.getAnswer().toUpperCase())){
                    checkRadio.setTextColor(Color.parseColor("#008577"));
                    checkRadio.setButtonDrawable(R.drawable.selector_option);
                }else{
                    checkRadio.setTextColor(Color.parseColor("#D16158"));
                    checkRadio.setButtonDrawable(R.drawable.selector_option_error);
                }
                for (int j = 0; j < radioGroup.getChildCount(); j++) {
                    ((RadioButton) radioGroup.getChildAt(j)).setEnabled(false);
                }
            }
            //                    holder.setOnClickListener(R.id.answer, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            holder.setText(R.id.answer, text);
//                            TextView view = (TextView) holder.getView(R.id.item_jiexi);
//                            view.setText("解析："+problem.getJiexi());
//                            view.setVisibility(View.VISIBLE);
//                        }
//                    });

        });
    }
}
