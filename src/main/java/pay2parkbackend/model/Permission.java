package com.example.pay2parkbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @Column(name = "permission_id", nullable = false)
    private Integer id;

    @Column(name = "permission_name", nullable = false, length = 50)
    private String permissionName;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "allow_add", nullable = false)
    private Integer allowAdd;

    @Column(name = "allow_edit", nullable = false)
    private Integer allowEdit;

    @Column(name = "allow_delete", nullable = false)
    private Integer allowDelete;

    @Column(name = "allow_export", nullable = false)
    private Integer allowExport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAllowAdd() {
        return allowAdd;
    }

    public void setAllowAdd(Integer allowAdd) {
        this.allowAdd = allowAdd;
    }

    public Integer getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Integer allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Integer getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Integer allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Integer getAllowExport() {
        return allowExport;
    }

    public void setAllowExport(Integer allowExport) {
        this.allowExport = allowExport;
    }

}