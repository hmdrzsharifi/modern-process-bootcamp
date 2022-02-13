package com.modern.process.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_comment", schema = "public")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "post_review", length = 50, nullable = false)
    private String review;

    @Transient
    private Integer code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_Date;

    @Enumerated(EnumType.STRING)
    private CommentType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getComment_Date() {
        return comment_Date;
    }

    public void setComment_Date(Date comment_Date) {
        this.comment_Date = comment_Date;
    }

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }
}
