package com.perkins.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.perkins.util.JsonDateSerializer;

public abstract class IDEntity implements Serializable{
	 
	    /**
	      * 
	      */
	    private static final long serialVersionUID = 1L;

		public abstract Long getId();

	    public abstract void setId(Long id);

	    /**
	     * 更新时间
	     */
	    @Column(name = "UPDATE_DATE")
	    private Date updateDate;

	    @JsonSerialize(using = JsonDateSerializer.class)
	    public Date getUpdateDate() {
	        return updateDate;
	    }

	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;
	    }

	    /**
	     * 创建时间
	     */
	    @Column(name = "CREATE_DATE")
	    private Date createDate;

	    @JsonSerialize(using = JsonDateSerializer.class)
	    public Date getCreateDate() {
	        return createDate;
	    }

	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;
	    }

	    /**
	     * 创建人
	     */
	    @Column(name = "CREATE_BY")
	    private String createBy;

	    public String getCreateBy() {
	        return createBy;
	    }

	    public void setCreateBy(String createBy) {
	        this.createBy = createBy;
	    }

	    /**
	     * 更新人
	     */
	    @Column(name = "UPDATE_BY")
	    private String updateBy;

	    public String getUpdateBy() {
	        return updateBy;
	    }

	    public void setUpdateBy(String updateBy) {
	        this.updateBy = updateBy;
	    }
}
