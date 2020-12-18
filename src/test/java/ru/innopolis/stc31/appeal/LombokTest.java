package ru.innopolis.stc31.appeal;

import lombok.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Data
class LombokTest {
    private int a;
    private String str;

    public LombokTest() { }

    @Test
    void testLombok () {
        LombokTest lombokTest=new LombokTest();
        lombokTest.setA(1);
        lombokTest.setStr("TestLombok");
        assertEquals(1, lombokTest.getA());
        assertEquals("TestLombok",lombokTest.getStr());
    }
}
