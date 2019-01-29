package model.entities.compoundKeys;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GenreFestivalsKey implements Serializable {
//   variables
   private int gfGenreId, gfFestivalId;

//   getters, setters, column names
   @Basic @Column(name = "gf_genre_id", length = -1)
   public int getGfGenreId() { return gfGenreId; }
   public void setGfGenreId(int gfGenderId) { this.gfGenreId = gfGenderId; }

   @Basic @Column(name = "gf_festival_id", length = -1)
   public int getGfFestivalId() { return gfFestivalId; }
   public void setGfFestivalId(int gfFestivalId) { this.gfFestivalId = gfFestivalId; }

//   constructors
   public GenreFestivalsKey(int gfGenderId , int gfFestivalId) {
      this.gfGenreId = gfGenderId; this.gfFestivalId = gfFestivalId;
   }
   public GenreFestivalsKey() { }

//   required methods
   @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      GenreFestivalsKey that = (GenreFestivalsKey) o;
      return gfGenreId == that.gfGenreId && gfFestivalId == that.gfFestivalId;
   }
   @Override public int hashCode() { return Objects.hash(gfGenreId, gfFestivalId); }
}
