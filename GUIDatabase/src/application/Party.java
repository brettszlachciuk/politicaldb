package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Party {

  private final StringProperty partyName;
  private final StringProperty numCongress;
  private final StringProperty numSenate;
  
  public Party(String partyName, String numCongress, String numSenate) {
    this.partyName = new SimpleStringProperty(partyName);
    this.numCongress = new SimpleStringProperty(numCongress);
    this.numSenate = new SimpleStringProperty(numSenate);
  }
  
  public String getPartyName() {return partyName.get();}
  public String getNumCongress() {return numCongress.get();}
  public String getNumSenate() {return numCongress.get();}
  
  
  public void setPartyName(String value) {partyName.set(value);}
  public void setNumCongress(String value) {numCongress.set(value);}
  public void setNumSenate(String value) {numSenate.set(value);}
  
  public StringProperty partyNameProperty() {return partyName;}
  public StringProperty numCongressProperty() {return numCongress;}
  public StringProperty numSenateProperty() {return numSenate;}
}
