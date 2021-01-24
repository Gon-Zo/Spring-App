package io.gonzo.jpa.app.domain.inheritance3;

import javax.persistence.Entity;

@Entity
public class Movie3 extends Item3 {

   private String director;

   private String actor;

}
