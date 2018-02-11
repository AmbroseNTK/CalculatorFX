package calculator.ExpressionController;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.io.IOException;
import java.net.URL;

public class ExpressionCell extends ListCell<ExpressionModel> {

    @Override
    protected void updateItem(ExpressionModel item, boolean empty) {
        super.updateItem(item, empty);
        if(item!=null){
            URL location = ExpressionController.class.getResource("Expression.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            try
            {
                Node root = (Node)fxmlLoader.load(location.openStream());
                ExpressionController controller = (ExpressionController) fxmlLoader.getController();
                controller.setModel(item);
                setGraphic(root);
            }
            catch(IOException ioe)
            {
                throw new IllegalStateException(ioe);
            }
        }
    }
}
