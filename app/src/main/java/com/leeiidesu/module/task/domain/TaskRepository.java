package com.leeiidesu.module.task.domain;

import com.leeiidesu.module.task.domain.model.Task;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by dgg on 2017/11/6.
 */

public interface TaskRepository {
    Observable<Long> addTaskToLocal(Task parameter);

    Observable<List<Task>> queryTask(int pageIndex);

    Observable<Boolean> doneTask(Long id);

    Observable<Boolean> deleteTask(Long id);
}
