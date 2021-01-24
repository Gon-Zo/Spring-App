package io.gonzo.jpa.app.domain.inheritance2;

import javax.persistence.Entity;

@Entity
public class Album2 extends Item2 {

   private String artist;

}
