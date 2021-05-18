package com.chenhao.dao.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String phone;

    private String username;

    private String password;

    private String gender;

    private String truename;

    private String birthday;

    private String email;

    private String personalbrief;

    private String recentlylanded;

    private Integer isActive;

    private String avatarimgurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPersonalbrief() {
        return personalbrief;
    }

    public void setPersonalbrief(String personalbrief) {
        this.personalbrief = personalbrief == null ? null : personalbrief.trim();
    }

    public String getRecentlylanded() {
        return recentlylanded;
    }

    public void setRecentlylanded(String recentlylanded) {
        this.recentlylanded = recentlylanded == null ? null : recentlylanded.trim();
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getAvatarimgurl() {
        return avatarimgurl;
    }

    public void setAvatarimgurl(String avatarimgurl) {
        this.avatarimgurl = avatarimgurl == null ? null : avatarimgurl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", gender=").append(gender);
        sb.append(", truename=").append(truename);
        sb.append(", birthday=").append(birthday);
        sb.append(", email=").append(email);
        sb.append(", personalbrief=").append(personalbrief);
        sb.append(", recentlylanded=").append(recentlylanded);
        sb.append(", isActive=").append(isActive);
        sb.append(", avatarimgurl=").append(avatarimgurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}