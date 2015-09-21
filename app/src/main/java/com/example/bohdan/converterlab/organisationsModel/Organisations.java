package com.example.bohdan.converterlab.organisationsModel;

/**
 * Created by Bohdan on 15.09.2015.
 */
public class Organisations {


        private String orgType;

        private String id;

        private Currencies currencies;

        private String phone;

        private String title;

        private String oldId;

        private String address;

        private String cityId;

        private String link;

        private String regionId;

    public Organisations(String id, Currencies currencies, String phone, String title, String oldId, String address, String cityId, String link, String regionId) {
        this.id = id;
        this.currencies = currencies;
        this.phone = phone;
        this.title = title;
        this.oldId = oldId;
        this.address = address;
        this.cityId = cityId;
        this.link = link;
        this.regionId = regionId;
    }

    public String getOrgType ()
        {
            return orgType;
        }

        public void setOrgType (String orgType)
        {
            this.orgType = orgType;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public Currencies getCurrencies ()
        {
            return currencies;
        }

        public void setCurrencies (Currencies currencies)
        {
            this.currencies = currencies;
        }

        public String getPhone ()
        {
            return phone;
        }

        public void setPhone (String phone)
        {
            this.phone = phone;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String getOldId ()
        {
            return oldId;
        }

        public void setOldId (String oldId)
        {
            this.oldId = oldId;
        }

        public String getAddress ()
        {
            return address;
        }

        public void setAddress (String address)
        {
            this.address = address;
        }

        public String getCityId ()
        {
            return cityId;
        }

        public void setCityId (String cityId)
        {
            this.cityId = cityId;
        }

        public String getLink ()
        {
            return link;
        }

        public void setLink (String link)
        {
            this.link = link;
        }

        public String getRegionId ()
        {
            return regionId;
        }

        public void setRegionId (String regionId)
        {
            this.regionId = regionId;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [orgType = "+orgType+", id = "+id+", currencies = "+currencies+", phone = "+phone+", title = "+title+", oldId = "+oldId+", address = "+address+", cityId = "+cityId+", link = "+link+", regionId = "+regionId+"]";
        }



}
