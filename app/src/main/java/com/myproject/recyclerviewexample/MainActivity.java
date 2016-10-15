package com.myproject.recyclerviewexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        ArrayList items = new ArrayList<>();

        for(int i=0; i < 100;i++){
            items.add(i);
        }

        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new MyAdapter(items,mContext);
        recyclerView.setAdapter(Adapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
    {
        private Context context;
        private ArrayList mItems;

        public MyAdapter(ArrayList items,Context mContext){
            mItems = items;
            context = mContext;
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
            }
        }


    }
}
