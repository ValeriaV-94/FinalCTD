package com.integrador.backend.controller;

import com.integrador.backend.exceptions.BadRequestException;
import com.integrador.backend.exceptions.ResourcesNotFoundException;
import com.integrador.backend.model.Image;
import com.integrador.backend.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    //Crear imagen
    @PostMapping("/save")
    public ResponseEntity<Image> saveImage(@RequestBody Image image) throws BadRequestException{
        try{
            Image savedImage = imageService.saveImage(image);
            return ResponseEntity.ok(savedImage);
        } catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    //Buscar todas las imagenes.
    @GetMapping("/all")
    public ResponseEntity<List<Image>> searchAllImage(){
        return ResponseEntity.ok(imageService.searchAllImages());
    }

    //Buscar imagen por id.
    @GetMapping("/search/{id}")
    public ResponseEntity<Image> searchImageById(@PathVariable("id") Long id) throws ResourcesNotFoundException{
        Optional<Image> searchImage = imageService.searchImageById(id);
        if (searchImage.isPresent()){
            return ResponseEntity.ok(searchImage.get());
        } else {
            throw new ResourcesNotFoundException("No se encontrò una imagen con id = " + id);
        }
    }

    //Actualizar imagen.
    @PutMapping("/update")
    public ResponseEntity<Image> updateImage(@RequestBody Image image){
        Optional<Image> imageToUpdate = imageService.searchImageById(image.getId());
        if(imageToUpdate.isPresent()){
            return ResponseEntity.ok(imageService.updateImage(image));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Borrar imagen.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImageById(@PathVariable Long id) throws ResourcesNotFoundException{
        Optional<Image> imageToDelete = imageService.searchImageById(id);
        if(imageToDelete.isPresent()){
            imageService.deleteImage(id);
            return ResponseEntity.ok("Se eliminó la imagen con id = " + id);
        } else {
            throw new ResourcesNotFoundException("No se encontró la imagen con id = " + id);
        }
    }
}
