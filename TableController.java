package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableController implements Initializable{

		@FXML
		private static TableView<Hotel> Hotel;
		
		@FXML
		private static TableColumn<Hotel, String> hname;
		
		@FXML
		private static TableColumn<Hotel, String> hhab;
		
		@FXML
		private static TableColumn<Hotel, String> hcat;
		
		@FXML
		private static TableColumn<Hotel, String> hloc;
		
		@FXML
		private static TableColumn<Hotel, String> hcity;
		
		static ObservableList<Hotel> observableUserSearch = FXCollections.observableArrayList();

		public static Connection myConection;


		public void initialize(URL url, ResourceBundle ResourceBundle) {
			
			 hname.setCellValueFactory(new PropertyValueFactory<Hotel, String>("nombre"));
			 hhab.setCellValueFactory(new PropertyValueFactory<Hotel, String>("n_Habitaciones"));
			 hcat.setCellValueFactory(new PropertyValueFactory<Hotel, String>("categoria"));
			 hloc.setCellValueFactory(new PropertyValueFactory<Hotel, String>("direccion"));
			 hcity.setCellValueFactory(new PropertyValueFactory<Hotel, String>("ciudad"));
			 
			 Hotel.setItems(observableUserSearch);

		}
		
		
		public static void inicialize() {
			 
			 Stage mainStage = new Stage();
			 BorderPane bPane = new BorderPane();
			 VBox HotelViewBox = new VBox();
			  TableView <Hotel> HotelTable = new TableView<Hotel>();
			 //Content
			 Scene HotelScene = new Scene(bPane, 895, 418);
			 mainStage.setTitle("");
			 mainStage.setResizable(false);

			 mainStage.setScene(HotelScene);

			 bPane.setCenter(HotelViewBox);

			 HotelViewBox.getChildren().add(HotelTable);

			 //prepareResultSet();

			 // Prepare the table view
			 observableUserSearch = FXCollections.observableArrayList();


			 TableColumn<Hotel, String> col1 = new TableColumn<Hotel, String>("Nombre");
			 TableColumn<Hotel, String> col2 = new TableColumn<Hotel, String>("N_habitaciones");
			 TableColumn<Hotel, String> col3 = new TableColumn<Hotel, String>("Categoria");
			 TableColumn<Hotel, String> col4 = new TableColumn<Hotel, String>("Direccion");
			 TableColumn<Hotel, String> col5 = new TableColumn<Hotel, String>("Ciudad");

			
			 col1.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hname"));
			 col2.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hhab"));
			 col3.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hcat"));
			 col4.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hloc"));
			 col5.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hcity"));

			 col1.setSortable(false);
			 col2.setSortable(false);
			 col3.setSortable(false);
			 col4.setSortable(false);
			 col5.setSortable(false);
			 
			 HotelTable.getColumns().addAll(col1, col2, col3, col4, col5);
			 

			 col1.setResizable(false);
			 col2.setResizable(false);
			 col3.setResizable(false);
			 col4.setResizable(false);
			 col5.setResizable(false);
			 
			 try {
				 HashMap<String, String> hm=null;
				 String[] config;
				 try {
					  FileReader entrada=new FileReader("//home/hang/eclipseworks/First_Project/src/application/config.conf");
					  try (BufferedReader myBuffer = new BufferedReader(entrada)) {
						//int count = 0;
						  String res = "";
						 
						  
						  hm = new HashMap<String, String>();
						  
						  while ((res = myBuffer.readLine())!=null) {
							config = res.split("=");
							hm.put(config[0], config[1]);
							System.out.println(config[0] + "="+ config[1]);

						  }//END while
					  }catch(IOException ioe) {
						  ioe.printStackTrace();
					  }
				 }catch(IOException ioefile) {
					  ioefile.printStackTrace();
				  }
				Connection myConection = DriverManager.getConnection("jdbc:mysql://"+ hm.get("IP") + ":" + hm.get("port") + "/" + hm.get("BBDDname"), hm.get("user"), hm.get("pass"));
					Statement myStatment = myConection.createStatement();
					 ResultSet myResults = myStatment.executeQuery(
							 "SELECT Nombre, N_Habitaciones, Categoria, Direccion, Ciudad FROM Hoteles"
							 );
					 while(myResults.next()) {
						 observableUserSearch.add(
								 new Hotel(
										 myResults.getString("Nombre"),
										 myResults.getString("N_Habitaciones"),
										 myResults.getString("Categoria"),
										 myResults.getString("Direccion"),
										 myResults.getString("Ciudad")
										 )
								 );
						 //Hotel.getItems().addAll(observableUserSearch);
						 
					 }//END while
					 HotelTable.setItems(observableUserSearch);
					 
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
				 
			 }
		}//END Inicialitzable


		

}
