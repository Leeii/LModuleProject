package com.leeiidesu.module.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leeiidesu.component.widget.dialog.LoadingDialog;
import com.leeiidesu.lib.base.common.BaseActivity;
import com.leeiidesu.lib.component.ComponentApplication;
import com.leeiidesu.module.template.TemplateApplicationLike;
import com.leeiidesu.module.template.dagger.ComponentFactory;
import com.leeiidesu.module.template.dagger.activity.ActivityComponent;


public abstract class DaggerActivity extends BaseActivity {

    private ActivityComponent activityComponent;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        inject(getActivityComponent());
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this,
                    getLifecycleApplication()
                            .fetchApplicationLike(TemplateApplicationLike.class));
        }
        return activityComponent;
    }

    private ComponentApplication getLifecycleApplication() {
        return ((ComponentApplication) getApplication());
    }

    protected abstract void inject(final ActivityComponent activityComponent);

    @Override
    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }

        loadingDialog.show();
    }

    @Override
    public void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }
}
