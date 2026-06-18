package com.example.JobPortal.Repository;

import com.example.JobPortal.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findAllById(long id);
}
