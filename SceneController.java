package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class SceneController extends Main {

	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 //Pag Pral sin cuenta
	 public void switchToScene1(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("Pagina_Principal_NoCuentaSintesis.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 //Crear cuenta
	 public void switchToScene2(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("SignUp_Sintesis.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 //Pag Pral con cuenta
	 public void switchToScene3(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("Sintesis.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 //Pagina de detalles sin cuenta
	 public void switchToScene4(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("Querer_Reservar.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 //Iniciar session
	 public void switchToScene5(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("Login_Sintesis.fxml")); 
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 //Pagina detalles con cuenta
	 public void switchToScene6(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("Hacer Reserva.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 //Perfil del usuario
	 public void switchToScene7(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("perfil.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 	 //Perfil del usuario
	 public void showtable(ActionEvent event) throws IOException {
     TableController.inicialize();
   	 }
	 

}
