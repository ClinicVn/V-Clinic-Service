package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the md9008_user_type_permissions database table.
 * 
 */
@Entity
@Table(name="md9008_user_type_permissions")
@NamedQuery(name="Md9008UserTypePermission.findAll", query="SELECT m FROM Md9008UserTypePermission m")
public class Md9008UserTypePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="menu_code")
	private String menuCode;

	@Column(name="user_type")
	private String userType;

	public Md9008UserTypePermission() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}