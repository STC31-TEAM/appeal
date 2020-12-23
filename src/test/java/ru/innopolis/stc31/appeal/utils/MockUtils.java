package ru.innopolis.stc31.appeal.utils;

import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.utils.random.RandomUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return new UserDTO(
                RandomUtils.makeId(),
                RandomUtils.makeLogin(),
                RandomUtils.makeUsername(),
                RandomUtils.makeEmail(),
                RandomUtils.getRandomPhone(),
                LocalDate.now(),
                (short) RandomUtils.getRandomValue(0, 2));
    }

    /**
     * @return List of UserDTO objects
     */
    public static List<UserDTO> makeListUserDTO(int size) {
        return Stream.generate(MockUtils::makeUserDTO).limit(size).collect(Collectors.toList());
    }
}
