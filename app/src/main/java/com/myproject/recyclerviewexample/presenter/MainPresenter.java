package com.myproject.recyclerviewexample.presenter;

import com.myproject.recyclerviewexample.model.MainModel;

import java.util.ArrayList;

/**
 * Created by Owner on 2016-11-01.
 */

public class MainPresenter implements BasePresenter {

    MainModel mModel;
    ArrayList mList;

    public MainPresenter() {
        super();
        mModel = new MainModel();
        mList = mModel.getData();
    }


    public ArrayList getData(){
        return mList;
    }

    public String getTouchText(){
        return mModel.getClickedText();
    }

    @Override
    public void start() {
    }
}
