package com.seojihoon.boardback.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.seojihoon.boardback.dto.request.board.PostCommentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="comment")
@Table(name="comment")
public class CommentEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int commentNumber;
    private int boardNumber;
    private String userEmail;
    private String contents;
    private String writeDatetime;

    public CommentEntity(PostCommentRequestDto dto, Integer boardNumber, String email) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.contents = dto.getContent();
        this.writeDatetime = writeDatetime;

    }
}
