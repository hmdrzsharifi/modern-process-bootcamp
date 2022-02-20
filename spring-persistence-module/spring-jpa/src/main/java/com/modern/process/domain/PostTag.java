package com.modern.process.domain;

import javax.persistence.*;

@Entity
@Table(name = "post_tag_join", schema = "public")
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;


    @ManyToOne
    @JoinColumn(name = "tag_id")
    Tag tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
