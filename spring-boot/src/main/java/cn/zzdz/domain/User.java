package cn.zzdz.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
// @Table(name = "t_user")
@NamedQueries({ @NamedQuery(name = "findUserWithId", query = "SELECT u FROM User u "),
		@NamedQuery(name = "findUserWithName", query = "SELECT u FROM User u WHERE u.name = :name") })
public class User implements Serializable {
	/**
	 * EntityManager em = emf.createEntityManager(); Query query =
	 * em.createNamedQuery("finduser_permission");//根据User实体中定义的命名查询
	 * query.setParameter("name", "李坏"); List<User> users = query.getResultList();
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	private String name;
	private int age;
	private String sex;
	private String username;
	private String pwd;
	@ElementCollection
	@CollectionTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "permission")
	private Set<String> permission = new HashSet<>();

	public Set<String> getPermission() {
		return permission;
	}

	public void setPermissions(Set<String> permission) {
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
