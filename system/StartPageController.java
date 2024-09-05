/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا من المفترض هى اول صفحة ستظهر///////////////////////////////////////////////////////////////////////
public class StartPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button cashierButton;
    @FXML
    private Button managerButton;

    @FXML
    private Button subManagerButton;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////الصورة لازم تكون موجودة فى ملف المصدر///////////////////////////////////////////////////////////////////////

    @FXML
    private AnchorPane img;

    @FXML
    private ImageView img2;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////عند الضغط على زر الكاشير///////////////////////////////////////////////////////////////////////
    //to link cashier page
    @FXML
    void cashierButtonAction(MouseEvent event) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("loginAndRegister.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        cashierButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
