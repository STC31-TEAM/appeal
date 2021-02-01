package ru.innopolis.stc31.appeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc31.appeal.model.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT * FROM tickets " +
            "WHERE close_date IS NOT NULL", nativeQuery = true)
    List<Ticket> findClosedTickets();

    @Query(value = "SELECT * FROM tickets " +
            "WHERE close_date IS NULL " +
            "ORDER BY open_date DESC", nativeQuery = true)
    List<Ticket> ticketsSortedByCreationTime();
}
