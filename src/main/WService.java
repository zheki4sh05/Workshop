package main;

import java.util.Objects;

public class WService implements Comparable<WService>{
    private final int this_ID;
    private double price=0.0;
    private String name;

    public int getDays() {
        return days;
    }

    private int days;
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public WService(double price, String name, int days, int id) {
        this.price = price;
        this.name = name;
        this.days = days;
        this.this_ID = id;
    }
    @Override
    public String toString(){
        return ""+this.name+" "+this.price+"$"+"  "+this.days+"дней";
    }
    public int getThis_ID() {
        return this_ID;
    }
    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public int compareTo(WService s) {
        if(this.price<s.getPrice()){
            return -1;
        }else if(this.price>s.getPrice()){
            return 1;
        }else{
            return 0;
        }

    }
}
