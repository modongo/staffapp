package com.staff.staffapp.faq.model;

public class SupportMedical {
    private  String title;
    private int image;

    public SupportMedical(String title, int image){

        this.title = title;
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
