
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Cart {
    
    HashMap<Item,Integer> cart;
    
    public void createCart(){
        cart = new HashMap();
        Item i = new Item();
        i.setName("Apple");
        i.setPrice(9);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Baby Carrots");
        i.setPrice(5);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Canadian Bacon");
        i.setPrice(50);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Chicken Breast");
        i.setPrice(30);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Romaine Lettuce");
        i.setPrice(10);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Bananas");
        i.setPrice(1);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Rib Eye Steak");
        i.setPrice(70);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Spinach");
        i.setPrice(33);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Dragonfruit");
        i.setPrice(44);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Salmon");
        i.setPrice(100);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Yellow Onions");
        i.setPrice(12);
        cart.put(i, 0);
        i=null;
        i = new Item();
        i.setName("Oranges");
        i.setPrice(17);
        cart.put(i, 0);
    }
    
    public void setQuantity(Item i, int q){
        cart.put(i, q);
    }
    
    public Item getItem(String name){
        for(Item i: cart.keySet()){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    
    public String getName(Item i){
        return i.getName();
    }
    
    public int getPrice(Item i){
        return i.getPrice();
    }
    
    public int getQuantity(Item i){
        return cart.get(i);
    }
    
    public HashMap getCart(){
        return cart;
    }
    public int size(){
        return cart.size();
    }

}
