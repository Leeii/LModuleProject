package com.leeiidesu.module.template.dagger.application.module;


import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.module.template.BuildConfig;
import com.leeiidesu.module.template.data.TemplateRepositoryImpl;
import com.leeiidesu.module.template.data.api.APIService;
import com.leeiidesu.module.template.domain.TemplateRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dgg on 2017/11/3.
 */
@Module
public class DataModule {
    public static final String MODULE_NAME = BuildConfig.MODULE_NAME;

    @ModuleSingleton
    @Provides
    TemplateRepository providerRepository(APIService apiService) {
        return new TemplateRepositoryImpl(apiService);
    }

/*
    //需要数据库取消注释这

   @ModuleSingleton
    @Provides
    @Named(MODULE_NAME)
    BoxStore providerBoxStore(Application application) {
        File file = new File("/data/data/" + application.getPackageName() + "/database/" + MODULE_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }

        return MyObjectBox.builder()
                .androidContext(application)
                .directory(file)
                .build();
        return null;
    }
*/

    public interface Exposes {
        TemplateRepository getRepository();
    }
}
