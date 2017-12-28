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

    private Long postId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
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
}
