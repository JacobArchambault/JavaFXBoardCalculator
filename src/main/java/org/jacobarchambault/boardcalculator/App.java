package org.jacobarchambault.boardcalculator;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	public static void main(final String[] args) {
		Application.launch();
	}

	DormComboBox dormComboBox = new DormComboBox(
			FXCollections.observableArrayList("Allen Hall", "Pike Hall", "Farthing Hall", "University Suites"));
	MealPlanComboBox mealPlanComboBox = new MealPlanComboBox(
			FXCollections.observableArrayList("7 Meals per week", "14 Meals per week", "Unlimited Meals per week"));

	Label price = new Label("0.00");

	@Override
	public void start(final Stage stage) {
		stage
				.setScene(
						new Scene(
								new MasterVBox(
										10,
										new Insets(10),
										new HBox(10, new Label("Select a dorm"), dormComboBox),
										new HBox(10, new Label("Select a meal plan"), mealPlanComboBox),
										new HBox(10, new Label("Cost: "), price),
										new HBox(10, new EventButton("Calculate charges", e -> display())))));
		stage.show();
	}

	void display() {
		price
				.setText(
						NumberFormat
								.getCurrencyInstance()
								.format(dormComboBox.dormCost() + mealPlanComboBox.mealPlanCost()));
	}
}