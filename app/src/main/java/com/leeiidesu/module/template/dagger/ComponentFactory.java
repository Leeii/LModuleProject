package com.leeiidesu.module.template.dagger;


import com.leeiidesu.module.template.TemplateApplicationLike;
import com.leeiidesu.module.template.base.DaggerActivity;
import com.leeiidesu.module.template.base.DaggerFragment;
import com.leeiidesu.module.template.dagger.activity.ActivityComponent;
import com.leeiidesu.module.template.dagger.application.ApplicationComponent;
import com.leeiidesu.module.template.dagger.fragment.FragmentComponent;

/**
 * Created by dgg on 2017/11/2.
 */

public class ComponentFactory {
	private ComponentFactory() {
	}

	public static ApplicationComponent createApplicationComponent(final TemplateApplicationLike application) {
		return ApplicationComponent.Initializer.init(application);
	}

	public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final TemplateApplicationLike taskApplicationLike) {
		return ActivityComponent.Initializer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
	}

	public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final TemplateApplicationLike templateApplicationLike) {
		return FragmentComponent.Initializer.init(daggerFragment, templateApplicationLike.getApplicationComponent());
	}
}
