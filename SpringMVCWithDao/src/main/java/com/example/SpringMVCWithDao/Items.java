package com.example.SpringMVCWithDao;

public class Items {

    private String itemcode;
    private String itemdesc;

    public Items(String itemcode, String itemdesc){
        this.itemcode = itemcode;
        this.itemdesc = itemdesc;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }
}
