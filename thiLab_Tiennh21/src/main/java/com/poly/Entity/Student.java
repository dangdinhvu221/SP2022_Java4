package com.poly.Entity;

import java.util.Date;

public class Student {
    private String code, fullname, major, phone, email;
    private boolean gender;
    private Date date;

    public Student() {
    }

    public Student(String code, String fullname, String major, String phone, String email, boolean gender, Date date) {
        this.code = code;
        this.fullname = fullname;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
