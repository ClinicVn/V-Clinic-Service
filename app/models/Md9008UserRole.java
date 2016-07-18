package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the md9008_user_roles database table.
 * 
 */
@Entity
@Table(name="md9008_user_roles")
@NamedQuery(name="Md9008UserRole.findAll", query="SELECT m FROM Md9008UserRole m")
public class Md9008UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="user_roles_index")
	private int userRolesIndex;

	//bi-directional many-to-one association to Md0002User
	@ManyToOne
	@JoinColumn(name="user_gid")
	private Md0002User md0002User;

	//bi-directional many-to-one association to Md0006Role
	@ManyToOne
	@JoinColumn(name="role_gid")
	private Md0006Role md0006Role;

	public Md9008UserRole() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public int getUserRolesIndex() {
		return this.userRolesIndex;
	}

	public void setUserRolesIndex(int userRolesIndex) {
		this.userRolesIndex = userRolesIndex;
	}

	public Md0002User getMd0002User() {
		return this.md0002User;
	}

	public void setMd0002User(Md0002User md0002User) {
		this.md0002User = md0002User;
	}

	public Md0006Role getMd0006Role() {
		return this.md0006Role;
	}

	public void setMd0006Role(Md0006Role md0006Role) {
		this.md0006Role = md0006Role;
	}

}