package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.base.CustomPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomStoreDTO {

    private CustomPK customPK;

    private String content;

}
