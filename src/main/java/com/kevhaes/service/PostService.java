/**
 * @author KevHaes
 *
 */
package com.kevhaes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.model.CommentDao;
import com.kevhaes.model.PostDao;
import com.kevhaes.model.PostDto;
import com.kevhaes.model.UserDao;
import com.kevhaes.repository.CommentRepository;
import com.kevhaes.repository.PostRepository;
import com.kevhaes.repository.UserRepository;

/**
 * @author KevHaes
 *
 */
@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;

	public PostDao createPost(PostDto postDto) {
		PostDao postDao = new PostDao();
		postDao.setTitle(postDto.getTitle());
		postDao.setDescription(postDto.getDescription());
		try {
			UserDao author = userRepository.findByUsername(postDto.getAuthor_username());
			postDao.setAuthor(author);
		} catch (Exception e) {
			System.out.println("somthing went wrong" + e.getMessage());
		}
		// System.out.println("to be saved: " + postDao);
		return postRepository.save(postDao);
	}

	public List<PostDao> getAllPosts() {
		return postRepository.findAll();
	}

	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}

	public PostDao editPost(Long postId, String title, String description) {
		PostDao postdao = postRepository.findById(postId).get();
		postdao.setTitle(title);
		postdao.setDescription(description);
		return postRepository.save(postdao);
	}

	public CommentDao createComment(Long postId, Long userId, String description) throws Exception {// ResourceNotFoundException
		UserDao author = userRepository.findById(userId)
				.orElseThrow(() -> new Exception("userId not found :: " + userId));
		PostDao post = postRepository.findById(postId)
				.orElseThrow(() -> new Exception("postId not found :: " + postId));
		CommentDao commentDao = new CommentDao();
		commentDao.setAuthor(author);
		commentDao.setPost(post);
		commentDao.setDescription(description);
		post.getComments().add(commentDao);
		// post.addComment(commentDao);
		return commentRepository.save(commentDao);
	}

	public List<CommentDao> showCommentsForPost(Long postId) {
		return commentRepository.findByPostId(postId);
	}
	// methods

	public PostDao addComment(long postId, CommentDao comment) {
		PostDao post = postRepository.findById(postId).get();
		post.getComments().add(comment);
		return postRepository.saveAndFlush(post);
	}
}

//TODO: CREATE EXEPTION

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//public class ResourceNotFoundException extends Exception{
//
//    private static final long serialVersionUID = 1L;
//
//    public ResourceNotFoundException(String message){
//        super(message);
//    }
//}