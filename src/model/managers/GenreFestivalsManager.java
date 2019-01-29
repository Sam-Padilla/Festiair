package model.managers;

import model.entities.FestivalEntity;
import model.entities.GenreFestivalsEntity;
import model.entities.UserFestivalsEntity;
import model.entities.compoundKeys.GenreFestivalsKey;
import model.entities.compoundKeys.UserFestivalsKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class GenreFestivalsManager {
//   variables
   private static final SessionFactory sessionFactory = new Configuration().configure("model/hibernate.cfg.xml").buildSessionFactory();

//   methods
   public boolean genreFestivalExist(int gfGenreId, int gfFestivalId){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      GenreFestivalsEntity user = session.get(GenreFestivalsEntity.class, new GenreFestivalsKey(gfGenreId,gfFestivalId));
      session.getTransaction().commit();
      return user != null;
   }
   public ArrayList<FestivalEntity> getGenreFestivals(int genreId){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.createQuery("from GenreFestivalsEntity where genreFestivalsKey.gfGenreId=" + genreId);
      ArrayList<GenreFestivalsEntity> results =  (ArrayList) query.list();
      session.getTransaction().commit();

//    festivals of their respective gender
      ArrayList<FestivalEntity> returnedArray = new ArrayList<>() ;
      for (GenreFestivalsEntity result : results) {
         returnedArray.add(new  FestivalManager().festivalObtain(result.getGenreFestivalsKey().getGfFestivalId()));
      }
      return returnedArray;
   }
   public void genreFestivalAdd( int gfGenreId, int gfFestivalId) {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(new GenreFestivalsEntity(gfGenreId,gfFestivalId));
      session.getTransaction().commit();
   }

}
