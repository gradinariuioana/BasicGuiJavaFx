import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class main extends Application {

    private static List<Veverita> veverite = new ArrayList<>();
    private ObservableList<String> listaObs =FXCollections.observableArrayList();

    @Override
    public void start(Stage s) throws Exception {
        Scene scene = new Scene(new Group(), 500, 600);

        s.setScene(scene);
        VBox vbox = new VBox();

        HBox hbox1 = new HBox();
        Label nume = new Label("Nume:        ");
        TextField text = new TextField();
        hbox1.getChildren().addAll(nume, text);
        vbox.getChildren().add(hbox1);
        ((Group)scene.getRoot()).getChildren().add(vbox);

        HBox hbox2 = new HBox();
        Label nume2 = new Label("Culoare:     ");
        TextField text2 = new TextField();
        hbox2.getChildren().addAll(nume2, text2);
        vbox.getChildren().add(hbox2);

        HBox hboxOptions = new HBox();
        Label labelOptions = new Label("Options      ");
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("a", "b", "c");
        hboxOptions.getChildren().addAll(labelOptions, comboBox);
        vbox.getChildren().add(hboxOptions);

        Button button = new Button();
        button.setText("add");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Veverita veverita = new Veverita();
                veverita.culoare = text.getText();
                veverita.nume = text2.getText();
                veverita.familie = (String)comboBox.getValue();
                veverite.add(veverita);
                listaObs.clear();
                for (Veverita veverita_aux:veverite)
                    listaObs.add(veverita.getCuloare() + " " + veverita.getNume() + " " + veverita.getFamilie());
            }
        });
        vbox.getChildren().add(button);
        ListView<String> output = new ListView<>();
        output.setItems(listaObs);

        vbox.getChildren().add(output);

        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
