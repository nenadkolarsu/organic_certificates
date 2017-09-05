/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pionir SU
 */
public class User {

    public String user_email;
    public String user_password;

    public User() {
    }

    public User(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public List<User> getAll() {
        List<User> lst = new ArrayList<User>();

        return lst;
    }

}
