package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;

@Component
public class TicketToTicketDTO implements Converter<Ticket, TicketDTO> {

    @Override
    public TicketDTO convert(Ticket source) {
        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(source.getId());
        ticketDTO.setIdUser(source.getCreatorUserId());
        ticketDTO.setIdCompany(source.getCompanyId());
        ticketDTO.setIdCountry(source.getCountryId());
        ticketDTO.setIdCity(source.getCityId());
        ticketDTO.setIdStreet(source.getStreetId());
        ticketDTO.setIdTypesServices(source.getServiceTypeId());
        ticketDTO.setIdAlbumLink(source.getAlbumLinkId());
        ticketDTO.setTitles(source.getTitle());
        ticketDTO.setDescription(source.getDescription());
        ticketDTO.setOpenDate(source.getOpenedOn());
        ticketDTO.setCloseDate(source.getClosedOn());
        ticketDTO.setCountLikes(source.getLikes());
        ticketDTO.setCountDisLikes(source.getDislikes());
        ticketDTO.setStatus(source.getStatus());

        return ticketDTO;
    }

}
