

package com.example.stealingnasapictures.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "camera", schema = "nasa")
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nasa_camera_id", unique = true, nullable = false)
    private long nasaCameraId;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "rover_id")
    private int roverId;

    @Column(name = "full_name", unique = true)
    private String fullName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "camera", cascade = CascadeType.REMOVE)
    private List<Picture> pictures;
}
