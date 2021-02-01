package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;

@Component
public class TicketDTOToTicket implements Converter<TicketDTO, Ticket>  {

    @Override
    public Ticket convert(TicketDTO source) {
        Ticket ticket=new Ticket();

        ticket.setId(source.getId());
        ticket.setCreatorUserId(source.getIdUser());
        ticket.setCompanyId(source.getIdCompany());
        ticket.setCountryId(source.getIdCountry());
        ticket.setCityId(source.getIdCity());
        ticket.setStreetId(source.getIdStreet());
        ticket.setServiceTypeId(source.getIdTypesServices());
        ticket.setAlbumLinkId(source.getIdAlbumLink());
        ticket.setTitle(source.getTitles());
        ticket.setDescription(source.getDescription());
        ticket.setOpenedOn(source.getOpenDate());
        ticket.setClosedOn(source.getCloseDate());
        ticket.setLikes(source.getCountLikes());
        ticket.setDislikes(source.getCountDisLikes());
        ticket.setStatus(source.getStatus());

        return ticket;
    }

}