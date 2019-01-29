package model.managers;

import controller.Utils;
import model.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsersManager {
//   variables
   private static final SessionFactory sessionFactory = new Configuration().configure("model/hibernate.cfg.xml").buildSessionFactory();
   private Utils utils = new Utils();

//   methods
   public UserEntity userObtain(int id){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      UserEntity user = session.get(UserEntity.class, id);
      session.getTransaction().commit();
      return user;
   }
   public boolean userExist(int id){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      UserEntity user = session.get(UserEntity.class, id);
      session.getTransaction().commit();
      return user != null;
   }
   public int userAdd( String name, String lastName, String country, String age) {
      name = utils.toCamelCase(name); lastName = utils.toCamelCase(lastName);;country = utils.toCamelCase(country);;
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      UserEntity user = new UserEntity(name,lastName,country,age);
      session.save(user);
      session.getTransaction().commit();
      return user.getUserId();
   }

}
