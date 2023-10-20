package com.seojihoon.boardback.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.seojihoon.boardback.dto.response.ResponseCode;
import com.seojihoon.boardback.dto.response.ResponseDto;
import com.seojihoon.boardback.dto.response.ResponseMessage;
import com.seojihoon.boardback.entity.BoardImageEntity;
import com.seojihoon.boardback.entity.BoardViewEntity;

import lombok.Getter;

@Getter
public class GetBoardResponseDto extends ResponseDto {
    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    private GetBoardResponseDto(String code, String message, BoardViewEntity boardViewEntity, List<BoardImageEntity> boardImageEntities) {
        super(code, message);
        List<String> boardImageList = new ArrayList<>();
        for (BoardImageEntity boardImageEntity: boardImageEntities) {
            String boardImage = boardImageEntity.getImageUrl();
            boardImageList.add(boardImage);
        }

        this.boardNumber = boardViewEntity.getBoardNumber();
        this.title = boardViewEntity.getTitle();
        this.content = boardViewEntity.getContent();
        this.boardImageList = boardImageList;
        this.writeDatetime = boardViewEntity.getWriteDatetime();
        this.writerEmail = boardViewEntity.getWriterEmail();
        this.writerNickname = boardViewEntity.getWriterNickname();
        this.writerProfileImage = boardViewEntity.getWriterProfileImage();
    }

    public static ResponseEntity<GetBoardResponseDto> success(BoardViewEntity boardViewEntity, List<BoardImageEntity> boardImageEntities) {
        GetBoardResponseDto result = new GetBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardViewEntity, boardImageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
