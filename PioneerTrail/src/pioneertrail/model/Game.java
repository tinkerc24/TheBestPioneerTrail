/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Danica
 */
public class Game implements Serializable {

    private double milesTraveled;
    private int numPeople;
    private Player player;
    
    private ArrayList<InventoryItem> items;

    /**
     * Get the value of items
     *
     * @return the value of items
     */
    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    /**
     * Set the value of items
     *
     * @param items new value of items
     */
    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public Game() {
    }

    public double getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(double milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.milesTraveled) ^ (Double.doubleToLongBits(this.milesTraveled) >>> 32));
        hash = 97 * hash + this.numPeople;
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "milesTraveled=" + milesTraveled + ", numPeople=" + numPeople + ", player=" + player + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.milesTraveled) != Double.doubleToLongBits(other.milesTraveled)) {
            return false;
        }
        if (this.numPeople != other.numPeople) {
            return false;
        }
        return true;
    }

}
