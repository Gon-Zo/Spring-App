package io.gonzo.jpa.app.domain.inheritance1;

import javax.persistence.Entity;

@Entity
public class Album1 extends Item1 {

   private String artist;

}
