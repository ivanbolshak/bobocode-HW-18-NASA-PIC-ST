

package com.example.stealingnasapictures.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NasaPictureDTO {
    @JsonProperty("id")
    private long nasaPhotoId;
    private int sol;
    @JsonProperty("img_src")
    private String imgSrc;
    private NasaCameraDTO camera;

}
