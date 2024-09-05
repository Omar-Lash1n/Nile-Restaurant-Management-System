//بسم الله
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

//import static restaurant.management.system.data.username;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class CashierfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label NumberOfCustomersIndashboardPage;

    @FXML
    private Label TodayncomeIindashboardPage;

    @FXML
    private Label TotalIncomeIindashboardPage;

    @FXML
    private Label ordermanagementlabel;

    @FXML
    private Button availableFoodAnddrinkButtonInMenu;

    @FXML
    private Button tablebutton;

    @FXML
    private AnchorPane availableFormAnchorPane;

    @FXML
    private AnchorPane tablemanagementpage2;

    @FXML
    private Button dashboardButtonInMenu;

    @FXML
    private AnchorPane dashboardFormAnchorPane;

    @FXML
    private Button exitButtonInMenu;

    @FXML
    private BarChart<?, ?> incomeStatisticsChartIndashoardPage;
    //table in productpage

    @FXML
    private TableView<categories> productTableViewInproductPage;

    @FXML
    private TableColumn<categories, String> productidTableViewColumnsInproductPage;

    @FXML
    private TableColumn<categories, String> productNameTableViewColumnsInproductPage;

    @FXML
    private TableColumn<categories, String> productTypeTableViewColumnsInproductPage;

    @FXML
    private TableColumn<categories, String> productPriceTableViewColumnsInproductPage;

    @FXML
    private TableColumn<categories, String> productAvailableTableViewColumnsInproductPage;

    @FXML
    private TableColumn<categories, Date> productdateTableViewColumnsInproductPage11;

    //30:52
    //stock
    @FXML
    private TableColumn<categories, Integer> productStockTableViewColumnsInproductPage1;
    @FXML
    private TextField productStockInproductPage1;
    @FXML
    private Label TotalIncomeIindashboardPage1;

    @FXML
    private Button logoutButtonInMenu;

    @FXML
    private AnchorPane mainFormAnchorPane;

    @FXML
    private TextField orderAmountlInOrderPage;

    @FXML
    private Button orderButtonInMenu;

    @FXML
    private AnchorPane orderFormAnchorPane;

    @FXML
    private Button importButtonMenuIoicture;

    @FXML
    private Button orderPayButtonInOrderPage;

    @FXML
    private TableView<categories> orderTableVirewInorderPage;

    @FXML
    private TableColumn<categories, String> orderProductNameTableViewInorderPage;

    @FXML
    private TableColumn<categories, String> orderProductPriceTableViewInorderPage;

    @FXML
    private TableColumn<categories, String> orderProductQuantityTableViewInorderPage;

    @FXML
    private TableColumn<categories, String> purchaseCountcolumn;
    @FXML
    private Label orderTotalLabelInOrderPage1;

    @FXML
    private Button orderRecieteButtonInOrderPage;

    @FXML
    private Button orderRemoveButtonInOrderPage;

    @FXML
    private BarChart<?, ?> orderStatisticsChartIndashoardPage;
    @FXML
    private ImageView imageviewProdutsavailable;

    @FXML
    private ImageView menuImageView;

    @FXML
    private Button menuButtonInMenu;

    @FXML
    private AnchorPane menuImageAnchorPanepage;

    @FXML
    private Button productAddbuttonInproductPage;

    @FXML
    private ComboBox<?> productAvailableComboBoxInproductPage;

    @FXML
    private Button productClearbuttonInproductPage;

    @FXML
    private TextField productNameInproductPage;

    @FXML
    private TextField productPriceInproductPage;

    @FXML
    private Button productRemovebuttonInproductPage;

    @FXML
    private ComboBox<?> productTypeComboBoxInproductPage;

    @FXML
    private Button productUpdatebuttonInproductPage;

    @FXML
    private TextField productidInproductPage;

    @FXML
    private TextField productsearchInproductPage;

    @FXML
    private TextField tablebooknotable;

    @FXML
    private TextField tablrbookcustomerrid;

    @FXML
    private Label usernameLabbelIndashbiardPage;

    @FXML
    private Label orderchangeLabelInOrderPage11;

    @FXML
    private GridPane ordermenugridpane11;//1.09

    @FXML
    private Button homeButtonInMenu1;

    @FXML
    private Button tablebuutoninmanager;

    @FXML
    private AnchorPane tablemanagementpage;

    @FXML
    private AnchorPane homeAnchorPane22222;

    @FXML
    private Button productDeleteallelementsbuttonInproductPage1;

    @FXML
    private Button CustomerButton;

    @FXML
    private AnchorPane customerTablePage;

    ///////////////////////////tablepage//////////////////////////
    @FXML
    private Button buttontableadd;

    @FXML
    private Button buttontablebook;

    @FXML
    private Button buttontableclear;

    @FXML
    private Button buttontableremove;

    @FXML
    private Button buttontableupdate;

    @FXML
    private ComboBox<?> comboboxtablechoose;

    @FXML
    private TableColumn<tables, String> tableavailbiltyc3;

    @FXML
    private TableColumn<tables, Integer> tablecapacityc2;

    @FXML
    private TableColumn<tables, Integer> tableidc1;
//////////////////////////////////////////////////////in home page
    @FXML
    private TableView<tables> tabletablepage;

    @FXML
    private TableColumn<tables, String> tableavailbiltyc31;

    @FXML
    private TableColumn<tables, Integer> tablecapacityc21;

    @FXML
    private TableColumn<tables, Integer> tableidc11;

    @FXML
    private TableColumn<tables, Integer> customeridintableBook;

    @FXML
    private TableView<tables> tabletablepage1;
//////////////////////////////////////////////////////////////////////
    @FXML
    private TextField textfeldtablecapacity;

    @FXML
    private TextField textfeldtableid;

    @FXML
    private TextField textfeldtabletablecustomerid;

    @FXML
    private TextField textfeldtabletableid;

    @FXML
    private Label texttableCustomerType;

    @FXML
    private Label texttablecapacity;

    @FXML
    private Label texttablecustomerid;

    @FXML
    private Label texttableid;

    @FXML
    private Label texttabletableid;
    /////////////////////سبحة رقمية////////////////////
    @FXML
    private Label tasbihNumberLabel;

    @FXML
    private Button resetButtonInDigital;

    @FXML
    private Button clickbuttonInDigital;
    /////////////////////////////////////////////////////

    @FXML
    private ComboBox<String> chhosecustomerforbookcombobox;

    @FXML
    private ComboBox<String> choosetableforbookcombobox;

    ///////////////////////////////////////////////////////////
    /////////////////customer tables////////////////////////
    @FXML
    private TableView<customerData> tableInCustomerPage;
    @FXML
    private TableColumn<customerData, String> cashierColoumnIncustomerPage;
    @FXML
    private TableColumn<customerData, String> customeridColoumnIncustomerPage;
    @FXML
    private TableColumn<customerData, String> dateColoumnIncustomerPage;
    @FXML
    private TableColumn<customerData, String> totalColoumnIncustomerPage;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////  لجدول العناصرdatabase ادوات قاعدة البيانات///////////////////////////////////////////////////////////////////////
    //database connect
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private ObservableList<categories> productFrame = FXCollections.observableArrayList();
    @FXML
    private Label customerManagementlabel;
    @FXML
    private Button importButton;
    @FXML
    private ScrollPane orderscrollpane;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////سبحة رقمية///////////////////////////////////
    private int countTasbih;

    public void clickonDigitalButton() {
        countTasbih++;
        tasbihNumberLabel.setText(String.valueOf(countTasbih));
    }

    public void resetDigitalButton() {
        countTasbih = 0;
        tasbihNumberLabel.setText("");
    }

    ///////////////////////////////////////////////////////////////
    public ObservableList<customerData> customerdatalistselect() {
        TotalIncomeIindashboardPage.setFont(Font.font(operate, change));
        ObservableList<customerData> datalist = FXCollections.observableArrayList();
        String sql = "SELECT * FROM reciept";
        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            customerData customermaindata;
            while (result.next()) {
                customermaindata = new customerData(
                        result.getInt("id"),
                        result.getInt("customer_id"),
                        result.getFloat("total_price"),
                        result.getDate("date"),
                        result.getString("employee_name"));
                datalist.add(customermaindata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datalist;
    }

//    public void fonts(){
//    ordermanagementlabel.setFont(Font.font(c));
//    }
    private ObservableList<customerData> customerdatalistForTable;

    public void customerDisplayData() {
        customerdatalistForTable = customerdatalistselect();

        customeridColoumnIncustomerPage.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        totalColoumnIncustomerPage.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        dateColoumnIncustomerPage.setCellValueFactory(new PropertyValueFactory<>("date"));
        cashierColoumnIncustomerPage.setCellValueFactory(new PropertyValueFactory<>("employee_name"));

        tableInCustomerPage.setItems(customerdatalistForTable);

    }

///////////////////////////////////////////username text نص اسم المتخدم///////////////////////////////////////////////////////////////////////
    //for display the username which eneterd
    public void displayusername() {
        String user = data.loginUsername;

        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        usernameLabbelIndashbiardPage.setText(user);
    }

    //////////////////////////////////////////////
    private LoginAndRegisterController loginRegisterController;

    public void showDashboard() {
        String userType = loginRegisterController.getUserType();
        if (userType.equals("Manager")) {
            dashboardButtonInMenu.setVisible(false);
            orderButtonInMenu.setVisible(false);
//        button2.setDisable(true);
        } else {
            dashboardButtonInMenu.setVisible(true);
            orderButtonInMenu.setVisible(true);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////availableFoodAndDrink كل ما بداخل قائمة الزر///////////////////////////////////////////////////////////////////////
    //هنا لاضافة عناصر داخل الجدول 
    @FXML
    public void availableFoodAndDrinkAdd() {
        String sql = "INSERT INTO categor(productid,productname,type,price,available,stock,image,date)" + "VALUES(?,?,?,?,?,?,?,?)";

        connect = database.connectDb();
        try {
            //stock
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, productidInproductPage.getText());
            prepare.setString(2, productNameInproductPage.getText());
            prepare.setString(3, (String) productTypeComboBoxInproductPage.getSelectionModel().getSelectedItem());
            prepare.setString(4, productPriceInproductPage.getText());
            prepare.setString(5, (String) productAvailableComboBoxInproductPage.getSelectionModel().getSelectedItem());
            prepare.setString(6, productStockInproductPage1.getText());

            //import image   
            String path = data.path;
            path = path.replace("\\", "\\\\");
            prepare.setString(7, path);
            //هنا للحصول على التاريخ والوقت الفعلى 
            Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            prepare.setString(8, String.valueOf(sqldate));

            Alert alert;
            //stock
            //path
            if (productidInproductPage.getText().isEmpty()
                    || productNameInproductPage.getText().isEmpty()
                    || productTypeComboBoxInproductPage.getSelectionModel() == null
                    || productPriceInproductPage.getText().isEmpty()
                    || productAvailableComboBoxInproductPage.getSelectionModel() == null
                    || productStockInproductPage1.getText().isEmpty()
                    || data.path == null) {
                //path للصور الخاصة بالاطعمة

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("alert message");
                alert.setHeaderText(null);
                alert.setContentText("من فضلك املاء كل الحقول المتوفرة");
                alert.showAndWait();
            } else {
///////////////////////categor
                String checkdata = "SELECT productid FROM categor WHERE productid = '" + productidInproductPage.getText() + "'";

                connect = database.connectDb();
                statement = connect.createStatement();
                result = statement.executeQuery(checkdata);
                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("alert message");
                    alert.setHeaderText(null);
                    alert.setContentText("Product id : " + productidInproductPage.getText() + " " + "العنصر موجود بالفعل ");
                    alert.showAndWait();

                } else {
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزي المستخدم هل انت متأكد من اضافة العنصر؟");

                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {

                        prepare.executeUpdate();
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("تم الاضافة");
//                        alert = new Alert(AlertType.CONFIRMATION);
//                        alert.setTitle("Confirmation message");
//                        alert.setHeaderText(null);
//                        alert.setContentText("عزيزى المستخدم متاكد انك ستضيف العنصر؟ ");
//                        alert.showAndWait();
                        //لمسح البيانات 
                        availableClearallTextFileds();
                        //لعرض البيانات
                        availableFoodAndDrinkdisplaydata();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////هنا زر اضافة صورة داخل الصفحة للمنتجات والاطعمة///////////////////////////////////////////////////////////////

    private Image imageproduct;

    @FXML
    public void importbuttonforProducts() {
        FileChooser filechoose = new FileChooser();
        filechoose.getExtensionFilters().add(new ExtensionFilter("open image file", "*png", "*jpg"));
        File file = filechoose.showOpenDialog(mainFormAnchorPane.getScene().getWindow());
        if (file != null) {
            data.path = file.getAbsolutePath();
            imageproduct = new Image(file.toURI().toString(), 145, 121, false, true);
            imageviewProdutsavailable.setImage(imageproduct);
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////هنا زر اضافة صورة داخل الصفحة للمنتجات والاطعمة///////////////////////////////////////////////////////////////

    private Image imageMenu;

    @FXML
    public void importbuttonforMenu() {
        FileChooser filechoose = new FileChooser();
        filechoose.getExtensionFilters().add(new ExtensionFilter("open image file", "*png", "*jpg"));
        File file = filechoose.showOpenDialog(mainFormAnchorPane.getScene().getWindow());
        if (file != null) {
            data.path = file.getAbsolutePath();
            imageMenu = new Image(file.toURI().toString(), 145, 121, false, true);
            menuImageView.setImage(imageMenu);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    private ObservableList<String> addtableidincombobox = FXCollections.observableArrayList();

    public void displaytableidinBookcombobox() {
        String gettableidtofillcombobox = "SELECT tableid FROM tables";
        connect = database.connectDb();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(gettableidtofillcombobox);

            while (result.next()) {
                String tableid = result.getString("tableid");
                addtableidincombobox.add(tableid);
//addtableidincombobox.clear();
            }
            choosetableforbookcombobox.setItems(addtableidincombobox);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ///////////////////////////////////booktable///////////////////////////////////////
    public void booktable() {
        Alert alert;
        if (chhosecustomerforbookcombobox.getSelectionModel().getSelectedItem()
                == null || choosetableforbookcombobox.getSelectionModel().getSelectedItem()
                == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("alert message");
            alert.setHeaderText(null);
            alert.setContentText("من فضلك املاء كل الحقول المتوفرة");
            alert.showAndWait();
        } else {

            String checktableid = "";
            /////////////////////categor
            String checktabletye = "SELECT type FROM tables WHERE tableid = '" + choosetableforbookcombobox.getSelectionModel().getSelectedItem() + "'";
            connect = database.connectDb();
            try {

                prepare = connect.prepareStatement(checktabletye);
                result = prepare.executeQuery();

                if (result.next()) {
                    checktableid = result.getString("type");
                }

                if (!checktableid.equals("free")) {
//                addButtonProductFrame.setStyle("-fx-background-color:red");
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("الطاولة محجوزة بالفعل");
                    alert.showAndWait();

                } else {
                    String sql = "UPDATE tables SET "
                            + "tableid = '" + choosetableforbookcombobox.getSelectionModel().getSelectedItem() + "', type = 'booked', customeridbook = '"
                            + chhosecustomerforbookcombobox.getSelectionModel().getSelectedItem()
                            + "' WHERE tableid= " + choosetableforbookcombobox.getSelectionModel().getSelectedItem();

                    connect = database.connectDb();
                    try {
                        alert = new Alert(AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("عزيزي المستخدم هل انت متأكد من حجز الطاولة " + textfeldtableid.getText() + "?");
//رسالة تختار منها زر
                        Optional<ButtonType> option = alert.showAndWait();

                        if (option.get().equals(ButtonType.OK)) {
                            prepare = connect.prepareStatement(sql);
                            prepare.executeUpdate();
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("تم بحمد الله الحجز بنجاح");
                            alert.showAndWait();

                            //لعرض البيانات
                            TablesDisplayDatainHomePage();
                            clearTablecomboboxinHomepage();

                        }//if
                    }//try
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void clearTablecomboboxinHomepage() {
        choosetableforbookcombobox.getItems().clear();
        chhosecustomerforbookcombobox.getItems().clear();

    }
    /////////////////////////////////////////////////////////////////////////

    private ObservableList<String> addcustomeridincombobox = FXCollections.observableArrayList();

    public void displaycustomeridinBookcombobox() {
        String getcustomeridtofillcombobox = "SELECT customer_id FROM reciept";
        connect = database.connectDb();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(getcustomeridtofillcombobox);
            while (result.next()) {
                String customerId = result.getString("customer_id");
                addcustomeridincombobox.add(customerId);

            }
            chhosecustomerforbookcombobox.setItems(addcustomeridincombobox);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////هنا لعرض جميع البيانات الموجودة فى الجدول على الحقول///////////////////////////////////////////////////////////////
    @FXML
    public void availableFoodAndDrinkSelect() {
        categories categoryData = productTableViewInproductPage.getSelectionModel().getSelectedItem();
        int number = productTableViewInproductPage.getSelectionModel().getSelectedIndex();
        if ((number - 1) < -1) {
            return;

        }
        productidInproductPage.setText(categoryData.getProductid());
        productNameInproductPage.setText(categoryData.getProductname());
//        productTypeComboBoxInproductPage.setSelectionModel(String.valueOf(categoryData.getStock()));
        productPriceInproductPage.setText(String.valueOf(categoryData.getPrice()));
//        productAvailableComboBoxInproductPage.setSelectionModel();
        //stock
        productStockInproductPage1.setText(String.valueOf(categoryData.getStock()));

//50
        data.path = categoryData.getimage();
        String path = "File:" + categoryData.getimage();
        //  التاريخ
        data.path = String.valueOf(categoryData.getDate());

        //image
        imageproduct = new Image(path, 145, 121, false, true);
        imageviewProdutsavailable.setImage(imageproduct);

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////هنا عند الضغط على صف العنصر تظهر فى الحقول///////////////////////////////////////////////////////////////
    //26:21
    public ObservableList<categories> availableFoodAndDrinkListdata() {
        ObservableList<categories> listdata = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM category ";
/////////////////////////////categor
        String sql = "SELECT * FROM categor ";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            categories category;
            while (result.next()) {
                //stock
                category = new categories(result.getInt("id"),
                        result.getString("productid"),
                        result.getString("productname"),
                        result.getString("type"),
                        result.getFloat("price"),
                        result.getString("available"),
                        result.getInt("stock"), result.getString("image"), result.getDate("date"));
                listdata.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listdata;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لحذف البيانات الموجودة فى صفحة available ا///////////////////////////////////////////////////////////////////////

    @FXML
    public void availableFoodAndDrinkDelete() {
        ///////////////////categor
        String sql = "DELETE FROM categor WHERE productid='" + productidInproductPage.getText() + "'";
        connect = database.connectDb();
        try {

            Alert alert;
            if (productidInproductPage.getText().isEmpty()
                    || productNameInproductPage.getText().isEmpty()
                    || productTypeComboBoxInproductPage.getSelectionModel().getSelectedItem() == null
                    || productPriceInproductPage.getText().isEmpty()
                    || productAvailableComboBoxInproductPage.getSelectionModel().getSelectedItem() == null
                    || productStockInproductPage1.getText().isEmpty()
                    || data.path == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("من فضلك املا كل الحقول المتاحة");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزي المستخدم هل انت متأكد من حذف" + productidInproductPage.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("تم الحذف");

                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    //لمسح البيانات 
                    availableClearallTextFileds();
                    //لعرض البيانات
                    availableFoodAndDrinkdisplaydata();

                } else {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("الغاء");
                    alert.showAndWait();

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لتحديث البيانات الموجودة فى صفحة available ا///////////////////////////////////////////////////////////////////////

    @FXML
    public void availableFoodAndDrinkUpdateAlltextFields() {

        if (productidInproductPage.getText().isEmpty()
                || productNameInproductPage.getText().isEmpty()
                || productTypeComboBoxInproductPage.getSelectionModel().getSelectedItem() == null
                || productPriceInproductPage.getText().isEmpty()
                || productAvailableComboBoxInproductPage.getSelectionModel().getSelectedItem() == null
                || productStockInproductPage1.getText().isEmpty()
                || data.path == null) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("من فضلك املا كل الحقول المتاحة");
            alert.showAndWait();

        } else {

            String path = data.path;
            path = path.replace("\\", "\\\\");
            ///////////////////////////////categor
            String sql = "UPDATE categor SET "
                    + "productid = '" + productidInproductPage.getText() + "', productname= '"
                    + productNameInproductPage.getText() + "', type = '"
                    + productTypeComboBoxInproductPage.getSelectionModel().getSelectedItem() + "', price = '"
                    + productPriceInproductPage.getText() + "', available= '"
                    + productAvailableComboBoxInproductPage.getSelectionModel().getSelectedItem() + "', stock = '"
                    + productStockInproductPage1.getText() + "', image = '"
                    + path + "' WHERE productid= " + productidInproductPage.getText();

            connect = database.connectDb();
            try {
                Alert alert;
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزي المستخدم هل انت متأكد من تحديث" + productidInproductPage.getText() + "?");
//رسالة تختار منها زر
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("تم بحمد الله التحديث بنجاح");
                    alert.showAndWait();

                    //لعرض البيانات
                    availableFoodAndDrinkdisplaydata();
                    //لمسح البيانات 
                    availableClearallTextFileds();
                }//if
            }//try
            catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////لمسح البيانات التى بداخل الحقول فى صفحة المنتجات المتاحة//////////////////////////////////////////////////////////////////////
    @FXML
    public void availableClearallTextFileds() {
        productidInproductPage.setText("");
        productNameInproductPage.setText("");
        productTypeComboBoxInproductPage.getSelectionModel().clearSelection();
        productPriceInproductPage.setText("");
        productAvailableComboBoxInproductPage.getSelectionModel().clearSelection();
        productStockInproductPage1.setText("");
        //stock
        data.path = "";
        imageviewProdutsavailable.setImage(null);
    }

    @FXML
    public void deleteallElementsbutton() {
        ////////////////categor
        String sql = "DELETE FROM categor";
        connect = database.connectDb();
        try {

            Alert alert;
            alert = new Alert(AlertType.WARNING);
            alert.setTitle("Waring Message");
            alert.setHeaderText(null);
            alert.setContentText("عزيزي المستخدم هل انت متأكد من حذف جميع الوجبات؟");
//رسالة تختار منها زر
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                productTableViewInproductPage.getItems().clear();
                prepare = connect.prepareStatement(sql);
                prepare.executeUpdate();
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("information Message");
                alert.setHeaderText(null);
                alert.setContentText("تم بحمد الله الحذف بنجاح");
                alert.showAndWait();

                //لمسح البيانات 
                availableClearallTextFileds();
            }//if
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    public void availableFoodAndDrinkSearch() {
        FilteredList<categories> filter = new FilteredList<>(availablefoodanddrinklist, e -> true);
        productsearchInproductPage.textProperty().addListener((observabl, newValue, oldValue) -> {
            filter.setPredicate(predicateCategories -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (predicateCategories.getProductid().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getProductname().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getAvailable().toLowerCase().contains(searchKey)) {
                    return true;
                } //integer
                else if (predicateCategories.getStock().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }

            });
        });
        SortedList<categories> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(productTableViewInproductPage.comparatorProperty());
        productTableViewInproductPage.setItems(sortList);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //لعرض البيانات فى اعمدة الجدول
    private ObservableList<categories> availablefoodanddrinklist;

    public void availableFoodAndDrinkdisplaydata() {
        availablefoodanddrinklist = availableFoodAndDrinkListdata();
        productidTableViewColumnsInproductPage.setCellValueFactory(new PropertyValueFactory<>("productid"));
        productNameTableViewColumnsInproductPage.setCellValueFactory(new PropertyValueFactory<>("productname"));
        productTypeTableViewColumnsInproductPage.setCellValueFactory(new PropertyValueFactory<>("type"));
        productPriceTableViewColumnsInproductPage.setCellValueFactory(new PropertyValueFactory<>("price"));
        productAvailableTableViewColumnsInproductPage.setCellValueFactory(new PropertyValueFactory<>("available"));
        //stock
        productStockTableViewColumnsInproductPage1.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productdateTableViewColumnsInproductPage11.setCellValueFactory(new PropertyValueFactory<>("date"));
        productTableViewInproductPage.setItems(availablefoodanddrinklist);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا لتحديد نوع الصنف هل وجبات طعام ام مشروبات///////////////////////////////////////////////////////////////////////

    private String[] categories = {"Meals", "Drinks", "Lanch Meals", "Braekfast Meals"};

    @FXML
    public void availableFoodAndDrinTypekFormAnchorPane() {
        List<String> listOfCategories = new ArrayList<>();
        for (String data : categories) {
            listOfCategories.add(data);
        }
        ObservableList listdata = FXCollections.observableArrayList(listOfCategories);
        productTypeComboBoxInproductPage.setItems(listdata);

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String[] available = {"Available", "NotAvailable"};

    @FXML
    public void availableFoodAndDrinkFormAnchorPane() {
        List<String> listavailable = new ArrayList<>();
        for (String data : available) {
            listavailable.add(data);
        }
        ObservableList listdata = FXCollections.observableArrayList(listavailable);
        productAvailableComboBoxInproductPage.setItems(listdata);

    }

    /////////////////////////////////////////table/////////////////////////////////////////////////
    private String[] tableavailable = {"free", "NotAvailable"};
    ///الصيانة

    @FXML
    public void tableFoodAndDrinkFormAnchorPane() {
        List<String> tablelistavailable = new ArrayList<>();
        for (String data : tableavailable) {
            tablelistavailable.add(data);
        }
        ObservableList listdata = FXCollections.observableArrayList(tablelistavailable);
        comboboxtablechoose.setItems(listdata);

    }

    @FXML
    public void TableButtonAdd() {
        String sql = "INSERT INTO tables(tableid,capacity,type,customeridbook)" + "VALUES(?,?,?,?)";

        connect = database.connectDb();
        try {
            //stock
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, textfeldtableid.getText());
            prepare.setString(2, textfeldtablecapacity.getText());
            prepare.setString(3, (String) comboboxtablechoose.getSelectionModel().getSelectedItem());
            prepare.setString(4, (String) chhosecustomerforbookcombobox.getSelectionModel().getSelectedItem());

            Alert alert;
            //stock
            //path
            if (textfeldtableid.getText().isEmpty()
                    || textfeldtablecapacity.getText().isEmpty()
                    || comboboxtablechoose.getSelectionModel().getSelectedItem() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("alert message");
                alert.setHeaderText(null);
                alert.setContentText("من فضلك املاء كل الحقول المتوفرة");
                alert.showAndWait();
            } else {

                String checkdata = "SELECT id FROM tables WHERE tableid = '" + textfeldtableid
                        .getText() + "'";

                connect = database.connectDb();
                statement = connect.createStatement();
                result = statement.executeQuery(checkdata);
                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("alert message");
                    alert.setHeaderText(null);
                    alert.setContentText("id : " + textfeldtableid.getText() + " " + "العنصر موجود بالفعل ");
                    alert.showAndWait();

                } else {
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم متاكد انك تريداضافة طاولة جديدة؟ ");
                    alert.showAndWait();
                    //لمسح البيانات 
                    tableClearallTextFileds();
                    //لعرض البيانات
                    TablesDisplayData();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<tables> TableListdata() {
        ObservableList<tables> listdata = FXCollections.observableArrayList();

        String sql = "SELECT * FROM tables";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            tables table;
            while (result.next()) {
                table = new tables(
                        result.getInt("id"),
                        result.getInt("tableid"),
                        result.getInt("capacity"),
                        result.getString("type"),
                        result.getInt("customeridbook")
                );

                listdata.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listdata;
    }
    private ObservableList<tables> Tablelist;

    public void TablesDisplayData() {
        Tablelist = TableListdata();///////////////////////////////////////////////////////////////////////////////////////////////////
        tableidc1.setCellValueFactory(new PropertyValueFactory<>("tableid"));
        tablecapacityc2.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        tableavailbiltyc3.setCellValueFactory(new PropertyValueFactory<>("type"));
        tabletablepage.setItems(Tablelist);
    }

    public void TablesDisplayDatainHomePage() {
        Tablelist = TableListdata();///////////////////////////////////////////////////////////////////////////////////////////////////
        tableidc11.setCellValueFactory(new PropertyValueFactory<>("tableid"));
        tablecapacityc21.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        tableavailbiltyc31.setCellValueFactory(new PropertyValueFactory<>("type"));
        customeridintableBook.setCellValueFactory(new PropertyValueFactory<>("customeridbook"));

        tabletablepage1.setItems(Tablelist);
    }

    @FXML
    public void tableClearallTextFileds() {
        textfeldtableid.setText("");
        textfeldtablecapacity.setText("");
        comboboxtablechoose.getSelectionModel().clearSelection();

    }

    @FXML
    public void TableButtonDelete() {
        ///////////////////categor
        String sql = "DELETE FROM tables WHERE tableid='" + textfeldtableid.getText() + "'";
        connect = database.connectDb();
        try {

            Alert alert;
            if (textfeldtableid.getText().isEmpty()
                    || textfeldtablecapacity.getText().isEmpty()
                    || comboboxtablechoose.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("من فضلك املا كل الحقول المتاحة");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزي المستخدم هل انت متأكد من حذف" + textfeldtableid.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("تم الحذف");

                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    tableFoodAndDrinkFormAnchorPane();

                    //لمسح البيانات 
                    tableClearallTextFileds();
                    //لعرض البيانات
                    TablesDisplayData();

                } else {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("الغاء");
                    alert.showAndWait();

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

////////////////////////////////////////////////////////////////////update
    @FXML
    public void TablesUpdateButton() {

        if (textfeldtableid.getText().isEmpty()
                || textfeldtablecapacity.getText().isEmpty()
                || comboboxtablechoose.getSelectionModel().getSelectedItem() == null) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("من فضلك املا كل الحقول المتاحة");
            alert.showAndWait();

        } else {

            String sql = "UPDATE tables SET "
                    + "tableid = '" + textfeldtableid.getText() + "', capacity= '"
                    + textfeldtablecapacity.getText() + "', type = '"
                    + comboboxtablechoose.getSelectionModel().getSelectedItem()
                    + "' WHERE tableid= " + textfeldtableid.getText();

            connect = database.connectDb();
            try {
                Alert alert;
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("عزيزي المستخدم هل انت متأكد من تحديث" + textfeldtableid.getText() + "?");
//رسالة تختار منها زر
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("تم بحمد الله التحديث بنجاح");
                    alert.showAndWait();

                    //لعرض البيانات
                    TablesDisplayData();
                    //لمسح البيانات 
                    tableClearallTextFileds();
                }//if
            }//try
            catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

///////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا للتنقل بين الصفحات الموجودة///////////////////////////////////////////////////////////////////////
    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == dashboardButtonInMenu) {
            dashboardFormAnchorPane.setVisible(true);
            availableFormAnchorPane.setVisible(false);
            orderFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(false);
            customerTablePage.setVisible(false);
            tablemanagementpage2.setVisible(false);
            menuImageAnchorPanepage.setVisible(false);

            homeButtonInMenu1.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
//            dashboardButtonInMenu.setStyle("-fx-background-color:black;" + "-fx-text-fill:white;");
            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            orderButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            exitButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            CustomerButton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            tablebutton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            menuButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");

        } else if (event.getSource() == availableFoodAnddrinkButtonInMenu) {
            dashboardFormAnchorPane.setVisible(false);
            availableFormAnchorPane.setVisible(true);
            orderFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(false);
            customerTablePage.setVisible(false);
            tablemanagementpage2.setVisible(false);
            menuImageAnchorPanepage.setVisible(false);

            homeButtonInMenu1.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:#FD7212;");
            dashboardButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            orderButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            exitButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            menuButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            CustomerButton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            tablebutton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");

            /////////////////////////////////////
            availableFoodAndDrinkdisplaydata();
            availableFoodAndDrinTypekFormAnchorPane();//
            availableFoodAndDrinkFormAnchorPane();//
            availableFoodAndDrinkSearch();
            /////////////////////////////////////
        } else if (event.getSource() == orderButtonInMenu) {
            orderFormAnchorPane.setVisible(true);
            dashboardFormAnchorPane.setVisible(false);
            availableFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(false);
            customerTablePage.setVisible(false);
            tablemanagementpage2.setVisible(false);
            menuImageAnchorPanepage.setVisible(false);

            orderButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:#FD7212;");
            dashboardButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            homeButtonInMenu1.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            exitButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            CustomerButton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            tablebutton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            menuButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");

            menuDisplayProductFrame();
            menuDisplayOrderData();
            menuGetOrder();
            menuDisplayTotal();
        } else if (event.getSource() == homeButtonInMenu1) {
            dashboardFormAnchorPane.setVisible(false);
            availableFormAnchorPane.setVisible(false);
            orderFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(true);
            customerTablePage.setVisible(false);
            tablemanagementpage2.setVisible(false);
            menuImageAnchorPanepage.setVisible(false);
            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            homeButtonInMenu1.setStyle("-fx-background-color:white;" + "-fx-text-fill:#FD7212;");
            dashboardButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            orderButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            exitButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            CustomerButton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            tablebutton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            menuButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            TablesDisplayDatainHomePage();//بيانات الجدول
//            displaycustomeridinBookcombobox();
//            displaytableidinBookcombobox();
//            chhosecustomerforbookcombobox.getItems().clear();
//        choosetableforbookcombobox.getItems().clear();

        } else if (event.getSource() == CustomerButton) {
            dashboardFormAnchorPane.setVisible(false);
            availableFormAnchorPane.setVisible(false);
            orderFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(false);
            customerTablePage.setVisible(true);
            tablemanagementpage2.setVisible(false);
            menuImageAnchorPanepage.setVisible(false);
            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
            CustomerButton.setStyle("-fx-background-color:black;" + "-fx-text-fill:white;");
            homeButtonInMenu1.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
            dashboardButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
            orderButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
            exitButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
            tablebutton.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
            menuButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");

            customerDisplayData();//بيانات الجدول
        } else if (event.getSource() == tablebutton) {
            dashboardFormAnchorPane.setVisible(false);
            availableFormAnchorPane.setVisible(false);
            orderFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(false);
            customerTablePage.setVisible(false);
            tablemanagementpage2.setVisible(true);
            menuImageAnchorPanepage.setVisible(false);

            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            CustomerButton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            homeButtonInMenu1.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            dashboardButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            orderButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            exitButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            tablebutton.setStyle("-fx-background-color:white;" + "-fx-text-fill:#FD7212;");
            menuButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");

            tableFoodAndDrinkFormAnchorPane();//combobox
            TablesDisplayData();//بيانات الجدول
        } else if (event.getSource() == menuButtonInMenu) {
            dashboardFormAnchorPane.setVisible(false);
            availableFormAnchorPane.setVisible(false);
            orderFormAnchorPane.setVisible(false);
            homeAnchorPane22222.setVisible(false);
            customerTablePage.setVisible(false);
            tablemanagementpage2.setVisible(false);
            menuImageAnchorPanepage.setVisible(true);
            availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            CustomerButton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            menuButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:#FD7212;");
            homeButtonInMenu1.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            dashboardButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            orderButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            exitButtonInMenu.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");
            tablebutton.setStyle("-fx-background-color:#FD7212;" + "-fx-text-fill:white;");

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////productframe layout ///////////////////////////////////////////////////////////////////////
    public ObservableList<categories> menuGetData() {
///////////////////categor
        String sql = "SELECT * FROM  categor";

        ObservableList<categories> listdata = FXCollections.observableArrayList();
        connect = database.connectDb();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            categories product;

            while (result.next()) {
                product = new categories(result.getInt("id"),
                        result.getString("productid"),
                        result.getString("productname"), result.getString("type"), result.getInt("stock"), result.getFloat("price"), result.getString("image"), result.getDate("date"));

                listdata.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdata;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////disply product frame//////////////////////////////////////////////////////////////////////
    public void menuDisplayProductFrame() {

        productFrame.clear();
        productFrame.addAll(menuGetData());
        int row = 0;
        int column = 0;
        ordermenugridpane11.getChildren().clear();
        ordermenugridpane11.getRowConstraints().clear();
        ordermenugridpane11.getColumnConstraints().clear();

        for (int q = 0; q < productFrame.size(); q++) {
            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("productframe.fxml"));
                AnchorPane pane = load.load();
                ProductframeController productf = load.getController();
                productf.setData(productFrame.get(q));
                if (column == 3) {
                    column = 0;
                    row += 1;
                }
                ordermenugridpane11.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    ///////////////////////////////////
    public void customerId() {
        String sql = "SELECT MAX(customerid) FROM customerr ";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                customerid = result.getInt("MAX(customerid)");
            }

            String checkcustomerid = "SELECT MAX(customer_id) FROM reciept";

            prepare = connect.prepareStatement(checkcustomerid);
            result = prepare.executeQuery();

            if (result.next()) {
                checkid = result.getInt("MAX(customer_id)");
            }
//            customerid=checkid;
            if (customerid == checkid) {
                customerid += 1;
            } else if (customerid == 0) {
                customerid += 1;
            }
//            
            data.customerid = customerid;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<categories> menuGetOrder() {
        customerId();
        ObservableList<categories> ListData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM  customerr WHERE customerid = " + customerid;

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            categories category;

            while (result.next()) {

                category = new categories(
                        result.getInt("id"),
                        result.getString("productid"),
                        result.getString("product_name"),
                        result.getString("type"),
                        result.getInt("quantity"),
                        result.getFloat("price"),
                        result.getString("image"),
                        result.getDate("date"));
                ListData.add(category);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListData;
    }
    private int customerid;
    private float totalPrice;

    public void menuGetTotal() {
        customerId();
        String total = "SELECT SUM(price) FROM customerr WHERE customerid = " + customerid;

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(total);
            result = prepare.executeQuery();
            if (result.next()) {
                totalPrice = result.getFloat("SUM(price)");

//                totalPrice = 2+5;
            }
            //38.38

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void menuDisplayTotal() {
        menuGetTotal();
        orderTotalLabelInOrderPage1.setText("L.E" + totalPrice);

    }

    private ObservableList<categories> menuOrderListData;

    public void menuDisplayOrderData() {
        menuOrderListData = menuGetOrder();

        orderProductNameTableViewInorderPage.setCellValueFactory(new PropertyValueFactory<>("productname"));/////////////////help
        orderProductQuantityTableViewInorderPage.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        orderProductPriceTableViewInorderPage.setCellValueFactory(new PropertyValueFactory<>("price"));

        orderTableVirewInorderPage.setItems(menuOrderListData);

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int get_id;

    public void orderPageSelectOrder() {
        categories product = orderTableVirewInorderPage.getSelectionModel().getSelectedItem();
        int number = orderTableVirewInorderPage.getSelectionModel().getSelectedIndex();

        if ((number - 1) < -1) {
            return;
        }
        get_id = product.getId();

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private float amount;
    private float change;

    @FXML
    public void menuAmount() {
        menuGetTotal();
        if (orderAmountlInOrderPage.getText().isEmpty() || totalPrice == 0) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("غير صحيح");
            alert.showAndWait();
        } else {
            amount = Float.parseFloat(orderAmountlInOrderPage.getText());
            change = 0;

            if (amount < totalPrice) {
                orderAmountlInOrderPage.setText("");
            } else {
                change = (amount - totalPrice);
                orderchangeLabelInOrderPage11.setText("L.E" + change);
            }
        }
    }
    private int purchaseCount;

    @FXML
    public void OrderPayButton() {
        if (totalPrice == 0) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("يرجى اختيار الطلب اولا");
            alert.showAndWait();
        } else {
            String insertpay = "INSERT INTO reciept" + "(customer_id,total_price,date,employee_name)"
                    + "VALUES (?,?,?,?)";

            connect = database.connectDb();
            try {

                if (amount == 0) {
                    Alert alert;
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("هناك خطأ");
                    alert.showAndWait();
                } else {
                    Alert alert;
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("عزيزى المستخدم متاكد من دفع الطلب؟");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {

                        customerId();
                        menuGetTotal();
                        prepare = connect.prepareStatement(insertpay);
                        prepare.setString(1, String.valueOf(customerid));
                        prepare.setString(2, String.valueOf(totalPrice));
                        Date date = new Date();
                        java.sql.Date sqldate = new java.sql.Date(date.getTime());
                        prepare.setString(3, String.valueOf(sqldate));
                        prepare.setString(4, data.usernameLabbelIndashbiardPage);
                        prepare.executeUpdate();

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("تمت الدفع بنجاح");
                        alert.showAndWait();
//                        orderrestart();
                        menuDisplayOrderData();
                        incrementcustomerId();
                    } else {
                        alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("تم الالغاء");
                        alert.showAndWait();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void clearOrderedItemsTable() {
        // Assuming you have a TableView named orderedItemsTableView
        orderTableVirewInorderPage.getItems().clear();
    }

    public void orderrestart() {
        totalPrice = 0;
        change = 0;
        amount = 0;
        orderTotalLabelInOrderPage1.setText("L.E 0.0");
        orderAmountlInOrderPage.setText("");
        orderchangeLabelInOrderPage11.setText("L.E 0.0");

        clearOrderedItemsTable();
    }

    @FXML
    public void orderRemoveButton() {
//        if (customerid == 10) 
        if ((totalPrice == 0)) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("من فضلك ادخل الطلب الذي تريد حذفه");
            alert.showAndWait();

        } else {
            String deletedata = "DELETE FROM customerr WHERE customerid = " + customerid;

            connect = database.connectDb();
            try {
                Alert alert;
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("هل انت متأكد من أن تريد الحذف؟");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deletedata);
                    prepare.executeUpdate();
                    orderrestart();
                }
                menuDisplayOrderData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void orderRecieptButton() {
        if (totalPrice == 0 || orderAmountlInOrderPage.getText().isEmpty()) {
            Alert alert;
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("من فضلك اطلب اولا");
            alert.showAndWait();
        } else {
//            customerId();
            HashMap map = new HashMap();
            map.put("getReciept", customerid - 1);

            try {
                JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\restaurant management system\\src\\restaurant\\management\\system\\report1.jrxml");
                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, map, connect);

                JasperViewer.viewReport(jprint, false);
                orderrestart();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    int checkid = 0;

    public void incrementcustomerId() {
        String sql = "SELECT MAX(customerid) FROM customerr ";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                customerid = result.getInt("MAX(customerid)") + 1; // Increment customer ID for the next customer
            }

            data.customerid = customerid;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////Logout///////////////////////////////////////////////////////////////////////
    @FXML
    public void logout() {
        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setContentText(" عزيزى المستخدم متأكد عاوز تطلع من الايميل؟");
            alert.setHeaderText(null);
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                Parent root = FXMLLoader.load(getClass().getResource("loginAndRegister.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                logoutButtonInMenu.getScene().getWindow().hide();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////exit///////////////////////////////////////////////////////////////////////

    @FXML
    public void exit() {
        System.exit(0);
        exitButtonInMenu.setStyle("-fx-background-color:black;" + "-fx-text-fill:white;");
        dashboardButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
        availableFoodAnddrinkButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");
        orderButtonInMenu.setStyle("-fx-background-color:white;" + "-fx-text-fill:black;");

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String operate = "";

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private TextField outputtextfield;

    @FXML
    private Label savednumbers;

    @FXML
    private TextArea calculatetextarea;

    private String firestnumber = "0"; // Initialize firestnumber to 0 to avoid null pointer exception
    private String currentnumber = "";
    private String calculationType;

    @FXML
    private void addaction(ActionEvent event) {
        calculationSetup("+");
    }

    @FXML
    private void subtractaction(ActionEvent event) {
        calculationSetup("-");
    }

    @FXML
    private void devideaction(ActionEvent event) {
        calculationSetup("/");
    }

    @FXML
    private void multipleaction(ActionEvent event) {
        calculationSetup("*");
    }

    public void calculationSetup(String calculateType) {
        this.calculationType = calculateType;
        firestnumber = currentnumber;
        currentnumber = "";
        savednumbers.setText(firestnumber + " " + calculationType);
    }

    @FXML
    private void calculate(ActionEvent event) {
        try {
            int firstNumberInt = Integer.parseInt(firestnumber);
            int secondNumberInt = Integer.parseInt(currentnumber);

            switch (calculationType) {
                case "+": {
                    int add = firstNumberInt + secondNumberInt;
                    savednumbers.setText(firestnumber + " + " + currentnumber + " = " + add);
//                    savednumbers.getText();
                    outputtextfield.setText(String.valueOf(add));
//                    calculatetextarea.setText(savednumbers.getText());
                    break;
                }

                case "-": {
                    int substract = firstNumberInt - secondNumberInt;
                    savednumbers.setText(firestnumber + " - " + currentnumber + " = " + substract);
                    outputtextfield.setText(String.valueOf(substract));
                    break;
                }

                case "/": {
                    if (secondNumberInt == 0) {
                        throw new ArithmeticException("Division by zero"); // Handle division by zero
                    }

                    int divide = firstNumberInt / secondNumberInt;
                    savednumbers.setText(firestnumber + " / " + currentnumber + " = " + divide);
                    outputtextfield.setText(String.valueOf(divide));
                    break;
                }

                case "*": {
                    int multiply = firstNumberInt * secondNumberInt;
                    savednumbers.setText(firestnumber + " * " + currentnumber + " = " + multiply);
                    outputtextfield.setText(String.valueOf(multiply));
                    break;
                }
//                calculatetextarea.setText(savednumbers.getText());

            }
        } catch (NumberFormatException e) { // Catch invalid input
            outputtextfield.setText("Invalid Input");
        } catch (ArithmeticException e) { // Catch division by zero
            outputtextfield.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void cleartextfield(ActionEvent event) {
        currentnumber = "";
        outputtextfield.setText("");
        savednumbers.setText("");
        calculatetextarea.setText("");
    }

    @FXML
    private void button0Clicked(ActionEvent event) {
        addnumber("0");
    }

    @FXML
    private void button1Clicked(ActionEvent event) {
        addnumber("1");
    }

    @FXML
    private void button2Clicked(ActionEvent event) {
        addnumber("2");
    }

    @FXML
    private void button3Clicked(ActionEvent event) {
        addnumber("3");
    }

    @FXML
    private void button4Clicked(ActionEvent event) {
        addnumber("4");
    }

    @FXML
    private void button5Clicked(ActionEvent event) {
        addnumber("5");
    }

    @FXML
    private void button6Clicked(ActionEvent event) {
        addnumber("6");
    }

    @FXML
    private void button7Clicked(ActionEvent event) {
        addnumber("7");
    }

    @FXML
    private void button8Clicked(ActionEvent event) {
        addnumber("8");
    }

    @FXML
    private void button9Clicked(ActionEvent event) {
        addnumber("9");
    }

    public void addnumber(String number) {
        currentnumber += number;
        updatetextfield();
    }

    public void updatetextfield() {
        outputtextfield.setText(currentnumber);

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayusername();
//        logout();
        availableFoodAndDrinkFormAnchorPane();
        //قائمة اطعمة
        availableFoodAndDrinTypekFormAnchorPane();
        availableFoodAndDrinkdisplaydata();

        menuDisplayProductFrame();
        menuGetOrder();
        menuDisplayTotal();
        menuDisplayOrderData();
        //جدول العملاء
        customerDisplayData();
        tableFoodAndDrinkFormAnchorPane();//combobox
        TablesDisplayData();
        TablesDisplayDatainHomePage();

        displaycustomeridinBookcombobox();
        displaytableidinBookcombobox();

    }

}
