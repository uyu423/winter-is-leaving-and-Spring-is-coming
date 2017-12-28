package com.timeline.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;

    @Column(name = "createdAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date createdAt;

    @Column(name = "updatedAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
