package application;
	
import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.HashMap;
/**
 * @author hang
 *
 *
 */

public class DispalyJobs extends Application {
	
	private TableView<Hotel> hoteles = new TableView<Hotel>();
	final ObservableList<Hotel> hotel =FXCollections.observableArrayList(
			
	); 
	
	 @Override
	 public void start(Stage stage) {
		
	  try {
		  FileReader entrada=new FileReader("//home/hang/eclipseworks/First_Project/src/application/config.conf");
		  BufferedReader mybuffer = new BufferedReader(entrada);
		  int count = 0;
		  String res = "";
		  HashMap<String, String> hm;
		  
		  hm = new HashMap<String, String>();
		  
		  while ((res = mybuffer.readLine())!=null) {
			//entrada.split("\\s+");
			String[] alone_val = res.split("=");
			count = entrada.read();
			char lett=(char)count;
			System.out.println(lett);
		}
		/*CREEM LA CONEXIÓ
			Connection myConection = DriverManager.getConnection("jdbc:mysql://192.168.2.11:3306/Projecte","hang","1234");
			
		//CREEM L'OBJECTE STATEMENT
			Statement myStatement=myConection.createStatement();
			
		//RECORREM EL RESULTAT
			ResultSet myResults=myStatement.executeQuery("SELECT * FROM Hoteles");
			while(myResults.next()){*/
	   
	   Parent root = FXMLLoader.load(getClass().getResource("Pagina_Principal_NoCuentaSintesis.fxml"));
	   Scene scene1 = new Scene(root);
	   stage.setScene(scene1);
	   stage.show();
			//}
	   
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	  
	 } 
	
	public static void main(String[] args) {
		launch(args);
	}
	
}// END class Main
