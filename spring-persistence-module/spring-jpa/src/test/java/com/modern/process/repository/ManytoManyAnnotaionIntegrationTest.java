package com.modern.process.repository;

import com.modern.process.domain.Post;
import com.modern.process.domain.PostTag;
import com.modern.process.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ManytoManyAnnotaionIntegrationTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostTagRepository postTagRepository;

    /*@Test
    public void givenPostAndTags_whenInsertPost_thenCreatesManytoManyRelationship(){
        Post post1 = new Post(null, "post_1");

        Tag tag1 = new Tag(null, "tag_1");
        Tag tag2 = new Tag(null, "tag_2");

        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);

        post1.setTags(tags);

        postRepository.save(post1);
    }*/


    @Test
    public void givenPostAndTags_whenInsertPost_thenCreatesManytoManyRelationship(){
        Post post1 = new Post(null, "post_1");
        postRepository.save(post1);

        Tag tag1 = new Tag(null, "tag_1");
        tagRepository.save(tag1);

        PostTag postTag = new PostTag();
        postTag.setPost(post1);
        postTag.setTag(tag1);
        postTagRepository.save(postTag);

    }
}
