package model.entities.compoundKeys;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserGenresKey implements Serializable {
//   variables
   private int ugUserId, ugGenreId;

//  getters, setters, column names
   @Basic @Column(name = "ug_user_id", length = -1)
   public int getUgUserId() { return ugUserId; }
   public void setUgUserId(int ufUserId) { this.ugUserId = ufUserId; }

   @Basic @Column(name = "ug_genre_id", length = -1)
   public int getUgGenreId() { return ugGenreId; }
   public void setUgGenreId(int ufGenreId) { this.ugGenreId = ufGenreId; }

//   constructors
   public UserGenresKey(int ugUserId , int ugGenreId) { this.ugUserId = ugUserId; this.ugGenreId = ugGenreId; }
   public UserGenresKey() { }

//   required methods
   @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserGenresKey that = (UserGenresKey) o;
      return ugUserId == that.ugUserId &&
              ugGenreId == that.ugGenreId;
   }
   @Override public int hashCode() {
      return Objects.hash(ugUserId, ugGenreId);
   }
}
