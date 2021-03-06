package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.converters.StreetDTOToStreet;
import ru.innopolis.stc31.appeal.converters.StreetToStreetDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.repository.StreetRepository;
import ru.innopolis.stc31.appeal.services.StreetService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles({"test"})
class StreetControllerTest {

    @Spy
    private StreetService streetService;

    @Spy
    private StreetRepository streetRepository;

    @Spy
    private StreetDTOToStreet streetDTOToStreet;

    @Spy
    private StreetToStreetDTO streetToStreetDTO;

    @InjectMocks
    private StreetController streetController;

    @Test
    void all() {
        List<StreetDTO> streetDTOList = MockUtils.makeListStreetDTO(4);
        when(streetService.getStreetList()).thenReturn(streetDTOList);

        assertEquals(streetDTOList.size(), streetController.getAllStreets().size());
        assertEquals(streetDTOList.get(1).getStreetName(), streetController.getAllStreets().get(1).getStreetName());
    }

    @Test
    void createWithOk() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();
        Street street = streetDTOToStreet.convert(streetDTO);
        street.setId(1);
        when(streetService.createStreet(streetDTO)).thenReturn(street);

        ResponseEntity<StreetDTO> responseEntity = streetController.createStreet(streetDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStreetName(), streetDTO.getStreetName());
    }

    @Test
    void createWithFail() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();
        Street street = null;
        when(streetService.createStreet(streetDTO)).thenReturn(street);

        ResponseEntity<StreetDTO> responseEntity = streetController.createStreet(streetDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }

    @Test
    void deleteWithOk() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(streetService.deleteStreet(streetDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = streetController.deleteStreet(streetDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getResult(), successModel.getResult());
    }

    @Test
    void deleteWithFail() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();

        when(streetService.deleteStreet(streetDTO)).thenReturn(false);

        ResponseEntity<SuccessModel> responseEntity = streetController.deleteStreet(streetDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }
}