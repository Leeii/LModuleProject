package com.leeiidesu.module.template.dagger.activity.module;

import com.leeiidesu.module.template.base.DaggerActivity;
import com.leeiidesu.module.template.dagger.activity.ActivityComponent;

import dagger.Module;

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


	public interface Exposes {
	}
}
