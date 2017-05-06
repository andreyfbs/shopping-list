package br.com.santosandrey.sl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean markedChecked;

    private String quantityDescription;

    private Date dateCreation;

    private Date dateUpdate;

    private Long userIdLastChanged;

    private ShoppingListEntity shoppingListEntity;

    public ItemEntity(String name, Boolean markedChecked, String quantityDescription, Date dateCreation, Date dateUpdate, Long userIdLastChanged, ShoppingListEntity shoppingListEntity) {
        this.name = name;
        this.markedChecked = markedChecked;
        this.quantityDescription = quantityDescription;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.userIdLastChanged = userIdLastChanged;
        this.shoppingListEntity = shoppingListEntity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getMarkedChecked() {
        return markedChecked;
    }

    public String getQuantityDescription() {
        return quantityDescription;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public Long getUserIdLastChanged() {
        return userIdLastChanged;
    }

    public ShoppingListEntity getShoppingListEntity() {
        return shoppingListEntity;
    }
}