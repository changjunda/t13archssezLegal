package com.ncs.iss.ezlegal.forum.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.forum.model.AddPostDTO;
import com.ncs.iss.ezlegal.forum.model.DeletePostDTO;
import com.ncs.iss.ezlegal.forum.model.DeletePostResponseDTO;
import com.ncs.iss.ezlegal.forum.model.Forum;
import com.ncs.iss.ezlegal.forum.model.GetPostDTO;
import com.ncs.iss.ezlegal.forum.model.ListPostDTO;
import com.ncs.iss.ezlegal.forum.model.Post;
import com.ncs.iss.ezlegal.forum.model.PostDTO;
import com.ncs.iss.ezlegal.forum.model.PostWrapper;
import com.ncs.iss.ezlegal.forum.model.SearchPostDTO;
import com.ncs.iss.ezlegal.forum.model.UpdatePostDTO;
import com.ncs.iss.ezlegal.forum.repository.ForumRepository;
import com.ncs.iss.ezlegal.forum.repository.PostRepository;
import com.ncs.iss.ezlegal.forum.repository.PostWrapperRepository;
import com.ncs.iss.ezlegal.forum.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private ForumRepository fr;

	@Autowired
	private PostRepository pr;
	
	@Autowired
	private PostWrapperRepository pwr;
	
	@Override
	public PostDTO addPost(AddPostDTO request) {
		Post p = new Post();
		p.setForumId(Long.parseLong(request.getForumId()));
		p.setReplyTo(0);
		p.setContent(request.getContent());
		
		Post up = pr.save(p);
		
		PostWrapper pw = pwr.getPostWrapperByPostId(up.getId());
		
		Date crDate = pw.getPostCreatedDt();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
		String formattedDate = formatter.format(crDate);
		
		PostDTO pdt = new PostDTO(String.valueOf(pw.getPostId()), pw.getPostSubject(), pw.getPostContent(), 
				formattedDate, String.valueOf(pw.getPostCreatedById()), pw.getPostCreatedByName(), 
				String.valueOf(pw.getPostCount()), String.valueOf(pw.getPostRating()), String.valueOf(pw.getUserRating()));
		
		return pdt;
	}

	@Override
	public PostDTO updatePost(UpdatePostDTO request) {
		Post p = pr.getById(Long.parseLong(request.getPostId()));
		p.setReplyTo(0);
		p.setContent(request.getContent());
		
		Post up = pr.save(p);
		
		PostWrapper pw = pwr.getPostWrapperByPostId(up.getId());
		
		Date crDate = pw.getPostCreatedDt();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
		String formattedDate = formatter.format(crDate);
		
		PostDTO pdt = new PostDTO(String.valueOf(pw.getPostId()), pw.getPostSubject(), pw.getPostContent(), 
				formattedDate, String.valueOf(pw.getPostCreatedById()), pw.getPostCreatedByName(), 
				String.valueOf(pw.getPostCount()), String.valueOf(pw.getPostRating()), String.valueOf(pw.getUserRating()));
		return pdt;
	}

	@Override
	public PostDTO getPost(GetPostDTO request) {
		PostWrapper pw = pwr.getPostWrapperByPostId(Long.parseLong(request.getPostId()));
		
		Date crDate = pw.getPostCreatedDt();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
		String formattedDate = formatter.format(crDate);
		
		PostDTO pdt = new PostDTO(String.valueOf(pw.getPostId()), pw.getPostSubject(), pw.getPostContent(), 
				formattedDate, String.valueOf(pw.getPostCreatedById()), pw.getPostCreatedByName(), 
				String.valueOf(pw.getPostCount()), String.valueOf(pw.getPostRating()), String.valueOf(pw.getUserRating()));
		return pdt;
	}

	@Override
	public DeletePostResponseDTO deletePost(DeletePostDTO request) {
		// Do not exist, do nothing
		return new DeletePostResponseDTO(request.getPostId());
	}

	@Override
	public ListPostDTO searchPost(SearchPostDTO request) {
		
		Forum forum = fr.getById(Long.parseLong(request.getForumId()));
		
		List<PostWrapper> postList = pwr.getPostWrapperByForumIdAndContent(forum.getId(), request.getSearchTerm());
		List<PostDTO> postDtoList = new ArrayList<>();
		
		for(PostWrapper pw : postList) {
			Date crDate = pw.getPostCreatedDt();
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
			String formattedDate = formatter.format(crDate);
			
			PostDTO pdt = new PostDTO(String.valueOf(pw.getPostId()), pw.getPostSubject(), pw.getPostContent(), 
					formattedDate, String.valueOf(pw.getPostCreatedById()), pw.getPostCreatedByName(), 
					String.valueOf(pw.getPostCount()), String.valueOf(pw.getPostRating()), String.valueOf(pw.getUserRating()));
			postDtoList.add(pdt);
		}
		
		return new ListPostDTO(postDtoList);
	}
	
	
	
}
