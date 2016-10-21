package com.sviet.anuragkumar.karma.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sviet.anuragkumar.karma.MainActivity;
import com.sviet.anuragkumar.karma.R;
import com.sviet.anuragkumar.karma.TaskPage;
import com.sviet.anuragkumar.karma.models.Task;
import com.sviet.anuragkumar.karma.models.UnitTask;

import java.util.ArrayList;

/**
 * Created by Anurag Kumar on 15-Oct-16.
 */

public class TaskListRecyclerAdapter extends RecyclerView.Adapter<TaskListRecyclerAdapter.ViewHolder> {

    private final String TAG = "/TaskRecyclerAdapter";
    private ArrayList<Task> taskArrayList;
    private final Context context;

    public TaskListRecyclerAdapter(Context context, ArrayList<Task> taskArrayList) {
        this.context = context;
        this.taskArrayList = taskArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.task_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        holder.getTextViewTitle().setText(taskArrayList.get(position).getTitle());
        holder.getTextViewHint().setText(taskArrayList.get(position).getMini_tasks().get(0).getContent());
        holder.getCardViewTask().setCardBackgroundColor(Color.parseColor("#"+taskArrayList.get(position).getColor()));
        int progress=0;
        for (UnitTask task : taskArrayList.get(position).getMini_tasks() ){
            if(task.isState()) progress++;
        }
        holder.getProgressBarTask().setMax(taskArrayList.get(position).getMini_tasks().size());
        holder.getProgressBarTask().setProgress(progress);
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textViewTitle;
        private final TextView textViewHint;
        private final CardView cardViewTask;
        private final ProgressBar progressBarTask;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, TaskPage.class);
                    intent.putExtra("task",new Gson().toJson(taskArrayList.get(getAdapterPosition())));

                    Pair<View , String> p1 = Pair.create((View)textViewTitle,"titleTrans")
                                       ,p2 = Pair.create((View)textViewHint,"taskCard");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) context,p1,p2);

                    //used for firing intent from outside of the activity.
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //convert context to activity to get all activity functions.
                    Activity activity = (Activity) context;
                    activity.startActivity(intent,options.toBundle());
                    //activity.overridePendingTransition();
                }
            });

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Snackbar.make(v,"long presses by elements.",Snackbar.LENGTH_LONG).show();
                    return true;
                }
            });

            textViewTitle = (TextView) v.findViewById(R.id.textViewTaskListTitle);
            textViewHint = (TextView) v.findViewById(R.id.textViewTaskListHint);
            cardViewTask = (CardView) v.findViewById(R.id.task_list_card);
            progressBarTask = (ProgressBar) v.findViewById(R.id.progressBarTask);

        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewHint() {
            return textViewHint;
        }

        public CardView getCardViewTask() {
            return cardViewTask;
        }

        public ProgressBar getProgressBarTask() {
            return progressBarTask;
        }
    }
}
