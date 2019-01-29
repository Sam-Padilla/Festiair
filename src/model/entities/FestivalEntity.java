package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "festivals", schema = "public", catalog = "festiair")
public class FestivalEntity {
//   variables
   private int festivalId;
   private String festivalName, festivalCountry;

//   setters, getter, column names
   @Id @Column(name = "festival_id", nullable = false)
   @SequenceGenerator(name = "festivals_generator", sequenceName = "festivals_sequence", allocationSize = 1)
   @GeneratedValue(generator = "festivals_generator")
   public int getFestivalId() {
      return festivalId;
   }
   public void setFestivalId(int festivalId) {
      this.festivalId = festivalId;
   }

   @Basic @Column(name = "festival_name", nullable = true, length = -1)
   public String getFestivalName() {
      return festivalName;
   }
   public void setFestivalName(String festivalName) {
      this.festivalName = festivalName;
   }

   @Basic @Column(name = "festival_country", nullable = true, length = -1)
   public String getFestivalCountry() {
      return festivalCountry;
   }
   public void setFestivalCountry(String festivalCountry) {
      this.festivalCountry = festivalCountry;
   }

//   constructors
   public FestivalEntity(String festivalName, String festivalCountry) {
      this.festivalName = festivalName; this.festivalCountry = festivalCountry;
   }
   public FestivalEntity() { }

//   required methods
   @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      FestivalEntity that = (FestivalEntity) o;
      return festivalId == that.festivalId &&
              Objects.equals(festivalName, that.festivalName) &&
              Objects.equals(festivalCountry, that.festivalCountry);
   }
   @Override public int hashCode() {
      return Objects.hash(festivalId, festivalName, festivalCountry);
   }
}
