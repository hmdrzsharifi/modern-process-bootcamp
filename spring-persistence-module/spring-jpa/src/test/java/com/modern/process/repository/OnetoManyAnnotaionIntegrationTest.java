package com.modern.process.repository;

import com.modern.process.domain.CommentType;
import com.modern.process.domain.Post;
import com.modern.process.domain.PostComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class OnetoManyAnnotaionIntegrationTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void givenManyPostComment_whenInsertPost_thenCreates1toManyRelationship(){
        Post post = new Post(null, "post_many_comment");

        Set<PostComment> postComments = new HashSet<>();
        PostComment postComment1 = new PostComment(null, "review_1", new Date(), CommentType.GOOD);
        postComment1.setPost(post);
        PostComment postComment2 = new PostComment(null, "review_2", new Date(), CommentType.BAD);
        postComment2.setPost(post);

        postComments.add(postComment1);
        postComments.add(postComment2);

        post.setPostCommentSet(postComments);

        postRepository.save(post);
    }

    @Test
    public void given1PostComment_whenInsertPost_thenCreates1toManyRelationship(){
        Post post = new Post(null, "post_1_comment");

        PostComment postComment = new PostComment(null, "review_3", new Date(), CommentType.GOOD);
        post.addComment(postComment);

        postRepository.save(post);
    }
}
