package me.ratseno.demospringdata;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends MyRepository<Comment, Long> {

	List<Comment> findByCommentContains(String keyword);

	// Page<Comment> findByLikeGreaterThanAndPostOrderByCreatedDesc(int likeCount,Post post, Pageable pageable);

	Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);
}
