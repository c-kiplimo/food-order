package com.collicode.foodorderback.repository;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
public class FileSystemRepository {
	
	String localpatch = getLocalPatch();
	


	public String getLocalPatch() {
		String patch = "C:";
		Character s = '\\';
		String[] tokens = { " "};
		for (int i = 0; i < tokens.length; i++) {
			patch += s + tokens[i];
		}
		patch += s;
		return patch;
	}
	

	public String save(byte[] content, String imageName) {
	   Path newFile = Paths.get(localpatch + new Date().getTime() + "-" + imageName);
	   try {
			Files.createDirectories(newFile.getParent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	   try {
			Files.write(newFile, content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	   return newFile.toAbsolutePath()
	       .toString();
	}
	public FileSystemResource findInFileSystem(String location) {
	    try {
	        return new FileSystemResource(Paths.get(location));
	    } catch (Exception e) {
	        // Handle access or file not found problems.
	        throw new RuntimeException();
	    }
	}

}
