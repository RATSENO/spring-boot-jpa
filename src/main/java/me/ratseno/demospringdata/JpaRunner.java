package me.ratseno.demospringdata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		 * Post post = new Post(); post.setTitle("Spring Dat JPA 언제 보나...");
		 * 
		 * Comment comment = new Comment(); comment.setComment("빨리 보고 싶어요");
		 * post.addComment(comment);
		 * 
		 * Comment comment1 = new Comment(); comment1.setComment("곧 보여드릴께요");
		 * post.addComment(comment1);
		 */

		Session session = entityManager.unwrap(Session.class);
		//session.save(post);
		Post post = session.get(Post.class, 4l);
		System.out.println("=======================================");
		System.out.println(post.getTitle());
		
		post.getComments().forEach(c ->{
			System.out.println("==============================");
			System.out.println(c.getComment());
			System.out.println("==============================");
		});
	}

}
