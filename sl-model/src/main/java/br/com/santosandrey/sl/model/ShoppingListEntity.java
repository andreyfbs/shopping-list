package br.com.santosandrey.sl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long userOwnerId;

    private Date dateCreation;

    private Date dateUpdate;

    private Long userIdLastChanged;

    public ShoppingListEntity() {
    }

    public ShoppingListEntity(String name, Long userOwnerId, Date dateCreation, Date dateUpdate, Long userIdLastChanged) {
        this.name = name;
        this.userOwnerId = userOwnerId;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.userIdLastChanged = userIdLastChanged;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getUserOwnerId() {
        return userOwnerId;
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
}