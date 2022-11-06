package com.example.jpa.domain.base;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BirthDate implements Serializable {

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private String day;

    @Transient
    public static BirthDate of(String brithDateStr) {
        String year = brithDateStr.substring(0, 4);
        String month = brithDateStr.substring(5, 7);
        String day = brithDateStr.substring(9, 10);
        return new BirthDate(year, month, day);
    }
}
