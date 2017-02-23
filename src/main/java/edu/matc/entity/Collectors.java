package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by David on 2/16/17.
 */
@Entity
@Table(name = "collectors")
public class Collectors {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idcollectors")
    private int id;

    public Collectors(String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int collectorId) {
        this.id = id;
    }

}
