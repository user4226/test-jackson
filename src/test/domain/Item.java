package test.domain;

import java.util.ArrayList;


public class Item {
    public int id;
    public String itemNr;
    public User createdBy;
    public ArrayList<User> associatedWith;

    public Item(int id, String itemNr, User createdBy) {
        this.id = id;
        this.itemNr = itemNr;
        this.createdBy = createdBy;
        associatedWith = null;
    }
    
    public Item(int id, String itemNr, User createdBy, ArrayList<User> associatedWith) {
        this.id = id;
        this.itemNr = itemNr;
        this.createdBy = createdBy;
        this.associatedWith = associatedWith;
    }
}
