package com.start.lvart;

/**
 * Created by user on 2017/6/13.
 */

public class Database {

    private String title; //name 活動名稱

    private String showUnit; //player 活動展演者

    private String time; //time 活動時間

    private String endTime; //endtime 活動結束時間

    private String locationName; //stand 活動場地

    private String location; //address 場地地址

    private String price; //value 票價

    private String sourceWebName; //system 售票系統

    private String webSales; //systemweb 售票網址

    private String masterUnit; //unit 主辦單位

    private String sourceWebPromote; //web 活動網址

    private String descriptionFilterHtml; //outline 簡介

    private String latitude; //緯度

    private String longitude; //經度

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowUnit() {
        return showUnit;
    }

    public void setShowUnit(String showUnit) {
        this.showUnit = showUnit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWebSales() {
        return webSales;
    }

    public void setWebSales(String webSales) {
        this.webSales = webSales;
    }

    public String getSourceWebName() {
        return sourceWebName;
    }

    public void setSourceWebName(String sourceWebName) {
        this.sourceWebName = sourceWebName;
    }

    public String getSourceWebPromote() {
        return sourceWebPromote;
    }

    public void setSourceWebPromote(String sourceWebPromote) {
        this.sourceWebPromote = sourceWebPromote;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMasterUnit() {
        return masterUnit;
    }

    public void setMasterUnit(String masterUnit) {
        this.masterUnit = masterUnit;
    }

    public String getDescriptionFilterHtml() {
        return descriptionFilterHtml;
    }

    public void setDescriptionFilterHtml(String descriptionFilterHtml) {
        this.descriptionFilterHtml = descriptionFilterHtml;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
