package twn.woin.ui;

import java.io.IOException;
import java.net.URL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import twn.woin.res.ResourceLoader;

public class MainScene {
	private static final String stateTitleValue = "W.O.I.N Character Creator";
	public static StringProperty stageTitle;

	static {
		stageTitle = new SimpleStringProperty(stateTitleValue);
	}

	public static void Show(Stage stage) {
		try {
			URL url = MainScene.class.getResource("mainscene.fxml");
			Scene scene = new Scene(FXMLLoader.load(url));
			scene.getStylesheets().add(MainScene.class.getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.getIcons().add(new Image(ResourceLoader.tywunon_trans_png()));
			stage.titleProperty().bindBidirectional(stageTitle);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
