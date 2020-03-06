package com.study.en.utils;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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

    public static void hintDialog(String title, String ContentText) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setContentText(ContentText);
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
