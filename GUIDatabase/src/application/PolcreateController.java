package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;

public class PolcreateController {
	@FXML
	private TextField name;
	@FXML
	private TextField party;
	@FXML
	private TextField job;
	
	private Button add;

	// Event Listener on Button[#add].onAction
	@FXML
	public void addPolitician(ActionEvent event) {
	  ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    String polname = name.getText();
    String polparty = party.getText();
    String poljob = job.getText();
    String sql = "INSERT INTO politician (polid, polname, party, job) VALUES (?, ?, ?, ?)";
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, null);
      preparedStatement.setString(2, polname);
      preparedStatement.setString(1, polparty);
      preparedStatement.setString(1, poljob);
      preparedStatement.executeQuery(); 
      preparedStatement.close();
    }
    
    catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
