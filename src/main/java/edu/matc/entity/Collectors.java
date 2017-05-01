package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by David on 2/16/17.
 */
@Entity
@Table(name = "collectors")
public class Collectors {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    public Collectors(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Collectors() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
