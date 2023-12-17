

package com.example.stealingnasapictures.service;

import com.example.stealingnasapictures.model.dto.NasaPictureDTO;
import com.example.stealingnasapictures.model.dto.NasaResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NasaService {

    private RestTemplate restTemplate;
    //    https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=300&api_key=QvBkYNPqRr3dAdQcUFaffASxsLykIeN91uUh5UZq
    private static final String API_KEY = "QvBkYNPqRr3dAdQcUFaffASxsLykIeN91uUh5UZq";
    private static final String API_KEY_PARAM_NAME = "api_key";
    private static final String SOL_PARAM_NAME = "sol";
    private static final String NASA_PHOTO_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";

    public List<NasaPictureDTO> getNasaPhotosPerDay(int sol) {

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(NASA_PHOTO_URL)
                .queryParam(API_KEY_PARAM_NAME, API_KEY)
                .queryParam(SOL_PARAM_NAME, String.valueOf(sol))
                .build();

        ResponseEntity<NasaResponseDTO> nasaPhotosEntity = restTemplate.getForEntity(uri.toUriString(), NasaResponseDTO.class);

        if (nasaPhotosEntity.getStatusCode().is2xxSuccessful() && nasaPhotosEntity.getBody() != null) {
            return nasaPhotosEntity.getBody().getPhotos();
        }
        return Collections.emptyList();
    }


}
