package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Address;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParseJsonFile {

    public static final String FILE_PATH = "/home/tahlehodanielmakhameng/workspaces/git/codeexercise/src/main/resources/addresses.json";
    public List<Address> parseJsonFile(String filePath){
        ObjectMapper mapper = new ObjectMapper();

        List<Address> addressList = null;
        try {
            addressList = Arrays.asList(mapper.readValue(new File(filePath),Address[].class));

        } catch (IOException e) {
            System.err.println("something went wrong while parsing the json file.");
            e.printStackTrace();
        }
        return addressList;
    }

}
