package com.example.stealingnasapictures.repository;

import com.example.stealingnasapictures.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PictureRepository extends JpaRepository<Picture, Long> {

    Optional<Picture> findByImgSrc(String imgSrc);
}
