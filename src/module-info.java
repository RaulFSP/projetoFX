module projeto_1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.fxml, javafx.graphics, javafx.controls;
	opens application.model to javafx.base;
}
