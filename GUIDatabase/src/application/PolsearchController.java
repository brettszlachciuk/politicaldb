package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;


public class PolsearchController implements Initializable {
  @FXML
  private TableColumn polname;
  @FXML
  private TableColumn polparty;
  @FXML
  private TableColumn polposition;
  @FXML
  private TableColumn polvoting;
  @FXML
  private ListView<String> listofpol;

  @FXML
  private TextField enterName;
  @FXML
  private Button search;


  ObservableList<String> list;

  public void initialize(URL url, ResourceBundle rb) {
    populateListofPol();
  }

  private void populateListofPol() {
    try {
      ConnectionClass connectionClass = new ConnectionClass();
      Connection connection = connectionClass.getConnection();
      String getPoliticians = "select polname from politician";
      PreparedStatement prestate = connection.prepareStatement(getPoliticians);
      ResultSet result = prestate.executeQuery();

      while (result.next()) {
        String current = result.getString(0);
        list.add(current);
      }

      prestate.close();
      result.close();     
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    listofpol.getItems().addAll(list);
  }

// Event Listener on Button[#search].onAction
@FXML
public void search(ActionEvent event) {
  
}


}


