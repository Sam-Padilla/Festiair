package model.entities;

import model.entities.compoundKeys.UserFestivalsKey;

import javax.persistence.*;

@Entity
@Table(name = "user_festivals", schema = "public", catalog = "festiair")
public class UserFestivalsEntity {
//   variables
   private UserFestivalsKey userFestivalsKey;

//   getters and setters for the key
   @EmbeddedId
   public UserFestivalsKey getUserFestivalsKey() { return userFestivalsKey; }
   public void setUserFestivalsKey(UserFestivalsKey userFestivalsKey) { this.userFestivalsKey = userFestivalsKey; }

//   constructors
   public UserFestivalsEntity(int ufUserId, int ufFestivalId){
      this.userFestivalsKey = new UserFestivalsKey(ufUserId,ufFestivalId);
   }
   public UserFestivalsEntity() { }
}


