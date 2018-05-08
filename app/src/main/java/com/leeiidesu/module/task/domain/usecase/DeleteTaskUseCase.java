package com.leeiidesu.module.task.domain.usecase;

import com.leeiidesu.lib.base.domain.UseCaseWithParameter;
import com.leeiidesu.module.task.domain.TaskRepository;

import io.reactivex.Observable;

/**
 * Created by iilee on 2018/5/8.
 */

public class DeleteTaskUseCase implements UseCaseWithParameter<Long, Boolean> {


    private TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Boolean> execute(Long parameter) {
        return repository.deleteTask(parameter);
    }
}
