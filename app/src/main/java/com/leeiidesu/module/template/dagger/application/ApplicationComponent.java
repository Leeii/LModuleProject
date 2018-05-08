package com.leeiidesu.module.template.dagger.application;


import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.lib.component.dagger.component.GlobalComponent;
import com.leeiidesu.module.template.TemplateApplicationLike;
import com.leeiidesu.module.template.dagger.application.module.ApplicationLikeModule;
import com.leeiidesu.module.template.dagger.application.module.DataModule;
import com.leeiidesu.module.template.dagger.application.module.ModuleRemoteModule;
import com.leeiidesu.module.template.dagger.application.module.UseCaseModule;

import dagger.Component;

/**
 * Created by dgg on 2017/11/3.
 */
@ModuleSingleton
@Component(modules = {
        ModuleRemoteModule.class,
        UseCaseModule.class,
        DataModule.class,
        ApplicationLikeModule.class
}, dependencies = GlobalComponent.class)
public interface ApplicationComponent extends ApplicationComponentExposes, ApplicationComponentInjects {
    final class Initializer {

        static public ApplicationComponent init(final TemplateApplicationLike applicationLike) {
            return DaggerApplicationComponent.builder()
                    .globalComponent(applicationLike.getGlobalComponent())
                    .useCaseModule(new UseCaseModule())
                    .applicationLikeModule(new ApplicationLikeModule(applicationLike))
                    .dataModule(new DataModule())
                    .moduleRemoteModule(new ModuleRemoteModule())
                    .build();
        }

        private Initializer() {
        }
    }

}
