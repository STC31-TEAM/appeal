package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles({"test"})
class StreetDTOToStreetTest {

    @Autowired
    private StreetDTOToStreet streetDTOToStreet;

    @Test
    void convert() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();
        assertEquals( streetDTOToStreet.convert(streetDTO).getStreetName(), streetDTO.getStreetName());
    }
}