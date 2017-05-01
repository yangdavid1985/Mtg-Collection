package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by David on 3/6/17.
 */
@Entity
@Table(name = "collector_roles")
public class CollectorRole {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "role_name")
    private String role_name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}