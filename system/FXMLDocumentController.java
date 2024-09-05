/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane leftAnchorPane;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Label signinLabel;

    @FXML
    private StackPane stackpane;
    @FXML
    private Button LoginButton;
    @FXML
    private TextField usernameLbel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////// لجدول المستخدم من اسم وكلمة مرورdatabase ادوات قاعدة البيانات///////////////////////////////////////////////////////////////////////
    //database tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////loginهنا تم اضافة معلومات تسجيل الدخول فى زر /////////////////////////////////////////////////////////////////////

    public void Login() {
        String sql = "SELECT * FROM admin WHERE username =? and password =? ";
        connect = database.connectDb();
        try {
            //اخذ النص من مربع النص الفارغ يحتوى على اسم المستخدم وكلمة المرور
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, usernameLbel.getText());
            prepare.setString(2, passwordfield.getText());
            result = prepare.executeQuery(); //هنا لتشغيل الجدول فى قاعدة البيانات

            //هنا لاعطاء رسالة تحذيرية
            Alert alert;
            //اذا تم ترك مربع النص فارغ 
            if (usernameLbel.getText().isEmpty() || passwordfield.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزى المستخدم ابوس دماغك ادخل اسم المستخدم وكلمة المرور ومتسبهمش فاضيين");
                alert.showAndWait();
                //اذا تم ادخال بيانات صحيحة
            } else {
                if (result.next()) {
                    //firstline for display the username from the textfield in login page
//                    data.usernameLabbelIndashbiardPage = usernameLbel.getText();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information message");
                    alert.setHeaderText(null);
                    alert.setContentText("اهلا ومرحبا بك عزيزى المستخدم");
                    alert.showAndWait();
                    LoginButton.getScene().getWindow().hide();
                    //ظهور الصفحة التالية مباشرة
                    //link the dashboard
//                    Parent root = FXMLLoader.load(getClass().getResource("cashierfile.fxml"));
//                    Stage stage = new Stage();
//                    Scene scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
                    //هنا اذا تم ادخال بيانات خاطئة فى مربع النص الفارغ

                } else {
                    //if wrong usernmae and passord
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم بالله عليك  ادخل اسم المستخدم وكلمة المرور صح");
                    alert.showAndWait();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
