package com.example.bohdan.converterlab.organisationsModel;

import com.example.bohdan.converterlab.organisationsModel.currencies.USD;
import com.example.bohdan.converterlab.organisationsModel.currencies.RUB;
import com.example.bohdan.converterlab.organisationsModel.currencies.EUR;
import com.example.bohdan.converterlab.organisationsModel.currencies.GBP;



public class Currencies
{
    private String BankName;
    private EUR EUR;

    private RUB RUB;

    private USD USD;

    private GBP GBP;

//    public Currencies( RUB RUB, USD USD, EUR EUR) {
//        this.EUR = EUR;
//        this.RUB = RUB;
//        this.USD = USD;
//    }

    public EUR getEUR ()
    {
        return EUR;
    }

    public void setEUR (EUR EUR)
    {
        this.EUR = EUR;
    }

    public RUB getRUB ()
    {
        return RUB;
    }

    public void setRUB (RUB RUB)
    {
        this.RUB = RUB;
    }

    public USD getUSD ()
    {
        return USD;
    }

    public void setUSD (USD USD)
    {
        this.USD = USD;
    }

    public GBP getGBP ()
    {
        return GBP;
    }

    public void setGBP (GBP GBP)
    {
        this.GBP = GBP;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EUR = "+EUR+", RUB = "+RUB+", USD = "+USD+", GBP = "+GBP+"]";
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }
}

