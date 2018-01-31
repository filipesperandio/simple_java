// Appendix B: Specification
//
// B1. Increments
//
// There is an increment for each of the following:
//   - if, else if, else, ternary operator
//   - switch
//   - for, foreach
//   - while, do while
//   - catch
//   - goto LABEL, break LABEL, continue LABEL
//   - sequences of binary logical operators
//   - each method in a recursion cycle

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1
      return;
    }

    if (Boolean.TRUE) { // +1
      return;
    }
  } // complexity=2
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1
      return;
    } else { // +1
      return;
    }
  } // complexity=2
}

public class Test {
  public static int foo() {
    return Boolean.TRUE ? 1 : 0; // +1
  } // complexity=1
}

public class Test {
  public static String foo(int number) {
    switch (number) { // +1
      case 1:
        return;
      case 2:
        return;
      case 3:
        return;
      default:
        return;
    }
  } // complexity=1
}

public class Test {
  public static void foo() {
    for (int i=1; i<=10; i++) { // +1
      return;
    }
  } // complexity=1
}

public class Test {
  public static void foo() {
    try {
      return;
    } catch (IOException e) { // +1
      return;
    }
  } // complexity=1
}

public class Test {
  public static void foo() {
    while (Boolean.TRUE) { // +1
      break; // +2 (nesting=1)
    }
  } // complexity=3
}

public class Test {
  public static void foo() {
    while (Boolean.TRUE) { // +1
      continue; // +2 (nesting=1)
    }
  } // complexity=3
}

public class Test {
  public static void foo() {
    return (Boolean.TRUE && Boolean.TRUE); // +1
  } // complexity=1
}

public class Test {
  public static Boolean foo() {
    return (Boolean.TRUE && Boolean.TRUE || Boolean.FALSE); // +2
  } // complexity=2
}

public class Test {
  public static Boolean foo() {
    return (Boolean.TRUE || (Boolean.FALSE || Boolean.TRUE)); // +2
  } // complexity=2
}

public class Test {
  public static Boolean foo() {
    return foo(); // +1
  } // complexity=1
}

// B2. Nesting Level
//
// The following structures increment the nesting level:
// - if, else if, else, ternary operator
// - switch
// - for, foreach
// - while, do while
// - catch
// - nested methods and method-like structures such as lambdas

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          return;
        }
      }
    }

  } //complexity=6
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      return;
    } else if (Boolean.TRUE) { // +1
      if (Boolean.TRUE) { // +2 (nesting=1)
        return;
      }
    }
  } //complexity=4
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      return;
    } else { // +1
      if (Boolean.TRUE) { // +2 (nesting=1)
        return;
      }
    }
  }
}

public class Test {
  public static String foo(int number) {
    switch (number) { // +1
      case 1:
        switch (number) { // +2 (nesting=1)
          default:
            switch (number) { // +3 (nesting=2)
              default:
                return;
            }
        }
      default:
        return;
    }
  } // complexity=6
}

public class Test {
  public static void foo() {
    for (int i=1; i<=10; i++) { // +1
      for (int i=1; i<=10; i++) { // +2 (nesting=1)
        for (int i=1; i<=10; i++) { // +3 (nesting=2)
          return;
        }
      }
    }
  } // complexity=6
}

public class Test {
  public static void foo() {
    while (Boolean.TRUE) { // +1
      while (Boolean.TRUE) { // +2 (nesting=1)
        while (Boolean.TRUE) { // +3 (nesting=2)
          return;
        }
      }
    }
  } // complexity=6
}

public class Test {
  public static void foo() {
    do { // +1
      do { // +2 (nesting=1)
        do { // +3 (nesting=2)
          return;
        } while (Boolean.TRUE);
      } while (Boolean.TRUE);
    } while (Boolean.TRUE);
  }
}

public class Test {
  public static void foo() {
    try {
      return;
    } catch (IOException e) { // +1
      try {
        return;
      } catch (IOException e) { // +2 (nesting=1)
        try {
          return;
        } catch (IOException e) { // +3 (nesting=2)
          return;
        }
      }
    }
  } // complexity=6
}

public class Test {
  public static void foo() {
    class Inner {
      static void bar() {
        if (Boolean.TRUE) { // +2
          if (Boolean.TRUE) { // +2 (nesting=1)
            if (Boolean.TRUE) { // +3 (nesting=2)
              return;
            }
          }
        }

        class SuperInner {
          static void baz() {
            if (Boolean.TRUE) { // +2 (nesting=1)
              if (Boolean.TRUE) { // +3 (nesting=2)
                if (Boolean.TRUE) { // +4 (nesting=3)
                  return;
                }
              }
            }
          } // complexity=6
        }
      } // complexity=15
    }
  } // complexity=21
}

public class Test {
  public static void foo() {
    MathOperation addition = (int a, int b) -> Boolean.TRUE ? 1 : 0; // +2 (nesting=1)
  }
}

// B3. Nesting increments
//
// The following structures receive a nesting increment commensurate with their
// nested depth inside B2 structures:
//   - if, ternary operator
//   - switch
//   - for, foreach
//   - while, do while
//   - catch

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          return;
        }
      }
    }
  } // complexity=6
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          return Boolean.TRUE ? 1 : 0; // +4 (nesting=3)
        }
      }
    }
  } // complexity=10
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          switch (number) { // +4 (nesting=3)
            default:
              return;
          }
        }
      }
    }
  } // complexity=10
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          for (int i=1; i<=10; i++) { // +4 (nesting=3)
            return;
          }
        }
      }
    }
  }
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          while (Boolean.TRUE) { // +4 (nesting=3)
            return;
          }
        }
      }
    }
  } // complexity=10
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          do { // +4 (nesting=3)
            return;
          } while (Boolean.TRUE);
        }
      }
    }
  } // complexity=10
}

public class Test {
  public static void foo() {
    if (Boolean.TRUE) { // +1 (nesting=0)
      if (Boolean.TRUE) { // +2 (nesting=1)
        if (Boolean.TRUE) { // +3 (nesting=2)
          try {
            return;
          } catch (IOException e) { // +4 (nesting=3)
            return;
          }
        }
      }
    }
  } // complexity=10
}

// Appendix C: Examples
//
//

public class Examples {
  @Nullable
  private MethodJavaSymbol overriddenSymbolFrom(ClassJavaType classType) {
      if (classType.isUnknown()) { // +1
          return Symbols.unknownMethodSymbol;
      }
      boolean unknownFound = false;
      List<JavaSymbol> symbols = classType.getSymbol().members().lookup(name);
      for (JavaSymbol overrideSymbol : symbols) { // +1
          if (overrideSymbol.isKind(JavaSymbol.MTH) // +2 (nesting = 1)
          && !overrideSymbol.isStatic()) { // +1
              MethodJavaSymbol methodJavaSymbol = (MethodJavaSymbol)overrideSymbol;
              if (canOverride(methodJavaSymbol)) { // +3 (nesting = 2)
                  Boolean overriding = checkOverridingParameters(methodJavaSymbol,
                  classType);
                  if (overriding == null) { // +4 (nesting = 3)
                      if (!unknownFound) { // +5 (nesting = 4)
                          unknownFound = true;
                      }
                      } else if (overriding) { // +1
                      return methodJavaSymbol;
                  }
              }
          }
      }
      if (unknownFound) { // +1
          return Symbols.unknownMethodSymbol;
      }
      return null;
  } // total complexity = 19

  private void addVersion(final Entry entry, final Transaction txn)
  throws PersistitInterruptedException, RollbackException {
      final TransactionIndex ti = _persistit.getTransactionIndex();
      while (true) { // +1
          try {
              synchronized (this) {
                  if (frst != null) { // +2 (nesting = 1)
                      if (frst.getVersion() > entry.getVersion()) { // +3 (nesting = 2)
                          throw new RollbackException();
                      }
                      if (txn.isActive()) { // +3 (nesting = 2)
                          for // +4 (nesting = 3)
                          (Entry e = frst; e != null; e = e.getPrevious()) {
                              final long version = e.getVersion();
                              final long depends = ti.wwDependency(version,
                              txn.getTransactionStatus(), 0);
                              if (depends == TIMED_OUT) { // +5 (nesting = 4)
                                  throw new WWRetryException(version);
                              }
                              if (depends != 0 // +5 (nesting = 4)
                              && depends != ABORTED) { // +1
                                  throw new RollbackException();
                              }
                          }
                      }
                  }
                  entry.setPrevious(frst);
                  frst = entry;
                  break;
              }
              } catch (final WWRetryException re) { // +2 (nesting = 1)
              try {
                  final long depends = _persistit.getTransactionIndex()
                  .wwDependency(re.getVersionHandle(),txn.getTransactionStatus(),
                  SharedResource.DEFAULT_MAX_WAIT_TIME);
                  if (depends != 0 // +3 (nesting = 2)
                  && depends != ABORTED) { // +1
                      throw new RollbackException();
                  }
                  } catch (final InterruptedException ie) { // +3 (nesting = 2)
                  throw new PersistitInterruptedException(ie);
              }
              } catch (final InterruptedException ie) { // +2 (nesting = 1)
              throw new PersistitInterruptedException(ie);
          }
      }
  } // total complexity = 35

  private static String toRegexp(String antPattern,
  String directorySeparator) {
      final String escapedDirectorySeparator = '\\' + directorySeparator;
      final StringBuilder sb = new StringBuilder(antPattern.length());
      sb.append('^');
      int i = antPattern.startsWith("/") || // +1
      antPattern.startsWith("\\") ? 1 : 0; // +1
      while (i < antPattern.length()) { // +1
          final char ch = antPattern.charAt(i);
          if (SPECIAL_CHARS.indexOf(ch) != -1) { // +2 (nesting = 1)
              sb.append('\\').append(ch);
              } else if (ch == '*') { // +1
              if (i + 1 < antPattern.length() // +3 (nesting = 2)
              && antPattern.charAt(i + 1) == '*') { // +1
                  if (i + 2 < antPattern.length() // +4 (nesting = 3)
                  && isSlash(antPattern.charAt(i + 2))) { // +1
                      sb.append("(?:.*")
                      .append(escapedDirectorySeparator).append("|)");
                      i += 2;
                      } else { // +1
                      sb.append(".*");
                      i += 1;
                  }
                  } else { // +1
                  sb.append("[^").append(escapedDirectorySeparator).append("]*?");
              }
              } else if (ch == '?') { // +1
              sb.append("[^").append(escapedDirectorySeparator).append("]");
              } else if (isSlash(ch)) { // +1
              sb.append(escapedDirectorySeparator);
              } else { // +1
              sb.append(ch);
          }
          i++;
      }
      sb.append('$');
      return sb.toString();
  } // total complexity = 20
}
