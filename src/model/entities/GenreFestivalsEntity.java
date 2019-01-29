package model.entities;

import model.entities.compoundKeys.GenreFestivalsKey;
import model.entities.compoundKeys.UserGenresKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "genre_festivals", schema = "public", catalog = "festiair")
public class GenreFestivalsEntity {
//   variables
   private GenreFestivalsKey genreFestivalsKey;

//   getters and setters of the key
   @EmbeddedId
   public GenreFestivalsKey getGenreFestivalsKey() { return genreFestivalsKey; }
   public void setGenreFestivalsKey(GenreFestivalsKey genreFestivalsKey) {
      this.genreFestivalsKey = genreFestivalsKey;
   }

//   constructors
   public GenreFestivalsEntity(int gfGenreId, int gfFestivalId){
      this.genreFestivalsKey = new GenreFestivalsKey(gfGenreId,gfFestivalId);
   }
   public GenreFestivalsEntity() { }
}


