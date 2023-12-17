

package com.example.stealingnasapictures.controller;

import com.example.stealingnasapictures.model.dto.StealPicRequestDTO;
import com.example.stealingnasapictures.service.StealImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictures")
@AllArgsConstructor
public class DefaultController {

    private StealImageService stealImageService;


    @PostMapping("/steal")
    public void stealPictures(@RequestBody StealPicRequestDTO dto) {
        stealImageService.steal(dto);
    }


}
