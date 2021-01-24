package io.gonzo.jpa.app.domain.inheritance1;

import javax.persistence.Entity;

@Entity
public class Movie1 extends Item1 {

   private String director;

   private String actor;

}
