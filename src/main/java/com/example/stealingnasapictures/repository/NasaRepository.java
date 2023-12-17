

package com.example.stealingnasapictures.repository;

import com.example.stealingnasapictures.model.dto.NasaPictureDTO;
import com.example.stealingnasapictures.model.entity.Camera;
import com.example.stealingnasapictures.model.entity.Picture;
import com.example.stealingnasapictures.utils.CustomMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NasaRepository {

    private CameraRepository cameraRepository;
    private PictureRepository pictureRepository;

    private CustomMapper customMapper;

    @Transactional
    public void saveNasaPhotos(List<NasaPictureDTO> nasaPictureDTOList) {

        nasaPictureDTOList.forEach(nasaPictureDTO -> {
            Camera camera = cameraRepository.findByName(nasaPictureDTO.getCamera().getName()).orElseGet(() -> {
                Camera cam = customMapper.nasaCameraDtoToNewCamera(nasaPictureDTO.getCamera());
                cameraRepository.save(cam);
                return cam;
            });
            if (camera.getPictures() == null || camera.getPictures().stream().noneMatch(pic -> pic.getImgSrc().equals(nasaPictureDTO.getImgSrc()))) {
                Picture picture = customMapper.nasaPictureDtoToNewPicture(nasaPictureDTO);
                picture.setCamera(camera);
                pictureRepository.save(picture);
            }
        });


    }

//    private void addPicturesDtoToCamera(Camera camera, List<NasaPictureDTO> nasaPictureDTOS){
//        List<String> existingCameraSource = camera.getPictures().stream().map(Picture::getImgSrc).toList();
//
//        nasaPictureDTOS.forEach(nasaPicture ->{
//            if (!existingCameraSource.contains(nasaPicture.getImgSrc())){
//                Picture picture = customMapper.nasaPictureDtoToNewPicture(nasaPicture);
//                picture.setCamera(camera);
//            }
//        });
//
//    }

}
