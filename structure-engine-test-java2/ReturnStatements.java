public class ReturnStatements {
  public static void tooManyReturns(int i) {
    if (i < 2) {
      return "lt 2";
    }

    if (i < 4) {
      return "lt 4";
    }

    if (i < 8) {
      return "lt 8";
    }

    if (i < 16) {
      return "lt 16";
    }

    if (i < 32) return "lt32";
    return "nope";
  }
}
