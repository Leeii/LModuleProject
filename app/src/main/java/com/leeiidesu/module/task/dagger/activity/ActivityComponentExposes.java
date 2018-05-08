package com.leeiidesu.module.task.dagger.activity;


import com.leeiidesu.module.task.dagger.activity.module.ActivityModule;
import com.leeiidesu.module.task.dagger.activity.module.ActivityPresenterModule;
import com.leeiidesu.module.task.dagger.application.ApplicationComponentExposes;

public interface ActivityComponentExposes extends ApplicationComponentExposes,
        ActivityModule.Exposes,
        ActivityPresenterModule.Exposes {


}
