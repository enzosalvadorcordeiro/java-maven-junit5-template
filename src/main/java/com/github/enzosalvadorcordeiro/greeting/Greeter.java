package com.github.enzosalvadorcordeiro.greeting;

import java.util.Objects;

/**
 * Sample domain type. Delete this package when the project has a real one.
 *
 * <p>
 * Fail fast: null and blank names are programming errors, not return values.
 */
public final class Greeter {

  public Greeting greet(String name) {
    Objects.requireNonNull(name, "name");
    String trimmed = name.trim();
    if (trimmed.isBlank()) {
      throw new IllegalArgumentException("name must not be blank");
    }
    return new Greeting("Hello, " + trimmed + "!");
  }
}
