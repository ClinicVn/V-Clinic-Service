package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the md0006_role database table.
 * 
 */
@Entity
@Table(name="md0006_role")
@NamedQuery(name="Md0006Role.findAll", query="SELECT m FROM Md0006Role m")
public class Md0006Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="role_code")
	private String roleCode;

	@Column(name="role_index")
	private short roleIndex;

	@Column(name="role_name")
	private String roleName;

	private String status;

	//bi-directional many-to-one association to Md0006RoleChild
	@OneToMany(mappedBy="md0006Role1")
	private List<Md0006RoleChild> md0006RoleChilds1;

	//bi-directional many-to-one association to Md0006RoleChild
	@OneToMany(mappedBy="md0006Role2")
	private List<Md0006RoleChild> md0006RoleChilds2;

	//bi-directional many-to-one association to Md9008UserRole
	@OneToMany(mappedBy="md0006Role")
	private List<Md9008UserRole> md9008UserRoles;

	//bi-directional many-to-one association to Md9011RoleMenu
	@OneToMany(mappedBy="md0006Role")
	private List<Md9011RoleMenu> md9011RoleMenus;

	public Md0006Role() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public short getRoleIndex() {
		return this.roleIndex;
	}

	public void setRoleIndex(short roleIndex) {
		this.roleIndex = roleIndex;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Md0006RoleChild> getMd0006RoleChilds1() {
		return this.md0006RoleChilds1;
	}

	public void setMd0006RoleChilds1(List<Md0006RoleChild> md0006RoleChilds1) {
		this.md0006RoleChilds1 = md0006RoleChilds1;
	}

	public Md0006RoleChild addMd0006RoleChilds1(Md0006RoleChild md0006RoleChilds1) {
		getMd0006RoleChilds1().add(md0006RoleChilds1);
		md0006RoleChilds1.setMd0006Role1(this);

		return md0006RoleChilds1;
	}

	public Md0006RoleChild removeMd0006RoleChilds1(Md0006RoleChild md0006RoleChilds1) {
		getMd0006RoleChilds1().remove(md0006RoleChilds1);
		md0006RoleChilds1.setMd0006Role1(null);

		return md0006RoleChilds1;
	}

	public List<Md0006RoleChild> getMd0006RoleChilds2() {
		return this.md0006RoleChilds2;
	}

	public void setMd0006RoleChilds2(List<Md0006RoleChild> md0006RoleChilds2) {
		this.md0006RoleChilds2 = md0006RoleChilds2;
	}

	public Md0006RoleChild addMd0006RoleChilds2(Md0006RoleChild md0006RoleChilds2) {
		getMd0006RoleChilds2().add(md0006RoleChilds2);
		md0006RoleChilds2.setMd0006Role2(this);

		return md0006RoleChilds2;
	}

	public Md0006RoleChild removeMd0006RoleChilds2(Md0006RoleChild md0006RoleChilds2) {
		getMd0006RoleChilds2().remove(md0006RoleChilds2);
		md0006RoleChilds2.setMd0006Role2(null);

		return md0006RoleChilds2;
	}

	public List<Md9008UserRole> getMd9008UserRoles() {
		return this.md9008UserRoles;
	}

	public void setMd9008UserRoles(List<Md9008UserRole> md9008UserRoles) {
		this.md9008UserRoles = md9008UserRoles;
	}

	public Md9008UserRole addMd9008UserRole(Md9008UserRole md9008UserRole) {
		getMd9008UserRoles().add(md9008UserRole);
		md9008UserRole.setMd0006Role(this);

		return md9008UserRole;
	}

	public Md9008UserRole removeMd9008UserRole(Md9008UserRole md9008UserRole) {
		getMd9008UserRoles().remove(md9008UserRole);
		md9008UserRole.setMd0006Role(null);

		return md9008UserRole;
	}

	public List<Md9011RoleMenu> getMd9011RoleMenus() {
		return this.md9011RoleMenus;
	}

	public void setMd9011RoleMenus(List<Md9011RoleMenu> md9011RoleMenus) {
		this.md9011RoleMenus = md9011RoleMenus;
	}

	public Md9011RoleMenu addMd9011RoleMenus(Md9011RoleMenu md9011RoleMenus) {
		getMd9011RoleMenus().add(md9011RoleMenus);
		md9011RoleMenus.setMd0006Role(this);

		return md9011RoleMenus;
	}

	public Md9011RoleMenu removeMd9011RoleMenus(Md9011RoleMenu md9011RoleMenus) {
		getMd9011RoleMenus().remove(md9011RoleMenus);
		md9011RoleMenus.setMd0006Role(null);

		return md9011RoleMenus;
	}

}