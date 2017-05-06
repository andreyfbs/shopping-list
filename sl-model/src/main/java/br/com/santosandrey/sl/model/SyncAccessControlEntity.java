package br.com.santosandrey.sl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SyncAccessControlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long accountDeviceId;

    private Long listId;

    private Date dateCreation;

    private Date dateUpdate;

    private String modificationStatus;

    public SyncAccessControlEntity() {
    }

    public SyncAccessControlEntity(Long userId, Long accountDeviceId, Long listId, Date dateCreation, Date dateUpdate, String modificationStatus) {
        this.userId = userId;
        this.accountDeviceId = accountDeviceId;
        this.listId = listId;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.modificationStatus = modificationStatus;
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

    public String getModificationStatus() {
        return modificationStatus;
    }
}