package com.leeiidesu.module.task.data;


import com.leeiidesu.module.task.data.api.APIService;
import com.leeiidesu.module.task.domain.TaskRepository;
import com.leeiidesu.module.task.domain.model.Task;
import com.leeiidesu.module.task.domain.model.Task_;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.reactivex.Observable;

/**
 * Created by dgg on 2017/11/6.
 */

public class TaskRepositoryImpl implements TaskRepository {
    private APIService apiService;
    private BoxStore boxStore;

    public TaskRepositoryImpl(APIService apiService, BoxStore boxStore) {

        this.apiService = apiService;
        this.boxStore = boxStore;
    }

    @Override
    public Observable<Long> addTaskToLocal(Task parameter) {
        return Observable.just(parameter)
                .map(this::saveToBox);
    }

    @Override
    public Observable<List<Task>> queryTask(int pageIndex) {
        return Observable.create(e -> {
            Box<Task> taskBox = boxStore.boxFor(Task.class);
            List<Task> tasks = taskBox.query()
                    .build()
                    .find((pageIndex - 1) * 10, 10);


            e.onNext(tasks);
            e.onComplete();
        });
    }

    @Override
    public Observable<Boolean> doneTask(Long id) {
        return Observable.just(id)
                .map(this::done);
    }

    @Override
    public Observable<Boolean> deleteTask(Long id) {

        return Observable.create(e -> {
            Box<Task> taskBox = boxStore.boxFor(Task.class);
            taskBox.remove(id);
            e.onNext(true);
            e.onComplete();
        });
    }

    private Boolean done(Long aLong) {
        Box<Task> taskBox = boxStore.boxFor(Task.class);

        Task unique = taskBox.query()
                .equal(Task_.id, aLong)
                .build().findUnique();

        if (unique == null) {
            return false;
        }

        unique.setDone(true);

        taskBox.put(unique);


        return true;
    }

    private Long saveToBox(Task task) {
        Box<Task> taskBox = boxStore.boxFor(Task.class);

        return taskBox.put(task);

    }
}
