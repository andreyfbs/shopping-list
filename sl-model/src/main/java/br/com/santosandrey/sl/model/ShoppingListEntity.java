package br.com.santosandrey.sl.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    private Long currentVersion;

    @OneToMany(mappedBy = "shoppingListEntity", cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntityList;

    public ShoppingListEntity() {
    }

    public ShoppingListEntity(String name, Long userOwnerId, Date dateCreation, Date dateUpdate, Long userIdLastChanged, Long currentVersion) {//, List<ItemEntity> itemEntityList) {
        this.name = name;
        this.userOwnerId = userOwnerId;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.userIdLastChanged = userIdLastChanged;
        this.currentVersion = currentVersion;
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

    public Long getCurrentVersion() {
        return currentVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShoppingListEntity that = (ShoppingListEntity) o;

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
        return "ShoppingListEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userOwnerId=" + userOwnerId +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                ", userIdLastChanged=" + userIdLastChanged +
                ", currentVersion=" + currentVersion +
                ", itemEntityList=" + itemEntityList +
                '}';
    }

    public void setItemEntityList(List<ItemEntity> itemEntityList) {
        this.itemEntityList = itemEntityList;
    }
}