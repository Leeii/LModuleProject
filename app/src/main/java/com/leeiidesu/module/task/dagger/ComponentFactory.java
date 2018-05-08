package com.leeiidesu.module.task.dagger;


import com.leeiidesu.module.task.TaskApplicationLike;
import com.leeiidesu.module.task.base.DaggerActivity;
import com.leeiidesu.module.task.base.DaggerFragment;
import com.leeiidesu.module.task.dagger.activity.ActivityComponent;
import com.leeiidesu.module.task.dagger.application.ApplicationComponent;
import com.leeiidesu.module.task.dagger.fragment.FragmentComponent;

/**
 * Created by dgg on 2017/11/2.
 */

public class ComponentFactory {
	private ComponentFactory() {
	}

	public static ApplicationComponent createApplicationComponent(final TaskApplicationLike application) {
		return ApplicationComponent.Initializer.init(application);
	}

	public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final TaskApplicationLike taskApplicationLike) {
		return ActivityComponent.Initializer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
	}

	public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final TaskApplicationLike taskApplicationLike) {
		return FragmentComponent.Initializer.init(daggerFragment, taskApplicationLike.getApplicationComponent());
	}
}
