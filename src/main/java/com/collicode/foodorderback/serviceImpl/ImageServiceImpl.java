package com.collicode.foodorderback.serviceImpl;

import com.collicode.foodorderback.model.Image;
import com.collicode.foodorderback.repository.ImageDbRepository;
import com.collicode.foodorderback.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDbRepository imageDbRepository;
    @Override
    public Image findOne(Long id) {
        Image image = imageDbRepository.findById(id).get();
        //MealDTO mealDTO = MealMapper.INSTANCE.entityToDTO(meal);

        return image;
    }

}
