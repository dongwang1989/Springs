package cn.zzdz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.zzdz.domain.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
	@Query("from User u where u.username=:username and u.pwd=:pwd")
	public User getUser(@Param("username") String username, @Param("pwd") String pwd);

	@Query("select u from User u where u.username=:username")
	public User findUserinfoBylog(@Param("username") String username);

	@Query("select u from User u where u.username=:username")
	public User findUserInfoByuser(@Param("username") String username);

	@Modifying
	@Query("delete from User where id=:id")
	public int delUserInfo(@Param("id") int id);

}
