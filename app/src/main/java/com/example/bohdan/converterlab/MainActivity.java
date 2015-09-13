package com.example.bohdan.converterlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Banks> banks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(layoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());
        banks = initBanks();

        RVAdapter adapter = new RVAdapter(banks);
        rv.setAdapter(adapter);



    }

   public  ArrayList<Banks> initBanks(){
       ArrayList<Banks> bankss = new ArrayList<>();
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));
        bankss.add(new Banks("Альфа-Банк", "Закарпатская область","Ужгород","lol","LOL"));


        return bankss;

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
}
