package com.leeiidesu.module.task.domain.usecase;

import com.leeiidesu.lib.base.domain.UseCaseWithParameter;
import com.leeiidesu.module.task.domain.TaskRepository;
import com.leeiidesu.module.task.domain.model.Task;

import io.reactivex.Observable;

/**
 * Created by iilee on 2018/5/8.
 */

public class AddTaskUseCase implements UseCaseWithParameter<Task,Long> {

    private TaskRepository repository;

    public AddTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Long> execute(Task parameter) {
        return repository.addTaskToLocal(parameter);
    }
}
