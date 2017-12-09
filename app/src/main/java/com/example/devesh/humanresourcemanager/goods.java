package com.example.devesh.humanresourcemanager;

/**
 * Created by devesh on 8/11/17.
 */

public class goods {
    String name ;
    String pice ;
    String description  ;

    public goods(String name ,String pice , String description) {

        this.name = name;
        this.pice = pice;
        this.description = description;
    }
    public goods() {


    }


    public String getName() {
        return name;
    }

    public String getPice() {
        return pice;
    }

    public String getDescription() {
        return description;
    }
}

