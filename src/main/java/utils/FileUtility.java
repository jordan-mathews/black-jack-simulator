package utils;

import java.io.*;


public class FileUtility {

  public String readFromFile(String filePath) throws Exception {
    StringBuilder fileContents = new StringBuilder();
    String line = null;

    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    while ((line = reader.readLine()) != null) {
      fileContents.append(line);
    }
    reader.close();

    return String.valueOf(fileContents);

  }

}
