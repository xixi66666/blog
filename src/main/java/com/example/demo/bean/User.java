package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private int User_ID;
    private String User_name;
    private String password;
    private int sex;
    private String email;
    private String phone;
    private String firstname;
    private String lastname;
    private String head;
    private int is_admin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date last_login;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date register;
    private int level;
    private int experience;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    private int freeze_id;
    private String status;
    private int freeze_comment;
    private int freeze_friend;

    public User() {
    }

    public User(int user_ID, String user_name, String password, int sex, String email, String phone, String firstname, String lastname, String head, int is_admin, Date last_login, Date register, int level, int experience, Date birthday, int freeze_id, String status, int freeze_comment, int freeze_friend) {
        User_ID = user_ID;
        User_name = user_name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.head = head;
        this.is_admin = is_admin;
        this.last_login = last_login;
        this.register = register;
        this.level = level;
        this.experience = experience;
        this.birthday = birthday;
        this.freeze_id = freeze_id;
        this.status = status;
        this.freeze_comment = freeze_comment;
        this.freeze_friend = freeze_friend;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getFreeze_id() {
        return freeze_id;
    }

    public void setFreeze_id(int freeze_id) {
        this.freeze_id = freeze_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFreeze_comment() {
        return freeze_comment;
    }

    public void setFreeze_comment(int freeze_comment) {
        this.freeze_comment = freeze_comment;
    }

    public int getFreeze_friend() {
        return freeze_friend;
    }

    public void setFreeze_friend(int freeze_friend) {
        this.freeze_friend = freeze_friend;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_ID=" + User_ID +
                ", User_name='" + User_name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", head='" + head + '\'' +
                ", is_admin=" + is_admin +
                ", last_login=" + last_login +
                ", register=" + register +
                ", level=" + level +
                ", experience=" + experience +
                ", birthday=" + birthday +
                ", freeze_id=" + freeze_id +
                ", status='" + status + '\'' +
                ", freeze_comment=" + freeze_comment +
                ", freeze_friend=" + freeze_friend +
                '}';
    }
}
