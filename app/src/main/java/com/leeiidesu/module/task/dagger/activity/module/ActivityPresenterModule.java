package com.leeiidesu.module.task.dagger.activity.module;

import com.leeiidesu.lib.base.dagger.ActivityScope;
import com.leeiidesu.module.task.base.DaggerActivity;
import com.leeiidesu.module.task.dagger.activity.ActivityComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leeii on 2017/11/4.
 */
@Module
public class ActivityPresenterModule {
	private final DaggerActivity daggerActivity;

	public ActivityPresenterModule(DaggerActivity daggerActivity) {
		this.daggerActivity = daggerActivity;
	}

	public ActivityComponent getActivityComponent() {
		return daggerActivity.getActivityComponent();
	}

	@Provides
	@ActivityScope
	com.leeiidesu.module.task.ui.add.AddTaskContract.IAddTaskPresenter providerAddTaskPresenter() {
		com.leeiidesu.module.task.ui.add.AddTaskPresenter presenter = new com.leeiidesu.module.task.ui.add.AddTaskPresenter();
		getActivityComponent().inject(presenter);
		return presenter;
	}

    @Provides
    @ActivityScope
    com.leeiidesu.module.task.ui.list.TaskListContract.ITaskListPresenter providerTaskListPresenter() {
        com.leeiidesu.module.task.ui.list.TaskListPresenter presenter = new com.leeiidesu.module.task.ui.list.TaskListPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }


    public interface Exposes {
	}
}
