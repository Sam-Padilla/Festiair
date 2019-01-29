package model.managers;

import controller.Utils;
import model.entities.FestivalEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class FestivalManager {
//   variables
   private static final SessionFactory sessionFactory = new Configuration().configure("model/hibernate.cfg.xml").buildSessionFactory();
   private Utils utils = new Utils();

//   methods

   public FestivalEntity festivalObtain(int id){
   Session session = sessionFactory.openSession();
   session.beginTransaction();
   FestivalEntity festival = session.get(FestivalEntity.class, id);
   session.getTransaction().commit();
   return festival;
}
   public int festivalSearchName(String name){
      name = utils.toCamelCase(name);
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.createQuery("from FestivalEntity where festivalName ='" + name + "'");
      ArrayList<FestivalEntity> results =  (ArrayList) query.list();
      session.getTransaction().commit();
      if (results.size() != 0){
         return results.get(0).getFestivalId();
      }else { return  -1; }
   }
   public int festivalAdd( String name, String country) {
      name = utils.toCamelCase(name);
      country = utils.toCamelCase(country);
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      FestivalEntity festival = new FestivalEntity(name,country);
      session.save(festival);
      session.getTransaction().commit();
      return festival.getFestivalId();
   }
}
