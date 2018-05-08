package com.leeiidesu.module.template.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leeiidesu.component.widget.dialog.LoadingDialog;
import com.leeiidesu.lib.base.common.BaseFragment;
import com.leeiidesu.lib.component.ComponentApplication;
import com.leeiidesu.module.template.TemplateApplicationLike;
import com.leeiidesu.module.template.dagger.ComponentFactory;
import com.leeiidesu.module.template.dagger.fragment.FragmentComponent;

/**
 * Created by Leeii on 2017/11/4.
 */

public abstract class DaggerFragment extends BaseFragment {
    private FragmentComponent fragmentComponent;
    private LoadingDialog loadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getFragmentComponent());
    }

    protected abstract void inject(FragmentComponent fragmentComponent);

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = ComponentFactory.createFragmentComponent(this,
                    ((ComponentApplication) getActivity().getApplication())
                            .fetchApplicationLike(TemplateApplicationLike.class));
        }

        return fragmentComponent;
    }

    private DaggerActivity getDaggerActivity() {
        return ((DaggerActivity) getActivity());
    }


    @Override
    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getActivity());
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
