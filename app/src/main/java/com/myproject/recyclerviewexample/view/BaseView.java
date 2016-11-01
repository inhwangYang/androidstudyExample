package com.myproject.recyclerviewexample.view;

import com.myproject.recyclerviewexample.presenter.BasePresenter;

/**
 * Created by Owner on 2016-11-01.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
    void showProgress();
    void hideProgess();
}
