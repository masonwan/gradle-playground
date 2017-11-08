package masonwan.gradle;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Foo {
  public static void exists() {
    Files.exists(Paths.get(""));
  }
}
