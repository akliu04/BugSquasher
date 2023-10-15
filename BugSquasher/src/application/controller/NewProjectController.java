package application.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.dao.ProjectDAO;
import content.bean.ProjectBean;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NewProjectController {
	
	@FXML private VBox newProjectBox;
	@FXML private Button cancelButton;
	@FXML private Button saveButton;
	@FXML private TextField projectNameTextField;
	@FXML private TextArea projectDescrTextArea;
	@FXML private DatePicker projectDatePicker;
	
	/*
	 * Perform all necessary post-processing.
	 */
	@FXML 
	public void initialize() {
		// Set the default time in the datePicker
		projectDatePicker.setValue(LocalDate.now());
	}

	/*
	 * Cancel new project and close the NewProject window.
	 */
	@FXML 
	private void cancelButtonAction() {
		// Get the Stage
		Stage stage = (Stage) cancelButton.getScene().getWindow();	
		// Close it
		stage.close();
	}

	/*
	 * Save the new project.
	 */
	@FXML 
	private void saveButtonAction() {
		// Get the name from nameTextField
		String name = projectNameTextField.getText();
		
		// Get the date from datePicker
		LocalDate localDate = projectDatePicker.getValue();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = localDate.format(formatter);
		
		// Get the description from the textArea
		String descr = projectDescrTextArea.getText();
		
		// Package data into a ProjectBean
		ProjectBean projectBean = new ProjectBean(name, date, descr);
		
		// Pass projectBean to DAO
		ProjectDAO dao = new ProjectDAO(projectBean);
	}
}
