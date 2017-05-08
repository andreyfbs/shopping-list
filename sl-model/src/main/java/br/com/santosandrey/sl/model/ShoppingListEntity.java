package br.com.santosandrey.sl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    private Long actualVersion;

    @OneToMany(mappedBy = "shoppingListEntity", cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntityList;

    public ShoppingListEntity() {
    }

    public ShoppingListEntity(String name, Long userOwnerId, Date dateCreation, Date dateUpdate, Long userIdLastChanged, Long actualVersion, List<ItemEntity> itemEntityList) {
        this.name = name;
        this.userOwnerId = userOwnerId;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.userIdLastChanged = userIdLastChanged;
        this.actualVersion = actualVersion;
        this.itemEntityList = itemEntityList;
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

    public Long getActualVersion() {
        return actualVersion;
    }
}