package com.akhil.sampleaudit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

@Entity
public class Bar {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="name")
	private String name;

	@Transient
	private String operation;

//	@Column(name="timestamp")
//	private long timestamp;
	
	private String createdBy;
	private Date createdOn;
	
	private String updatedBy;
	private Date updatedOn;
	
	public Bar() {
		super();
	}

	public Bar(String name) {
		super();
		this.name = name;
	}
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@PrePersist
	public void onPrePersist() {
		audit("INSERT");
	}

	@PreUpdate
	public void onPreUpdate() {
		audit("UPDATE");
	}

//	@PreRemove
//	public void onPreRemove() {
//		audit("DELETE");
//	}

	private void audit(String operation) {
		if(operation.equals("UPDATE")) {
			//set only updateOn and updateBy
			String userId = "admin"; // here service method has to be called for getting username
			System.out.println("Updated ---> syso");
			setUpdatedBy(userId);
			Date dateNow = new Date();
			setUpdatedOn(dateNow);
		} else if (operation.equals("INSERT")) {
			// set only createdOn and createdBy
			String userId = "admin";
			setCreatedBy(userId);
			Date dateNow = new Date();
			setCreatedOn(dateNow);
		}
//		setOperation(operation);
//		setTimestamp((new Date()).getTime());
	}

}
