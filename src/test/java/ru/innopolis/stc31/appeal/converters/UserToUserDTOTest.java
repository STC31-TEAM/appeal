package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.model.entity.User;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles({"test"})
class UserToUserDTOTest {

    @Autowired
    private UserToUserDTO userToUserDTO;

    @Autowired
    private UserDTOToUser userDTOToUser;

    @Test
    void convert() {
        User user = userDTOToUser.convert(MockUtils.makeUserDTO());
        assertEquals( userToUserDTO.convert(user).getLogin(), user.getLogin());
    }
}