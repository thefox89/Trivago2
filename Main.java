package application;
	
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import javafx.application.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
/**
 * @author hang i carles
 * @version 3.0
 *
 */

public class Main extends Application {
	
	static Stage mainStage;

	static TableView<Hotel> columntable;
	static Scene HotelScene;

	static BorderPane bPane;

	static VBox rankingVBox;

	static PreparedStatement HotelStmt;

	static ObservableList<Hotel> observableUserSearch;
			

	
	 @Override
	 /**
	  * Aquest es el metode que iniciara el programa per complet indicant els seus procediments
	  */
	 public void start(Stage stage) {
		
			  Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("Pagina_Principal_NoCuentaSintesis.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   Scene scene1 = new Scene(root);
			   stage.setScene(scene1);
			   stage.show();

	 }//END start method 
	 
	 /**
	  * Aquest metode configurara la base de dades
	  * @param hm es el nom del nostre hash map per a el arxiu de configuració
	  */
	 public static void connectdb(HashMap<String, String> hm){
		 try {
			
		 Connection myConection = DriverManager.getConnection("jdbc:mysql://"+ hm.get("IP") + ":" + hm.get("port") + "/" + hm.get("BBDDname"), hm.get("user"), hm.get("pass"));
		 Statement myStatment = myConection.createStatement();
         ResultSet myResults = myStatment.executeQuery("SELECT * FROM Hoteles");
         while(myResults.next()) {
				System.out.println(myResults.getString("Nombre")+
						", "+myResults.getString("N_Habitaciones")+", "+myResults.getString("Categoria")+
						", "+myResults.getString("DirecciÃ³n")+", "+myResults.getString("Ciudad"));
						
			}// END while

		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	/**
	 * Main, el metodo que lanza argumentos
	 * @param args metodo executable
	 */
	public static void main(String[] args) {
		launch(args);
	}//END main method
	
}// END class DispalyJobs
