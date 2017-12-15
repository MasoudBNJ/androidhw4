package org.maktab.masoudbn.flexiblefragment;

/**
 * Created by MasoudBN on 01/12/2017.
 */

public class TourismPlace {
    private int id;
    private String title;
    private String address;
    private String details;
    private String imageName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public TourismPlace()
    {

    }
    public TourismPlace(String title, String address, String details, String imageName)
    {
        this.title = title;
        this.address = address;
        this.details = details;
        this.imageName = imageName;
    }
}
