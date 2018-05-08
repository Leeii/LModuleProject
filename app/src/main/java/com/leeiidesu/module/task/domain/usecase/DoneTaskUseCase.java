package com.leeiidesu.module.task.domain.usecase;

import com.leeiidesu.lib.base.domain.UseCaseWithParameter;
import com.leeiidesu.module.task.domain.TaskRepository;

import io.reactivex.Observable;

/**
 * Created by iilee on 2018/5/8.
 */

public class DoneTaskUseCase implements UseCaseWithParameter<Long, Boolean> {

    private TaskRepository repository;

    public DoneTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<Boolean> execute(Long id) {
        return repository.doneTask(id);
    }
}
