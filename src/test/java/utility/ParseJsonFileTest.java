package utility;


import models.Address;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParseJsonFileTest {

    private List<Address> addressList = null;

    @BeforeAll
    public void setUp(){
        addressList = new ParseJsonFile().parseJsonFile(ParseJsonFile.FILE_PATH);
    }

    @Test
    void parseJsonFile() {

        assertEquals(3, addressList.size());
    }
}