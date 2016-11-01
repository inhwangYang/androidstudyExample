package com.myproject.recyclerviewexample.model;

import java.util.ArrayList;

/**
 * Created by Owner on 2016-11-01.
 */

public class MainModel {

    ArrayList item;
    public MainModel(){
        item = new ArrayList<>();

        for(int i=0; i < 100;i++){
            item.add(i);
        }
    }

    public ArrayList<Integer> getData(){
        return item;
    }

    public void setData(ArrayList array){
        item = array;
    }

    public String getClickedText(){
        return "클릭했습니다!!";
    }
}
