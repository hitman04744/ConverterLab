package com.example.bohdan.converterlab.organisationsModel.currencies;


public class GBP {

    private String ask;

    private String bid;

    public String getAsk ()
    {
        return ask;
    }

    public void setAsk (String ask)
    {
        this.ask = ask;
    }

    public String getBid ()
    {
        return bid;
    }

    public void setBid (String bid)
    {
        this.bid = bid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ask = "+ask+", bid = "+bid+"]";
    }
}


