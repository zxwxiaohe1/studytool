package com.study.en.controller;

import com.study.en.view.AddWordView;
import com.study.en.view.EnglishFormatView;
import com.study.en.view.MainView;
import com.study.en.view.WordPricticeView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@FXMLController
public class MainController implements Initializable {

    @Autowired
    public MainView mainView;
    @Autowired
    public AddWordView addWordView;
    @Autowired
    public EnglishFormatView englishFormatView;
    @Autowired
    public WordPricticeView wordPricticeView;
    @Autowired
    private DataSource dataSource;
    @FXML
    public Pane dynamicPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void showEnglishFormatView(final Event e) {
        if (e.getSource() instanceof Button) {
            dynamicPane.getChildren().clear();
            if (mainView.getEnglishFormatId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(englishFormatView.getView());
            } else if (mainView.getWordNotebookId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(addWordView.getView());
            } else if (mainView.getWordPricticeId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(wordPricticeView.getView());
            }
        }

    }
    @FXML
    public void test(){
        try {
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO `english_word` VALUES ('75abd646-aa79-32eb-b38f-b51b49178384', 'further', '[{\\\"wordType\\\":\\\"adv\\\",\\\"mean\\\":\\\" 更远地;远非;进一步地;而且;处于更高阶段\\\"},{\\\"wordType\\\":\\\"adj\\\",\\\"mean\\\":\\\" 更多的,附加的;更远的;进一步的,深一层的\\\"},{\\\"wordType\\\":\\\"v\\\",\\\"mean\\\":\\\" 促进,增进,助长\\\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
