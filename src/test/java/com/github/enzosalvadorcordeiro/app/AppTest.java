package com.github.enzosalvadorcordeiro.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void defaultNameIsWorld() {
    assertThat(App.run(new String[] {})).isEqualTo("Hello, world!");
  }

  @Test
  void usesFirstArgumentAsName() {
    assertThat(App.run(new String[] { "Enzo" })).isEqualTo("Hello, Enzo!");
  }
}
