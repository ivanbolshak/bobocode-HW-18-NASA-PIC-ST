

package com.example.stealingnasapictures.service;

import com.example.stealingnasapictures.model.dto.NasaPictureDTO;
import com.example.stealingnasapictures.model.dto.StealPicRequestDTO;
import com.example.stealingnasapictures.repository.NasaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StealImageService {

    private NasaRepository nasaRepository;
    private NasaService nasaService;
    public void steal(StealPicRequestDTO dto) {

        List<NasaPictureDTO> nasaPhotosPerDay = nasaService.getNasaPhotosPerDay(dto.getSol());
        nasaRepository.saveNasaPhotos(nasaPhotosPerDay);

    }
}
