package com.leeiidesu.module.task.ui.add;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.leeiidesu.module.task.R;
import com.leeiidesu.module.task.R2;
import com.leeiidesu.module.task.base.DaggerActivity;
import com.leeiidesu.module.task.dagger.activity.ActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by iilee on 2018/5/8.
 */
public class AddTaskActivity extends DaggerActivity implements AddTaskContract.IAddTaskView {
    @Inject
    AddTaskContract.IAddTaskPresenter mPresenter;
    @BindView(R2.id.button)
    Button button;
    @BindView(R2.id.content)
    EditText content;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_add_task;
    }

    @OnClick(R2.id.button)
    public void onViewClicked() {
        mPresenter.addTask(content.getText().toString());
    }
}
