package com.seojihoon.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seojihoon.boardback.entity.BoardViewEntity;

@Repository
public interface BoardViewRepository extends JpaRepository<BoardViewEntity, Integer> {

    BoardViewEntity findByBoardNumber(Integer boardNumber);

    List<BoardViewEntity> findByOrderByWriteDatetimeDesc();
    List<BoardViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String email);
    List<BoardViewEntity> findTop3ByWriteDatetimeGreaterThanOrderByFavoriteCountDesc(String writeDatetime);
    List<BoardViewEntity> findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(String title, String content);

}
