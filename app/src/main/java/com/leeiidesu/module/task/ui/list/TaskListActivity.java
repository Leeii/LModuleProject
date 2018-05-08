package com.leeiidesu.module.task.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.leeiidesu.lib.base.RxBus;
import com.leeiidesu.lib.base.loading.LoadingHelper;
import com.leeiidesu.lib.component.router.RouterService;
import com.leeiidesu.module.task.R;
import com.leeiidesu.module.task.R2;
import com.leeiidesu.module.task.base.DaggerActivity;
import com.leeiidesu.module.task.dagger.activity.ActivityComponent;
import com.leeiidesu.module.task.domain.event.TaskEvent;
import com.leeiidesu.module.task.ui.add.AddTaskActivity;
import com.leeiidesu.module.task.ui.list.adapter.TaskAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by iilee on 2018/5/8.
 */
@Route(path = RouterService.Task.TASK_LIST)
public class TaskListActivity extends DaggerActivity implements TaskListContract.ITaskListView {
    @Inject
    TaskListContract.ITaskListPresenter mPresenter;
    @BindView(R2.id.recycler)
    RecyclerView recycler;
    @BindView(R2.id.refresh)
    SmartRefreshLayout refresh;

    private LoadingHelper loadingHelper;
    private TaskAdapter mAdapter;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        refresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPresenter.nextPage();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.refresh();
            }
        });

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(mAdapter = new TaskAdapter(mPresenter.getDataList()));

        RxBus.getInstance()
                .toObservable(TaskEvent.class)
                .compose(bindLifecycle())
                .subscribe(this::dispatchTaskEvent);


        loadingHelper = LoadingHelper.with(refresh);
        loadingHelper.setOnRetryClickListener(view -> {
            loadingHelper.showLoading();
            mPresenter.refresh();
        });

        loadingHelper.showLoading();

        mPresenter.refresh();
    }

    private void dispatchTaskEvent(TaskEvent taskEvent) {
        if (taskEvent.getType() == 0) {
            //完成任务

            mPresenter.doTask(taskEvent.getPosition());
        } else if (taskEvent.getType() == 1) {
            mPresenter.deleteTask(taskEvent.getPosition());
        }
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_task_list;
    }

    @OnClick(R2.id.add)
    public void onViewClicked() {
        startActivity(new Intent(this, AddTaskActivity.class));
    }

    @Override
    public void showEmpty(String msg) {
        loadingHelper.showEmpty(msg);
    }

    @Override
    public void showNormal() {
        loadingHelper.restore();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void loadFinish(boolean loadEnable) {
        if (refresh.isRefreshing()) {
            refresh.finishRefresh();
        }

        if (refresh.isLoading()) {
            refresh.finishLoadMore();
        }
        refresh.setNoMoreData(!loadEnable);

    }

    @Override
    public void updateUi(int position) {
        mAdapter.notifyItemChanged(position);
    }

    @Override
    public void updateUiDelete(int position) {
        mAdapter.notifyItemRemoved(position);
    }
}
