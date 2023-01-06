package com.integrador.backend.services;

import com.integrador.backend.model.Image;
import com.integrador.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
    final static Logger logger = Logger.getLogger(ImageServiceImpl.class.getName());

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> searchAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> searchImageById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
