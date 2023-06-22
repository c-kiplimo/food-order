package com.collicode.foodorderback.service;


import com.collicode.foodorderback.model.Image;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
	
	Image findOne(Long id);

}
