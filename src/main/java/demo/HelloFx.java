package demo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloFx extends Application {
 
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      launch(args);
  }
 
  @Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("hellofx");
      Button btn = new Button();
      btn.setText("Open Dialog");
      btn.setOnAction(new EventHandler<ActionEvent>() {
 
          @Override
          public void handle(ActionEvent event) {
              final Stage myDialog = new Stage();
//              myDialog.initModality(Modality.WINDOW_MODAL);
//              myDialog.initModality(Modality.NONE);
              myDialog.setResizable(false);
              myDialog.initStyle(StageStyle.UNDECORATED);
              myDialog.initModality(Modality.APPLICATION_MODAL);
             
              Button okButton = new Button("CLOSE");
              okButton.setOnAction(new EventHandler<ActionEvent>(){
 
                  @Override
                  public void handle(ActionEvent arg0) {
                      myDialog.close();
                  }
                 
              });
             
              Scene myDialogScene = new Scene(VBoxBuilder.create()
                      .children(new Text("Hello! it's My Dialog."), okButton)
                      .alignment(Pos.CENTER)
                      .padding(new Insets(10))
                      .build());
             
              myDialog.setScene(myDialogScene);
              myDialog.show();
          }
      });
     
      StackPane root = new StackPane();
      root.getChildren().add(btn);
      primaryStage.setScene(new Scene(root, 300, 250));
      primaryStage.show();
  }
}
