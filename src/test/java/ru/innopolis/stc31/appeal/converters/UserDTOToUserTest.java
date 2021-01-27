package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"test"})
class UserDTOToUserTest {

    @Autowired
    private UserDTOToUser userDTOToUser;

    @Test
    void convert() {
        UserDTO userDTO = MockUtils.makeUserDTO();
        assertEquals( userDTO.getLogin(), userDTOToUser.convert(userDTO).getLogin());
    }
}