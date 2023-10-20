package com.seojihoon.boardback.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seojihoon.boardback.entity.CommentEntity;
import com.seojihoon.boardback.repository.resultSet.CommentListResultSet;

@Repository
public interface CommentRespository extends JpaRepository<CommentEntity, Integer> {
    
    @Query(
        value=
        "SELECT " + 
            "U.nickname AS nickname, " +
            "U.profile_image_url AS profileImage, " +
            "C.contents AS content, " +
            "C.write_datetime AS writeDatetime " +
        "FROM comment AS C " +
        "INNER JOIN user AS U " +
        "ON C.user_email = U.email " +
        "WHERE C.board_number = ?1 " +
        "ORDER BY C.write_datetime DESC ",
        nativeQuery=true
    )
    List<CommentListResultSet> findByCommentList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);

}
