package com.test.marketit.common;

import com.test.marketit.common.code.ApiCode;
import com.test.marketit.dto.ErrorResponseDto;
import com.test.marketit.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public class CommController  {

    public ResponseEntity SuccessReturn(Object data) {
        return ResponseEntity.ok().body(
                ResponseDto.builder().statusCode(ApiCode.SUCCESS.getCode()).codeMsg(ApiCode.SUCCESS.getMsg()).data(data).build());
    }

    public ResponseEntity SuccessReturn() {
        return ResponseEntity.ok().body(
                ResponseDto.builder().statusCode(ApiCode.SUCCESS.getCode()).codeMsg(ApiCode.SUCCESS.getMsg()).build());
    }

    public ResponseEntity ErrorReturn(ApiCode apiCode) {
        return ResponseEntity.ok().body(
                ResponseDto.builder().statusCode(apiCode.getCode()).codeMsg(apiCode.getMsg()).build());
    }

    public ResponseEntity ErrorReturn(ApiCode apiCode, Object data) {
        return ResponseEntity.ok().body(
                ResponseDto.builder().statusCode(apiCode.getCode()).codeMsg(apiCode.getMsg()).data(data).build());
    }

    public ResponseEntity ErrorReturn(int code, String msg) {
        return ResponseEntity.ok().body(
                ResponseDto.builder().statusCode(code).codeMsg(msg).build());
    }

    public ResponseEntity ErrorReturn(int code, String msg, Object data) {
        return ResponseEntity.ok().body(
                ResponseDto.builder().statusCode(code).codeMsg(msg).data(data).build());
    }


}
