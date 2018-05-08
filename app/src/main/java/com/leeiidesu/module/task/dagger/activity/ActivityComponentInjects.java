package com.leeiidesu.module.task.dagger.activity;



public interface ActivityComponentInjects {
    void inject(com.leeiidesu.module.task.ui.add.AddTaskPresenter presenter);

    void inject(com.leeiidesu.module.task.ui.add.AddTaskActivity activity);

    void inject(com.leeiidesu.module.task.ui.list.TaskListPresenter presenter);

    void inject(com.leeiidesu.module.task.ui.list.TaskListActivity activity);
}
