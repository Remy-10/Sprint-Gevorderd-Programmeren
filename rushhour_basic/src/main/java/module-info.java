module be.ugent.rushhour {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens be.ugent.rushhour to javafx.fxml;
    exports be.ugent.rushhour;
    exports be.ugent.rushhour.view;
    opens be.ugent.rushhour.view to javafx.fxml;
}