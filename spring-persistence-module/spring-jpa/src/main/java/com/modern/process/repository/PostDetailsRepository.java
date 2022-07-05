package com.modern.process.repository;

import com.modern.process.domain.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
