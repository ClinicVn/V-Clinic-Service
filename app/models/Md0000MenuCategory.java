package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the md0000_menu_category database table.
 * 
 */
@Entity
@Table(name="md0000_menu_category")
@NamedQuery(name="Md0000MenuCategory.findAll", query="SELECT m FROM Md0000MenuCategory m")
public class Md0000MenuCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	@Column(name="cat_code")
	private String catCode;

	@Column(name="cat_index")
	private int catIndex;

	@Column(name="cat_name")
	private String catName;

	private String status;

	private String type;

	//bi-directional many-to-one association to Md0003Menu
	@OneToMany(mappedBy="md0000MenuCategory")
	private List<Md0003Menu> md0003Menus;

	public Md0000MenuCategory() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getCatCode() {
		return this.catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public int getCatIndex() {
		return this.catIndex;
	}

	public void setCatIndex(int catIndex) {
		this.catIndex = catIndex;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Md0003Menu> getMd0003Menus() {
		return this.md0003Menus;
	}

	public void setMd0003Menus(List<Md0003Menu> md0003Menus) {
		this.md0003Menus = md0003Menus;
	}

	public Md0003Menu addMd0003Menus(Md0003Menu md0003Menus) {
		getMd0003Menus().add(md0003Menus);
		md0003Menus.setMd0000MenuCategory(this);

		return md0003Menus;
	}

	public Md0003Menu removeMd0003Menus(Md0003Menu md0003Menus) {
		getMd0003Menus().remove(md0003Menus);
		md0003Menus.setMd0000MenuCategory(null);

		return md0003Menus;
	}

}