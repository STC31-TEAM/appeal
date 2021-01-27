package ru.innopolis.stc31.appeal.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CompanyErrors extends Exception {
    private ErrorMessage errorMessage;
}
