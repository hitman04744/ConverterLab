package com.example.bohdan.converterlab.asyncTask;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.bohdan.converterlab.dataBase.OrganisationsDB;
import com.example.bohdan.converterlab.organisationsModel.Currencies;
import com.example.bohdan.converterlab.organisationsModel.Organisations;
import com.example.bohdan.converterlab.organisationsModel.currencies.EUR;
import com.example.bohdan.converterlab.organisationsModel.currencies.RUB;
import com.example.bohdan.converterlab.organisationsModel.currencies.USD;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by Bohdan on 14.09.2015.
 */
public class RequestTask extends AsyncTask<Void,Integer,String> {
    private static final String LOG_TAG = "my_log";
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    Context mContext;
    RecyclerView rv;
    ProgressDialog progressDialog;
    LinearLayoutManager layoutmanager;
    private OrganisationsDB mOrganisationsDB;

    private SQLiteDatabase mSqLiteDatabase;
    private SQLiteDatabase mSqLiteDatabase1;
    public AsyncResponse delegate = (AsyncResponse) mContext;


    ArrayList<Organisations> mList = new ArrayList<>();

    public RequestTask (Context context, RecyclerView rv){
        this.mContext = context;
        this.rv = rv;

    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();

//        progressDialog = new ProgressDialog(mContext);
//        progressDialog.setIndeterminate(false);
//        progressDialog.setMax(100);
//        progressDialog.setProgress(0);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progressDialog.setMessage("Downloading Data");
//        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        Log.d(LOG_TAG, "Start");
        try {
            URL url = new URL("http://resources.finance.ua/ru/public/currency-cash.json");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            int lenghtOfFile = urlConnection.getContentLength();

            InputStream inputStream = urlConnection.getInputStream();

            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader((inputStream)));

            String line;
            int i=0;
            long readLength = 0;
            Log.d(LOG_TAG, lenghtOfFile+"");

            while ((line = reader.readLine()) != null) {
                readLength += (line.length());

                buffer.append(line);
                buffer.length();
                Log.d(LOG_TAG, buffer.length() + "");
                publishProgress((int) ((readLength / lenghtOfFile) * 100));
            }

            resultJson = buffer.toString();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
//        progressDialog.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
        Log.d(LOG_TAG, "Stop");

        JSONObject dataJsonObj = null;
        mOrganisationsDB = new OrganisationsDB(mContext);


        mSqLiteDatabase = mOrganisationsDB.getWritableDatabase();

        ContentValues newValues = new ContentValues();
        ContentValues newValues1 = new ContentValues();


        String askRUB = "";
        String bidRUB = "";
        String askEUR = "";
        String bidEUR = "";
        String askUSD = "";
        String bidUSD = "";

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray  organizations = dataJsonObj.getJSONArray("organizations");
            JSONObject regions =  dataJsonObj.getJSONObject("regions");
            JSONObject cities =  dataJsonObj.getJSONObject("cities");
            JSONObject currencies =  dataJsonObj.getJSONObject("currencies");


            for (int i = 0; i < organizations.length(); i++) {
                JSONObject banks = organizations.getJSONObject(i);
                JSONObject JsonCurrencies = banks.getJSONObject("currencies");

                if (JsonCurrencies.has("RUB")) {
                    askRUB = JsonCurrencies.getJSONObject("RUB").getString("ask");
                    bidRUB = JsonCurrencies.getJSONObject("RUB").getString("bid");
                }
                if (JsonCurrencies.has("USD")) {

                    askUSD = JsonCurrencies.getJSONObject("USD").getString("ask");
                    bidUSD = JsonCurrencies.getJSONObject("USD").getString("bid");
                }
                if (JsonCurrencies.has("EUR")) {

                    askEUR = JsonCurrencies.getJSONObject("EUR").getString("ask");
                    bidEUR = JsonCurrencies.getJSONObject("EUR").getString("bid");
                }

                String orgType = banks.getString("orgType");
                String id = banks.getString("id");
//                Currencies currency = new Currencies(new RUB(currencies.getString("RUB"),askRUB, bidRUB),
//                        new USD(currencies.getString("USD"),askUSD, bidUSD),
//                        new EUR(currencies.getString("EUR"),askEUR, bidEUR));
//                currenc RUB(currencies.getString("RUB"),askRUB, bidRUB
                Currencies currency = new Currencies();
                currency.setRUB(new RUB(currencies.getString("RUB"),askRUB, bidRUB));
                currency.setUSD(new USD(currencies.getString("USD"), askUSD, bidUSD));
                currency.setEUR(new EUR(currencies.getString("EUR"),askEUR, bidEUR));

                String phone = banks.getString("phone");
                String title = banks.getString("title");
                String oldId = banks.getString("oldId");
                String address = banks.getString("address");
                String link = banks.getString("link");
                String regionId = regions.getString(banks.getString("regionId"));
                String cityId = cities.getString(banks.getString("cityId"));

                /*
                *
                * Запись в базу данных Банков(название,город...)
                *
                */

                newValues.put(mOrganisationsDB.ORG_TYPE_COLUMN, orgType);
                newValues.put(mOrganisationsDB.ID_COLUMN ,id);
                newValues.put(mOrganisationsDB.PHONE_COLUMN ,phone);
                newValues.put(mOrganisationsDB.TITLE_COLUMN ,title);
                newValues.put(mOrganisationsDB.OLD_ID_COLUMN , oldId);
                newValues.put(mOrganisationsDB.ADRESS_COLUMN, address);
                newValues.put(mOrganisationsDB.CITY_ID_COLUMN, cityId);
                newValues.put(mOrganisationsDB.LINK_COLUMN, link);
                newValues.put(mOrganisationsDB.REGION_ID_COLUMN, regionId);

                mSqLiteDatabase.insert("organisations", null, newValues);


                /*
                *
                * Запись в базу данных Валют
                *
                */


                newValues1.put(mOrganisationsDB.ID_COLUMN, id);
                newValues1.put(mOrganisationsDB.TITLE_COLUMN, title);
                newValues1.put(mOrganisationsDB.СURRENCY_COLUMN,currency.getRUB().getName());
                newValues1.put(mOrganisationsDB.ASK_COLUMN,currency.getRUB().getAsk());
                newValues1.put(mOrganisationsDB.BID_COLUMN, currency.getRUB().getBid());
                mSqLiteDatabase.insert("currencies", null, newValues1);
                newValues1.put(mOrganisationsDB.ID_COLUMN, id);
                newValues1.put(mOrganisationsDB.TITLE_COLUMN, title);
                newValues1.put(mOrganisationsDB.СURRENCY_COLUMN,currency.getUSD().getName());
                newValues1.put(mOrganisationsDB.ASK_COLUMN,currency.getUSD().getAsk());
                newValues1.put(mOrganisationsDB.BID_COLUMN,currency.getUSD().getBid());
                mSqLiteDatabase.insert("currencies", null, newValues1);
                newValues1.put(mOrganisationsDB.ID_COLUMN, id);
                newValues1.put(mOrganisationsDB.TITLE_COLUMN, title);
                newValues1.put(mOrganisationsDB.СURRENCY_COLUMN,currency.getEUR().getName());
                newValues1.put(mOrganisationsDB.ASK_COLUMN,currency.getEUR().getAsk());
                newValues1.put(mOrganisationsDB.BID_COLUMN,currency.getEUR().getBid());
                mSqLiteDatabase.insert("currencies", null, newValues1);


//              String regionId = banks.getString("regionId");
//              String cityId   = banks.getString("cityId");

                        mList.add(new Organisations(id, currency, phone, title, oldId, address, cityId, link, regionId));
                        delegate.processFinish(mList);
                Log.d(LOG_TAG, mList.toString());
            }
            Log.d(LOG_TAG, "final");

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        layoutmanager = new LinearLayoutManager(mContext);
//        rv.setLayoutManager(layoutmanager);
//        rv.setItemAnimator(new DefaultItemAnimator());
//        RVAdapter adapter = new RVAdapter(mContext,mList);
//        rv.setAdapter(adapter);


    }





}
