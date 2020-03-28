package com.study.en.controller;

import com.study.en.domain.entity.AccountBackup;
import com.study.en.domain.service.AccountBackupService;
import com.study.en.modules.vo.SecurityAccount;
import com.study.en.utils.Des3;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.utils.JacksonUtil;
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
public class CreateAccountController {

    @FXML
    public Pane createAccountPane;
    @FXML
    private TextField sysNameTextField;
    @FXML
    private TextField urlTextField;
    @FXML
    private TextField loginNameTextField;
    @FXML
    private TextArea remarksTextArea;
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
    private Label nameDialog;
    @FXML
    private Label phoneDialog;
    @FXML
    private Label idcardDialog;
    @FXML
    private Label passwdDialog;
    @Autowired
    private AccountBackupService accountBackupService;

    private static final String dialog = "the parameter cannot be null";


    public void createButtonAction(ActionEvent event) {
        String name = nameTextField.getText().trim().toLowerCase();
        String phone = phoneTextField.getText().trim();
        String idcard = idcardTextField.getText().trim().toLowerCase();
        String passwd = passwdTextField.getText().trim();
        String salt = saltTextField.getText().trim().toLowerCase();

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
        if (StringUtils.isBlank(passwd) || StringUtils.isBlank(salt)) {
            passwdDialog.setTextFill(Paint.valueOf("red"));
            passwdDialog.setText(dialog);
            return;
        }
        AccountBackup accountBackup = new AccountBackup();
        accountBackup.setId(IdGen.uuid());
        accountBackup.setSysName(sysNameTextField.getText());
        accountBackup.setSysUrl(urlTextField.getText());
        accountBackup.setLoginName(loginNameTextField.getText());
        accountBackup.setRemarks(remarksTextArea.getText());
        try {
            SecurityAccount securityAccount = new SecurityAccount(name, phone, idcard, salt);
            securityAccount.setProof(Des3.encode(JacksonUtil.bean2Json(securityAccount)));
            securityAccount.setPasswd(Des3.encode(passwd));
            accountBackup.setPassword(Des3.encode(JacksonUtil.bean2Json(securityAccount)));
            accountBackupService.save(accountBackup);
            DialogUtils.hintDialog("create account", "create account sucess !");
            clearCreateAccountPane();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearCreateAccountPane() {
        nameTextField.setText("");
        phoneTextField.setText("");
        idcardTextField.setText("");
        passwdTextField.setText("");
        saltTextField.setText("");
        sysNameTextField.setText("");
        urlTextField.setText("");
        loginNameTextField.setText("");
        remarksTextArea.setText("");
        nameDialog.setText("");
        phoneDialog.setText("");
        idcardDialog.setText("");
        passwdDialog.setText("");
    }
}
