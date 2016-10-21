package com.sviet.anuragkumar.karma;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sviet.anuragkumar.karma.adapters.TaskListRecyclerAdapter;
import com.sviet.anuragkumar.karma.expo.AppBarPractice;
import com.sviet.anuragkumar.karma.models.Task;
import com.sviet.anuragkumar.karma.models.UnitTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Menu menu;
    private TextView textViewNavMain,textViewNavAlter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView listViewTaskList;
        /*
        Generating prototype dataset for adapter.
         */
        ArrayList<UnitTask> minis = new ArrayList<>();
        String colors[] = {"ef9a9a","F48FB1","CE93D8","B39DDB","C5E1A5","FFF176","81D4FA"};
        minis.add(new UnitTask("hello",false));
        minis.add(new UnitTask("hello 2",false));
        ArrayList<UnitTask> minis2 = new ArrayList<>();
        minis2.add(new UnitTask("hello, everyone, this is Anurag kumar......",true));
        minis2.add(new UnitTask("hello 2",true));
        ArrayList<UnitTask> minis3 = new ArrayList<>();
        minis3.add(new UnitTask("hello, everyone, this is Anurag kumar......there are many more things to say, but i will end here. Joe Don",false));
        minis3.add(new UnitTask("hello 2",true));
        ArrayList<Task> taskArrayList = new ArrayList<>();
        taskArrayList.add(new Task("45","Go Out",    minis2, colors[0]));
        taskArrayList.add(new Task("45","Go Out2",   minis3, colors[2]));
        taskArrayList.add(new Task("45","Go Out3",   minis,  colors[3]));
        taskArrayList.add(new Task("45","Go Out4",   minis2, colors[4]));
        taskArrayList.add(new Task("45","Go Out5",   minis,  colors[1]));
        taskArrayList.add(new Task("45","Go Out6",   minis,  colors[5]));
        taskArrayList.add(new Task("45","Go Out",    minis3, colors[4]));
        taskArrayList.add(new Task("45","Go Out2",   minis2, colors[2]));
        taskArrayList.add(new Task("45","Go Out3",   minis,  colors[1]));
        taskArrayList.add(new Task("45","Go Out4",   minis2, colors[0]));
        taskArrayList.add(new Task("45","Go Out5",   minis,  colors[2]));
        taskArrayList.add(new Task("45","Go Out6",   minis3, colors[4]));
        taskArrayList.add(new Task("45","Go Out",    minis2, colors[3]));
        taskArrayList.add(new Task("45","Go Out2",   minis,  colors[0]));
        taskArrayList.add(new Task("45","Go Out3",   minis3, colors[5]));
        taskArrayList.add(new Task("45","Go Out4",   minis2, colors[6]));
        taskArrayList.add(new Task("45","Go Out5",   minis2, colors[0]));
        taskArrayList.add(new Task("45","Go Out6",   minis3, colors[6]));
        taskArrayList.add(new Task("45","Go Out",    minis2, colors[3]));
        taskArrayList.add(new Task("45","Go Out2",   minis,  colors[2]));
        taskArrayList.add(new Task("45","Go Out3",   minis3, colors[0]));
        taskArrayList.add(new Task("45","Go Out4",   minis,  colors[1]));
        taskArrayList.add(new Task("45","Go Out5",   minis,  colors[4]));
        taskArrayList.add(new Task("45","Go Out6",   minis,  colors[6]));
        // end.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //put create new task functionality.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TaskPage.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //filling recyclerView with the Task Set Datas.
        listViewTaskList = (RecyclerView) findViewById(R.id.list);
        listViewTaskList.setHasFixedSize(false);
        listViewTaskList.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        listViewTaskList.setItemAnimator(new DefaultItemAnimator());
        TaskListRecyclerAdapter taskListAdapter = new TaskListRecyclerAdapter(this,taskArrayList);
        listViewTaskList.setAdapter(taskListAdapter);

        getWindow().setExitTransition(new Explode().excludeTarget(R.id.toolbar,true));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            menu.clear();

        } else if (id == R.id.nav_manage) {

            startActivity(new Intent(MainActivity.this,Login_signup.class));


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(MainActivity.this, AppBarPractice.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
