package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_otp database table.
 * 
 */
@Entity
@Table(name="user_otp")
public class UserOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expired_dtz")
	private Date expiredDtz;

	private String otp;

	@Column(name="user_gid")
	private int userGid;

	public UserOtp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpiredDtz() {
		return this.expiredDtz;
	}

	public void setExpiredDtz(Date expiredDtz) {
		this.expiredDtz = expiredDtz;
	}

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getUserGid() {
		return this.userGid;
	}

	public void setUserGid(int userGid) {
		this.userGid = userGid;
	}

}