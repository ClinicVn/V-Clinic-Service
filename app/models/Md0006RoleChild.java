package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the md0006_role_child database table.
 * 
 */
@Entity
@Table(name="md0006_role_child")
@NamedQuery(name="Md0006RoleChild.findAll", query="SELECT m FROM Md0006RoleChild m")
public class Md0006RoleChild implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="role_child_index")
	private int roleChildIndex;

	//bi-directional many-to-one association to Md0006Role
	@ManyToOne
	@JoinColumn(name="role_gid")
	private Md0006Role md0006Role1;

	//bi-directional many-to-one association to Md0006Role
	@ManyToOne
	@JoinColumn(name="role_child_gid")
	private Md0006Role md0006Role2;

	public Md0006RoleChild() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public int getRoleChildIndex() {
		return this.roleChildIndex;
	}

	public void setRoleChildIndex(int roleChildIndex) {
		this.roleChildIndex = roleChildIndex;
	}

	public Md0006Role getMd0006Role1() {
		return this.md0006Role1;
	}

	public void setMd0006Role1(Md0006Role md0006Role1) {
		this.md0006Role1 = md0006Role1;
	}

	public Md0006Role getMd0006Role2() {
		return this.md0006Role2;
	}

	public void setMd0006Role2(Md0006Role md0006Role2) {
		this.md0006Role2 = md0006Role2;
	}

}