package io.gonzo.jpa.app.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


public class MessageDTO {

    @Getter
    @SuperBuilder
    @AllArgsConstructor
    public static class Default {

        private int status;

        private String message;

        @Setter
        private Object data;

    }

    @Getter
    @SuperBuilder
    public static class Error extends Default {

        private String code;

        public Error(int status, String message, Object data) {
            super(status, message, data);
        }

        protected Error(DefaultBuilder<?, ?> b) {
            super(b);
        }

    }

}
