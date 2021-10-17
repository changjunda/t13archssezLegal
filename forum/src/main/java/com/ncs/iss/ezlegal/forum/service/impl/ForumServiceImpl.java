package com.ncs.iss.ezlegal.forum.service.impl;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.iss.ezlegal.forum.model.AddForumDTO;
import com.ncs.iss.ezlegal.forum.model.AddForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.DeleteForumDTO;
import com.ncs.iss.ezlegal.forum.model.DeleteForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.Forum;
import com.ncs.iss.ezlegal.forum.model.ForumTagWrapper;
import com.ncs.iss.ezlegal.forum.model.ForumTagWrapperDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumListDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumListResponseDTO;
import com.ncs.iss.ezlegal.forum.model.GetForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.PostDTO;
import com.ncs.iss.ezlegal.forum.model.PostWrapper;
import com.ncs.iss.ezlegal.forum.model.SearchForumListDTO;
import com.ncs.iss.ezlegal.forum.model.SearchForumListResponseDTO;
import com.ncs.iss.ezlegal.forum.model.UpdateForumDTO;
import com.ncs.iss.ezlegal.forum.model.UpdateForumResponseDTO;
import com.ncs.iss.ezlegal.forum.model.User;
import com.ncs.iss.ezlegal.forum.repository.ForumRepository;
import com.ncs.iss.ezlegal.forum.repository.ForumTagWrapperRepository;
import com.ncs.iss.ezlegal.forum.repository.PostWrapperRepository;
import com.ncs.iss.ezlegal.forum.repository.UserRepository;
import com.ncs.iss.ezlegal.forum.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private ForumRepository fr;
	
	@Autowired
	private ForumTagWrapperRepository ftwr;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private PostWrapperRepository pwr;
	
	@Override
	public AddForumResponseDTO addForum(AddForumDTO request) {
		
		Forum ft = new Forum();
		
		ft.setTitle(request.getTitle());

		Forum updatedFT = fr.save(ft);
		Instant createdDt = updatedFT.getCreatedDate();
		Date crDate = Date.from(createdDt);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
		String formattedDate = formatter.format(crDate);
		String createdById = updatedFT.getCreatedBy();
		
		User ut = ur.getUserByUserId(Integer.parseInt(createdById));
		
		return new AddForumResponseDTO(String.valueOf(updatedFT.getId()), updatedFT.getTitle(), formattedDate, createdById, ut.getFirstName() + " " + ut.getLastName());
	}

	@Override
	public UpdateForumResponseDTO updateForum(UpdateForumDTO request) {

		Forum ft = fr.getForumByForumId(Long.parseLong(request.getForumId()));
		
		if(ft == null) {
			ft = new Forum();
		}
		ft.setTitle(request.getTitle());

		Forum updatedFT = fr.save(ft);
		Instant createdDt = updatedFT.getCreatedDate();
		Date crDate = Date.from(createdDt);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
		String formattedDate = formatter.format(crDate);
		String createdById = updatedFT.getCreatedBy();
		
		User ut = ur.getUserByUserId(Integer.parseInt(createdById));
		
		List<ForumTagWrapper> forumTagWrapperList = ftwr.getForumTagWrapperByForumId(ft.getId());
		List<ForumTagWrapperDTO> ftrdto = new ArrayList<>();
		for(ForumTagWrapper ftw: forumTagWrapperList) {
			ftrdto.add(new ForumTagWrapperDTO(String.valueOf(ftw.getId()), String.valueOf(ftw.getForumId()), String.valueOf(ftw.getTagId()), ftw.getTagName(), ftw.getTagDescription()));
		}
		
		return new UpdateForumResponseDTO(String.valueOf(updatedFT.getId()), updatedFT.getTitle(), formattedDate, createdById, ut.getFirstName() + " " + ut.getLastName(), ftrdto);
		
	}

	@Override
	public GetForumResponseDTO getForum(GetForumDTO request) {
		
		Forum forum = fr.getForumByForumId(Long.parseLong(request.getForumId()));
		
		List<PostWrapper> postList = pwr.getPostWrapperByForumId(Long.parseLong(request.getForumId()));
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
		List<ForumTagWrapper> forumTagWrapperList = ftwr.getForumTagWrapperByForumId(Long.parseLong(request.getForumId()));
		List<ForumTagWrapperDTO> ftrdto = new ArrayList<>();
		for(ForumTagWrapper ftw: forumTagWrapperList) {
			ftrdto.add(new ForumTagWrapperDTO(String.valueOf(ftw.getId()), String.valueOf(ftw.getForumId()), String.valueOf(ftw.getTagId()), ftw.getTagName(), ftw.getTagDescription()));
		}
		
		Instant createdDt = forum.getCreatedDate();
		Date crDate = Date.from(createdDt);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
		String formattedDate = formatter.format(crDate);
		String createdById = forum.getCreatedBy();
		
		User ut = ur.getUserByUserId(Integer.parseInt(createdById));
		
		return new GetForumResponseDTO(String.valueOf(forum.getId()), forum.getTitle(), formattedDate, createdById, ut.getFirstName() + " " + ut.getLastName(), ftrdto, postDtoList);
	}

	@Override
	public GetForumListResponseDTO getForumList(GetForumListDTO request) {
		
		List<GetForumResponseDTO> forumList = new ArrayList<>();
		List<Forum> forums = fr.getAll();
		List<PostWrapper> postList = pwr.getPostWrapperOrderByIdAsc();
		
		for(Forum f: forums) {
			
			List<PostDTO> postDtoList = new ArrayList<>();
			for(PostWrapper pw : postList) {
				if(f.getId() == pw.getForumId()) {
					Date crDate = pw.getPostCreatedDt();
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
					String formattedDate = formatter.format(crDate);
					
					PostDTO pdt = new PostDTO(String.valueOf(pw.getPostId()), pw.getPostSubject(), pw.getPostContent(), 
							formattedDate, String.valueOf(pw.getPostCreatedById()), pw.getPostCreatedByName(), 
							String.valueOf(pw.getPostCount()), String.valueOf(pw.getPostRating()), String.valueOf(pw.getUserRating()));
					postDtoList.add(pdt);
				}
			}
			
			List<ForumTagWrapper> forumTagWrapperList = ftwr.getForumTagWrapperByForumId(f.getId());
			List<ForumTagWrapperDTO> ftrdto = new ArrayList<>();
			for(ForumTagWrapper ftw: forumTagWrapperList) {
				ftrdto.add(new ForumTagWrapperDTO(String.valueOf(ftw.getId()), String.valueOf(ftw.getForumId()), String.valueOf(ftw.getTagId()), ftw.getTagName(), ftw.getTagDescription()));
			}
			
			Instant createdDt = f.getCreatedDate();
			Date crDate = Date.from(createdDt);
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
			String formattedDate = formatter.format(crDate);
			String createdById = f.getCreatedBy();
			
			User ut = ur.getUserByUserId(Integer.parseInt(createdById));
			
			GetForumResponseDTO gfrdto = new GetForumResponseDTO(String.valueOf(f.getId()), f.getTitle(), formattedDate, createdById, ut.getFirstName() + " " + ut.getLastName(), ftrdto, postDtoList);
			forumList.add(gfrdto);
		}
		
		return new GetForumListResponseDTO(forumList);
	}

	@Override
	public DeleteForumResponseDTO deleteForum(DeleteForumDTO request) {
		
		//No such feature
		
		return new DeleteForumResponseDTO(request.getForumId());
	}

	@Override
	public SearchForumListResponseDTO searchForumList(SearchForumListDTO request) {
		List<GetForumResponseDTO> forumList = new ArrayList<>();
		List<Forum> forums = fr.getAllByTitle(request.getSearchTerm());
		List<PostWrapper> postList = pwr.getPostWrapperOrderByIdAsc();
		
		for(Forum f: forums) {
			
			List<PostDTO> postDtoList = new ArrayList<>();
			for(PostWrapper pw : postList) {
				if(f.getId() == pw.getForumId()) {
					Date crDate = pw.getPostCreatedDt();
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
					String formattedDate = formatter.format(crDate);
					
					PostDTO pdt = new PostDTO(String.valueOf(pw.getPostId()), pw.getPostSubject(), pw.getPostContent(), 
							formattedDate, String.valueOf(pw.getPostCreatedById()), pw.getPostCreatedByName(), 
							String.valueOf(pw.getPostCount()), String.valueOf(pw.getPostRating()), String.valueOf(pw.getUserRating()));
					postDtoList.add(pdt);
				}
			}
			
			List<ForumTagWrapper> forumTagWrapperList = ftwr.getForumTagWrapperByForumId(f.getId());
			List<ForumTagWrapperDTO> ftrdto = new ArrayList<>();
			for(ForumTagWrapper ftw: forumTagWrapperList) {
				ftrdto.add(new ForumTagWrapperDTO(String.valueOf(ftw.getId()), String.valueOf(ftw.getForumId()), String.valueOf(ftw.getTagId()), ftw.getTagName(), ftw.getTagDescription()));
			}
			
			Instant createdDt = f.getCreatedDate();
			Date crDate = Date.from(createdDt);
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
			String formattedDate = formatter.format(crDate);
			String createdById = f.getCreatedBy();
			
			User ut = ur.getUserByUserId(Integer.parseInt(createdById));
			
			GetForumResponseDTO gfrdto = new GetForumResponseDTO(String.valueOf(f.getId()), f.getTitle(), formattedDate, createdById, ut.getFirstName() + " " + ut.getLastName(), ftrdto, postDtoList);
			forumList.add(gfrdto);
		}
		
		return new SearchForumListResponseDTO(forumList);
	}
	
}
