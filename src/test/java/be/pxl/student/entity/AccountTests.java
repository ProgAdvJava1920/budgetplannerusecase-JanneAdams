package be.pxl.student.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {

    @Test
    public void newAccount_instantiatesCorrectly(){
        Account testAccount = new Account();
        assertTrue(testAccount instanceof Account);
    }

}
