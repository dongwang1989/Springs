package cn.zzdz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import cn.zzdz.domain.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
	@Query("from User u where u.username=:username and u.pwd=:pwd")
	public User getUser(@Param("username") String username, @Param("pwd") String pwd);

	@Query(value = "select * from User where Username=?1 and pwd=?2 ", nativeQuery = true)
	public List<User> findUserinfo(String username, String pwd);

	@Query("select u from User u where u.username=:username")
	public User findUserinfoByuser(@Param("username") String username);

	@Query(value = "select * from User where username=?1", nativeQuery = true)
	public List<User> findUserinfo2(String username);

	@Query(value = "select * from User where username=?1", nativeQuery = true)
	public User findUserinfoByuser3(String username);

	@Modifying
	@Query(value = "delete from User where id=?1", nativeQuery = true)
	public int delUserInfo(int id);

}
