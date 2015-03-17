package com.lt.study.mongo;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by luotao on 2015/3/16.
 */
public class UserData {
    private Set<String> pets;
    private Map<String, String> favoriteMovies;
    private Date birthday;
    private String name;
    private String password;


    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setPets(Set<String> pets) {
        this.pets = pets;
    }

    public Set<String> getPets() {
        return pets;
    }

    public void setFavoriteMovies(Map<String, String> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public Map<String, String> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
