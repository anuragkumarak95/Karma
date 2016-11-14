package com.sviet.anuragkumar.karma;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class LeaderBoard extends AppCompatActivity {

    RecyclerView recyclerViewLeaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewLeaderboard = (RecyclerView) findViewById(R.id.recyclerViewLeaderBoard);
        recyclerViewLeaderboard.setHasFixedSize(true);
        recyclerViewLeaderboard.setLayoutManager(new LinearLayoutManager(this));

        String[] data = {"hi","hello"};
        // ArrayAdapter<String> scn = new ArrayAdapter<String>(Arrays.asList(data));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
