/*
 * This file is a subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.example.stealingnasapictures.repository;

import com.example.stealingnasapictures.model.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CameraRepository extends JpaRepository<Camera, Long> {

    Optional<Camera> findByName(String name);
}
