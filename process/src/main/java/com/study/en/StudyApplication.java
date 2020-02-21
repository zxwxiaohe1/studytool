package com.study.en;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author heyong
 * @date 2020/02/17 17:07
 */
@Slf4j
@SpringBootApplication
public class StudyApplication  extends AbstractJavaFxApplicationSupport {

    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void init() {
        ConfigurableApplicationContext run = SpringApplication.run(StudyApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(run::getBean);
        HostServices hostServices = getHostServices();
        run.getBeanFactory().registerSingleton("hostServices", hostServices);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/main.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.setScene(new Scene(root));
        //图标
        primaryStage.getIcons().add(new Image("/image/icon.png"));
        primaryStage.setWidth(1200);
        primaryStage.setHeight(700);
        primaryStage.setTitle("study tool");
        primaryStage.show();
    }
}
