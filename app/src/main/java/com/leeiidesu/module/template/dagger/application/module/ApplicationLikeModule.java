package com.leeiidesu.module.template.dagger.application.module;


import android.app.Application;

import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.module.template.TemplateApplicationLike;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dgg on 2017/11/3.
 */
@Module
public class ApplicationLikeModule {

	private TemplateApplicationLike application;

	public ApplicationLikeModule(TemplateApplicationLike application) {
		this.application = application;
	}


	@Provides
	@ModuleSingleton
	Application providerApplication() {
		return application.getApplication();
	}

	@Provides
	@ModuleSingleton
    TemplateApplicationLike providerApplicationLike() {
		return application;
	}

	public interface Exposes {
		TemplateApplicationLike application();

		Application getApplication();
	}
}
