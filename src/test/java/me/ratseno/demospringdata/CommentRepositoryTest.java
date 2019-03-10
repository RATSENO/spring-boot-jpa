package me.ratseno.demospringdata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository commentRepository;

	@Test
	public void crud() throws ExecutionException, InterruptedException {
		this.createComment(100, "spring data jpa");
		this.createComment(50, "HIBERNATE SPRING");
		commentRepository.flush();
		
		List<Comment> all = commentRepository.findAll();
		assertThat(all.size()).isEqualTo(2);

		PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "LikeCount");

		ListenableFuture<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("Spring",
				pageRequest);

		System.out.println("==================");
		System.out.println("is done?" + future.isDone());

		future.addCallback(new ListenableFutureCallback<List<Comment>>() {

			@Override
			public void onFailure(Throwable ex) {
				System.out.println(ex);
			}

			@Override
			public void onSuccess(List<Comment> result) {
				System.out.println("======Async======");
				System.out.println(result.size());
			}
		});
		
		Thread.sleep(5000l);
	}

	public void createComment(int likeCount, String comment) {
		Comment newComment = new Comment();
		newComment.setLikeCount(likeCount);
		newComment.setComment(comment);
		commentRepository.save(newComment);
	}
}
