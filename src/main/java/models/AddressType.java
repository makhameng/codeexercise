package models;

import java.util.Arrays;
import java.util.Optional;

public enum AddressType {

    POSTAL("Postal Address"),
    PHYSICAL("Physical Address") ,
    BUSINESS("Business Address");

    private String description ;

    AddressType(String descriptin) {
        this.description =descriptin;
    }

    public String getDescription() {
        return description;
    }
}
