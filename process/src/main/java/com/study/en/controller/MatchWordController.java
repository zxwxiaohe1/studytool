package com.study.en.controller;

import com.study.en.view.MatchWordView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@FXMLController
public class MatchWordController extends BaseController implements Initializable {

    @Autowired
    private MatchWordView matchWordView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
