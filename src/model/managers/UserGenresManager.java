package model.managers;

import model.entities.UserGenresEntity;
import model.entities.compoundKeys.UserGenresKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class UserGenresManager {
//variables
   private static final SessionFactory sessionFactory = new Configuration().configure("model/hibernate.cfg.xml").buildSessionFactory();

// methods
   private int getAttractiveGenre(ArrayList<Integer> genresId) {

      int count = 1, tempCount, temp = 0, attractiveGenre = genresId.get(0);
      for (int i = 0; i < genresId.size(); i++)
      {
         temp = genresId.get(i); tempCount = 0;
         for (int j = 1; j < genresId.size(); j++) { if (temp == genresId.get(j)) { tempCount++; } }
         if (tempCount > count) { attractiveGenre = temp;count = tempCount; }
      }


      return attractiveGenre;
   }
   private ArrayList<Integer> getUserGenres(int id){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.createQuery("from UserGenresEntity where userGenresKey.ugUserId=" + id);
      ArrayList<UserGenresEntity> results =  (ArrayList) query.list();
      session.getTransaction().commit();
      ArrayList<Integer> returnedArray = new ArrayList<>() ;
      for (UserGenresEntity result : results) {
         returnedArray.add(result.getUserGenresKey().getUgGenreId());
      }
      return returnedArray;
   }

   public ArrayList<Integer> getUserGenresAttractive(int id){
      ArrayList<Integer> userGenres =  getUserGenres(id), returnedArray = new ArrayList<>();
      if (userGenres.size() !=0){
         int counter = 0;
         do {
            int attractiveGenre = getAttractiveGenre(userGenres);
            returnedArray.add(attractiveGenre);
            userGenres.removeAll(Collections.singleton(attractiveGenre));
            counter++;
         }while (userGenres.size() > 0 && counter < 4);
      }
      return returnedArray;
   }
   public void userGenreAdd( int ugUserId, int ugGenreId) {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save( new UserGenresEntity(ugUserId,ugGenreId));
      session.getTransaction().commit();
   }

}
