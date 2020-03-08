package com.study.en.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * @author hy
 * @date 2019/8/23 14:18
 */
public class DialogUtils {

    private final static ButtonType confirm = new ButtonType("confirm");

    public static void closeDialog(Stage primaryStage) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("exit");
        dialog.setContentText("exit!");
        dialog.initOwner(primaryStage);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.APPLY);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.getDialogPane().setPrefSize(350, 100);
        Optional<ButtonType> s = dialog.showAndWait();
        s.ifPresent(s1 -> {
            if (s1.equals(ButtonType.APPLY)) {
                primaryStage.close();
            } else if (s1.equals(ButtonType.CLOSE)) {
                dialog.close();
            }
        });
    }

    public static void hintDialog(Stage primaryStage, String title, String ContentText) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setContentText(ContentText);
        dialog.initOwner(primaryStage);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.getDialogPane().setPrefSize(350, 100);
        Optional<ButtonType> s = dialog.showAndWait();
        s.ifPresent(s1 -> {
            if (s1.equals(ButtonType.CLOSE)) {
                dialog.close();
            }
        });
    }

//    public static void hintDialog(String title, String ContentText) {
//        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.setTitle(title);
//        dialog.setContentText(ContentText);
//        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
//        dialog.getDialogPane().setPrefSize(350, 100);
//        Optional<ButtonType> s = dialog.showAndWait();
//        s.ifPresent(s1 -> {
//            if (s1.equals(ButtonType.CLOSE)) {
//                dialog.close();
//            }
//        });
//    }

    public static void hintDialog(String title, String ContentText) {
        Dialog<ButtonType> dialog = new Dialog<>();
        DialogPane pane = new DialogPane();
        HBox contentPane = new HBox();
        contentPane.setAlignment(Pos.CENTER);
        Label content = new Label(ContentText);
        content.setLayoutY(30.0);
        content.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        content.setTextFill(Paint.valueOf("green"));
        contentPane.getChildren().add(content);
        pane.setContent(contentPane);
        dialog.setTitle(title);
        dialog.setDialogPane(pane);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.getDialogPane().setPrefSize(350, 100);
        Optional<ButtonType> s = dialog.showAndWait();
        s.ifPresent(s1 -> {
            if (s1.equals(ButtonType.CLOSE)) {
                dialog.close();
            }
        });
    }

    public static void operationDialog(String title, AnchorPane anchorPane) {
        operationDialog(title, anchorPane, 350, 100);
    }

    public static void operationDialog(String title, AnchorPane anchorPane, Integer width, Integer height) {
        Dialog<ButtonType> dialog = new Dialog<>();
        DialogPane pane = new DialogPane();
        pane.setContent(anchorPane);
        dialog.setDialogPane(pane);
        dialog.setTitle(title);
        dialog.getDialogPane().getButtonTypes().add(confirm);
        dialog.getDialogPane().setPrefSize(width, height);
        Optional<ButtonType> s = dialog.showAndWait();
        s.ifPresent(s1 -> {
            if (s1.equals(confirm)) {
                dialog.close();
            }
        });
    }

    public static void operationDialog(String title, AnchorPane anchorPane, Integer width, Integer height, RadioButton exportButton) {
        Dialog<ButtonType> dialog = new Dialog<>();
        DialogPane pane = new DialogPane();
        pane.setContent(anchorPane);
        dialog.setDialogPane(pane);
        dialog.setTitle(title);
        ButtonType imports = new ButtonType(exportButton.getText());
        dialog.getDialogPane().getButtonTypes().add(imports);
        dialog.getDialogPane().getButtonTypes().add(confirm);
        dialog.getDialogPane().setPrefSize(width, height);
        Optional<ButtonType> s = dialog.showAndWait();
        s.ifPresent(s1 -> {
            if (s1.equals(confirm)) {
                dialog.close();
            } else if (s1.equals(imports)) {
                exportButton.setSelected(true);
            }
        });
    }

    public static void operationDialog(String title, AnchorPane anchorPane, RadioButton exportButton) {
        operationDialog(title, anchorPane, 350, 100, exportButton);
    }
}
