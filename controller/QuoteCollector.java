package cs3500.pa05.controller;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * Represets Quote Collector
 */
public class QuoteCollector {

  @FXML
  private TextField quoteTextField;

  private List<String> quotes;

  /**
   * initalizes the quote collector
   */
  @FXML
  private void initialize() {
    quotes = new ArrayList<>();
  }

  /**
   * Adds quotes when the user presses enter
   *
   * @param event the keyevent by the user
   */
  @FXML
  private void onEnterKeyPressed(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
      String quote = quoteTextField.getText();
      quotes.add(quote);
      System.out.println("Added quote: " + quote);
    }
  }

  /**
   * Clears the text field when the user
   * releases the enter key
   *
   * @param event the keyevent by the user
   */
  @FXML
  private void onEnterKeyReleased(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
      quoteTextField.clear();
    }
  }

  /**
   * @return list of quotes
   */
  public List<String> getQuotes() {
    return quotes;
  }
}
