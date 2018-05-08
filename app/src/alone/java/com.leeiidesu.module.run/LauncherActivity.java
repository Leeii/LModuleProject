package com.leeiidesu.module.run;

import android.os.Bundle;
import android.widget.Button;

import com.leeiidesu.lib.base.common.BaseActivity;
import com.leeiidesu.module.task.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by iilee on 2018/5/8.
 */

public class LauncherActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_layout_launcher;
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        button.setText("我被点击了");
    }
}
