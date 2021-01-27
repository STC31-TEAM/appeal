package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"test"})
class StreetToStreetDTOTest {

    @Autowired
    private StreetDTOToStreet streetDTOToStreet;

    @Autowired
    private StreetToStreetDTO streetToStreetDTO;

    @Test
    void convert() {
        Street street = streetDTOToStreet.convert(MockUtils.makeStreetDTO());
        assertEquals( streetToStreetDTO.convert(street).getStreetName(), street.getStreetName());
    }
}