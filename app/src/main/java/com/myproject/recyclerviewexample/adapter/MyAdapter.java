package com.myproject.recyclerviewexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.myproject.recyclerviewexample.R;
import com.myproject.recyclerviewexample.presenter.MainPresenter;

import java.util.ArrayList;

/**
 * Created by Owner on 2016-11-01.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private Context mContext;
        private ArrayList mItems;
        private Activity mActivity;

        private MainPresenter mPresenter;

        public MyAdapter(ArrayList items,Context context,Activity activity){
            mItems = items;
            this.mContext = context;
            this.mActivity = activity;
        }

        // 필수로 Generate 되어야 하는 메소드1 : 새로운 뷰 생성
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            //새로운 뷰를 만든다
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textview,parent,false);
            ViewHolder holder = new ViewHolder(v);
            return holder;
        }

        // 필수로 Generate 되어야 하는 메소드 2 : ListView의 getView 부분을 담당하는 메소드
        public void onBindViewHolder(ViewHolder holder, int position){



            holder.textView.setText( "Item: "+mItems.get(position).toString());


        }

        //필수로 generate 되어야 하는 메소드 3
        public int getItemCount(){
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView textView;
            public ViewHolder(View view){
                super(view);
                textView = (TextView)view.findViewById(R.id.counttext);

                textView.setClickable(true);
                textView.setFocusableInTouchMode(true);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("Here","Clicked");
                        mPresenter = new MainPresenter();
                        Toast.makeText(textView.getContext(),mPresenter.getTouchText(),Toast.LENGTH_SHORT).show();
                    }

                });
            }
        }
}
