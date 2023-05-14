package com.example.giuaky.model;


import java.sql.Timestamp;
import java.util.Date;

public class Tour {
    private  String name;
    private  String urlImage;
    private Date startDate;
    private int totalDay;
    private  int price;
    private String tourDestination;

    public Tour() {

    }

    public Tour(String name, String urlImage, Date startDate, int totalDay, int price, String tourDestination) {
        this.name = name;
        this.urlImage = urlImage;
        this.startDate = startDate;
        this.totalDay = totalDay;
        this.price = price;
        this.tourDestination = tourDestination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTourDestination() {
        return tourDestination;
    }

    public void setTourDestination(String tourDestination) {
        this.tourDestination = tourDestination;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", startDate=" + startDate +
                ", totalDay=" + totalDay +
                ", price=" + price +
                ", tourDestination='" + tourDestination + '\'' +
                '}';
    }
}
