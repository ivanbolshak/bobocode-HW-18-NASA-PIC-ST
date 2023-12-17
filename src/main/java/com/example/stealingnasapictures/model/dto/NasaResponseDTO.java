/*
 * This file is a subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.example.stealingnasapictures.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class NasaResponseDTO {
    private List<NasaPictureDTO> photos;
}
