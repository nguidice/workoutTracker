package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	String user = "JavaFX2";
	String pw = "password";
	String checkUser, checkPw;
	DataCenter center=DataCenter.getInstance();
	
    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LiftTracker");
        
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        
        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(60,30,30,30));
        
        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
       //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();
        
        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);
        
        //Reflection for gridPane

        
        //DropShadow effect
        
        //Adding text and DropShadow effect to it
        Text text = new Text("LiftTracker");
        text.setFont(Font.font ("Courier New", 30));
        
        //Adding text to HBox
        hb.getChildren().add(text);
                          
        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");
                
        //Action for btnLogin
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		String checkUser = txtUserName.getText().toString();
        		String password = pf.getText().toString();
        		if(center.checkPassword(password)){
        			lblMessage.setText("Congratulations!");
        			lblMessage.setTextFill(Color.GREEN);
        			VerticalListExample list=new VerticalListExample();
        			VBox box =list.getRoot();
        			Scene scene2 = new Scene(box,125,145);
        	     	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        		    primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        	        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
        			primaryStage.setScene(scene2);
        			primaryStage.show();
        			
        		}
        		else{
        			lblMessage.setText("Incorrect info.");
        			lblMessage.setTextFill(Color.RED);
        		}
        		txtUserName.setText("");
        		pf.setText("");
        	}
        	});
       
        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);  
        
        //Adding BorderPane to the scene and loading CSS
    	Scene scene = new Scene(bp);
    	scene.getStylesheets().add("application.css");
    	primaryStage.setScene(scene);
    	primaryStage.setResizable(false);
    	primaryStage.show(); // Add this line
	}
}