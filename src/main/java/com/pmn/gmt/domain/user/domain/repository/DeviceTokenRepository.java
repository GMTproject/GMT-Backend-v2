package com.pmn.gmt.domain.user.domain.repository;

import com.pmn.gmt.domain.user.domain.entity.DeviceToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTokenRepository extends JpaRepository<DeviceToken, Integer> {
}
