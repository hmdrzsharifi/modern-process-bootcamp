package com.modern.process.repository;

import com.modern.process.domain.Post;
import com.modern.process.domain.PostDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OnetoOneAnnotaionFKBasedIntegrationTest {

    @Autowired
    private PostDetailsRepository postDetailsRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void whenInsertPostDetails_thenCreates1to1relationship(){
        Post post = new Post(null, "post_new");

        PostDetails postDetails = new PostDetails(null, null, "admin");
        postDetails.setPost(post);
        post.setPostDetails(postDetails);

        //Post entry will automatically be created by hibernate, since cascade type is specified as ALL
        postDetailsRepository.save(postDetails);

    }

    @Test
    public void whenInsertPost_thenCreates1to1relationship(){
        Post post = new Post(null, "post_new2");

        PostDetails postDetails = new PostDetails(null, null, "user");
        postDetails.setPost(post);
        post.setPostDetails(postDetails);

        //PostDetails entry will automatically be created by hibernate, since cascade type is specified as ALL
        postRepository.save(post);

    }
}
