package utility;

import models.Address;
import models.AddressType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressUtilityTest {
    private List<Address> addressList = null;
    private AddressUtility addressUtility = null;

    @BeforeAll
    public void setUp(){
        addressList = new ParseJsonFile().parseJsonFile(ParseJsonFile.FILE_PATH);
        addressUtility = new  AddressUtility();
    }

    /**
     * Test a function that return a pretty print version of an address in the format:
     * Type: Line details - city - province/state - postal code – country
     */
    @Test
    void prettyPrintAddress() {
        int index = 0;
        System.out.println("printing address : " + index + " : ");
        addressUtility.prettyPrintAddress(addressList.get(index));

    }

    /**
     * Test a function that pretty print all the addresses in the attached file
     */
    @Test
    void prettyPrintAllTheAddresses() {
        System.out.println(" print all the addresse :");
        addressUtility.prettyPrintAllTheAddresses(addressList);
    }

    /**
     * Test a function that print an address of a certain type (postal, physical, business)
     */
    @Test
    void printAddressByType() {
        addressUtility.printAddressByType(addressList.get(0), AddressType.PHYSICAL);
        addressUtility.printAddressByType(addressList.get(1), AddressType.POSTAL);
        addressUtility.printAddressByType(addressList.get(2), AddressType.BUSINESS);
    }

    /**
     * Test a function that validate an address
     * For each address in the attached file, determine if it is valid or not,
     * and if not give an indication of what is invalid in a message format of your choice.
     */
    @Test
    void validateAddress() {
        addressList.forEach(addressUtility::validateAddress);
    }
}