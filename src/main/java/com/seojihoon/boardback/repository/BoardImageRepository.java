package com.seojihoon.boardback.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seojihoon.boardback.entity.BoardImageEntity;

@Repository
public interface BoardImageRepository extends JpaRepository<BoardImageEntity, Integer> {
    
    List<BoardImageEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);

}
