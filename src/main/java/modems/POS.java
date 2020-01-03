package modems;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class ModemDidNotConnectException extends Exception {
}

class ModemUtils {
  public static void dialModem(int phoneNum)
      throws ModemDidNotConnectException {

  }

}

public class POS {

  public static void sellStuff()
      throws ModemDidNotConnectException, IOException {
    // add up prices
    // ask for payment
    // if credit card
    {
      authorizePayment(2468, 254);
    }
  }

  private static boolean USING_MODEM = true;

  public static void authorizePayment(int ccnum, int amount)
      throws ModemDidNotConnectException, UnknownHostException, IOException {
//    try { // loop, retry three times? If still failing, pass it up...
    // other things
    if (USING_MODEM) {
      ModemUtils.dialModem(1234);
    } else {
      Socket s = new Socket("card.com", 1234);

    }
    // more other things
//    } catch(ModemDidNotConnectException me) {
//
//    }
  }

}
