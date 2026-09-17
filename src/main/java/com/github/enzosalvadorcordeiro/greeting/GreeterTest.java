package com.github.enzosalvadorcordeiro.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Greeter")
class GreeterTest {

  private final Greeter greeter = new Greeter();

  @ParameterizedTest(name = "greets \"{0}\"")
  @ValueSource(strings = { "Ada", "Linus", "Grace" })
  void greetsKnownNames(String name) {
    assertThat(greeter.greet(name).text()).isEqualTo("Hello, " + name + "!");
  }

  @Test
  void trimsSurroundingWhitespace() {
    assertThat(greeter.greet("  Ada  ").text()).isEqualTo("Hello, Ada!");
  }

  @Nested
  @DisplayName("validation")
  class Validation {

    @Test
    void rejectsNullName() {
      assertThatThrownBy(() -> greeter.greet(null))
          .isInstanceOf(NullPointerException.class)
          .hasMessageContaining("name");
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "  ", "\t", "\n" })
    void rejectsBlankName(String name) {
      assertThatThrownBy(() -> greeter.greet(name))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("blank");
    }
  }
}
