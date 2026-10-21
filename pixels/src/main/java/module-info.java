module be.ugent.pixels {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens be.ugent.pixels to javafx.fxml;
    exports be.ugent.pixels;
    exports be.ugent.pixels.view;
    opens be.ugent.pixels.view to javafx.fxml;
}