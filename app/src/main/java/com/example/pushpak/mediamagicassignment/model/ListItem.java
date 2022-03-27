package com.example.pushpak.mediamagicassignment.model;

import org.simpleframework.xml.ElementArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pushpak on 3/27/2022.
 */

public class ListItem {

    @ElementArray(name = "ListOfItems")
    private List<ModelClass> list;

    public List<ModelClass> getList() {
        return list;
    }

    public void setList(List<ModelClass> list) {
        this.list = list;
    }
}
