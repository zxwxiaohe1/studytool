package com.study.en.controller;

import com.study.en.domain.entity.AccountBackup;
import com.study.en.domain.service.AccountBackupService;
import com.study.en.modules.vo.SecurityAccount;
import com.study.en.utils.*;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author heyong
 * @date 2020/3/28
 */
@FXMLController
public class DecodePasswordController {

    @FXML
    public Pane decodePasswordPane;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField idcardTextField;
    @FXML
    private TextField passwdTextField;
    @FXML
    private TextField saltTextField;
    @FXML
    private TextArea enCodePasswordTextArea;
    @FXML
    private Label saltDialog;
    @FXML
    private Label enTextAreaDialog;
    @FXML
    private Label nameDialog;
    @FXML
    private Label phoneDialog;
    @FXML
    private Label idcardDialog;

    private static final String dialog = "the parameter cannot be null";

    public void decodePasswordButtonAction(ActionEvent event) {

        String name = nameTextField.getText().trim().toLowerCase();
        String phone = phoneTextField.getText().trim();
        String idcard = idcardTextField.getText().trim().toLowerCase();
        String salt = saltTextField.getText().trim().toLowerCase();
        String enPass = enCodePasswordTextArea.getText().trim();
        if (StringUtils.isBlank(name)) {
            nameDialog.setTextFill(Paint.valueOf("red"));
            nameDialog.setText(dialog);
            return;
        }
        if (StringUtils.isBlank(phone)) {
            phoneDialog.setTextFill(Paint.valueOf("red"));
            phoneDialog.setText(dialog);
            return;
        }
        if (StringUtils.isBlank(idcard)) {
            idcardDialog.setTextFill(Paint.valueOf("red"));
            idcardDialog.setText(dialog);
            return;
        }
        if (StringUtil.isBlank(salt)) {
            saltDialog.setTextFill(Paint.valueOf("red"));
            saltDialog.setText(dialog);
            return;
        }

        if (StringUtil.isBlank(enPass)) {
            enTextAreaDialog.setTextFill(Paint.valueOf("red"));
            enTextAreaDialog.setText(dialog);
            return;
        }
        try {
            String proof = Des3.encode(JacksonUtil.bean2Json(new SecurityAccount(name, phone, idcard, salt)));
            SecurityAccount securityAccount = JacksonUtil.json2Bean(Des3.decode(enPass),SecurityAccount.class);
            if (proof.trim().equals(securityAccount.getProof())) {
                passwdTextField.setText(Des3.decode(securityAccount.getPasswd()));
            } else {
                passwdTextField.setText("");
                DialogUtils.hintDialog("error", "info error !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
