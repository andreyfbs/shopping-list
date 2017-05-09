package br.com.santosandrey.sl.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    private ShoppingListEntity shoppingListEntity;

    @Transient
    private Long idDevice;

    public ItemEntity(String name, Boolean markedChecked, String quantityDescription, Date dateCreation, Date dateUpdate, ShoppingListEntity shoppingListEntity) {
        this.name = name;
        this.markedChecked = markedChecked;
        this.quantityDescription = quantityDescription;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.shoppingListEntity = shoppingListEntity;
    }

    public ItemEntity(String name, Boolean markedChecked, String quantityDescription, Date dateCreation, Date dateUpdate, ShoppingListEntity shoppingListEntity, Long idDevice) {
        this.name = name;
        this.markedChecked = markedChecked;
        this.quantityDescription = quantityDescription;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.shoppingListEntity = shoppingListEntity;
        this.idDevice = idDevice;
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

    public ShoppingListEntity getShoppingListEntity() {
        return shoppingListEntity;
    }

    public Long getIdDevice() {
        return idDevice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", markedChecked=" + markedChecked +
                ", quantityDescription='" + quantityDescription + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                ", shoppingListEntity=" + shoppingListEntity +
                '}';
    }
}