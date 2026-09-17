package com.github.enzosalvadorcordeiro.app;

import com.github.enzosalvadorcordeiro.greeting.Greeter;

/**
 * Process entry point. Keep {@code main} thin: parse args, call the domain,
 * print the result. Logic lives in types you can unit-test without capturing
 * stdout.
 */
public final class App {
  private App() {
  }

  public static String run(String[] args) {
    String name = args.length > 0 ? args[0] : "world";
    return new Greeter().greet(name).text();
  }

  public static void main(String[] args) {
    System.out.println(run(args));
  }
}
