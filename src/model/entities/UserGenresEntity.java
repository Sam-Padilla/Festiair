package model.entities;

import model.entities.compoundKeys.UserGenresKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_genres", schema = "public", catalog = "festiair")
public class UserGenresEntity {
//   variables
   private UserGenresKey userGenresKey;

//   getters and setters for the key
   @EmbeddedId
   public UserGenresKey getUserGenresKey() { return userGenresKey; }
   public void setUserGenresKey(UserGenresKey userGenresKey) {
      this.userGenresKey = userGenresKey;
   }

//   constructors
   public UserGenresEntity(int ugUserId, int ugFestivalId){
      this.userGenresKey = new UserGenresKey(ugUserId,ugFestivalId);
   }
   public UserGenresEntity() { }
}


