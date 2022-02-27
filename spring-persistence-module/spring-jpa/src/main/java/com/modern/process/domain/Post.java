package com.modern.process.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post", schema = "public")
public class Post {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    private String title;

    public Post() {

    }

    public Post(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private PostDetails postDetails;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private Set<PostComment> postCommentSet = new HashSet<>();

    /*@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    List<Tag> tags = new ArrayList<>();*/

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    List<PostTag> postTags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public Set<PostComment> getPostCommentSet() {
        return postCommentSet;
    }

    public void setPostCommentSet(Set<PostComment> postCommentSet) {
        this.postCommentSet = postCommentSet;
    }

    public void addComment(PostComment postComment) {
        postCommentSet.add(postComment);
        postComment.setPost(this);
    }

    /*public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }*/

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }
}
