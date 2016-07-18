package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the md0003_menu_relation database table.
 * 
 */
@Entity
@Table(name="md0003_menu_relation")
@NamedQuery(name="Md0003MenuRelation.findAll", query="SELECT m FROM Md0003MenuRelation m")
public class Md0003MenuRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	private String type;

	//bi-directional many-to-one association to Md0003Menu
	@ManyToOne
	@JoinColumn(name="menu_child_gid")
	private Md0003Menu md0003Menu1;

	//bi-directional many-to-one association to Md0003Menu
	@ManyToOne
	@JoinColumn(name="menu_gid")
	private Md0003Menu md0003Menu2;

	public Md0003MenuRelation() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Md0003Menu getMd0003Menu1() {
		return this.md0003Menu1;
	}

	public void setMd0003Menu1(Md0003Menu md0003Menu1) {
		this.md0003Menu1 = md0003Menu1;
	}

	public Md0003Menu getMd0003Menu2() {
		return this.md0003Menu2;
	}

	public void setMd0003Menu2(Md0003Menu md0003Menu2) {
		this.md0003Menu2 = md0003Menu2;
	}

}