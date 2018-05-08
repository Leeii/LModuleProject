package com.leeiidesu.module.template.dagger.fragment.module;


import com.leeiidesu.module.template.base.DaggerFragment;

import dagger.Module;

@Module
public class FragmentModule {

    private final DaggerFragment fragment;

    public FragmentModule(final DaggerFragment fragment) {
        this.fragment = fragment;
    }

	public DaggerFragment getDaggerFragment() {
		return fragment;
	}

}
