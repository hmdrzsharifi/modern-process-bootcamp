package com.modern.process.repository;

import com.modern.process.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PostRepositoryUnitTest {

    final String POST_NAME_1 = "post_1";
    final String POST_NAME_2 = "post_2";

    @Autowired
    private PostRepository postRepository;

    @Test
    public void givenSavedPost_WhenUpdate_ThenReturnUpdatedPost(){

        postRepository.save(new Post(null,"post_1"));

        Post post = postRepository.findById(4L).get();
        post.setTitle("post_2");
        postRepository.save(post);

        assertThat(postRepository.findById(4L).get().getTitle()).isEqualTo(POST_NAME_2);
    }

    @Test
    public void givenSavedPost_whenDelete_ThenReturnDeletedPost(){
        postRepository.save(new Post(null, "post_1"));
        postRepository.save(new Post(null, "post_2"));

        postRepository.deleteById(5L);

        Boolean present = postRepository.findById(5L).isPresent();
        assertThat(present).isEqualTo(false);
    }

    @Test
    public void givenPostsInDB_WhenFindAllWithSortByTitle_ThenReturnPostsSorted(){
        postRepository.save(new Post(null, "post_2"));
        postRepository.save(new Post(null, "post_1"));
        postRepository.save(new Post(null, "post_3"));

        List<Post> postsSortedByTitle =  postRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));

        assertThat(postsSortedByTitle.get(0).getTitle()).isEqualTo(POST_NAME_1);
    }

    @Test
    public void givenPostsInDB_WhenFindAllWithPageRequestQuery_ThenReturnPageOfPosts(){
        postRepository.save(new Post(null, "post_1"));
        postRepository.save(new Post(null, "post_2"));
        postRepository.save(new Post(null, "post_3"));
        postRepository.save(new Post(null, "post_4"));
        postRepository.save(new Post(null, "post_5"));
        postRepository.save(new Post(null, "post_6"));

        Page<Post> postPage = postRepository.findAll(PageRequest.of(0,3));

        assertThat(postPage.getContent()
                    .get(0)
                     .getTitle()).isEqualTo(POST_NAME_1);

    }
}
