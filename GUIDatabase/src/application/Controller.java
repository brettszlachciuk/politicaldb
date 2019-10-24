/*package application;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import connectivity.ConnectionClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class Controller {
  
  public TextField textField;
  public Label textLabel;
  public TextField username;
  public PasswordField userPassword;
  public Label isConnected;
  public Button search;
  public TableView<Party> tableParty;
  public TableColumn<Party, String> columnPartyName;
  public TableColumn<Party, String> columnNumCongress;
  public TableColumn<Party, String> columnNumSenate;
  private ObservableList<Party> parties;
  
  
  public void login(ActionEvent actionevent) {
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    try {
      
      Statement statement = connection.createStatement();
      String sql = "SELECT userName FROM userauth WHERE username = '"+username.getText()+"' AND userPassword = '"+userPassword.getText()+"'";
      ResultSet resultSet = statement.executeQuery(sql);
    
      if (resultSet.next()) {
        isConnected.setText("Connected");
      }
      else {
        isConnected.setText("Not connected");
      }
    }
    
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void getPartyInfo(ActionEvent actionevent) {
    try {
      ConnectionClass connectionClass = new ConnectionClass();
      Connection connection = connectionClass.getConnection();
      String sql = "SELECT * FROM party WHERE partyname = '"+textField.getText()+"'";
      ResultSet rs = connection.createStatement().executeQuery(sql);
      while(rs.next()) {
        parties.add(new Party(rs.getString(1), rs.getString(2), rs.getString(3)));
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    columnPartyName.setCellValueFactory(new PropertyValueFactory<>("Party"));
    
    tableParty.setItems(null);
    tableParty.setItems(parties);
    
  }
  
  
}
*/
