/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.util.Date;
import javafx.scene.image.Image;

/**
 *
 * @author Ahmed
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////هنا تم اضافتهم للعمل بهم فى الجدول ///////////////////////////////////////////////////////////////////////
public class categories {

    private String productid;
    private String productname;
    private String type;
    private Float price;
    private String available;
    private Integer stock;
    private String image;
    private Date date;
    private int quantity;
    private Integer id;

    public categories(Integer id,String productid, String productname, String type,Float price, String available, Integer stock, String image, Date date) {
        this.id=id;
        this.productid = productid;
        this.productname = productname;
        this.type = type;
        this.price = price;
        this.available = available;
        this.stock = stock;
        this.image = image;
        this.date = date;
        
    }
    
        public categories(Integer id,String productid, String productname,String type, Integer quantity ,Float price,String image,Date date) {
        this.id=id;
        this.productid = productid;
        this.productname = productname;
        this.type = type;
        this.price = price;
        this.image = image;      
        this.date = date;
        this.quantity=quantity;
        }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
        
    public String getProductid() {
        return productid;
    }

    public String getimage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

    public String getProductname() {
        return productname;
    }

    public String getType() {
        return type;
    }

    public Float getPrice() {
        return price;
    }

    public String getAvailable() {
        return available;
    }

    public Integer getStock() {
        return stock;
    }

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

