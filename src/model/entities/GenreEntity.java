package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "genres", schema = "public", catalog = "festiair")
public class GenreEntity {
//   variables
   private int genreId;
   private String genreName;

//   setters, getter, column names
   @Id
   @Column(name = "genre_id", nullable = false)
   @SequenceGenerator(name = "genres_generator", sequenceName = "genres_sequence", allocationSize = 1)
   @GeneratedValue(generator = "genres_generator")
   public int getGenreId() {
      return genreId;
   }
   private void setGenreId(int genreId) {
      this.genreId = genreId;
   }

   @Basic @Column(name = "genre_name", nullable = true, length = -1)
   public String getGenreName() {
      return genreName;
   }
   public void setGenreName(String genreName) {
      this.genreName = genreName;
   }

//   constructors
   public GenreEntity(String genreName) { this.genreName = genreName; }
   public GenreEntity() { }

//   required methods
   @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      GenreEntity that = (GenreEntity) o;
      return genreId == that.genreId && Objects.equals(genreName, that.genreName);
   }
   @Override public int hashCode() {
      return Objects.hash(genreId, genreName);
   }
}
