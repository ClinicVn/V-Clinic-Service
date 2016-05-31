package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the last_update database table.
 * 
 */
@Entity
@Table(name="last_update")
public class LastUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="created_by_gid")
	private int createdByGid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_datetime")
	private Date createdDatetime;

	@Column(name="deleted_by_gid")
	private int deletedByGid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_datetime")
	private Date deletedDatetime;

	@Column(name="table_name")
	private String tableName;

	@Column(name="updated_by_gid")
	private int updatedByGid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_datetime")
	private Date updatedDatetime;

	public LastUpdate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedByGid() {
		return this.createdByGid;
	}

	public void setCreatedByGid(int createdByGid) {
		this.createdByGid = createdByGid;
	}

	public Date getCreatedDatetime() {
		return this.createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public int getDeletedByGid() {
		return this.deletedByGid;
	}

	public void setDeletedByGid(int deletedByGid) {
		this.deletedByGid = deletedByGid;
	}

	public Date getDeletedDatetime() {
		return this.deletedDatetime;
	}

	public void setDeletedDatetime(Date deletedDatetime) {
		this.deletedDatetime = deletedDatetime;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getUpdatedByGid() {
		return this.updatedByGid;
	}

	public void setUpdatedByGid(int updatedByGid) {
		this.updatedByGid = updatedByGid;
	}

	public Date getUpdatedDatetime() {
		return this.updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

}