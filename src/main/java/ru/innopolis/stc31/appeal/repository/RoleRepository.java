package ru.innopolis.stc31.appeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc31.appeal.model.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {

//    List<Role> findByUserId(long userId);
    Role findById(long id);
    Role findByTitle(String title);
}

