package com.timeline.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "followRelation")
public class FollowRelation {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "followUserId")
    private User followUser;

    @Column(name = "createdAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date createdAt;

    public FollowRelation(User user, User followUser, Date createdAt) {
        this.user = user;
        this.followUser = followUser;
        this.createdAt = createdAt;
    }

    public FollowRelation() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollowUser() {
        return followUser;
    }

    public void setFollowUser(User followUser) {
        this.followUser = followUser;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
