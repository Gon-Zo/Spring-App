package io.gonzo.jpa.app.domain.inheritance3;

import javax.persistence.Entity;

@Entity
public class Book3 extends Item3 {
    private String author;
    private String isbn;
}
