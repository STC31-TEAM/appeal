package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.converters.StreetDTOToStreet;
import ru.innopolis.stc31.appeal.converters.StreetToStreetDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.repository.StreetRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles({"test"})
class StreetServiceImplTest {

    @Mock
    private StreetRepository streetRepository;

    @Spy
    private StreetDTOToStreet streetDTOToStreet;

    @Spy
    private StreetToStreetDTO streetToStreetDTO;

    @InjectMocks
    private StreetServiceImpl streetServiceImpl;

    @Test
    void getStreetList() {
        List<Street> streeList = new ArrayList<>();
        MockUtils.makeListStreetDTO(4).stream().forEach( streetDTO -> {
            streeList.add(streetDTOToStreet.convert(streetDTO));
        } );
        when(streetRepository.findAll()).thenReturn(streeList);

        assertEquals(streeList.size(), streetServiceImpl.getStreetList().size());
        assertEquals(streeList.get(1).getStreetName(), streetServiceImpl.getStreetList().get(1).getStreetName());
    }

    @Test
    void createStreet() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();
        Street street = streetDTOToStreet.convert(streetDTO);
        street.setId(1);
        when(streetRepository.save(streetDTOToStreet.convert(streetDTO))).thenReturn(street);

        assertEquals(streetServiceImpl.createStreet(streetDTO).getId(), street.getId());
    }

    @Test
    void deleteStreet() {
        StreetDTO streetDTO = MockUtils.makeStreetDTO();
        assertEquals(streetServiceImpl.deleteStreet(streetDTO), true);
        verify(streetRepository).deleteById(any());
    }
}