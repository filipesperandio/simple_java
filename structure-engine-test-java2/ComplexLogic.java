public class ComplexLogic {
  public static void conditionalTooComplex() {
    if ((Boolean.TRUE && Boolean.FALSE) || ((Boolean.FALSE || Boolean.TRUE) && (Boolean.TRUE || Boolean.FALSE) || Boolean.TRUE)) {
      System.out.println("foo");
    }
  }

  public static void conditionalWayTooComplex() {
    if ((Boolean.TRUE && Boolean.FALSE) || ((Boolean.FALSE || Boolean.TRUE) && (Boolean.TRUE || Boolean.FALSE) || Boolean.TRUE && Boolean.FALSE)) {
      System.out.println("foo");
    }
  }

  public static void notComplex() {
    if (Boolean.TRUE) {
      System.out.println("foo");
    }
  }
}
