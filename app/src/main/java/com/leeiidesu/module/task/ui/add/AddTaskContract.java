package com.leeiidesu.module.task.ui.add;

import com.leeiidesu.lib.base.mvp.BasePresenter;
import com.leeiidesu.lib.base.mvp.BaseView;


/**
 * Created by iilee on 2018/5/8.
 */
public interface AddTaskContract {
    interface IAddTaskView extends BaseView {

    }

    interface IAddTaskPresenter extends BasePresenter {

        void addTask(String text);
    }
}
