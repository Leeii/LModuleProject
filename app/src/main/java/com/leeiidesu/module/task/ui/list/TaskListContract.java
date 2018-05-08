package com.leeiidesu.module.task.ui.list;

import com.leeiidesu.lib.base.mvp.BasePresenter;
import com.leeiidesu.lib.base.mvp.BaseView;
import com.leeiidesu.module.task.domain.model.Task;

import java.util.List;


/**
 * Created by iilee on 2018/5/8.
 */
public interface TaskListContract {
    interface ITaskListView extends BaseView {

        void showEmpty(String msg);

        void showNormal();

        void loadFinish(boolean loadEnable);

        void updateUi(int position);

        void updateUiDelete(int position);
    }

    interface ITaskListPresenter extends BasePresenter {

        void nextPage();

        void refresh();

        List<Task> getDataList();

        void doTask(int position);

        void deleteTask(int position);
    }
}
