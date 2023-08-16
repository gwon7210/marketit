package com.test.marketit.common.exception;

import com.test.marketit.common.code.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception{
    private ApiCode status;
}
