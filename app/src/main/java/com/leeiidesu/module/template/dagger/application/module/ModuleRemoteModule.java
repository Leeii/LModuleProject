package com.leeiidesu.module.template.dagger.application.module;


import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.module.template.data.api.APIService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Leeii on 2017/11/3.
 */
@Module
public class ModuleRemoteModule {
    @Provides
    @ModuleSingleton
    APIService providerApiService(Retrofit retrofit) {
        return retrofit
                .create(APIService.class);
    }

    public interface Exposes {
        APIService getApiService();
    }
}
