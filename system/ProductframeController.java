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
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ProductframeController implements Initializable {

    @FXML
    private AnchorPane FrameOfProduct;
    @FXML
    private Label FoodNameLabell;
    @FXML
    private Label priceLabel;

    @FXML
    private Label salesoftheproduct;

    @FXML
    private ImageView ImageOfProduct;
    @FXML
    private Spinner<Integer> spinnerProductFrame;
    @FXML
    private Button addButtonProductFrame;

    private categories categorydata;

    private String productId;

    private Image image;

    private SpinnerValueFactory<Integer> spinnerProduct;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private String productimage;
    private String productdate;
    private Alert alert;

    private String type;

    private float total_price;
    private float price;

    public void setData(categories categorydata) {
        this.categorydata = categorydata;
        productId = categorydata.getProductid();
        FoodNameLabell.setText(categorydata.getProductname());
        type = categorydata.getType();
        priceLabel.setText(String.valueOf(categorydata.getPrice()) + "L.E");
        price = categorydata.getPrice();

        productimage = categorydata.getimage();
        productdate = String.valueOf(categorydata.getDate());
        String path = "File:" + categorydata.getimage();
        image = new Image(path, 190, 94, false, true);
        ImageOfProduct.setImage(image);
    }

    private int quantity;

    public void setQuantity() {
        spinnerProduct = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        spinnerProductFrame.setValueFactory(spinnerProduct);

    }
    CashierfileController cashierform = new CashierfileController();

//    private int purchaseCount;
//
//    public void purchaseCounter() {
//
//        cashierform.OrderPayButton();
//        purchaseCount = quantity;
//        if (purchaseCount > 10) {
//            salesoftheproduct.setText("اكثر مبيعا");
//        } else {
//            salesoftheproduct.setText("غير شائع");
//        }
//
//    }
    public void addButton() {

        cashierform.customerId();
        
        quantity = spinnerProductFrame.getValue();

        String check = "";
        /////////////////////categor
        String checkavaliable = "SELECT available FROM categor WHERE productid = '" + productId + "'";
        connect = database.connectDb();

        try {

            int checkstck = 0;

            prepare = connect.prepareStatement(checkavaliable);
            result = prepare.executeQuery();

            if (result.next()) {
                check = result.getString("available");
            }

            if (!check.equals("Available") || quantity == 0) {
//                addButtonProductFrame.setStyle("-fx-background-color:red");
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("العنصر ليس متاحا عزيزي المستخدم");
                alert.showAndWait();
                addButtonProductFrame.setStyle("-fx-background-color:red");
            } else {
                /////////////////////categor
                String checkstoke = "SELECT stock FROM categor WHERE productid  ='" + productId + "' ";

                prepare = connect.prepareStatement(checkstoke);
                result = prepare.executeQuery();

                if (result.next()) {
                    checkstck = result.getInt("stock");
                }

                if (checkstck == 0) {
                    ///////////////////////categor
                    String updatestock = "UPDATE categor SET productname ='" + FoodNameLabell.getText() + "',type = '"
                            + type + "',price = '" + price + "',available = 'NotAvailable',stock = 0,image = '" + productimage + "', date='"
                            + productdate + "'WHERE productid='" + productId + "' ";

                    prepare = connect.prepareStatement(updatestock);
                    prepare.executeUpdate();
                }
/////////////////////////////////////////////////////////////////////////////////////////

                if (checkstck < quantity) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("للأسف الكمية المطلوبة اكبر من المتواجدة المتاح حاليا  " + checkstck);
                    alert.showAndWait();
                } else {
                    int upstock = checkstck - quantity;
                    productimage = productimage.replace("\\", "\\\\");
                    String insertdata = "INSERT INTO customerr" + "(customerid,productid,product_name,type,quantity,price,image,date,emplyee_name)"
                            + "VALUES(?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertdata);
                    prepare.setString(1, String.valueOf(data.customerid));
                    prepare.setString(2, productId);
                    prepare.setString(3, FoodNameLabell.getText());
                    prepare.setString(4, type);
                    prepare.setString(5, String.valueOf(quantity));
                    total_price = (quantity * price);
                    prepare.setString(6, String.valueOf(total_price));
                    prepare.setString(7, productimage);
                    Date date = new Date();
                    java.sql.Date sqldate = new java.sql.Date(date.getTime());
                    prepare.setString(8, String.valueOf(sqldate));
                    prepare.setString(9, data.loginUsername);
                    prepare.executeUpdate();

                    productimage = productimage.replace("\\", "\\\\");
                    System.out.println("Date: " + productdate);
                    System.out.println("Image: " + productimage);
                    ///////////////////////categor
                    String updatestock = "UPDATE categor SET productname ='" + FoodNameLabell.getText() + "',type = '"
                            + type + "',price = '" + price + "',available = '" + check + "',stock = '" + upstock + "',image = '" + productimage + "', date='"
                            + productdate + "'WHERE productid='" + productId + "' ";

                    prepare = connect.prepareStatement(updatestock);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("تم اضافة العنصر بنجاح");
                    alert.showAndWait();
//                     spinnerProductFrame.setValueFactory(null);

                    if (checkstck <= 10) {
                        alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Waring Message");
                        alert.setHeaderText(null);
                        alert.setContentText("للأسف العنصر اقترب على النفاذ");
                        alert.showAndWait();
                        addButtonProductFrame.setStyle("-fx-background-color:orange");
                    }

                    cashierform.menuGetTotal();
                
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setQuantity();

    }

}
