package application;
	
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * @author hang
 *
 */
public class DispalyJobs extends Application {
	
		
	 @Override
	 public void start(Stage stage) {
	  try {
	   
	   Parent root = FXMLLoader.load(getClass().getResource("Pagina_Principal_NoCuentaSintesis.fxml"));
	   Scene scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	 } 
	
	public static void main(String[] args) {
		launch(args);
	}
	
}// END class Main
