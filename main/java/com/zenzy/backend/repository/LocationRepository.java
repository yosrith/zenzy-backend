package com.zenzy.backend.repository;

import com.zenzy.backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
