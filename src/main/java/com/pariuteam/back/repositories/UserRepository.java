package com.pariuteam.back.repositories;


import com.pariuteam.back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findByMail(String mail);
}
