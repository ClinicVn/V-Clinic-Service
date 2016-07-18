package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the md9011_role_menu database table.
 * 
 */
@Entity
@Table(name="md9011_role_menu")
@NamedQuery(name="Md9011RoleMenu.findAll", query="SELECT m FROM Md9011RoleMenu m")
public class Md9011RoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="role_menu_index")
	private int roleMenuIndex;

	//bi-directional many-to-one association to Md0003Menu
	@ManyToOne
	@JoinColumn(name="menu_gid")
	private Md0003Menu md0003Menu;

	//bi-directional many-to-one association to Md0006Role
	@ManyToOne
	@JoinColumn(name="role_gid")
	private Md0006Role md0006Role;

	public Md9011RoleMenu() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public int getRoleMenuIndex() {
		return this.roleMenuIndex;
	}

	public void setRoleMenuIndex(int roleMenuIndex) {
		this.roleMenuIndex = roleMenuIndex;
	}

	public Md0003Menu getMd0003Menu() {
		return this.md0003Menu;
	}

	public void setMd0003Menu(Md0003Menu md0003Menu) {
		this.md0003Menu = md0003Menu;
	}

	public Md0006Role getMd0006Role() {
		return this.md0006Role;
	}

	public void setMd0006Role(Md0006Role md0006Role) {
		this.md0006Role = md0006Role;
	}

}