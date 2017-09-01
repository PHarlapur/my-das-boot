package com.boot.repository;

import com.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Prabhas_Harlapur on 8/30/2017.
 */


public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
