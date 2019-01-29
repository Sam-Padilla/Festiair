package controller.pages;

import controller.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import model.managers.*;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddFestival {
   //variables
   private int id ;
   @FXML private TextField inputName, inputGenre, inputCountry;
   private Utils utils = new Utils();

   //functions
   public void setId(int id){ this.id = id; }
   private int addNewGenre(String name){
      name = utils.toCamelCase(name);
      GenreManager gm = new GenreManager();
      //add to general genre and user genre
      int genreId = gm.genreSearchName(name);
      if (genreId == -1){ genreId = gm.genreAdd(name); }
      new UserGenresManager().userGenreAdd(id,genreId);
      return genreId;
   }
   public int addNewFestival(String name, String country){
      FestivalManager fm = new FestivalManager();
      UserFestivalsManager ufm = new UserFestivalsManager();
      //add to general festivals and user festivals
      int festivalId = fm.festivalSearchName(name);
      if (festivalId == -1) { festivalId = fm.festivalAdd(name, country); }
      if (!ufm.userFestivalExist(id,festivalId)){
         ufm.userFestivalAdd(id,festivalId);
      }else { festivalId = -1;}
      return festivalId;
   }
   private void buttonCreateFunction(ActionEvent event) throws IOException{
      String name = inputName.getText(), genre = inputGenre.getText(), country = inputCountry.getText();

//      this structure includes validators
      if (!name.equals("") && !genre.equals("") && !country.equals("")){
         int festivalId = addNewFestival(name,country);
         if (festivalId != -1){ //-1 = existing festival
            GenreFestivalsManager gfm = new GenreFestivalsManager();
            int genreId = addNewGenre(genre);
            if (!gfm.genreFestivalExist(genreId,festivalId)) {
               gfm.genreFestivalAdd(genreId,festivalId);
            }
            utils.showAlert("Evento Agregado", "Se ha añadido a tus festivales",'I');
         }else { utils.showAlert("Festival ya agregado","Festival ya en tus festivales",'W');}
         utils.new screenChangers().mainScreenChanger(event, id);
      }else {
         utils.showAlert("No se puede agregar", "Por favor rellene todos los campos",'W');
      }
   }

   //events
   public void buttonCreateClick (ActionEvent event) throws IOException{ buttonCreateFunction(event); }
   public void buttonReturnClick (ActionEvent event) throws IOException {
      utils.new screenChangers().mainScreenChanger(event, id);
   }
}
