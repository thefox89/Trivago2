package application;
	
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.*;
import javafx.application.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	static Logger logger; 
	static FileHandler fh; 
			

	
	/**
	 * Metode que inicia el programa
	 */
	@Override
	 public void start(Stage primaryStage) {
		ObservableList<String> lang = FXCollections.observableArrayList();
		lang.addAll("Español", "Catala", "French", "English");
		ComboBox<String> language = new ComboBox<>(lang);
		language.setPromptText("Language");
		Image image = new Image(getClass().getResourceAsStream("Photos/logo_transparent.png"));
		ImageView logo = new ImageView(image);
		Button help = new Button();
		help.setText("Help");
		help.setStyle("-fx-background-color: #4d6bf0");
		Button SignIn = new Button();
		SignIn.setText("Sign In");
		SignIn.setStyle("-fx-background-color: #4d6bf0");
		Button Login = new Button();
		Login.setText("Login ");
		Login.setStyle("-fx-background-color: #4d6bf0");
		HBox hb1 = new HBox();
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.getChildren().addAll(language, logo, help, SignIn, Login);
		TextField tf = new TextField();
		DatePicker checkIn = new DatePicker();
		DatePicker checkOut = new DatePicker();
		Button search = new Button("Search");
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(tf, checkIn, checkOut, search);
		hb2.setAlignment(Pos.CENTER);
		VBox vb = new VBox();
		vb.getChildren().addAll(hb1, hb2);
		BorderPane bPane = new BorderPane();
		bPane.setTop(vb);
		
		//Creem TableView
		TableView <Hotel> HotelTable = new TableView<Hotel>();

		 bPane.setCenter(HotelTable);

		 //.getChildren().add(HotelTable);

		 //prepareResultSet();

		 // Prepare the table view
		 observableUserSearch = FXCollections.observableArrayList();

		 //Creamos las columnas de la tabla
		 TableColumn col1 = new TableColumn("Nombre");
		 TableColumn col2 = new TableColumn("N_habitaciones");
		 TableColumn col3 = new TableColumn("Categoria");
		 TableColumn col4 = new TableColumn("Direccion");
		 TableColumn col5 = new TableColumn("Ciudad");

		
		 col1.setCellValueFactory(new PropertyValueFactory<Hotel, String>("nombre"));
		 col2.setCellValueFactory(new PropertyValueFactory<Hotel, String>("n_Habitaciones"));
		 col3.setCellValueFactory(new PropertyValueFactory<Hotel, String>("categoria"));
		 col4.setCellValueFactory(new PropertyValueFactory<Hotel, String>("direccion"));
		 col5.setCellValueFactory(new PropertyValueFactory<Hotel, String>("ciudad"));

		 col1.setSortable(false);
		 col2.setSortable(false);
		 col3.setSortable(false);
		 col4.setSortable(false);
		 col5.setSortable(false);
		 
		 HotelTable.getColumns().addAll(col1, col2, col3, col4, col5);
		 

		 col1.setResizable(true);
		 col2.setResizable(true);
		 col3.setResizable(true);
		 col4.setResizable(true);
		 col5.setResizable(true);
		 
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
					  Main.logger.severe("No se puede acceder al archivo de configuracion");
				  }
			 }catch(IOException ioefile) {
				  ioefile.printStackTrace();
				  Main.logger.severe("No se puede acceder al archivo de configuracion" + ioefile.getMessage());
				  
			  }
			 //Conectamos con la BBDD
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
					 System.out.println();
					 System.out.println("El nombre del hotel es: "+ myResults.getString("Nombre"));
					 System.out.println("El numero de habitaciones màximo es: "+ myResults.getString("N_Habitaciones"));
					 System.out.println("La categoria del hotel es: "+ myResults.getString("Categoria"));
					 System.out.println("La direccion del hotel es: "+ myResults.getString("Direccion"));
					 System.out.println("El Hotel està situado en: "+ myResults.getString("Ciudad"));
				 }//END while
				 HotelTable.setItems(observableUserSearch);
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
			 System.out.println("Se ACABÓ el progama");
		 }//END try/catch/finally
		Scene scene = new Scene(bPane, 1260, 718);
		primaryStage.setScene(scene);
		primaryStage.show();

		 /*connectdb(hm);
		 System.out.println("jdbc:mysql://"+ hm.get("IP") + ":" + hm.get("port") + "/" + hm.get("BBDDname"));
		 System.out.println("");
		 System.out.println("");*/
		 
	 }//END start method 
	 
	 
	 /**
	 * Hacemos la conexion con la BBDD
	 */
	public static void connectdb(HashMap<String, String> hm){
		 try {
			
		 Connection myConection = DriverManager.getConnection("jdbc:mysql://"+ hm.get("IP") + ":" + hm.get("port") + "/" + hm.get("BBDDname"), hm.get("user"), hm.get("pass"));
		 Statement myStatment = myConection.createStatement();
         ResultSet myResults = myStatment.executeQuery("SELECT * FROM Hoteles WHERE Ciudad=?");
         while(myResults.next()) {
				System.out.println(myResults.getString("Nombre")+
						", "+myResults.getString("N_Habitaciones")+", "+myResults.getString("Categoria")+
						", "+myResults.getString("Dirección")+", "+myResults.getString("Ciudad"));
						
			}// END while
         /*ResultSet myRes = myStatment.executeQuery("SELECT * FROM Reservas");
         while(myResults.next()) {
				System.out.println(myResults.getString("Id_Reserva")+", "+myResults.getString("Dni_Cliente")+
						", "+myResults.getString("Id_Hotel")+", "+myResults.getString("N_Personas")+
						", "+myResults.getString("Fecha_Inicio")+", "+myResults.getString("Fecha_Fin"));
			}// END while */
		 }catch(Exception e) {
			 e.printStackTrace();
		 }//END catch
	 }//END method connectdb
	 
	 
	/**
	 * Iniciamos el log que guardara los errores que nos de, a la hora de ejecutar el programa
	 */
	public static void Startlog(){

		 try { // This block configure the logger with handler and formatter 
		fh = new FileHandler("//home/hang/eclipseworks/First_Project/src/application/logs.log"); 
		logger = Logger.getLogger("application"); 
		logger.addHandler(fh);
		logger.info("My first log"); 
		} catch (SecurityException e) { 
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} 
	logger.info("Error"); 
	}//END method Startlog
		  
	 
	 
	
	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		launch(args);
	}//END main method
	
	/*
	 Llista_Reserva lr = new Llista_Reserva(Id_Reserva,Id_Hotel,Fecha_Inicio,Fecha_Fin)
	        

	*/
}// END class DispalyJobs
