package calculator.ExpressionController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ExpressionController {
    private final ChangeListener<String> EXPRESSION_CHANGE_LISTENER = new ChangeListener<String>()
    {
        public void changed(ObservableValue<? extends String> property, String oldValue, String newValue)
        {
            updateExprView(newValue);
        }
    };
    private final ChangeListener<Integer> ID_CHANGE_LISTENER = new ChangeListener<Integer>()
    {
        public void changed(ObservableValue<? extends Integer> property, Integer oldValue, Integer newValue)
        {
            updateIDView(newValue);
        }
    };

    @FXML
    Label lbID;

    @FXML
    TextArea tbExpr;

    private ExpressionModel model;

    public void setModel(ExpressionModel model)
    {
        if(this.model != null)
            removeModelListeners();
        this.model = model;
        setupModelListeners();
        updateView();
    }

    private void removeModelListeners()
    {
        model.exprProperty().removeListener(EXPRESSION_CHANGE_LISTENER);
        model.idProperty().removeListener(ID_CHANGE_LISTENER);
    }

    private void setupModelListeners()
    {
        model.exprProperty().addListener(EXPRESSION_CHANGE_LISTENER);
        model.idProperty().addListener(ID_CHANGE_LISTENER);

    }

    private void updateView()
    {
        updateExprView();
        updateIDView();
    }


    private void updateExprView(){ updateExprView(model.getExpr()); }
    private void updateExprView(String newValue)
    {
        tbExpr.setText(newValue);
    }


    private void updateIDView(){updateIDView(0);}
    private void updateIDView(int id){
        lbID.setText(String.valueOf(id));
    }

}
