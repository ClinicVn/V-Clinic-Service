package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_history database table.
 * 
 */
@Entity
@Table(name="user_history")
public class UserHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="user_gid")
	private int userGid;

	@Column(name="user_pwd_from")
	private String userPwdFrom;

	@Column(name="user_pwd_to")
	private String userPwdTo;

	public UserHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserGid() {
		return this.userGid;
	}

	public void setUserGid(int userGid) {
		this.userGid = userGid;
	}

	public String getUserPwdFrom() {
		return this.userPwdFrom;
	}

	public void setUserPwdFrom(String userPwdFrom) {
		this.userPwdFrom = userPwdFrom;
	}

	public String getUserPwdTo() {
		return this.userPwdTo;
	}

	public void setUserPwdTo(String userPwdTo) {
		this.userPwdTo = userPwdTo;
	}

}