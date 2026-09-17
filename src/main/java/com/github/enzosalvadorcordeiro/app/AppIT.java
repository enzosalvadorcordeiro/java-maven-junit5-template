package com.github.enzosalvadorcordeiro.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Integration test sample. Surefire runs {@code *Test}; Failsafe runs
 * {@code *IT}
 * during {@code mvn verify}. Use this class for tests that need a JVM-wide
 * resource (file, network, container). This one stays cheap on purpose.
 */
class AppIT {

  @Test
  void endToEndGreeting() {
    assertThat(App.run(new String[] { "verify" })).isEqualTo("Hello, verify!");
  }
}
