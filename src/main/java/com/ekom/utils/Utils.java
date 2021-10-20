package com.ekom.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Utils {
  private static long baseId = 4845892L;

  static public String toHex(String arg) {
    byte[] bytes = arg.getBytes(StandardCharsets.UTF_8);
    return String.format("%06x", new BigInteger(1, bytes));
  }

  public static String generateIdFromObj(Object obj) {
    String id = "-" + (obj.hashCode() + baseId++);
    return "EK" + toHex(id).toUpperCase();
  }
}
