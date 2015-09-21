package com.example.bohdan.converterlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bohdan.converterlab.adapter.RVAdapter;
import com.example.bohdan.converterlab.asyncTask.AsyncResponse;
import com.example.bohdan.converterlab.asyncTask.RequestTask;
import com.example.bohdan.converterlab.organisationsModel.Organisations;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    Intent intent;
    ArrayList<Organisations>mList= new ArrayList<>();
    RequestTask requestTask;
    RecyclerView rv;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RVAdapter adapter;
    boolean status = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);

        startService(
                intent = new Intent(MainActivity.this, UpdateService.class)
        );

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(layoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());

        adapter = new RVAdapter(this,mList);
        rv.setAdapter(adapter);
        requestTask = new RequestTask(this,rv);
        requestTask.delegate = this;
        requestTask.execute();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
//        new RequestTask(this,rv).execute();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

    }

    private void refreshItems() {
        requestTask = new RequestTask(this,rv);
        requestTask.delegate = this;
        requestTask.execute();
        if(status){
            onItemsLoadComplete();
        }

    }

    private void onItemsLoadComplete() {
        adapter.notifyDataSetChanged();
        Toast.makeText(this,"REFRESHED",Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
        status = false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void processFinish(ArrayList<Organisations> list) {
        this.mList = list;
        this.status = status;
        RVAdapter adapter = new RVAdapter(this,mList);
        rv.setAdapter(adapter);
    }
}
