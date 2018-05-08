package com.leeiidesu.module.template.dagger.application;


import com.leeiidesu.module.template.dagger.application.module.ApplicationLikeModule;
import com.leeiidesu.module.template.dagger.application.module.DataModule;
import com.leeiidesu.module.template.dagger.application.module.ModuleRemoteModule;
import com.leeiidesu.module.template.dagger.application.module.UseCaseModule;

public interface ApplicationComponentExposes extends
		UseCaseModule.Exposes,
		DataModule.Exposes,
		ModuleRemoteModule.Exposes,
		ApplicationLikeModule.Exposes {

}
