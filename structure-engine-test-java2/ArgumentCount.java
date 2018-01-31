import java.lang.StringBuilder;

public class ArgumentCount {
  public static String tooManyArgsSingleLine(String a, String b, String c, String d, String e, String f) {
    StringBuilder builder = new StringBuilder(a);

    builder.append(b);
    builder.append(c);
    builder.append(d);
    builder.append(e);
    builder.append(f);

    return builder.toString();
  }

  private int tooManyArgsMultiLine(int a,
      int b,
      int c,
      int d,
      int e) { 
    return a + b + c + d + e;
  }
}
