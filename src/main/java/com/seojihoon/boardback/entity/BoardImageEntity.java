package com.seojihoon.boardback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="board_image")
@Table(name="board_image")
public class BoardImageEntity {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sequence;
    private int boardNumber;
    private String imageUrl;

    public BoardImageEntity (int boardNumber, String imageUrl) {
        this.boardNumber = boardNumber;
        this.imageUrl = imageUrl;
    }

}
