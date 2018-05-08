package com.leeiidesu.module.task.domain.usecase;

import com.leeiidesu.lib.base.domain.UseCaseWithParameter;
import com.leeiidesu.module.task.domain.TaskRepository;
import com.leeiidesu.module.task.domain.model.Task;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by iilee on 2018/5/8.
 */

public class QueryTaskUseCase implements UseCaseWithParameter<QueryTaskUseCase.Query, List<Task>> {


    private TaskRepository repository;

    public QueryTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<Task>> execute(Query parameter) {
        return repository.queryTask(parameter.pageIndex);
    }

    public static class Query {
        //查询条件 不止一个

        private int pageIndex;

        public Query(int pageIndex) {

            this.pageIndex = pageIndex;
        }
    }
}
