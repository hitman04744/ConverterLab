package com.example.bohdan.converterlab.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


public class OrganisationsDB extends SQLiteOpenHelper  implements BaseColumns{
    private static final String DATABASE_NAME = "organisationsDataBase.db";
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE = "organisations";
    public static final String DATABASE_TABLE1 = "currencies";



    public static final String ORG_TYPE_COLUMN = "orgType";
    public static final String ID_COLUMN = "id";
    public static final String PHONE_COLUMN = "phone";
    public static final String TITLE_COLUMN = "title";
    public static final String OLD_ID_COLUMN = "oldId";
    public static final String ADRESS_COLUMN = "address";
    public static final String CITY_ID_COLUMN = "cityId";
    public static final String LINK_COLUMN = "link";
    public static final String REGION_ID_COLUMN = "regionId";

    public static final String СURRENCY_COLUMN = "currency";
    public static final String ASK_COLUMN = "ask";
    public static final String BID_COLUMN = "bid";


    private static final String DATABASE_CREATE_SCRIPT = "CREATE TABLE "
            + DATABASE_TABLE + " ("
            + ORG_TYPE_COLUMN + " TEXT,"
            + ID_COLUMN + " TEXT,"
            + PHONE_COLUMN + " TEXT,"
            + TITLE_COLUMN + " TEXT,"
            + OLD_ID_COLUMN + " TEXT,"
            + ADRESS_COLUMN + " TEXT,"
            + CITY_ID_COLUMN + " TEXT,"
            + LINK_COLUMN + " TEXT,"
            + REGION_ID_COLUMN + " TEXT);";

    private static final String DATABASE_CREATE_SCRIPT1 = "CREATE TABLE "
            + DATABASE_TABLE1 + " ("
            + ID_COLUMN + " TEXT,"
            + TITLE_COLUMN + " TEXT,"
            + СURRENCY_COLUMN + " TEXT,"
            + BID_COLUMN + " TEXT,"
            + ASK_COLUMN + " TEXT);";




    public OrganisationsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        db.execSQL(DATABASE_CREATE_SCRIPT1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        onCreate(db);

    }
}
