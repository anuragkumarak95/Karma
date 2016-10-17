package com.sviet.anuragkumar.karma.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;

import com.sviet.anuragkumar.karma.R;
import com.sviet.anuragkumar.karma.models.UnitTask;

import java.util.ArrayList;

/**
 * Created by Anurag Kumar on 16-Oct-16.
 */

public class TaskPageRecyclerAdapter extends RecyclerView.Adapter<TaskPageRecyclerAdapter.ViewHolder> {

    private ArrayList<UnitTask> taskArrayList;
    private final Context context;

    public TaskPageRecyclerAdapter(Context context, ArrayList<UnitTask> taskArrayList) {
        this.context = context;
        this.taskArrayList = taskArrayList;
    }

    @Override
    public TaskPageRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_page_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskPageRecyclerAdapter.ViewHolder holder, int position) {

        holder.getCheckBoxTask().setChecked(taskArrayList.get(position).isState());
        holder.getEditTextTask().setText(taskArrayList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final EditText editTextTask;
        private final CheckBox checkBoxTask;

        public ViewHolder(View v) {
            super(v);

            editTextTask = (EditText) v.findViewById(R.id.editTextTaskPageLayout);
            editTextTask.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    taskArrayList.get(getAdapterPosition()).setContent(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            checkBoxTask = (CheckBox) v.findViewById(R.id.checkboxTaskPageLayout);
        }

        public EditText getEditTextTask() {
            return editTextTask;
        }

        public CheckBox getCheckBoxTask() {
            return checkBoxTask;
        }
    }
}
