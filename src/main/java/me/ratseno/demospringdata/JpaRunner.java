package me.ratseno.demospringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	Keesun keesun;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=========================================");
		System.out.println(keesun.getName());
	}

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
	
	
	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * List<Post> posts = entityManager.createNativeQuery("Select * from Post",
	 * Post.class).getResultList(); posts.forEach(System.out::println); }
	 */
	
	
	/*
	 * @Override public void run(ApplicationArguments args)throws Exception {
	 * postRepository.findAll().forEach(System.out::println); }
	 */
}
