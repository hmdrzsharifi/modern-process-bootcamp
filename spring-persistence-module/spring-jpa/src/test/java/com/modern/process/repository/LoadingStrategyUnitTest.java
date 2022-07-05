package com.modern.process.repository;

import com.modern.process.domain.CommentType;
import com.modern.process.domain.Post;
import com.modern.process.domain.PostComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class LoadingStrategyUnitTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Test
    @Transactional
    public void whenPostLoadedLazy_thenLoadPostComment(){

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

        List<Post> posts = postRepository.findAll();
        Post postLazyLoaded = posts.get(0);
        assertThat(postLazyLoaded.getPostCommentSet().iterator().next().getReview()).isEqualTo("review_2");
    }

    @Test
    @Transactional
    public void whenPostCommentLoadedLazy_thenLoadPost(){

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

        List<PostComment> postCommentList = postCommentRepository.findAll();
        PostComment postCommentLazyLoad = postCommentList.get(1);
        Post postLazy = postCommentLazyLoad.getPost();
        assertThat(postLazy.getTitle()).isEqualTo("post_many_comment");
    }
}
