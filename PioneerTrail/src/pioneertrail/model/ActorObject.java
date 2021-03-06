/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Tinkerc
 */
public class ActorObject implements Serializable {
    
    //Class instance variables
    private String name;
    private String gender;
    private String type;
    private int health;
    private Point coordinates;
    private String sickness;
    private int strength;

    public ActorObject() {
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        if (sickness.equals("Deceased"))
            this.sickness = "Deceased";
        else
            this.sickness = sickness;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
            this.sickness = "Deceased";
        } else if (health > 100){
            this.health = 100;
        } else {
            this.health = health;
        }
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }
    
    public static Comparator<ActorObject> NameComparator = new Comparator<ActorObject>() {

	public int compare(ActorObject s1, ActorObject s2) {
	   String ActorName1 = s1.getName().toUpperCase();
	   String ActorName2 = s2.getName().toUpperCase();

	   //ascending order
	   //return StudentName1.compareTo(StudentName2);

	   //descending order
	   return ActorName2.compareTo(ActorName1);
    }};

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.gender);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.health;
        hash = 67 * hash + Objects.hashCode(this.coordinates);
        hash = 67 * hash + Objects.hashCode(this.sickness);
        return hash;
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
        final ActorObject other = (ActorObject) obj;
        if (this.health != other.health) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.sickness, other.sickness)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActorObject{" + "name=" + name + ", gender=" + gender + ", type=" + type + ", health=" + health + ", coordinates=" + coordinates + ", sickness=" + sickness + '}';
    }


}
