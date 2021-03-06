package com.leeiidesu.module.template.dagger.activity;


import com.leeiidesu.lib.base.dagger.ActivityScope;
import com.leeiidesu.module.template.base.DaggerActivity;
import com.leeiidesu.module.template.dagger.activity.module.ActivityModule;
import com.leeiidesu.module.template.dagger.activity.module.ActivityPresenterModule;
import com.leeiidesu.module.template.dagger.application.ApplicationComponent;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                ActivityPresenterModule.class
        }
)
public interface ActivityComponent extends ActivityComponentInjects, ActivityComponentExposes {

    final class Initializer {

        static public ActivityComponent init(final DaggerActivity daggerActivity, final ApplicationComponent applicationComponent) {
            return DaggerActivityComponent.builder()
                    .applicationComponent(applicationComponent)
                    .activityPresenterModule(new ActivityPresenterModule(daggerActivity))
                    .activityModule(new ActivityModule(daggerActivity))
                    .build();
        }

        private Initializer() {
        }
    }
}
