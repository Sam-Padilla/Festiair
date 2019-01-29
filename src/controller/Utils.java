package controller;

import controller.pages.AddFestival;
import controller.pages.Principal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;


public class Utils {
//   java fx utilities
   // to change scene
   public  class  screenChangers{

      public void standardScreenChanger(ActionEvent event, String resource) throws IOException {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
         Parent newFXML = loader.load();
         stage.hide(); stage.setScene(new Scene(newFXML)); stage.show();
      }
      public void mainScreenChanger(ActionEvent event, int id) throws IOException{
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pages/Principal/Principal.fxml"));
         Parent newFXML = loader.load();
         Principal pm = loader.getController(); pm.setData(id);
         stage.hide(); stage.setScene(new Scene(newFXML)); stage.show();
      }
      public void addFestivalsScreenChanger(ActionEvent event, int id) throws IOException{
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pages/AddFestival/AddFestival.fxml"));
         Parent newFXML = loader.load();
         AddFestival pm = loader.getController(); pm.setId(id);
         stage.hide(); stage.setScene(new Scene(newFXML)); stage.show();
      }
   }

   //I = Information,W = warning and E =error; message
   public void showAlert(String title, String message, char alertType){
      Alert alert ;
      switch (alertType){
         case 'W': alert = new Alert(Alert.AlertType.WARNING); break;
         case 'I': alert = new Alert(Alert.AlertType.INFORMATION); break;
         case 'E': alert = new Alert(Alert.AlertType.ERROR); break;
         default:
            alert = new Alert(Alert.AlertType.ERROR);
            title = "Error"; message = "Incorrect alert type in alert function";
            break;
      }
      alert.setTitle(title); alert.setHeaderText(null);
      alert.setContentText(message);
      alert.showAndWait();
   }
   public void sceneInitializer(Stage stage, String resource) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource(resource));
      Scene mainScene = new Scene(root,960,540);
      stage.setTitle("Festiair");
      stage.setScene(mainScene);
      stage.setResizable(false);
      stage.show();
   }

//   text methods
   public String removeSecondWord (String word){
   if (word.contains(" ")){
      word = word.substring(0, word.indexOf(" "));
   }
   return word;
}
   public String toCamelCase(final String init) {
      if (init==null) return null;
      final StringBuilder ret = new StringBuilder(init.length());
      for (final String word : init.split(" ")) {
         if (!word.isEmpty()) {
            ret.append(word.substring(0, 1).toUpperCase());
            ret.append(word.substring(1).toLowerCase());
         }
         if (!(ret.length()==init.length())) ret.append(" ");
      }
      return ret.toString().replace(" ","");
   }
   public String toStringFormatted(String text){
      return text.replaceAll("(.)(\\p{Upper})", "$1 $2");
   }

}
