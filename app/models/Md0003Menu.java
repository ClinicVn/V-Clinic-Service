package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the md0003_menu database table.
 *
 */
@Entity
@Table(name="md0003_menu")
@NamedQuery(name="Md0003Menu.findAll", query="SELECT m FROM Md0003Menu m")
public class Md0003Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private BigInteger gid;

    @Column(name="action_url")
    private String actionUrl;

    @Column(name="is_need_param")
    private String isNeedParam;

    @Column(name="menu_index")
    private int menuIndex;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="module_gid")
    private BigInteger moduleGid;

    private String status;

    private String type;

    //bi-directional many-to-one association to Md0000MenuCategory
    @ManyToOne
    @JoinColumn(name="cat_gid")
    private Md0000MenuCategory md0000MenuCategory;

    //bi-directional many-to-one association to Md0003MenuRelation
    @OneToMany(mappedBy="md0003Menu1")
    private List<Md0003MenuRelation> md0003MenuRelations1;

    //bi-directional many-to-one association to Md0003MenuRelation
    @OneToMany(mappedBy="md0003Menu2")
    private List<Md0003MenuRelation> md0003MenuRelations2;

    //bi-directional many-to-one association to Md9011RoleMenu
    @OneToMany(mappedBy="md0003Menu")
    private List<Md9011RoleMenu> md9011RoleMenus;

    public Md0003Menu() {
    }

    public BigInteger getGid() {
        return this.gid;
    }

    public void setGid(BigInteger gid) {
        this.gid = gid;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getIsNeedParam() {
        return this.isNeedParam;
    }

    public void setIsNeedParam(String isNeedParam) {
        this.isNeedParam = isNeedParam;
    }

    public int getMenuIndex() {
        return this.menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public BigInteger getModuleGid() {
        return this.moduleGid;
    }

    public void setModuleGid(BigInteger moduleGid) {
        this.moduleGid = moduleGid;
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

    public Md0000MenuCategory getMd0000MenuCategory() {
        return this.md0000MenuCategory;
    }

    public void setMd0000MenuCategory(Md0000MenuCategory md0000MenuCategory) {
        this.md0000MenuCategory = md0000MenuCategory;
    }

    public List<Md0003MenuRelation> getMd0003MenuRelations1() {
        return this.md0003MenuRelations1;
    }

    public void setMd0003MenuRelations1(List<Md0003MenuRelation> md0003MenuRelations1) {
        this.md0003MenuRelations1 = md0003MenuRelations1;
    }

    public Md0003MenuRelation addMd0003MenuRelations1(Md0003MenuRelation md0003MenuRelations1) {
        getMd0003MenuRelations1().add(md0003MenuRelations1);
        md0003MenuRelations1.setMd0003Menu1(this);

        return md0003MenuRelations1;
    }

    public Md0003MenuRelation removeMd0003MenuRelations1(Md0003MenuRelation md0003MenuRelations1) {
        getMd0003MenuRelations1().remove(md0003MenuRelations1);
        md0003MenuRelations1.setMd0003Menu1(null);

        return md0003MenuRelations1;
    }

    public List<Md0003MenuRelation> getMd0003MenuRelations2() {
        return this.md0003MenuRelations2;
    }

    public void setMd0003MenuRelations2(List<Md0003MenuRelation> md0003MenuRelations2) {
        this.md0003MenuRelations2 = md0003MenuRelations2;
    }

    public Md0003MenuRelation addMd0003MenuRelations2(Md0003MenuRelation md0003MenuRelations2) {
        getMd0003MenuRelations2().add(md0003MenuRelations2);
        md0003MenuRelations2.setMd0003Menu2(this);

        return md0003MenuRelations2;
    }

    public Md0003MenuRelation removeMd0003MenuRelations2(Md0003MenuRelation md0003MenuRelations2) {
        getMd0003MenuRelations2().remove(md0003MenuRelations2);
        md0003MenuRelations2.setMd0003Menu2(null);

        return md0003MenuRelations2;
    }

    public List<Md9011RoleMenu> getMd9011RoleMenus() {
        return this.md9011RoleMenus;
    }

    public void setMd9011RoleMenus(List<Md9011RoleMenu> md9011RoleMenus) {
        this.md9011RoleMenus = md9011RoleMenus;
    }

    public Md9011RoleMenu addMd9011RoleMenus(Md9011RoleMenu md9011RoleMenus) {
        getMd9011RoleMenus().add(md9011RoleMenus);
        md9011RoleMenus.setMd0003Menu(this);

        return md9011RoleMenus;
    }

    public Md9011RoleMenu removeMd9011RoleMenus(Md9011RoleMenu md9011RoleMenus) {
        getMd9011RoleMenus().remove(md9011RoleMenus);
        md9011RoleMenus.setMd0003Menu(null);

        return md9011RoleMenus;
    }

}