package com.perkins.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Role {
	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy=GenerationType.IDENTITY,generator="Mysql")
	    private Long id;

	    @Column(name = "ROLE_NAME")
	    private String roleName;

	    @Column(name = "ROLE_CODE")
	    private String roleCode;

	    @Column(name = "ROLE_DESC")
	    private String roleDesc;

	    @Column(name = "ROLE_TYPE")
	    private String roleType;

	    @Column(name = "DELETED")
	    private String deleted;

	    /**
	     * @return ID
	     */
	    public Long getId() {
	        return id;
	    }

	    /**
	     * @param id
	     */
	    public void setId(Long id) {
	        this.id = id;
	    }

	    /**
	     * @return ROLE_NAME
	     */
	    public String getRoleName() {
	        return roleName;
	    }

	    /**
	     * @param roleName
	     */
	    public void setRoleName(String roleName) {
	        this.roleName = roleName;
	    }

	    /**
	     * @return ROLE_CODE
	     */
	    public String getRoleCode() {
	        return roleCode;
	    }

	    /**
	     * @param roleCode
	     */
	    public void setRoleCode(String roleCode) {
	        this.roleCode = roleCode;
	    }

	    /**
	     * @return ROLE_DESC
	     */
	    public String getRoleDesc() {
	        return roleDesc;
	    }

	    /**
	     * @param roleDesc
	     */
	    public void setRoleDesc(String roleDesc) {
	        this.roleDesc = roleDesc;
	    }

	    /**
	     * @return ROLE_TYPE
	     */
	    public String getRoleType() {
	        return roleType;
	    }

	    /**
	     * @param roleType
	     */
	    public void setRoleType(String roleType) {
	        this.roleType = roleType;
	    }

	    /**
	     * @return DELETED
	     */
	    public String getDeleted() {
	        return deleted;
	    }

	    /**
	     * @param deleted
	     */
	    public void setDeleted(String deleted) {
	        this.deleted = deleted;
	    }
}
