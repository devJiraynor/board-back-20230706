package com.seojihoon.boardback.service;

import org.springframework.http.ResponseEntity;

import com.seojihoon.boardback.dto.request.auth.SignInRequestDto;
import com.seojihoon.boardback.dto.request.auth.SignUpRequestDto;
import com.seojihoon.boardback.dto.response.auth.SignInResponseDto;
import com.seojihoon.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

}
