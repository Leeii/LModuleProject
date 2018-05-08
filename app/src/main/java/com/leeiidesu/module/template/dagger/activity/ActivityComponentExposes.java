package com.leeiidesu.module.template.dagger.activity;


import com.leeiidesu.module.template.dagger.activity.module.ActivityModule;
import com.leeiidesu.module.template.dagger.activity.module.ActivityPresenterModule;
import com.leeiidesu.module.template.dagger.application.ApplicationComponentExposes;

public interface ActivityComponentExposes extends ApplicationComponentExposes,
        ActivityModule.Exposes,
        ActivityPresenterModule.Exposes {


}
