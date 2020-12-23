package ru.innopolis.stc31.appeal;

import ru.innopolis.stc31.appeal.model.dto.UserDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * For generation some mock objects
 *
 * @author Sergey Fomin
 */
public class MockUtils {
    /**
     * @return UserDTO instance
     */
    public static UserDTO makeUserDTO() {
        return new UserDTO(1, "user01", "User 01", "user01@asd.ru", 89129984444L, LocalDate.now(), (short) 1);
    }

    /**
     * @return List of UserDTO objects
     */
    public static List<UserDTO> makeListUserDTO() {
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "User 01", "user01@asd.ru", 89129984444L, LocalDate.now(), (short) 1));
        users.add(new UserDTO(2, "user02", "User 02", "user02@asd.ru", 89129984444L, LocalDate.now(), (short) 1));

        return users;
    }
}
