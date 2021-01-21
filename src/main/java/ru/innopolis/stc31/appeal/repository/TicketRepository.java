package ru.innopolis.stc31.appeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc31.appeal.model.ModelMock;
import ru.innopolis.stc31.appeal.model.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
