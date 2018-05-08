package com.leeiidesu.module.task.ui.list;

import com.leeiidesu.module.task.domain.model.Task;
import com.leeiidesu.module.task.domain.usecase.DeleteTaskUseCase;
import com.leeiidesu.module.task.domain.usecase.DoneTaskUseCase;
import com.leeiidesu.module.task.domain.usecase.QueryTaskUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by iilee on 2018/5/8.
 */
public class TaskListPresenter implements TaskListContract.ITaskListPresenter {
    @Inject
    TaskListContract.ITaskListView mView;
    @Inject
    QueryTaskUseCase queryTaskUseCase;
    @Inject
    DeleteTaskUseCase deleteTaskUseCase;
    @Inject
    DoneTaskUseCase doneTaskUseCase;

    private int pageIndex = 1;

    private final List<Task> datas = new ArrayList<>();

    @Override
    public void nextPage() {
        pageIndex++;
        queryTask();
    }

    private void queryTask() {
        queryTaskUseCase.execute(new QueryTaskUseCase.Query(pageIndex))
                .compose(mView.bindLifecycleAndThread())
                .subscribe(lst -> {
                    if (pageIndex == 1) {
                        datas.clear();
                    }

                    datas.addAll(lst);
                    if (datas.size() == 0) {
                        mView.showEmpty("暂无任务");
                    } else {
                        mView.showNormal();
                    }


                    mView.loadFinish(datas.size() >= pageIndex * 10);
                });
    }

    @Override
    public void refresh() {
        pageIndex = 1;
        queryTask();
    }

    @Override
    public List<Task> getDataList() {
        return datas;
    }

    @Override
    public void doTask(int position) {
        Task task = datas.get(position);

        doneTaskUseCase.execute(task.getId())
                .compose(mView.bindLifecycleAndThreadWithLoading())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        task.setDone(true);
                        mView.updateUi(position);
                    }
                });
    }

    @Override
    public void deleteTask(int position) {
        Task task = datas.get(position);

        deleteTaskUseCase.execute(task.getId())
                .compose(mView.bindLifecycleAndThreadWithLoading())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        datas.remove(position);
                        mView.updateUiDelete(position);
                    }
                });
    }
}
