package com.github.enzosalvadorcordeiro.greeting;

import java.util.Objects;

/**
 * Immutable result of a greet. Records are the default data carrier in Java
 * 16+: validation belongs in the compact constructor.
 */
public record Greeting(String text) {

  public Greeting {
    Objects.requireNonNull(text, "text");
    if (text.isBlank()) {
      throw new IllegalArgumentException("text must not be blank");
    }
  }
}
