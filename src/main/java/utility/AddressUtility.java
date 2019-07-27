package utility;

import models.Address;
import models.AddressLineDetail;
import models.AddressType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressUtility {

    public static final String ZA_ADDRESS = "ZA";
    public static final String ADDRESS_BLANK = "Country is blank.";
    public static final String PROVINCE_REQUIRED = "When country is South Africa province is required.";
    public static final String ADDRESS_LINE_BLANK = "address should have at least one address line.";
    public static final String NUMERIC_POSTAL_CODE = "Postal code should be numeric.";
    public static final String VALID_ADDRESS = "The address is valid";

    private List<String> messageList;

    public void prettyPrintAddress(Address address) {
        String addressFormat = address.getType().getName() + " : " + address.getAddressLineDetail() + " - " + address.getCityOrTown() + " - " +
                address.getProvinceOrState() + " - " + address.getPostalCode() + " - " + address.getCountry();

        System.out.println(addressFormat);
    }

    public void prettyPrintAllTheAddresses(List<Address> addressList) {
        addressList.forEach(address -> prettyPrintAddress(address));
    }

    public void printAddressByType(Address address, AddressType addressType) {
        String stringAddress;
        if (addressType.getDescription().equalsIgnoreCase(AddressType.PHYSICAL.getDescription())) {
            stringAddress = address.getType().getName() + " : " + address.getAddressLineDetail() + " - " + address.getCityOrTown() + " - " +
                    address.getProvinceOrState() + " - " + address.getPostalCode() + " - " + address.getCountry();
        } else if (addressType.getDescription().equalsIgnoreCase(AddressType.BUSINESS.getDescription())) {
            stringAddress = address.getType().getName() + " : " + address.getAddressLineDetail() + " - " + address.getCityOrTown() + " - " +
                    address.getSuburbOrDistrict() + " - " + address.getPostalCode() + " - " + address.getCountry();
        } else {
            stringAddress = address.getType().getName() + " : " + address.getCityOrTown() +
                    " - " + address.getPostalCode() + " - " + address.getCountry();
        }

        System.out.println(stringAddress);

    }

    public void validateAddress(Address address) {
        messageList = new ArrayList<>();

        validatePostalCode(address.getPostalCode());
        validateCountry(address);
        validateAddressLine(address.getAddressLineDetail());

        if (!messageList.isEmpty()) {
            messageList.forEach(System.out::println);
        } else {
            System.out.println(VALID_ADDRESS);
        }
    }

    private void validatePostalCode(String postalCode) {
        if (!StringUtils.isNumeric(postalCode)) {
            messageList.add(NUMERIC_POSTAL_CODE);
        }

    }

    private void validateCountry(Address address) {
        if (address.getCountry() != null && StringUtils.isNoneBlank(address.getCountry().getName())) {
            if (address.getCountry().getCode().equalsIgnoreCase(ZA_ADDRESS)) {
                if (address.getProvinceOrState() == null) {
                    messageList.add(PROVINCE_REQUIRED);
                }
            }

        } else {
            messageList.add(ADDRESS_BLANK);
        }
    }

    private void validateAddressLine(AddressLineDetail addressLineDetail) {
        if (addressLineDetail == null) {
            messageList.add(ADDRESS_LINE_BLANK);
        } else if (StringUtils.isBlank(addressLineDetail.getLine1()) && StringUtils.isBlank(addressLineDetail.getLine2())) {
            messageList.add(ADDRESS_LINE_BLANK);
        }
    }
}
