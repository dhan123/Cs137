package everything;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Item {
    public String name;
    public int price;
    public int quantity;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    

    
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }    
}
