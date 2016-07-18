package models;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the md0002_user database table.
 *
 */
@Entity
@Table(name="md0002_user")
public class Md0002User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String address;

    @Column(name="auth_token")
    private String authToken;

    @Column(name="company_name")
    private String companyName;

    @Column(name="def_lang_code")
    private String defLangCode;

    private String fullname;

    @Column(name="last_login_datetimez")
    private Timestamp lastLoginDatetimez;

    @Column(name="otp_flag")
    private String otpFlag;

    private String status;

    @Column(name="summertime_flag")
    private String summertimeFlag;

    @Column(name="timezone_gid")
    private BigInteger timezoneGid;

    private String type;

    @Column(name="user_code")
    private String userCode;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="user_gender")
    private String userGender;

    @Column(name="user_phone")
    private String userPhone;

    @Column(name="user_pwd")
    private String userPwd;

    @Column(name="user_pwd_expired_dtz")
    private Timestamp userPwdExpiredDtz;

    //bi-directional many-to-one association to Md0002UserOtp
    @OneToMany(mappedBy="md0002User")
    private List<Md0002UserOtp> md0002UserOtps;

    //bi-directional many-to-one association to Md9008UserRole
    @OneToMany(mappedBy="md0002User")
    private List<Md9008UserRole> md9008UserRoles;

    public Md0002User() {
    }

    public Long getGid() {
        return this.gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDefLangCode() {
        return this.defLangCode;
    }

    public void setDefLangCode(String defLangCode) {
        this.defLangCode = defLangCode;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Timestamp getLastLoginDatetimez() {
        return this.lastLoginDatetimez;
    }

    public void setLastLoginDatetimez(Timestamp lastLoginDatetimez) {
        this.lastLoginDatetimez = lastLoginDatetimez;
    }

    public String getOtpFlag() {
        return this.otpFlag;
    }

    public void setOtpFlag(String otpFlag) {
        this.otpFlag = otpFlag;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummertimeFlag() {
        return this.summertimeFlag;
    }

    public void setSummertimeFlag(String summertimeFlag) {
        this.summertimeFlag = summertimeFlag;
    }

    public BigInteger getTimezoneGid() {
        return this.timezoneGid;
    }

    public void setTimezoneGid(BigInteger timezoneGid) {
        this.timezoneGid = timezoneGid;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return this.userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return this.userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Timestamp getUserPwdExpiredDtz() {
        return this.userPwdExpiredDtz;
    }

    public void setUserPwdExpiredDtz(Timestamp userPwdExpiredDtz) {
        this.userPwdExpiredDtz = userPwdExpiredDtz;
    }

    public List<Md0002UserOtp> getMd0002UserOtps() {
        return this.md0002UserOtps;
    }

    public void setMd0002UserOtps(List<Md0002UserOtp> md0002UserOtps) {
        this.md0002UserOtps = md0002UserOtps;
    }

    public Md0002UserOtp addMd0002UserOtp(Md0002UserOtp md0002UserOtp) {
        getMd0002UserOtps().add(md0002UserOtp);
        md0002UserOtp.setMd0002User(this);

        return md0002UserOtp;
    }

    public Md0002UserOtp removeMd0002UserOtp(Md0002UserOtp md0002UserOtp) {
        getMd0002UserOtps().remove(md0002UserOtp);
        md0002UserOtp.setMd0002User(null);

        return md0002UserOtp;
    }

    public List<Md9008UserRole> getMd9008UserRoles() {
        return this.md9008UserRoles;
    }

    public void setMd9008UserRoles(List<Md9008UserRole> md9008UserRoles) {
        this.md9008UserRoles = md9008UserRoles;
    }

    public Md9008UserRole addMd9008UserRole(Md9008UserRole md9008UserRole) {
        getMd9008UserRoles().add(md9008UserRole);
        md9008UserRole.setMd0002User(this);

        return md9008UserRole;
    }

    public Md9008UserRole removeMd9008UserRole(Md9008UserRole md9008UserRole) {
        getMd9008UserRoles().remove(md9008UserRole);
        md9008UserRole.setMd0002User(null);

        return md9008UserRole;
    }

    // Start Add manual
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Md0002User aux = (Md0002User) obj;
        return (gid == aux.gid);
    }

    public String createToken() {
        authToken = UUID.randomUUID().toString();
        return authToken;
    }

    public void deleteAuthToken() {
        authToken = null;
    }

    // End Add manual

}