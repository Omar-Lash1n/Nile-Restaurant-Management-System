/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

/**
 *
 * @author Ahmed
 */
public class tables {
    private Integer id;
    private Integer tableid;
    private Integer capacity;
    private String type;
    private Integer customeridbook;

    public tables(Integer id, Integer tableid, Integer capacity, String type,Integer customeridbook) {
        this.id = id;
        this.tableid = tableid;
        this.capacity = capacity;
        this.type = type;
        this.customeridbook=customeridbook;
    }

    public Integer getCustomeridbook() {
        return customeridbook;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTableid() {
        return tableid;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
    
    
}
