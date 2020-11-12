/**
 * @author KevHaes
 *
 */
package com.kevhaes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.model.CommentDao;
import com.kevhaes.model.PostDao;
import com.kevhaes.model.PostDto;
import com.kevhaes.service.PostService;

/**
 * @author KevHaes
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class PostController {

	@Autowired
	PostService postService;

//-------posts

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public ResponseEntity<PostDao> createPost(@RequestBody PostDto postDto) {
		System.out.println("POST TO BE SAVED: " + postDto);
		return ResponseEntity.ok(postService.createPost(postDto));
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ResponseEntity<List<PostDao>> getAllPosts() {
		System.out.println("postService.getAllPosts() :" + postService.getAllPosts());
		return ResponseEntity.ok(postService.getAllPosts());
	}

	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable long postId) {

		postService.deletePost(postId);
	}

	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.PUT)
	public ResponseEntity<PostDao> editPost(@PathVariable Long postId, @RequestParam("title") String title,
			@RequestParam("description") String description) {
		// public void test(@RequestParam(value = "params") String params) {
		System.out.println("EDIT REQUEST IN CONTROLLER  for: " + title);
		return ResponseEntity.ok(postService.editPost(postId, title, description));
	}

//---------comments
	@RequestMapping(value = "/posts/{postId}/comments", method = RequestMethod.POST)
	public ResponseEntity<CommentDao> createPost(@PathVariable Long postId, @RequestParam("authorId") Long userId,
			@RequestParam("comment") String description) throws Exception {
		return ResponseEntity.ok(postService.createComment(postId, userId, description));
	}

//	@RequestMapping(value = "/posts/{postId}/comments", method = RequestMethod.GET)
//	public ResponseEntity<List<CommentDao>> showCommentsForPost(@PathVariable Long postId) {
//		return ResponseEntity.ok(postService.showCommentsForPost(postId));
//	}

}
