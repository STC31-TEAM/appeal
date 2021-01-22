package ru.innopolis.stc31.appeal.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleErrorsTest {

    @Test
    void getErrorMassage() {
        ErrorMessage errorMessage = new ErrorMessage(-1,"errorMessage");
        RoleErrors roleErrors = new RoleErrors(errorMessage);
        assertEquals(errorMessage.getErrorMessage(), roleErrors.getErrorMassage().getErrorMessage());

    }
}