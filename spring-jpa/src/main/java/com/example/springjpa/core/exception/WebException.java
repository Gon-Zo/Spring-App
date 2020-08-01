package com.example.springjpa.core.exception;

/**
 * Create by park031517@gmail.com on 2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public class WebException extends RuntimeException {

   private ErrorCode errorCode;

   public WebException(String message, ErrorCode errorCode) {
      super(message);
      this.errorCode = errorCode;
   }

   public WebException(ErrorCode errorCode) {
      super(errorCode.getMessage());
      this.errorCode = errorCode;
   }

   public ErrorCode getErrorCode() {
      return errorCode;
   }

   public ErrorCode getStaticErrorCode() {
      return errorCode;

   }

}
