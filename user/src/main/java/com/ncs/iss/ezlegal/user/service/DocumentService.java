package com.ncs.iss.ezlegal.user.service;

import java.io.InputStream;

import com.ncs.iss.ezlegal.user.model.Document;
    
public interface DocumentService {
    
    boolean saveAFile(String name, int userId, InputStream stream) throws Throwable;
    
    boolean deleteAFile(int fileId);
    
    Document selectAFile(int fileId);
}