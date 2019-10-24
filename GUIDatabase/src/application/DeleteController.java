package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;

public class DeleteController {
	@FXML
	private TextField name;
	@FXML
	private TextField party;
	@FXML
	private TextField positon;
	@FXML
	private Button delete;
	@FXML
	private TextField id;

	// Event Listener on Button[#delete].onAction
	@FXML
	public void deletePol(ActionEvent event) {
	  ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    String polid = id.getText();
    String polname = name.getText();
    String polparty = party.getText();
    String poljob = positon.getText();
    String sql = "delete from politician where polname=?";
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, polid);
      preparedStatement.setString(2, polname);
      preparedStatement.setString(1, polparty);
      preparedStatement.setString(1, poljob);
      preparedStatement.executeUpdate(); 
      preparedStatement.close();
    }
    
    catch (Exception e) {
      e.printStackTrace();
    }
	}
}
