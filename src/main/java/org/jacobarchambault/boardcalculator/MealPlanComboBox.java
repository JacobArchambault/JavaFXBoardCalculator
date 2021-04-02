package org.jacobarchambault.boardcalculator;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class MealPlanComboBox extends ComboBox<String> {

	MealPlanComboBox(final ObservableList<String> items) {
		super(items);
		getSelectionModel().selectFirst();
	}

	double mealPlanCost() {
		final var mealPlan = getValue();
		if (mealPlan.contains("7")) {
			return 560;
		} else if (mealPlan.contains("14")) {
			return 1095;
		} else {
			return 1500;
		}
	}

}
