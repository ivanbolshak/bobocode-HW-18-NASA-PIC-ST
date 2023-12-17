

package com.example.stealingnasapictures.utils;

import com.example.stealingnasapictures.model.dto.NasaCameraDTO;
import com.example.stealingnasapictures.model.dto.NasaPictureDTO;
import com.example.stealingnasapictures.model.entity.Camera;
import com.example.stealingnasapictures.model.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CustomMapper {

    private ModelMapper modelMapper;
    
    public Camera nasaCameraDtoToNewCamera(NasaCameraDTO nasaCameraDTO){
        Camera camera = modelMapper.map(nasaCameraDTO, Camera.class);
        return camera;
    }
    
    public Picture nasaPictureDtoToNewPicture(NasaPictureDTO nasaPictureDTO){
        Picture picture = modelMapper.map(nasaPictureDTO, Picture.class);
        return picture;
    }

    
}
