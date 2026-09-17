# Changelog

## 2.0.0

Reescrita profissional do boilerplate Maven original.

- Pacotes reais (`app`, `greeting`) no lugar de diretórios vazios
- `pom.xml` sem leftover de archetype: plugins de fato ligados
- Java 21 via `maven.compiler.release`, Enforcer (JDK 21 + Maven 3.9)
- JUnit 5 BOM + AssertJ, testes aninhados e parametrizados
- Failsafe (`*IT`) separado de Surefire (`*Test`)
- Spotless + Google Java Format, JaCoCo com gate de 70%
- JAR executável (`Main-Class`) e `exec-maven-plugin`
- Maven Wrapper 3.9.9
- GitHub Actions com Temurin 21
- README, convenções, SECURITY e gitignore de IDE/OS/Maven
