package com.pmn.gmt.domain.auth.domain.repository;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {
    RefreshToken findByToken(String token);
    RefreshToken findByUserId(int userId);
}