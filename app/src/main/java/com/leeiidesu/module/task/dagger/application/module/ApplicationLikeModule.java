package com.leeiidesu.module.task.dagger.application.module;


import android.app.Application;

import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.module.task.TaskApplicationLike;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dgg on 2017/11/3.
 */
@Module
public class ApplicationLikeModule {

	private TaskApplicationLike application;

	public ApplicationLikeModule(TaskApplicationLike application) {
		this.application = application;
	}


	@Provides
	@ModuleSingleton
	Application providerApplication() {
		return application.getApplication();
	}

	@Provides
	@ModuleSingleton
	TaskApplicationLike providerApplicationLike() {
		return application;
	}

	public interface Exposes {
		TaskApplicationLike application();

		Application getApplication();
	}
}
