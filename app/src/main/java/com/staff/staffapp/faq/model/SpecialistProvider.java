package com.staff.staffapp.faq.model;

public class SpecialistProvider {
    private  String title;
    private int image;


    public SpecialistProvider(String title, int image ){

        this.title = title;
        this.image = image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {

        this.title = title;
    }


}
