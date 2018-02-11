package calculator.ExpressionController;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExpressionModel {
    private final StringProperty expr;
    private final IntegerProperty id;
    public ExpressionModel(int id, String expr){
        this.expr=new SimpleStringProperty(expr);
        this.id=new SimpleIntegerProperty(id);
    }

    public String getExpr() {
        return expr.get();
    }

    public StringProperty exprProperty() {
        return expr;
    }
    public void setExpr(String expr){
        this.expr.setValue(expr);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }
    public void setID(int id){
        this.id.setValue(id);
    }
}
