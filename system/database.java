/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ahmed
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////الاتصال بقاعدة البيانات///////////////////////////////////////////////////////////////////////
 
public class database {
    public static Connection connectDb(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        //معلومات التسجيل 
        //اسم المستخدم الخاص بقاعدة البيانات  root
        //لا يوجد كلمة مرور 
        //ان شاء الله سوف يتم وضع ذلك لتامينها
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantmanagementsystem","root","");
        return connect;
        
        }catch(Exception e){
        e.printStackTrace();
        
        }
    return null; ///
    
    }
    
}
