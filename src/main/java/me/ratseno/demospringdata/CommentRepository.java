package me.ratseno.demospringdata;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends MyRepository<Comment, Long> {

	//List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword , int likeCount);

	//List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountAsc(String keyword);

	//Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable page);

	Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable page);
}
