package com.modern.process;

import com.modern.process.domain.CommentType;
import com.modern.process.domain.Post;
import com.modern.process.domain.PostComment;
import com.modern.process.repository.PostCommentRepository;
import com.modern.process.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final PostRepository postRepository;
	private final PostCommentRepository postCommentRepository;

	public DemoApplication(PostRepository postRepository, PostCommentRepository postCommentRepository) {
		this.postRepository = postRepository;
		this.postCommentRepository = postCommentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PostComment postComment = new PostComment();
		postComment.setReview("review1");
		postComment.setComment_Date(new Date());
		postComment.setType(CommentType.GOOD);
		postCommentRepository.save(postComment);
	}
}
