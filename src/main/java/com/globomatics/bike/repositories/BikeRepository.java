package com.globomatics.bike.repositories;

import com.globomatics.bike.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BikeRepository")
public interface BikeRepository extends JpaRepository<Bike, Long> {}
