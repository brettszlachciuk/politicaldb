package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private TextField username;
	@FXML
	private Label isConnected;
	@FXML
	private PasswordField userPassword;
	@FXML
	private Label welcomeLabel;

	// Event Listener on Button.onAction
	@FXML
	public void login(ActionEvent actionevent) throws IOException {
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Parent homepageParent = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
    Scene homepageScene = new Scene(homepageParent);
    Stage hpStage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
    hpStage.setScene(homepageScene);
    try {
      
      Statement statement = connection.createStatement();
      String sql = "SELECT userName FROM userauth WHERE username = '"+username.getText()+"' AND userPassword = '"+userPassword.getText()+"'";
      ResultSet resultSet = statement.executeQuery(sql);
    
      if (resultSet.next()) {
        hpStage.show();
      }
      else {
        isConnected.setText("Not connected");
      }
    }
    
    catch (Exception e) {
      e.printStackTrace();
    }
  }
	
	
	
}
  
