package com.leeiidesu.module.template;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.leeiidesu.lib.component.IApplicationLike;
import com.leeiidesu.module.template.dagger.ComponentFactory;
import com.leeiidesu.module.template.dagger.application.ApplicationComponent;

/**
 * Created by dgg on 2017/11/10.
 */
@Route(path = "/template/application/like")
public class TemplateApplicationLike extends IApplicationLike {
    private ApplicationComponent applicationComponent;


    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = ComponentFactory.createApplicationComponent(this);
            applicationComponent.inject(this);
        }
        return applicationComponent;
    }
}
