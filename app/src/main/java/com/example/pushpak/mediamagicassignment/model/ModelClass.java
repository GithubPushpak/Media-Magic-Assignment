package com.example.pushpak.mediamagicassignment.model;

import org.simpleframework.xml.Element;

/**
 * Created by Pushpak on 3/26/2022.
 */

public class ModelClass {

    @Element(name = "StationId")
    private String stationId;

    @Element(name = "StationName")
    private String stationName;

    @Element(name = "Logo")
    private String logo;


    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
