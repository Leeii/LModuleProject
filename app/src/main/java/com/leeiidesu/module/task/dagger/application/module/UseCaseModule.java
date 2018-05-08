package com.leeiidesu.module.task.dagger.application.module;

import com.leeiidesu.lib.base.dagger.ModuleSingleton;
import com.leeiidesu.module.task.domain.TaskRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dgg on 2017/11/3.
 */
@Module
public class UseCaseModule {


    @Provides
    @ModuleSingleton
    com.leeiidesu.module.task.domain.usecase.AddTaskUseCase providerAddTaskUseCase(TaskRepository repository) {
        return new com.leeiidesu.module.task.domain.usecase.AddTaskUseCase(repository);
    }

    @Provides
    @ModuleSingleton
    com.leeiidesu.module.task.domain.usecase.QueryTaskUseCase providerQueryTaskUseCase(TaskRepository repository) {
        return new com.leeiidesu.module.task.domain.usecase.QueryTaskUseCase(repository);
    }

    @Provides
    @ModuleSingleton
    com.leeiidesu.module.task.domain.usecase.DoneTaskUseCase providerDoneTaskUseCase(TaskRepository repository) {
        return new com.leeiidesu.module.task.domain.usecase.DoneTaskUseCase(repository);
    }

    @Provides
    @ModuleSingleton
    com.leeiidesu.module.task.domain.usecase.DeleteTaskUseCase providerDeleteTaskUseCase(TaskRepository repository) {
        return new com.leeiidesu.module.task.domain.usecase.DeleteTaskUseCase(repository);
    }

    public interface Exposes {

        com.leeiidesu.module.task.domain.usecase.AddTaskUseCase getAddTaskUseCase();

        com.leeiidesu.module.task.domain.usecase.QueryTaskUseCase getQueryTaskUseCase();

        com.leeiidesu.module.task.domain.usecase.DoneTaskUseCase getDoneTaskUseCase();

        com.leeiidesu.module.task.domain.usecase.DeleteTaskUseCase getDeleteTaskUseCase();
    }
}
