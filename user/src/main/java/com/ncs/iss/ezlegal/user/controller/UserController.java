package com.ncs.iss.ezlegal.user.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ncs.iss.ezlegal.user.model.AddLawyerDTO;
import com.ncs.iss.ezlegal.user.model.AddUserDTO;
import com.ncs.iss.ezlegal.user.model.AddUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.DeleteDocumentDTO;
import com.ncs.iss.ezlegal.user.model.Document;
import com.ncs.iss.ezlegal.user.model.DownloadDocumentDTO;
import com.ncs.iss.ezlegal.user.model.GetUserDTO;
import com.ncs.iss.ezlegal.user.model.GetUserEmailDTO;
import com.ncs.iss.ezlegal.user.model.GetUserEmailResponseDTO;
import com.ncs.iss.ezlegal.user.model.GetUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.ListDocumentDTO;
import com.ncs.iss.ezlegal.user.model.LoginUserDTO;
import com.ncs.iss.ezlegal.user.model.LoginUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.LogoutUserDTO;
import com.ncs.iss.ezlegal.user.model.LogoutUserResponseDTO;
import com.ncs.iss.ezlegal.user.model.UpdateUserDTO;
import com.ncs.iss.ezlegal.user.model.UpdateUserResponseDTO;
import com.ncs.iss.ezlegal.user.service.DocumentService;
import com.ncs.iss.ezlegal.user.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService us;
	
	@Autowired
	DocumentService fs;
	
	@PostMapping(value="/adduser" , consumes = "application/json")
	public ResponseEntity<AddUserResponseDTO> addUser(@RequestBody AddUserDTO request) {
		return new ResponseEntity<> (us.addUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/addlawyer" , consumes = "application/json")
	public ResponseEntity<AddUserResponseDTO> addLawyer(@RequestBody AddLawyerDTO request) {
		return new ResponseEntity<> (us.addLawyer(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/update" , consumes = "application/json")
	public ResponseEntity<UpdateUserResponseDTO> updateUser(@RequestBody UpdateUserDTO request) {
		return new ResponseEntity<> (us.updateUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/get" , consumes = "application/json")
	public ResponseEntity<GetUserResponseDTO> getUser(@RequestBody GetUserDTO request) {
		return new ResponseEntity<> (us.getUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/getbyemail" , consumes = "application/json")
	public ResponseEntity<GetUserEmailResponseDTO> getUserEmail(@RequestBody GetUserEmailDTO request) {
		return new ResponseEntity<> (us.getUserEmail(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/login" , consumes = "application/json")
	public ResponseEntity<LoginUserResponseDTO> loginUser(@RequestBody LoginUserDTO request) {
		return new ResponseEntity<> (us.loginUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value="/logout" , consumes = "application/json")
	public ResponseEntity<LogoutUserResponseDTO> logoutUser(@RequestBody LogoutUserDTO request) {
		return new ResponseEntity<> (us.logoutUser(request), HttpStatus.OK);
	}
	
	@PostMapping(value = "/uploadfile", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadfile(@RequestPart(value="name", required=true) String name, @RequestPart(value="file", required=true) MultipartFile file)
            throws Throwable {
        
		HttpServletRequest urequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String userIndex = (String) urequest.getAttribute("userIndex");
        //MultipartFile multipartFile = request.getFile("uploadFile");
        //int size = (int) multipartFile.getSize();
        //String contentType = multipartFile.getContentType();
        //String name = multipartFile.getOriginalFilename();
        InputStream stream = file.getInputStream();
        
        boolean saved = fs.saveAFile(name, Integer.parseInt(userIndex), stream);
        
        if(saved) {
        	return new ResponseEntity<> ("success", HttpStatus.OK);
        }
        return new ResponseEntity<> ("fail", HttpStatus.OK);
    }
    
    @ResponseBody
    @PostMapping(value = "/deletefile", consumes = "application/json")
    public ResponseEntity<String> deletefile(@RequestBody DeleteDocumentDTO request) throws Throwable {
        boolean deleted = fs.deleteAFile(request.getId());
        if(deleted) {
        	return new ResponseEntity<> ("success", HttpStatus.OK);
        }
        return new ResponseEntity<> ("fail", HttpStatus.OK);
    }
    
    @PostMapping(value = "/downloadfile", consumes = "application/json")
    public void downloadfile(@RequestBody DownloadDocumentDTO request,
            HttpServletResponse response) throws Throwable {
        
        Document d = fs.selectAFile(request.getId());
        if(d != null) {
	        InputStream is = new BufferedInputStream(new ByteArrayInputStream(d.getDocument()));
	        String mimeType = URLConnection.guessContentTypeFromStream(is);
	        response.setContentType(mimeType);
	        response.addHeader("Content-Disposition",
	                "attachment; filename=\"" + d.getName() + "\"");
	        response.setContentLength(d.getDocument().length);
	        response.getOutputStream().write(d.getDocument());
	        
	        response.flushBuffer();
        } else {
        	response.getWriter().println("Document not found");
        	response.setStatus(404);
        }
    }
    
    @PostMapping(value = "/listfile", consumes = "application/json")
    public ResponseEntity<List<Document>> listfile(@RequestBody ListDocumentDTO request,
            HttpServletResponse response) throws Throwable {
        
        List<Document> dl = fs.listAllFile(request.getUserId());
        
        return new ResponseEntity<> (dl, HttpStatus.OK);
    }
	
}
