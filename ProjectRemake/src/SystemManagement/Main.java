package SystemManagement;


import CsvFiles.ReadWrite;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadWrite<List<String>> readWrite=ReadWrite.getInstance();
        Services s=new Services();
        s.application(readWrite);


    }

}
