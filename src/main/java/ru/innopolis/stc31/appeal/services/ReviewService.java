package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class ReviewService {

    private final TicketService ticketService;

    public Map<String, TicketDTO> getAllTickets(){
        List<TicketDTO> ticketDTOList = ticketService.getTicketList();
        Map<String,TicketDTO> ticketDTOMap = new HashMap<>();
        for (TicketDTO ticketDTO: ticketDTOList){
            ticketDTOMap.put(ticketDTO.getTitles(), ticketDTO );
        }
        return ticketDTOMap;
    }
}
