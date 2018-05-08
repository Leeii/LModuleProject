package com.leeiidesu.module.task.ui.list.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.leeiidesu.component.widget.adapter.SimpleItemAdapter;
import com.leeiidesu.lib.base.RxBus;
import com.leeiidesu.module.task.R;
import com.leeiidesu.module.task.domain.event.TaskEvent;
import com.leeiidesu.module.task.domain.model.Task;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by iilee on 2018/5/8.
 */

public class TaskAdapter extends SimpleItemAdapter {

    private List<Task> tasks;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA);


    public TaskAdapter(List<Task> tasks) {
        super(R.layout.item_layout_task);
        this.tasks = tasks;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView date = holder.getViewAs(R.id.date);
        ImageView done = holder.getViewAs(R.id.done);
        ImageView delete = holder.getViewAs(R.id.delete);
        TextView content = holder.getViewAs(R.id.content);


        Task task = tasks.get(position);
        date.setText(format.format(task.getCreateTime()));
        if (task.isDone()) {
            done.setImageResource(R.drawable.ic_done_gray);
            done.setEnabled(false);
        } else {
            done.setImageResource(R.drawable.ic_done);
            done.setEnabled(true);
            done.setOnClickListener(v -> RxBus.getInstance().post(new TaskEvent(0, holder.getAdapterPosition())));
        }

        delete.setOnClickListener(v -> RxBus.getInstance().post(new TaskEvent(1, holder.getAdapterPosition())));

        content.setText(task.getContent());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
