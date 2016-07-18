package models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the md8014_notification database table.
 * 
 */
@Entity
@Table(name="md8014_notification")
@NamedQuery(name="Md8014Notification.findAll", query="SELECT m FROM Md8014Notification m")
public class Md8014Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="notification_source")
	private String notificationSource;

	@Column(name="sent_datetimez")
	private Timestamp sentDatetimez;

	private String sentence;

	private String status;

	public Md8014Notification() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getNotificationSource() {
		return this.notificationSource;
	}

	public void setNotificationSource(String notificationSource) {
		this.notificationSource = notificationSource;
	}

	public Timestamp getSentDatetimez() {
		return this.sentDatetimez;
	}

	public void setSentDatetimez(Timestamp sentDatetimez) {
		this.sentDatetimez = sentDatetimez;
	}

	public String getSentence() {
		return this.sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}