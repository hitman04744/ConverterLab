package com.example.bohdan.converterlab.organisationsModel.currencies;




public class USD extends CurrenciesABS  {
    private String name;

    private String ask;
    private String bid;

    public USD(String name,String ask, String bid) {
        super(name,ask,bid);
        this.name = name;
        this.ask = ask;
        this.bid = bid;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}