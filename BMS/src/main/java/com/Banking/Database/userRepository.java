package com.Banking.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Banking.Models.User;
@Repository
public interface userRepository extends JpaRepository<User, String>
{
	User findUserByUserId(String userId);
	User findUserByName(String Name);
}
