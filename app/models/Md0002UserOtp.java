package models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the md0002_user_otp database table.
 * 
 */
@Entity
@Table(name="md0002_user_otp")
@NamedQuery(name="Md0002UserOtp.findAll", query="SELECT m FROM Md0002UserOtp m")
public class Md0002UserOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="expired_dtz")
	private Timestamp expiredDtz;

	private String otp;

	//bi-directional many-to-one association to Md0002User
	@ManyToOne
	@JoinColumn(name="user_gid")
	private Md0002User md0002User;

	public Md0002UserOtp() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Timestamp getExpiredDtz() {
		return this.expiredDtz;
	}

	public void setExpiredDtz(Timestamp expiredDtz) {
		this.expiredDtz = expiredDtz;
	}

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Md0002User getMd0002User() {
		return this.md0002User;
	}

	public void setMd0002User(Md0002User md0002User) {
		this.md0002User = md0002User;
	}

}