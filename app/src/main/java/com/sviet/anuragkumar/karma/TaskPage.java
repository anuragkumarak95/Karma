package com.sviet.anuragkumar.karma;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sviet.anuragkumar.karma.adapters.TaskPageRecyclerAdapter;
import com.sviet.anuragkumar.karma.models.Task;
import com.sviet.anuragkumar.karma.models.UnitTask;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskPage extends AppCompatActivity {

    private RecyclerView recyclerViewTaskPage;
    private ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_task_page);

        final TextView txtTitle = (TextView) findViewById(R.id.editTextTitle);
        List<String> str_data = new ArrayList<>();

        recyclerViewTaskPage = (RecyclerView) findViewById(R.id.listViewTaskPage);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String taskStr = extras.getString("task");
            Task task = new Gson().fromJson(taskStr,Task.class);

            //setting title for Task

            txtTitle.setText(task.getTitle());

            //setting Color of the Task.
            bar = getSupportActionBar();
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#"+task.getColor())));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_task_page);
            relativeLayout.setBackgroundColor(Color.parseColor("#"+task.getColor()));
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#"+task.getColor()));

            //adapting the unit Tasks of Task.
            recyclerViewTaskPage.setHasFixedSize(true);
            recyclerViewTaskPage.setLayoutManager(new LinearLayoutManager(this));
            TaskPageRecyclerAdapter taskPageRecyclerAdapter = new TaskPageRecyclerAdapter(getApplicationContext(),task.getMini_tasks());
            recyclerViewTaskPage.setAdapter(taskPageRecyclerAdapter);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task_page_menu,menu);
        return true;
    }
}
