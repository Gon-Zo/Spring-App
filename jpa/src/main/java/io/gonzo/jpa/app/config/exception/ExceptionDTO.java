package io.gonzo.jpa.app.config.exception;


import lombok.Builder;
import lombok.Getter;

import java.io.PrintWriter;
import java.io.StringWriter;

@Getter
public class ExceptionDTO {

    private String code;

    private String message;

    private String detailMessage;

    @Builder
    public ExceptionDTO(String code, String message, String detailMessage) {
        this.code = code;
        this.message = message;
        this.detailMessage = detailMessage;
    }

    public ExceptionDTO toDetailMessage(Exception e) {
        this.detailMessage = getPrintStackTrace(e);
        return this;
    }

    private String getPrintStackTrace(Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

}
