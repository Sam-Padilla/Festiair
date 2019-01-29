package controller.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.managers.UsersManager;
import controller.Utils;

import java.io.IOException;

public class ObtainID {

   //variables
   @FXML private TextField inputName, inputLastName, inputCountry, inputAge;
   private Utils utils = new Utils();

   //functions
   private void buttonObtainFunction(ActionEvent event) throws IOException{
      String name = inputName.getText(), lastName = inputLastName.getText(), country = inputCountry.getText(), age = inputAge.getText();

      if (!name.equals("") && !lastName.equals("") && !country.equals("") && !age.equals("")){
         int id = new UsersManager().userAdd(name,lastName,country,age);
         utils.showAlert("Usuario Agregado", "Tu id es: " + id,'I');
         utils.new screenChangers().standardScreenChanger(event, "/view/pages/Start/Start.fxml");
      }else {
         utils.showAlert("Inposible crear usuario", "Por favor rellene todos los campos",'W');
      }
   }
   //events
   public void buttonObtainClick (ActionEvent event) throws IOException { buttonObtainFunction(event); }
   public void buttonReturnClick (ActionEvent event) throws IOException {
      utils.new screenChangers().standardScreenChanger(event, "/view/pages/Start/Start.fxml");
   }

}
