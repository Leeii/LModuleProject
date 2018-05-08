package com.leeiidesu.module.task.dagger.application.module;


import android.app.Application;

import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.module.task.BuildConfig;
import com.leeiidesu.module.task.data.TaskRepositoryImpl;
import com.leeiidesu.module.task.data.api.APIService;
import com.leeiidesu.module.task.domain.TaskRepository;
import com.leeiidesu.module.task.domain.model.MyObjectBox;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

/**
 * Created by dgg on 2017/11/3.
 */
@Module
public class DataModule {
    public static final String MODULE_NAME = BuildConfig.MODULE_NAME;

    @ModuleSingleton
    @Provides
    TaskRepository providerRepository(APIService apiService,
                                      @Named(MODULE_NAME) BoxStore boxStore) {
        return new TaskRepositoryImpl(apiService, boxStore);
    }


    @ModuleSingleton
    @Provides
    @Named(MODULE_NAME)
    BoxStore providerBoxStore(Application application) {
        File file = new File(application.getFilesDir().getAbsolutePath() + "/database/" + MODULE_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }

        return MyObjectBox.builder()
                .androidContext(application)
                .directory(file)
                .build();
    }


    public interface Exposes {
        TaskRepository getRepository();

    }
}
