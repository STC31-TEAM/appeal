package ru.innopolis.stc31.appeal.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SuccessModel {

    private String result;
}
