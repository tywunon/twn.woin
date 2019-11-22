package twn.woin;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import twn.woin.ui.MainScene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Thread.setDefaultUncaughtExceptionHandler(Main::handleException);
		MainScene.Show(primaryStage);
	}
	
	public static void handleException(Thread thread, Throwable throwable){
		throwable.printStackTrace();
		if(Platform.isFxApplicationThread()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(String.format("Error! %s", throwable.getClass().getName()));
			StringBuilder mainBuilder = new StringBuilder();
			mainBuilder.append(throwable.getLocalizedMessage());
			alert.setContentText(mainBuilder.toString());
			alert.showAndWait();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
