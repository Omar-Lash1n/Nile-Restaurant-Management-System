/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.sql.Date;

/**
 *
 * @author Ahmed
 */
public class customerData {
    private Integer id;
    private Integer customerid;
    private Float total;
    private Date date;
    private String employeeUsername;

    public customerData(Integer id, Integer customerid, Float total, Date date, String employeeUsername) {
        this.id = id;
        this.customerid = customerid;
        this.total = total;
        this.date = date;
        this.employeeUsername = employeeUsername;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public Float getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }
    
}
