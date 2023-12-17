

package com.example.stealingnasapictures.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NasaCameraDTO {
    @JsonProperty("id")
    private long nasaCameraId;
    private String name;
    @JsonProperty("rover_id")
    private int roverId;
    @JsonProperty("full_name")
    private String fullName;
}
