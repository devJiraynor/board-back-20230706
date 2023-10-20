package com.seojihoon.boardback.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seojihoon.boardback.entity.FavoriteEntity;
import com.seojihoon.boardback.entity.primaryKey.FavoritePk;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {
    
    boolean existsByUserEmailAndBoardNumber(String userEmail, Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
    
}
