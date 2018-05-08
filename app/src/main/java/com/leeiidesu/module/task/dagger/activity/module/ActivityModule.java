package com.leeiidesu.module.task.dagger.activity.module;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;


import com.leeiidesu.lib.base.dagger.ActivityScope;
import com.leeiidesu.module.task.base.DaggerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

	private final DaggerActivity daggerActivity;

	public ActivityModule(final DaggerActivity daggerActivity) {
		this.daggerActivity = daggerActivity;
	}

	@Provides
	@ActivityScope
	Context provideActivityContext() {
		return daggerActivity;
	}

	@Provides
	@ActivityScope
	Activity provideActivity() {
		return daggerActivity;
	}

	private DaggerActivity getDaggerActivity() {
		return daggerActivity;
	}

	@Provides
	@ActivityScope
    FragmentManager provideFragmentManager() {
		return daggerActivity.getSupportFragmentManager();
	}

	@Provides
	@ActivityScope
	com.leeiidesu.module.task.ui.add.AddTaskContract.IAddTaskView providerAddTaskView() {
		return (com.leeiidesu.module.task.ui.add.AddTaskContract.IAddTaskView) getDaggerActivity();
	}

    @Provides
    @ActivityScope
    com.leeiidesu.module.task.ui.list.TaskListContract.ITaskListView providerTaskListView() {
        return (com.leeiidesu.module.task.ui.list.TaskListContract.ITaskListView) getDaggerActivity();
    }

    public interface Exposes {

		Activity activity();

		Context context();

		FragmentManager fragmentManager();
	}
}
