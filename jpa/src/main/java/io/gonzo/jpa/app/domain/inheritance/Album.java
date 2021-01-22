package io.gonzo.jpa.app.domain.inheritance;

import javax.persistence.Entity;

@Entity
public class Album extends Item{

   private String artist;

}
