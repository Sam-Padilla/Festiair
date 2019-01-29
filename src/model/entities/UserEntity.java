package model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "festiair")
public class UserEntity {
//   variables
   private String userName, userLastName, userCountry, userAge;
   private int userId;

//   setters, getter, column names
   @Id @Column(name = "user_id", nullable = false)
   @SequenceGenerator(name = "users_generator",  sequenceName = "users_sequence", allocationSize = 1)
   @GeneratedValue(generator = "users_generator"  )
   public int getUserId() {
      return userId;
   }
   private void setUserId(int userId) { this.userId = userId; }

   @Basic @Column(name = "user_name", nullable = true, length = -1)
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }

   @Basic @Column(name = "user_last_name", nullable = true, length = -1)
   public String getUserLastName() {
      return userLastName;
   }
   public void setUserLastName(String userLastName) {
      this.userLastName = userLastName;
   }

   @Basic @Column(name = "user_country", nullable = true, length = -1)
   public String getUserCountry() {
      return userCountry;
   }
   public void setUserCountry(String userCountry) {
      this.userCountry = userCountry;
   }

   @Basic @Column(name = "user_age", nullable = true, length = -1)
   public String getUserAge() {
      return userAge;
   }
   public void setUserAge(String userAge) {
      this.userAge = userAge;
   }

//   constructors
   public UserEntity(String userName, String userLastName, String userCountry, String userAge) {
      this.userName = userName;
      this.userLastName = userLastName;
      this.userCountry = userCountry;
      this.userAge = userAge;
   }
   public UserEntity() { }

//   required methods
   @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserEntity that = (UserEntity) o;
      return userId == that.userId &&
              Objects.equals(userName, that.userName) &&
              Objects.equals(userLastName, that.userLastName) &&
              Objects.equals(userCountry, that.userCountry) &&
              Objects.equals(userAge, that.userAge);
   }
   @Override public int hashCode() {
      return Objects.hash(userId, userName, userLastName, userCountry, userAge);
   }
}
