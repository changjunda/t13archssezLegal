package com.ncs.iss.ezlegal.user.service.impl;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.ncs.iss.ezlegal.user.model.Document;
import com.ncs.iss.ezlegal.user.repository.DocumentRepository;
import com.ncs.iss.ezlegal.user.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentRepository dr;
	
	@Override
    public boolean saveAFile(String name, int userId, InputStream stream) throws Throwable {
		Document d = new Document();
		d.setUserId(userId);
		d.setName(name);
		d.setDocument(StreamUtils.copyToByteArray(stream));
		
		Document newD = dr.save(d);
		
		if(newD != null) {
			return true;
		}
		
		return false;
    }
    
	@Override
    public boolean deleteAFile(int fileId) {
		Document d = dr.getDocumentById(fileId);
		if(d != null) {
			dr.delete(d);
		}
		d = dr.getDocumentById(fileId);
		if(d != null) {
			return false;
		}
		return true;
		
    }
    
	@Override
    public Document selectAFile(int fileId) {      
    	return dr.getDocumentById(fileId);
    }
	
	@Override
	public List<Document> listAllFile(int userId) {
		return dr.getDocumentByUserId(userId);
	}
}