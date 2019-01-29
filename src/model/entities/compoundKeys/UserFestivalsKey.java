package model.entities.compoundKeys;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFestivalsKey implements Serializable {
//   variables
   private int ufUserId, ufFestivalId;

//   getters, setters, column names
   @Basic @Column(name = "uf_user_id", length = -1)
   public int getUfUserId() { return ufUserId; }
   public void setUfUserId(int ufUserId) { this.ufUserId = ufUserId; }

   @Basic @Column(name = "uf_festival_id", length = -1)
   public int getUfFestivalId() { return ufFestivalId; }
   public void setUfFestivalId(int ufFestivalId) { this.ufFestivalId = ufFestivalId; }

//   constructors
   public UserFestivalsKey() { }
   public UserFestivalsKey(int ufUserId , int ufFestivalId) {
      this.ufUserId = ufUserId; this.ufFestivalId = ufFestivalId;
   }

//   required methods
   @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserFestivalsKey that = (UserFestivalsKey) o;
      return ufUserId == that.ufUserId && ufFestivalId == that.ufFestivalId;
   }
   @Override public int hashCode() {
      return Objects.hash(ufUserId, ufFestivalId);
   }
}
