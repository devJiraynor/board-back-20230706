package com.seojihoon.boardback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.seojihoon.boardback.entity.BoardViewEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListItem {
    private int boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private int viewCount;
    private int favoriteCount;
    private int commentCount;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    public BoardListItem(BoardViewEntity boardViewEntity) {
        this.boardNumber = boardViewEntity.getBoardNumber();
        this.title = boardViewEntity.getTitle();
        this.content = boardViewEntity.getContent();
        this.boardTitleImage = boardViewEntity.getBoardTitleImage();
        this.viewCount = boardViewEntity.getViewCount();
        this.favoriteCount = boardViewEntity.getFavoriteCount();
        this.commentCount = boardViewEntity.getCommentCount();
        this.writeDatetime = boardViewEntity.getWriteDatetime();
        this.writerEmail = boardViewEntity.getWriterEmail();
        this.writerNickname = boardViewEntity.getWriterNickname();
        this.writerProfileImage = boardViewEntity.getWriterProfileImage();
    }

    public static List<BoardListItem> getList(List<BoardViewEntity> boardViewEntities) {
        List<BoardListItem> list = new ArrayList<>();
        for (BoardViewEntity boardViewEntity: boardViewEntities) {
            BoardListItem boardListItem = new BoardListItem(boardViewEntity);
            list.add(boardListItem);
        }
        return list;
    }
}
