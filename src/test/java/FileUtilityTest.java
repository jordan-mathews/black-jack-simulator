import org.junit.jupiter.api.Test;
import utils.FileUtility;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilityTest {

  @Test
  public void readFile_success() throws Exception {
    String expected = "C2,D2,H2,S2,C3,D3,H3,S3,C4,D4,H4,S4,C5,D5,H5,S5,C6,D6,H6,S6,C7,D7,H7,S7,C8,D8,H8,S8,C9,D9,H9,S9,C10,D10,H10,S10,CJ,DJ,HJ,SJ,CQ,DQ,HQ,SQ,CK,DK,HK,SK,CA,DA,HA,SA";
    String result = new FileUtility().readFromFile("src/test/resources/deckTest.txt");

    assertEquals(expected, result, "File parsed correctly");
  }

  @Test
  public void readFileNotFound_error(){
    Exception exception = null;

    try{
      String result = new FileUtility().readFromFile("src/test/resources/nonExistingFile.txt");
    } catch (Exception e){
      exception = e;
    }

    assertEquals(FileNotFoundException.class, exception.getClass());
  }



}
