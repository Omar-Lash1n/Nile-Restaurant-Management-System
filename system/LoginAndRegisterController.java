/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class LoginAndRegisterController implements Initializable {

    @FXML
    private Button BackButtonQuestion;

    @FXML
    private FontAwesomeIcon BuildingFont;

    @FXML
    private Button alreadyHaveAcoountButton;

    @FXML
    private TextField answerForget;

    @FXML
    private Button backButtonpassword;

    @FXML
    private AnchorPane createAccountPage;

    @FXML
    private Button createnewAccuontButton;

    @FXML
    private PasswordField forgetConfirmPassword;

    @FXML
    private PasswordField forgetPassword;

    @FXML
    private Hyperlink forgetPasswordlink;

    @FXML
    private ComboBox<?> forgetQuestion;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginPage;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField loginUsername;

    @FXML
    private AnchorPane newpasswordPage;

    @FXML
    private Button proceedButton;

    @FXML
    private AnchorPane questionRecoveryPage;

    @FXML
    private TextField registerAnswer;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private ComboBox<?> registerQuestion;

    @FXML
    private TextField registerUsername;

    @FXML
    private Button resetButton;

    @FXML
    private Button signupButton;

    @FXML
    private AnchorPane signupPage;

    @FXML
    private TextField usernameForget;

    @FXML
    private RadioButton managerradiobutton;
    @FXML
    private RadioButton cashierradiobutton;

    /**
     * Initializes the controller class.
     */
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////  لجدول العناصرdatabase ادوات قاعدة البيانات///////////////////////////////////////////////////////////////////////
    //database connect
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    /////////////////////////////logintype
    private String questionList[] = {"ما هو لونك المفضل؟", "ما هو طعامك المفضل؟", "ما هو تاريخ ميلادك؟"};
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا للتنقل بين الصفحات///////////////////////////////////////////////////////////////////////

    public void switchForgetPassword() {

        questionRecoveryPage.setVisible(true);
        loginPage.setVisible(false);
        passwordForgetquestionList();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لاضافة قائمة فى التسجيل///////////////////////////////////////////////////////////////////////

//    public void registerTypeList() {
////        List<String> listquestion = new ArrayList<>();
////        for (String data : registerrationType) {
////            listquestion.add(data);
////            ObservableList listData = FXCollections.observableArrayList(listquestion);
////            EnrollTypecombobox.setItems(listData);
////        }
//
//        ToggleGroup toggleGroup = new ToggleGroup();
//        managerradiobutton.setToggleGroup(toggleGroup);
//        cashierradiobutton.setToggleGroup(toggleGroup);
//
//    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لاضافة قائمة فى الاسئلة///////////////////////////////////////////////////////////////////////
    public void registerquestionList() {
        List<String> listquestion = new ArrayList<>();
        for (String data : questionList) {
            listquestion.add(data);
            ObservableList listData = FXCollections.observableArrayList(listquestion);
            registerQuestion.setItems(listData);
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////زر التاكد من صحة البيات التى تم ادخالها للسؤال///////////////////////////////////////////////////////////////////////

    public void proceedquestionbutton() {
        if (usernameForget.getText().isEmpty()
                || forgetQuestion.getSelectionModel().getSelectedItem() == null || answerForget.getText().isEmpty()) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("error message");
            alert.setHeaderText(null);
            alert.setContentText("عزيزى السمتخدم من فضلك قم بملأ الحقول المطلوبة");
            alert.showAndWait();

        } else {
            String selectdataforget = "SELECT username, question, answer FROM loginandregister WHERE username=? AND question=? AND answer=?";
            connect = database.connectDb();
            try {
                prepare = connect.prepareStatement(selectdataforget);
                prepare.setString(1, usernameForget.getText());
                prepare.setString(2, (String) forgetQuestion.getSelectionModel().getSelectedItem());
                prepare.setString(3, answerForget.getText());
                result = prepare.executeQuery(); //هنا لتشغيل الجدول فى قاعدة البيانات والحصول على نتيجة من قاعدة البيانات

                if (result.next()) {
                    newpasswordPage.setVisible(true);
                    questionRecoveryPage.setVisible(false);

                } else {
                    Alert alert;
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("error message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم تم ادخال بيانات غير صحيحة");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لاضافة  الاسئلة فى القائمة///////////////////////////////////////////////////////////////////////

    public void passwordForgetquestionList() {
        List<String> forgetPasswordquestionList = new ArrayList<>();
        for (String data : questionList) {
            forgetPasswordquestionList.add(data);
        }

        ObservableList listdata = FXCollections.observableArrayList(questionList);
        forgetQuestion.setItems(listdata);

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا زر اعادة تغيير كلمة المرور///////////////////////////////////////////////////////////////////////

    public void resetPasswordButton() {
//        try {
//هنا اذا كان احقول فارغة
        if (forgetPassword.getText().isEmpty() || forgetConfirmPassword.getText().isEmpty()) {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("عزيزى المستخدم ابوس دماغك ادخل اسم المستخدم وكلمة المرور ومتسبهمش فاضيين");
            alert.showAndWait();
        } else {

            /////شرط الثمانية احرف
            if (forgetPassword.getText().length() < 8 || forgetConfirmPassword.getText().length() < 8) {
                Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزى المستخدم من فضلك ادخل كلمة مرور اكبر من ثمانية احرف");
                alert.showAndWait();

            } //هنا اذا كانت كلمة المرور غير متطابقة فى الحقول
            else if (forgetPassword.getText().equals(forgetConfirmPassword.getText())) {
                connect = database.connectDb();
                try {
                    String UpdatePassword = "UPDATE loginandregister SET password = '" + forgetPassword.getText()
                            + "',question='" + forgetQuestion.getSelectionModel().getSelectedItem() + "',answer='" + answerForget.getText() + "'";

                    Alert alert;
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم هل انت متاكد من تحديث كلمة المرور للمستخدم " + usernameForget.getText() + "?");

                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("تم بحمد الله تغيير كلمة المرور");
                        alert.showAndWait();
                        statement = connect.createStatement();
                        statement.executeUpdate(UpdatePassword);
                        //هنا لحذف النص المكتوب
                        clearpasswordfieldForgetAndquestion();

                        //هنا للتحرك الى صفحة التسجيل
                        newpasswordPage.setVisible(false);
                        loginPage.setVisible(true);
                    } else {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("الغاء");

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزى المستخدم كلمة المرور غير متطابقة");
                alert.showAndWait();

            }

        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////لسمح البيانات التى بداخل الحقول فى صفحة تغيير كلمة المرور///////////////////////////////////////////////////////////////////////

    public void clearpasswordfieldForgetAndquestion() {
        forgetPassword.setText("");
        forgetConfirmPassword.setText("");

        forgetQuestion.getSelectionModel().clearSelection();
        answerForget.setText("");
        usernameForget.setText("");
    }

    //للتنقل الى الصفحات
    public void backbuttontoLoginPage() {
        questionRecoveryPage.setVisible(false);
        loginPage.setVisible(true);
    }

    public void backbuttontoquestionPage() {
        newpasswordPage.setVisible(false);
        questionRecoveryPage.setVisible(true);

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لاضافة قائمة فى الاسئلة///////////////////////////////////////////////////////////////////////

    public void loginbutton() {
        Alert alert;
//try{}catch(Exception e){}
        //اذا تم ترك مربع النص فارغ 
        if (loginUsername.getText().isEmpty() || loginPassword.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("عزيزى المستخدم ابوس دماغك ادخل اسم المستخدم وكلمة المرور ومتسبهمش فاضيين");
            alert.showAndWait();
        } else {
//            String selectData = "SELECT username, password FROM loginandregister WHERE username =? and password =? ";
            String selectData = "SELECT * FROM loginandregister WHERE username =? and password =? ";
            connect = database.connectDb();

            try {
                //اخذ النص من مربع النص الفارغ يحتوى على اسم المستخدم وكلمة المرور
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, loginUsername.getText());
                prepare.setString(2, loginPassword.getText());
                result = prepare.executeQuery(); //هنا لتشغيل الجدول فى قاعدة البيانات

                if (result.next()) {
//                    if (userType.equals("Cashier")) {
//                        data.loginUsername = loginUsername.getText();
//                        alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("information message");
//                        alert.setHeaderText(null);
//                        alert.setContentText("اهلا ومرحبا بك عزيزى الكاشير : "+loginUsername.getText());
//                        alert.showAndWait();
//                        registerUsername.getScene().getWindow().hide();
//                        Parent root = FXMLLoader.load(getClass().getResource("cashierfilebuttons.fxml"));
//                        Stage stage = new Stage();
//                        Scene scene = new Scene(root);
//                        stage.setScene(scene);
//                        stage.show();
//
//                    }else{
                    //firstline for display the username from the textfield in login page
                        data.loginUsername = loginUsername.getText();
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("information message");
                        alert.setHeaderText(null);
                        alert.setContentText("اهلا ومرحبا بك عزيزى المستخدم : "+loginUsername.getText());
                        alert.showAndWait();
                        registerUsername.getScene().getWindow().hide();
                        //ظهور الصفحة التالية مباشرة
                        //link the dashboard
                        Parent root = FXMLLoader.load(getClass().getResource("cashierfile.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setTitle("مطعم النيل");
                        stage.setScene(scene);
                        stage.show();
                    }
                    //هنا اذا تم ادخال بيانات خاطئة فى مربع النص الفارغ
//                } 
//اذا كانت المعلومات خاطئة فسوف يتم ظهور رسالة تحذيرية //else for cashier radio button
                else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم بالله عليك  ادخل اسم المستخدم وكلمة المرور صح");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//دالة زر الدخول
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////معلومات وبيانات التسجيل///////////////////////////////////////////////////////////////////////
    private String userType = "";

    public void registerationButton() {
        Alert alert;
        //اذا تم ترك مربع النص فارغ 
        if (registerUsername.getText().isEmpty() || registerPassword.getText().isEmpty()
                || registerQuestion.getSelectionModel().getSelectedItem() == null
                || registerAnswer.getText().isEmpty()) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("عزيزى المستخدم ابوس دماغك ادخل جميع البيانات ومتسبهمش فاضيين");
            alert.showAndWait();
            //هنا لادخال البيانات
        } else {
            String registrationData = "INSERT INTO loginandregister (username,password,question,answer)"
                    + "VALUES(?,?,?,?)";
            connect = database.connectDb();
            try {
                //هنا للتاكد من ان اسم المستخدم موجود
                String checkUsername = "SELECT username FROM loginandregister WHERE username ='" + registerUsername.getText() + "'";
                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();
                //الخطة التالية بعد كتابة اسم المستخدم
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم تم استخدام اسم المستخدم من قبل");
                    alert.showAndWait();
                }//if
                //هنا لجعل كلمة المرو لا تقل عن ثمانية احرف
                else if (registerPassword.getText().length() < 8) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم من فضلك ادخل كلمة مرور اكبر من ثمانية احرف");
                    alert.showAndWait();
                }//elseif
                else {

//                    if (managerradiobutton.isSelected()) {
//                        userType = "Manager";
//                    } else if (cashierradiobutton.isSelected()) {
//                        userType = "Cashier";
//                    } else {
//                        // Handle case where no radio button is selected
//                        alert = new Alert(AlertType.ERROR);
//                        alert.setTitle("Error");
//                        alert.setHeaderText("Missing User Type");
//                        alert.setContentText("Please select either Manager or Cashier.");
//                        alert.showAndWait();
//                        return;  // Exit the function to prevent database insertion
//                    }
                    prepare = connect.prepareStatement(registrationData);
                    prepare.setString(1, registerUsername.getText());
                    prepare.setString(2, registerPassword.getText());
                    prepare.setString(3, (String) registerQuestion.getSelectionModel().getSelectedItem());
                    prepare.setString(4, registerAnswer.getText());
//                    prepare.setString(5, userType);
                    ////////////////////////////////
//                Date date = new Date();
//                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//                prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("تم بحمد لله انشاء الحساب");
                    alert.showAndWait();

                    //لمسح البيانات المكتوبة بعد انشاء الحساب
//                    registerUsername.setText("");
//                    registerPassword.setText("");
//                    registerQuestion.getSelectionModel().clearSelection();
//                    registerAnswer.setText("");
                    //للتحرك لصفحة تسجيل الدخول بعد انشاء الحساب
                    TranslateTransition slider = new TranslateTransition();
                    slider.setNode(createAccountPage);
                    slider.setToX(0);
                    slider.setDuration(Duration.seconds(.5));

                    slider.setOnFinished((ActionEvent e) -> {
                        alreadyHaveAcoountButton.setVisible(true);
                        createnewAccuontButton.setVisible(true);
                    });
                    slider.play();

                }//else

            }//try
            catch (Exception e) {
                e.printStackTrace();
            }
        }//else

    }//دالة زر التسجيل
/////////////////////////////////////////

    public String getUserType() {
        return userType;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// ما بداخل قائمة الزر/ //////////////////////////////////////////////////////////////////////
    public void switchForm(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == createnewAccuontButton) {
            slider.setNode(createAccountPage);
            slider.setToX(450);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
//                alreadyHaveAcoountButton.setVisible(true);
//                createnewAccuontButton.setVisible(false);

                //هنا تم اظهار صفحة التسجيل عشان لما الصفحة ترجع مكانها بعد انشاء الحساب
                questionRecoveryPage.setVisible(false);
                loginPage.setVisible(true);
                newpasswordPage.setVisible(false);

                registerquestionList();
            });
            slider.play();
        } else if (event.getSource() == alreadyHaveAcoountButton) {
            slider.setNode(createAccountPage);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                alreadyHaveAcoountButton.setVisible(true);
                createnewAccuontButton.setVisible(true);
                //هنا تم اظهار صفحة التسجيل عشان لما الصفحة ترجع مكانها بعد انشاء الحساب
                questionRecoveryPage.setVisible(false);
                loginPage.setVisible(true);
                newpasswordPage.setVisible(false);
            });
            slider.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //هذا المكان مخصص لظهور الشئ قبل الصفحة
    }

}
