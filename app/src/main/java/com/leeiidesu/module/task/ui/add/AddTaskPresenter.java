package com.leeiidesu.module.task.ui.add;

import com.leeiidesu.lib.core.util.Check;
import com.leeiidesu.module.task.domain.model.Task;
import com.leeiidesu.module.task.domain.usecase.AddTaskUseCase;

import javax.inject.Inject;

/**
 * Created by iilee on 2018/5/8.
 */
public class AddTaskPresenter implements AddTaskContract.IAddTaskPresenter {
    @Inject
    AddTaskContract.IAddTaskView mView;

    @Inject
    AddTaskUseCase addTaskUseCase;

    @Override
    public void addTask(String text) {
        if (Check.isEmpty(text)) {
            mView.showToast("请输入任务内容！");
            return;
        }

        Task task = new Task();
        task.setContent(text);
        task.setCreateTime(System.currentTimeMillis());

        addTaskUseCase.execute(task)
                .compose(mView.bindLifecycleAndThread())
                .subscribe(l -> {
                    mView.showToast(String.format("添加成功：id -> %s", l));
                    mView.finishActivity();
                }, Throwable::printStackTrace);
    }
}
