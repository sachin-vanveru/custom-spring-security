package com.vvsolution.login.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.vvsolution.login.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("select u from Users u where u.user_id= :userid")
	public Users getUserByUserids(@Param("userid") String userid);
	
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    public Users getUserByUsername(@Param("username") String username);
	
}
