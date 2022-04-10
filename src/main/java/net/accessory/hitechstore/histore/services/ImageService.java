package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ImageService{
public String storeFile(MultipartFile file);
public Stream<Path> loadAllImage();
public ResponseEntity<byte[]> readFile(String fileName);
public void deleteFile();
}
