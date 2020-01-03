package closingjavasix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CloseStuff {
  public static void main(String[] args) {
    BufferedReader br = null;
    PrintWriter bw = null;
    try {
      br = Files.newBufferedReader(Paths.get("in.txt"));
      bw = new PrintWriter(Files.newBufferedWriter(Paths.get("out.txt"),
          StandardOpenOption.CREATE));
      String line;
      while ((line = br.readLine()) != null) {
        bw.println(line);
      }
      bw.flush();
    } catch (Exception ex) {
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (br != null) {
        bw.close();
      }
    }
  }
}
