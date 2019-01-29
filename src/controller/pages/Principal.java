package controller.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import controller.Utils;
import model.entities.FestivalEntity;
import model.entities.compoundKeys.UserFestivalsKey;
import model.managers.UserFestivalsManager;
import model.managers.UsersManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {
   //variables
   @FXML private AnchorPane paneFestivalsMy, paneFestivalsRecommendations;
   @FXML private Label greet;

   private UsersManager um = new UsersManager();
   private Utils utils = new Utils();
   private int id;

   //functions
   private void noDataMessageSet(AnchorPane pane, String message){
      Label label = new Label(message);
      label.getStyleClass().add("no-data-message");
      label.setLayoutX(220); label.setLayoutY(60);
      pane.getChildren().add(label);
   }

   private Hyperlink formattedDeleteButton(FestivalEntity festival){
      Hyperlink hyperlink = new Hyperlink("X");
      hyperlink.getStyleClass().add("text-button");
      hyperlink.setLayoutX(130); hyperlink.setLayoutY(6);
      hyperlink.setOnAction(event -> {
         new UserFestivalsManager().userFestivalDelete(new UserFestivalsKey(id,festival.getFestivalId()));
         addAllFestivals(new UserFestivalsManager().getUserFestivals(id),false );
      });
      return hyperlink;
   }
   private Button formattedAddButton(FestivalEntity festival, String text){
      Button button = new Button(text);
      button.getStyleClass().add("button");
      button.getStyleClass().add("button-recommendation-add");
      button.setLayoutX(112); button.setLayoutY(112);
      DropShadow shadow = new DropShadow();
      button.setEffect(shadow);

      button.setOnAction(event -> {
         new UserFestivalsManager().userFestivalAdd(id,festival.getFestivalId());
         addAllFestivals(new UserFestivalsManager().getUserFestivals(id) ,true);
      });
      return button;
   }
   private Label formattedRegionTitle(FestivalEntity festival){
      Label label = new Label();
      //so that it fits in the region
      String name = utils.removeSecondWord(utils.toStringFormatted(festival.getFestivalName()));
      label.setText(utils.toStringFormatted(name + " - " + festival.getFestivalCountry() ) );
      label.setLayoutY(9); label.setLayoutX(3);
      label.getStyleClass().add("region_title");
      return label;
   }
   private AnchorPane formattedRegion( FestivalEntity festival, double layoutX){
      char initialLetter = festival.getFestivalName().charAt(0);
      AnchorPane region = new AnchorPane();
      region.setPrefHeight(150); region.setPrefWidth(150);
      region.setLayoutY(2); region.setLayoutX(layoutX);
      BackgroundImage backgroundImage= new BackgroundImage(new Image("view/img/letters/"+initialLetter+".jpg"),
              BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
              BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
      region.setBackground(new Background(backgroundImage));
      region.getChildren().add(formattedRegionTitle(festival));
      return region;
   }

   private void addAllFestivalsRecommendations(ArrayList<FestivalEntity> festivals){
      paneFestivalsRecommendations.getChildren().clear();
      if (festivals.size() != 0){
         for (int i = 0; i <festivals.size(); i++) {
            AnchorPane region = formattedRegion(festivals.get(i), 170 * i);
            region.getChildren().add(formattedAddButton(festivals.get(i), "+"));
            paneFestivalsRecommendations.getChildren().add(region);
         }
      }else { noDataMessageSet(paneFestivalsRecommendations,"Sigue agregando Festivales"); }
   }

   private void addAllFestivals(ArrayList<FestivalEntity> festivals ,boolean addFestivalRecommendations){
      Collections.reverse(festivals); //Sort the list chronologically
      paneFestivalsMy.getChildren().clear();
      if (festivals.size() != 0){
         for (int i = 0; i <festivals.size(); i++) {
            AnchorPane region = formattedRegion(festivals.get(i), 170 * i);
            region.getChildren().add(formattedDeleteButton(festivals.get(i)));
            paneFestivalsMy.getChildren().add(region);
         }
      }else { noDataMessageSet(paneFestivalsMy,"Comienza a agregar Festivales"); }
      if (addFestivalRecommendations){
         addAllFestivalsRecommendations(new UserFestivalsManager().getUserFestivalsRecommendations(id));
      }
   }

   public void setData(int id) {
      this.id = id;
      greet.setText("Hola, " + utils.toStringFormatted(um.userObtain(this.id).getUserName()));

      UserFestivalsManager ufm = new UserFestivalsManager();
      addAllFestivals(ufm.getUserFestivals(id),true);
   }

   //Events
   public void buttonAddClick (ActionEvent event) throws IOException {
      utils.new screenChangers().addFestivalsScreenChanger(event, id);
   }
   public void buttonExitClick (ActionEvent event) throws IOException {
      utils.new screenChangers().standardScreenChanger(event, "/view/pages/Start/Start.fxml");
   }
}
