package com.example.bohdan.converterlab.organisationsModel.currencies;

/**
 * Created by Bohdan on 21.09.2015.
 */
public abstract class CurrenciesABS  {
    private String ask;
    private String bid;
    private String name;

    public CurrenciesABS(String ask, String bid, String name) {
        this.ask = ask;
        this.bid = bid;
        this.name = name;
    }

    public abstract String getAsk();

    public abstract void setAsk(String ask);

    public abstract String getBid();

    public abstract void setBid(String bid);

    public abstract String getName();

    public abstract void setName(String name);


}
