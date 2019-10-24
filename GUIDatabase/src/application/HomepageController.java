package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.Connection;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomepageController {
	@FXML
	private Label label;
	@FXML
	private Button searchPol;
	@FXML
	private Button searchbill;
	@FXML
	private Button addpol;
	@FXML
	private Button delete;

	// Event Listener on Button[#searchPol].onAction
	@FXML

  public void openSearchpol(ActionEvent event) throws IOException {
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Parent polsearchParent = FXMLLoader.load(getClass().getResource("Polsearch.fxml"));
    Scene polsearchScene = new Scene(polsearchParent);
    Stage polStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    polStage.setScene(polsearchScene);
    try {
      polStage.show();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
	// Event Listener on Button[#searchbill].onAction
	@FXML
	public void openSearchbill(ActionEvent event) throws IOException {
	  ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Parent billpageParent = FXMLLoader.load(getClass().getResource("Billpage.fxml"));
    Scene billpageScene = new Scene(billpageParent);
    Stage billpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    billpageStage.setScene(billpageScene);
    try {
      billpageStage.show();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
	// Event Listener on Button[#addpol].onAction
	@FXML
	public void openAddpol(ActionEvent event) throws IOException {
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Parent polcreateParent = FXMLLoader.load(getClass().getResource("Polcreate.fxml"));
    Scene polcreateScene = new Scene(polcreateParent);
    Stage polcStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    polcStage.setScene(polcreateScene);
    try {
      polcStage.show();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
	// Event Listener on Button[#delete].onAction
	@FXML
	public void openDelete(ActionEvent event) throws IOException{
	  ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Parent deleteParent = FXMLLoader.load(getClass().getResource("Delete.fxml"));
    Scene deleteScene = new Scene(deleteParent);
    Stage deleteStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    deleteStage.setScene(deleteScene);
    try {
      deleteStage.show();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
