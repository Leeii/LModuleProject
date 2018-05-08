package com.leeiidesu.module.template.dagger.fragment.module;


import com.leeiidesu.lib.base.dagger.FragmentScope;
import com.leeiidesu.module.template.base.DaggerFragment;
import com.leeiidesu.module.template.dagger.fragment.FragmentComponent;

import dagger.Module;

@Module
public final class FragmentPresenterModule {

    private final DaggerFragment daggerFragment;

    public FragmentPresenterModule(final DaggerFragment daggerFragment) {
        this.daggerFragment = daggerFragment;
    }

    @FragmentScope
    private FragmentComponent getFragmentComponent() {
        return daggerFragment.getFragmentComponent();
    }

	private DaggerFragment getDaggerFragment() {
		return daggerFragment;
	}

}
