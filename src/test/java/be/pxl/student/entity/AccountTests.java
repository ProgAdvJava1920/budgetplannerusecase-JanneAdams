package java.be.pxl.student.entity;

import be.pxl.student.entity.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTests {

    @Test
    public void newAccount_instantiatesCorrectly(){
        Account testAccount = new Account();
        assertEquals(true, testAccount instanceof Account);
    }
    
}
