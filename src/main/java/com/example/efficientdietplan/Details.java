package com.example.efficientdietplan;

public class Details {
    String id;
    String email;
    String height;
    String weight;
    String gender;

    public Details(String id,String email,String gender,String height,String weight) {
        this.id=id;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.gender = gender;

    }

    public String getEmail() {
        return email;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String setId() {
        return id;
    }
}
