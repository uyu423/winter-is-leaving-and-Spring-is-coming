package com.timeline.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Stream;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="userId")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="postId")
    private Collection<Comment> comments;

    @Column(name = "createdAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date createdAt;

    @Column(name = "updatedAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date updatedAt;

    public Post(User user, String content, Date createdAt) {
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Post() {}


    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
