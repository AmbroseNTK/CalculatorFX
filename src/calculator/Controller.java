package calculator;

import calculator.ExpressionController.ExpressionCell;
import calculator.ExpressionController.ExpressionModel;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    HBox pTool;
    @FXML
    VBox pToolSub;
    @FXML
    Separator separator;

    @FXML
    BorderPane borderPane;

    @FXML
    MenuBar mainMenu;


    @FXML
    ListView<ExpressionModel> listExpr;

    SequentialTransition showToolTrans;
    SequentialTransition hideToolTrans;

    boolean isShowToolbox;

    public static Stage windows;
    public static double xOffset;
    public static double yOffset;

    public ObservableList<ExpressionModel> expressionModelObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isShowToolbox=true;

        mainMenu.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = windows.getX() - event.getScreenX();
                yOffset = windows.getY() - event.getScreenY();
            }
        });

        mainMenu.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                windows.setX(event.getScreenX() + xOffset);
                windows.setY(event.getScreenY() + yOffset);
            }
        });

        listExpr.setCellFactory(p -> new ExpressionCell());
        expressionModelObservableList = FXCollections.observableArrayList(new ExpressionModel(),new ExpressionModel(),new ExpressionModel());
        listExpr.setItems(expressionModelObservableList);
        listExpr.setEditable(true);
    }



    public void setAnimationToolbox(){
        TranslateTransition transIn = new TranslateTransition(Duration.seconds(1),pTool);
        transIn.setFromX(-pToolSub.getWidth()-separator.getWidth());
        transIn.setToX(0);
        showToolTrans = new SequentialTransition(transIn);

        TranslateTransition transOut = new TranslateTransition(Duration.seconds(1),pTool);
        transOut.setFromX(0);
        transOut.setToX(-pToolSub.getWidth()-separator.getWidth());
        hideToolTrans = new SequentialTransition(transOut);



    }
    public void toggleToolbox(MouseEvent event){
        setAnimationToolbox();
        if(isShowToolbox) {
            hideToolTrans.play();
            isShowToolbox=false;
        }
        else{
            showToolTrans.play();
            isShowToolbox=true;
        }
    }
    public void closeWindows(MouseEvent event){
        windows.close();
    }

    public void addNewExpr(ActionEvent event){
        listExpr.getItems().clear();
        listExpr.getItems().add(new ExpressionModel());

    }

}
