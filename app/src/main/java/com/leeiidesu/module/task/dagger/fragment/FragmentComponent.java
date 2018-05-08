package com.leeiidesu.module.task.dagger.fragment;



import com.leeiidesu.lib.base.dagger.FragmentScope;
import com.leeiidesu.module.task.base.DaggerFragment;
import com.leeiidesu.module.task.dagger.application.ApplicationComponent;
import com.leeiidesu.module.task.dagger.fragment.module.FragmentModule;
import com.leeiidesu.module.task.dagger.fragment.module.FragmentPresenterModule;

import dagger.Component;

@FragmentScope
@Component(
		dependencies = ApplicationComponent.class,
		modules = {
				FragmentModule.class,
				FragmentPresenterModule.class
		}
)
public interface FragmentComponent extends FragmentComponentInjects, FragmentComponentExposes {

	final class Initializer {

		static public FragmentComponent init(final DaggerFragment fragment, final ApplicationComponent applicationComponent) {
			return DaggerFragmentComponent.builder()
					.applicationComponent(applicationComponent)
					.fragmentModule(new FragmentModule(fragment))
					.fragmentPresenterModule(new FragmentPresenterModule(fragment))
					.build();
		}

		private Initializer() {
		}
	}
}
