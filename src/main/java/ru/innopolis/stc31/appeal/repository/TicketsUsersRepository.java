package ru.innopolis.stc31.appeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc31.appeal.model.entity.TicketsUsers;

@Repository
public interface TicketsUsersRepository extends JpaRepository<TicketsUsers, Integer> {
}
