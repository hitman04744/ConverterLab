package com.example.bohdan.converterlab;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.bohdan.converterlab.asyncTask.RequestTask;

import java.util.Timer;
import java.util.TimerTask;

public class UpdateService extends Service {
RecyclerView rv;
    RequestTask requestTask;
    boolean state=false;
    @Override
    public void onCreate() {
        super.onCreate();
//        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
//        rv.findViewById(R.id.rv);
//        rv.setLayoutManager(layoutmanager);
//        rv.setItemAnimator(new DefaultItemAnimator());
//        new RequestTask(this,rv).execute();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {


       requestTask = new RequestTask(this,rv);
        Timer time =new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                requestTask.execute();

                Log.d("Task", "waiting");

            }
        };


//        time.scheduleAtFixedRate(task1, 3000, 1800000);





        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        state=false;
        super.onDestroy();
    }



    public UpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
