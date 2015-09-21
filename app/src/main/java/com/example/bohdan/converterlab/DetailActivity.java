package com.example.bohdan.converterlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bohdan.converterlab.adapter.CustomListViewAdapter;
import com.example.bohdan.converterlab.dataBase.OrganisationsDB;
import com.example.bohdan.converterlab.organisationsModel.Currencies;
import com.example.bohdan.converterlab.organisationsModel.currencies.EUR;
import com.example.bohdan.converterlab.organisationsModel.currencies.RUB;
import com.example.bohdan.converterlab.organisationsModel.currencies.USD;

import java.util.ArrayList;


/**
 * Created by Bohdan on 16.09.2015.
 */
public class DetailActivity extends AppCompatActivity {
    private OrganisationsDB mOrganisationsDB ;
    ArrayList<Object> list = new ArrayList<>();

    Currencies currencies = new Currencies();
    RUB rub;
    USD usd;
    EUR eur;
    TextView mCurrencyName;
    TextView mAsk;
    TextView mBid;

    TextView mTitle;
    TextView mURL;
    TextView mAdress;
    TextView mHotline;
    TextView mPhone;
    TextView mPhone2;
    TextView mEmail;
    ListView lvMain;
    CustomListViewAdapter mCustomListViewAdapter;
    String bankName;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bankName = getIntent().getStringExtra("name");
        setContentView(R.layout.details_layout);
        findViews();
        mOrganisationsDB = new OrganisationsDB(this);
        list = ReadDb();
        ReadDbInfo();

        mCustomListViewAdapter = new CustomListViewAdapter(this, list);
        lvMain.setAdapter(mCustomListViewAdapter);



    }
     public void findViews(){
         mTitle = (TextView) findViewById(R.id.bank_title_DA);
         mURL = (TextView) findViewById(R.id.bank_site_Url_DA);
         mAdress = (TextView) findViewById(R.id.bank_adress_DA);
         mHotline  = (TextView) findViewById(R.id.hotLine_DA);
         mPhone = (TextView) findViewById(R.id.phone_number_DA);
         mPhone2 = (TextView) findViewById(R.id.phone_number_foreign_DA);
         mEmail = (TextView) findViewById(R.id.email_DA);
         mCurrencyName = (TextView)findViewById(R.id.currency_name_DA);
         mAsk = (TextView) findViewById(R.id.ask_DA);
         mBid = (TextView) findViewById(R.id.bid_DA);
         lvMain = (ListView) findViewById(R.id.lvMain);

     }



    private ArrayList<Object>  ReadDb() {

        SQLiteDatabase db = mOrganisationsDB.getWritableDatabase();

        String select = "SELECT * FROM " + mOrganisationsDB.DATABASE_TABLE1;
        Cursor c = db.rawQuery(select, null);
        StringBuilder sb = new StringBuilder();
        int wordIndex = c.getColumnIndex(mOrganisationsDB.TITLE_COLUMN);
        int definitionIndex = c.getColumnIndex(mOrganisationsDB.СURRENCY_COLUMN);
        int definitionIndex2 = c.getColumnIndex(mOrganisationsDB.ASK_COLUMN);
        int definitionIndex3 = c.getColumnIndex(mOrganisationsDB.BID_COLUMN);

        c.moveToFirst();
        String title = "";

        while (c.moveToNext()){
        title = c.getString(wordIndex);
        String currency = c.getString(definitionIndex);
        String ask = c.getString(definitionIndex2);
        String bid = c.getString(definitionIndex3);
            if (title.equals(bankName)){
                switch (currency) {
                    case ("российские рубли"):
                        rub = new RUB(currency, ask, bid);
                        currencies.setRUB(rub);

                        break;
                    case ("доллары США"):

                        usd = new USD(currency, ask, bid);
                        currencies.setUSD(usd);
                        break;
                    case ("ЕВРО"):
                        eur = new EUR(currency, ask, bid);
                        currencies.setEUR(eur);
                        break;
                }

            }

        }

        ArrayList<Object> list2 = new ArrayList<>();

        list2.add(rub);
        list2.add(usd);
        list2.add(eur);
        Log.d("my", currencies.toString());
        return list2;




    }

    private void ReadDbInfo() {
        SQLiteDatabase db = mOrganisationsDB.getWritableDatabase();

        String select = "SELECT * FROM " + mOrganisationsDB.DATABASE_TABLE;
        Cursor c = db.rawQuery(select, null);
        StringBuilder sb = new StringBuilder();

        int wordIndex = c.getColumnIndex(mOrganisationsDB.TITLE_COLUMN);
        int definitionIndex = c.getColumnIndex(mOrganisationsDB.PHONE_COLUMN);
        int definitionIndex2 = c.getColumnIndex(mOrganisationsDB.LINK_COLUMN);
        int definitionIndex3 = c.getColumnIndex(mOrganisationsDB.ADRESS_COLUMN);

        c.moveToFirst();
        String title = "";

        while (c.moveToNext()){
            title = c.getString(wordIndex);
            String phone = c.getString(definitionIndex);
            String link = c.getString(definitionIndex2);
            String adress = c.getString(definitionIndex3);
            if (title.equals(bankName)){
                mTitle.setText(title);
                mPhone.setText(phone);
                mAdress.setText(adress);
                mURL.setText(link);

                }
        }


    }
}

