

package com.example.stealingnasapictures.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "picture", schema = "nasa")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nasa_photo_id", unique = true, nullable = false)
    private long nasaPhotoId;

    private int sol;

    @Column(name = "img_src", unique = true, nullable = false)
    private String imgSrc;

    @ManyToOne
    @JoinColumn(name = "camera_info_dto_id")
    private Camera camera;


}
