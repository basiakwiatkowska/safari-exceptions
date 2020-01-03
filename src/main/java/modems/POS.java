package modems;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class RetryCCLaterException extends Exception {
  public RetryCCLaterException() {
  }

  public RetryCCLaterException(String message) {
    super(message);
  }

  public RetryCCLaterException(String message, Throwable cause) {
    super(message, cause);
  }

  public RetryCCLaterException(Throwable cause) {
    super(cause);
  }

  public RetryCCLaterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

class LaughInFaceException extends Exception {
}

class ModemDidNotConnectException extends Exception {
}

class ModemUtils {
  public static void dialModem(int phoneNum)
      throws ModemDidNotConnectException {

  }

}

public class POS {

  public static void sellStuff()
//      throws ModemDidNotConnectException, IOException
  {
    // add up prices
    // ask for payment
    // if credit card
    {
      try {
        authorizePayment(2468, 254);
      } catch (RetryCCLaterException e) {
        e.printStackTrace();
      } catch (LaughInFaceException e) {
        e.printStackTrace();
      }
    }
  }

  private static boolean USING_MODEM = true;

  public static void authorizePayment(int ccnum, int amount)
      throws RetryCCLaterException, LaughInFaceException {
    try { // loop, retry three times? If still failing, pass it up...
      // other things
      if (USING_MODEM) {
        ModemUtils.dialModem(1234);
        // do comms stuff
        // disconnect modem...
      } else {
        Socket s = new Socket("card.com", 1234);

      }
      // more other things
    } catch (ModemDidNotConnectException | IOException me) {
      throw new RetryCCLaterException(me);
    } /*catch (IOException ioe) {
      throw new RetryCCLaterException();
    }*/
  }

}
