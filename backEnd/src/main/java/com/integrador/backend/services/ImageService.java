package com.integrador.backend.services;

import com.integrador.backend.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image saveImage(Image image);
    List<Image> searchAllImages();
    Optional<Image> searchImageById(Long id);
    Image updateImage(Image image);
    void deleteImage(Long id);
}
