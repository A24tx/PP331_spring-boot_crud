package com.ax.crud.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "userstable_pp331")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "country")
    private String country;

    public User(String name, Integer age, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && getAge() == user.getAge() && Objects.equals(getName(), user.getName()) && Objects.equals(getCountry(), user.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getCountry());
    }
}
