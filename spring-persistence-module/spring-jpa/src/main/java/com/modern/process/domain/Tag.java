package com.modern.process.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag", schema = "public")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

   /* @ManyToMany(mappedBy = "tags")
    List<Post> posts = new ArrayList<>();*/

    @OneToMany(mappedBy = "tag")
    List<PostTag> postTags = new ArrayList<>();

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tag() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }*/

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }
}
