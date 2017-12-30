package com.timeline.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "postId", updatable = false)
    private Long postId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "createdAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date createdAt;

    @Column(name = "updatedAt", insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private Date updatedAt;

    public Comment(Long postId, User user, String content, Date createdAt) {
        this.postId = postId;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
