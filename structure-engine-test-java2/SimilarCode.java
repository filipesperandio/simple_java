public class SimilarCode {
  public static void foo() {
    int[] anArray;

    anArray = new int[10];

    for (int i = 0; i < anArray.length; i++) {
      anArray[i] = i;
    }

    for (int i = 0; i < anArray.length; i++) {
      System.out.print(anArray[i] + " ");
    }

    System.out.println();
  }

  public static void bar() {
    int[] anArray;

    anArray = new int[10];

    for (int i = 0; i < anArray.length; i++) {
      anArray[i] = i;
    }

    for (int i = 0; i < anArray.length; i++) {
      System.out.print(anArray[i] + " ");
    }

    System.out.println();
  }
}
