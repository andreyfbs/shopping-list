package br.com.santosandrey.sl.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoppingListControlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long accountDeviceId;

    private Long listId;

    private Date dateCreation;

    private Date dateUpdate;

    private Long listVersion;

    public ShoppingListControlEntity() {
    }

    public ShoppingListControlEntity(Long userId, Long accountDeviceId, Long listId, Date dateCreation, Date dateUpdate, Long listVersion) {
        this.userId = userId;
        this.accountDeviceId = accountDeviceId;
        this.listId = listId;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.listVersion = listVersion;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountDeviceId() {
        return accountDeviceId;
    }

    public Long getListId() {
        return listId;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public Long getListVersion() {
        return listVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShoppingListControlEntity that = (ShoppingListControlEntity) o;

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
        return "ShoppingListControlEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountDeviceId=" + accountDeviceId +
                ", listId=" + listId +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                ", listVersion=" + listVersion +
                '}';
    }
}