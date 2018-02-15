public class NestedControlFlow {
  public static void deeplyNested() {
    int[] numbers = {1,2,3,4,5,6,7,8,9,10};
    for (int i = 0; i < 5; i++) {
      for (int item : numbers) {
        while (item + i < 40) {
          switch (item) {
            case 6:
              if (i == 3) {
                System.out.println("yippee");
              }
              break;
            default:
              break;
          }
        }
      }
    }
  }
}
