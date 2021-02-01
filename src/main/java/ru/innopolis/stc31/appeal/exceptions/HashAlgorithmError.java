package ru.innopolis.stc31.appeal.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HashAlgorithmError extends Exception {
    private ErrorMessage errorMessage;

}
