package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnectionClass {
  Scanner scanner = new Scanner(System.in);
  
  public Connection connection;

  private final String serverName = "localhost";

  private final int portNumber = 3306;
  
  private final String dbName = "politicaldb";
  
  private String userName = "root";
  
  private String password = "0quetqtv67";
  
  
  private String url = "jdbc:mysql://"
      + this.serverName + ":" + this.portNumber + "/" + this.dbName;
  

  
  public Connection getConnection() {
    try {
    connection = DriverManager.getConnection(this.url, this.userName, this.password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return connection;
  }

}
