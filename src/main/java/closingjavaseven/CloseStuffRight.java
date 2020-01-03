package closingjavaseven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CloseStuffRight {
  int [] data = {1, 3,  2,};
  public static void main(String[] args)
    /* throws  something we can't handle */ {
    try (
        BufferedReader br = Files.newBufferedReader(Paths.get("in.txt"));
        PrintWriter bw = new PrintWriter(Files.newBufferedWriter(Paths.get("out.txt"),
            StandardOpenOption.CREATE));
    ) {
      String line;
      // throws something we can't handle...
      while ((line = br.readLine()) != null) {
        bw.println(line);
      }
      bw.flush();
    } catch (Exception ex) { // all except "someting we can't handle :}
      //
    } /*finally { // "something we can't handle" will potentially
    // have closure exception reported as a "SuppresedException"
      if (br != null) {
        try {
          br.close(); // would "kill" something we can't handle
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (br != null) {
        bw.close();
      }
    }*/
  }
}
