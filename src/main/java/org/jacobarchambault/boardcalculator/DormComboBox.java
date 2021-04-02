package org.jacobarchambault.boardcalculator;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DormComboBox extends ComboBox<String> {

	DormComboBox(final ObservableList<String> items) {
		super(items);
		getSelectionModel().selectFirst();
	}

	double dormCost() {
		final var selectedDorm = getValue();
		if (selectedDorm.contains("Allen")) {
			return 1500;
		} else if (selectedDorm.contains("Pike")) {
			return 1600;
		} else if (selectedDorm.contains("Farthing")) {
			return 1200;
		} else {
			return 1800;
		}
	}
}
