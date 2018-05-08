package com.leeiidesu.module.task;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.leeiidesu.lib.component.IApplicationLike;
import com.leeiidesu.lib.component.router.RouterService;
import com.leeiidesu.module.task.dagger.ComponentFactory;
import com.leeiidesu.module.task.dagger.application.ApplicationComponent;

/**
 * Created by dgg on 2017/11/10.
 */
@Route(path = RouterService.Task.APPLICATION_LIKE)
public class TaskApplicationLike extends IApplicationLike {
    private ApplicationComponent applicationComponent;


    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = ComponentFactory.createApplicationComponent(this);
            applicationComponent.inject(this);
        }
        return applicationComponent;
    }
}
