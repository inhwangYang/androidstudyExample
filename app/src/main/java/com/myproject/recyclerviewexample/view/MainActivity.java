package com.myproject.recyclerviewexample.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myproject.recyclerviewexample.R;
import com.myproject.recyclerviewexample.adapter.MyAdapter;
import com.myproject.recyclerviewexample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);

        mPresenter = new MainPresenter();

        adapter = new MyAdapter(mPresenter.getData(),mContext,MainActivity.this);
        recyclerView.setAdapter(adapter);


    }

}
