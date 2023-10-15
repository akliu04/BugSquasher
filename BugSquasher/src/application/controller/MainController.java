package application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class MainController {
	
	@FXML private BorderPane mainBorderPane;
	
	/*
	 * Perform all necessary procedures on start-up
	 */
	@FXML 
	public void initialize() {
		
	}

	/*
	 * Shows the new project page in a new window.
	 */
	@FXML 
	private void showNewProject() {
		URL url = getClass().getClassLoader().getResource("view/NewProject.fxml");
		
		try {
			VBox root = (VBox) FXMLLoader.load(url);
			Stage newProjectStage = new Stage();
			newProjectStage.setTitle("New Project");
			newProjectStage.setScene(new Scene(root));
			newProjectStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
}
