package me.ratseno.demospringdata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.omg.PortableServer.POA;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p",
	 * Post.class); List<Post> posts = query.getResultList();
	 * posts.forEach(System.out::println); }
	 */

	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	 * CriteriaQuery<Post> query = builder.createQuery(Post.class); Root<Post> root
	 * = query.from(Post.class); query.select(root);
	 * 
	 * List<Post> posts = entityManager.createQuery(query).getResultList();
	 * posts.forEach(System.out::println); }
	 */

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Post> posts = entityManager.createNativeQuery("Select * from Post", Post.class).getResultList();
		posts.forEach(System.out::println);
	}

}
