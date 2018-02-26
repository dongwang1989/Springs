package cn.zzdz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.zzdz.domain.User;
public interface UserJpaRepository extends JpaRepository<User,Integer> {
	@Query("from User u where u.username=:username and u.pwd=:pwd")
    User getUser(@Param("username") String username,@Param("pwd") String pwd);
	
	@Query(value="select * from User where Username=?1 and pwd=?2 ",nativeQuery=true)
	List<User> findUserinfo(String username,String pwd);
	/*@Query("update User set username=?1 where id=?2")
    void updateUsernameById(String username,Long id);  */
	@Query("select u from User u where u.username=:username")
     User findUserinfoByuser(@Param("username") String username);
	@Query(value="select * from User where username=?1",nativeQuery=true)
	List<User> findUserinfo2(String username);
	/*@Query("insert into User (name,age) values (?1,?2) ")
	int addUser(String name,int age);*/
	
	@Query(value="select * from User where username=?1",nativeQuery=true)
    User findUserinfoByuser3(String username);
	@Modifying
	@Query(value="delete from User where id=?1",nativeQuery=true)
    void delUserInfo(String id);
	
}
