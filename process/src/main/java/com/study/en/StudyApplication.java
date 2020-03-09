package com.study.en;

import com.study.en.controller.WordEditController;
import com.study.en.support.holder.SpringContextHolder;
import com.study.en.view.MatchWordView;
import com.study.en.view.WordEditView;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
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
public class StudyApplication extends AbstractJavaFxApplicationSupport {

    public FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
//        launch(StudyApplication.class, MainView.class, args);
    }

    @Override
    public void init() {
//        try {
//            super.init();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
//        primaryStage.setResizable(false);
        primaryStage.setTitle("study tool");
        primaryStage.show();
    }

    public static void showView(AbstractFxmlView view, Modality mode, String title) {
        Stage newStage = new Stage();
        Scene newScene;
        if (view.getView().getScene() != null) {
            newScene = view.getView().getScene();
        } else {
            newScene = new Scene(view.getView());
        }
        view.getView().layout();
        newStage.requestFocus();
        newStage.getIcons().add(new Image("/image/icon.png"));
        newStage.setScene(newScene);
        newStage.initModality(mode);
        newStage.initOwner(getStage());
        newStage.setResizable(false);
        newStage.setTitle(title);
        newStage.initStyle(StageStyle.DECORATED);
        newStage.show();
        newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                String paneTitle = ((Stage) event.getSource()).getTitle().replaceAll(" +", "").toLowerCase();
                if ("match word".replaceAll(" +", "").toLowerCase()
                        .equals(paneTitle)) {
                    SpringContextHolder.getBean(MatchWordView.class).setOpened(false);
                } else if ("edit word".replaceAll(" +", "").toLowerCase()
                        .equals(paneTitle)) {
                    SpringContextHolder.getBean(WordEditView.class).setOpened(false);
                    SpringContextHolder.getBean(WordEditController.class).getWordTextField().requestFocus();
                }
                newStage.close();
            }
        });
    }
}
