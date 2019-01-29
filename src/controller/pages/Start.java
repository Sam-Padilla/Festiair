package controller.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.managers.UsersManager;
import controller.Utils;


import java.io.IOException;
import javafx.scene.control.TextField;

public class Start {

//variables
@FXML private TextField inputId;
private Utils utils = new Utils();

//functions

   private void buttonAcceptFunction(ActionEvent event) throws IOException{
      String idString = inputId.getText();
      try{
         int id = Integer.valueOf(idString);
         if (!idString.equals("") && new UsersManager().userExist(id)){
            utils.new screenChangers().mainScreenChanger(event,id);
         }else { throw new NumberFormatException(); }
      }catch (NumberFormatException e){
         utils.showAlert("Id incorrecto", "Verifique su Id", 'W');
      }
   }
//events
   public void buttonAcceptClick (ActionEvent event) throws IOException { buttonAcceptFunction(event); }
   public void buttonObtainClick (ActionEvent event) throws IOException {
      utils.new screenChangers().standardScreenChanger(event,"/view/pages/ObtainId/ObtainID.fxml");
   }

}
