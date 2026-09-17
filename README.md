# Java 21 + Maven + JUnit 5

Template profissional de Java para trabalhos da faculdade e para o primeiro
emprego. Java 21 (LTS), Maven Wrapper, JUnit Jupiter, AssertJ, Spotless
(Google Java Format), JaCoCo e GitHub Actions.

O pacote `greeting` e a classe `App` existem só para demonstrar o fluxo
**domínio → teste → JAR executável**. Apague-os quando o projeto for o seu.

Repositório original:
[java-maven-junit5-template](https://github.com/enzosalvadorcordeiro/java-maven-junit5-template)

## Requisitos

- JDK **21** ou mais novo (Temurin, Oracle, Amazon Corretto)
- Não precisa instalar Maven: o wrapper `./mvnw` baixa a 3.9.9 na primeira
  execução

IDE: IntelliJ IDEA Community ou VS Code com Extension Pack for Java. Importe
o `pom.xml`. A IDE deve usar o JDK 21 do projeto, não o 17 do sistema.

## Começar

```text
chmod +x mvnw          # uma vez, no Linux/macOS
./mvnw test            # unit tests (*Test)
./mvnw verify          # test + IT + Spotless + JaCoCo ≥ 70%
./mvnw -q exec:java    # Hello, world!
./mvnw -q exec:java -Dexec.args="Ada"
./mvnw -q package && java -jar target/app-0.1.0-SNAPSHOT.jar Enzo
./mvnw spotless:apply  # formata o código (Google Java Format, 2 espaços)
```

No Windows: `mvnw.cmd test`.

## Estrutura

```text
src/main/java/.../app/App.java          ponto de entrada
src/main/java/.../greeting/             domínio de exemplo (apague)
src/main/resources/                     configs, não código
src/test/java/...                       *Test = unitário, *IT = integração
.mvn/wrapper/                           Maven Wrapper
.github/workflows/ci.yml                Temurin 21 + ./mvnw -B verify
docs/CONVENTIONS.md                     nomes, pacotes, testes
```

Layout Maven padrão. Não invente `src/java` nem coloque testes em `src/main`.

## O que o `pom.xml` já faz

| Peça              | Função                                                |
| ----------------- | ----------------------------------------------------- |
| `java.version=21` | `--release 21` no compilador                          |
| JUnit BOM 5.12    | Jupiter + params, versões alinhadas                   |
| AssertJ           | `assertThat` — o padrão em times profissionais        |
| Enforcer          | exige Maven ≥ 3.9 e JDK ≥ 21                          |
| Surefire          | `*Test` em `mvn test`                                 |
| Failsafe          | `*IT` em `mvn verify`                                 |
| JaCoCo            | relatório + gate de 70% de linhas em `verify`         |
| Spotless          | Google Java Format na fase `verify`                   |
| JAR               | `Main-Class` no manifesto                             |
| exec-maven-plugin | `./mvnw exec:java`                                    |

Versões ficam em `<properties>`. Subir uma dependência é mudar uma linha.

## Convenções

Leia [docs/CONVENTIONS.md](docs/CONVENTIONS.md). Resumo:

| Coisa     | Forma                            | Exemplo                          |
| --------- | -------------------------------- | -------------------------------- |
| Pacote    | reverse-DNS, minúsculo           | `com.github.enzosalvadorcordeiro.greeting` |
| Classe    | PascalCase, um tipo público/arquivo | `Greeter.java`                |
| Método    | camelCase                        | `greet`                          |
| Constante | SCREAMING_SNAKE                  | `MAX_NAME_LENGTH`                |
| Teste     | `*Test` / `*IT`                  | `GreeterTest`                    |
| Método de teste | camelCase, comportamento   | `trimsSurroundingWhitespace`     |
| Indent    | 2 espaços (Google Java Format)   | Spotless                         |

Código em inglês. Documentação pode ficar em português.
Sem wildcard imports (`import java.util.*`).

## Como usar isto num trabalho novo

1. Copie o conteúdo deste repositório para o seu (mantenha o `.git` dele).
2. No `pom.xml`, mude `<name>`, `<description>`, `<artifactId>` e, se a
   universidade exigir, o `<groupId>`.
3. Para renomear o pacote:
   - refatore no IntelliJ (Shift+F6 no pacote), **ou**
   - mova as pastas em `src/main/java` e `src/test/java` e atualize
     `package`, imports e `<main.class>`.
4. Apague `greeting/` e escreva o domínio do trabalho.
5. `./mvnw verify` antes de cada entrega.

Pacote da universidade, se precisar: `br.edu.<sigla>.<seuusuario>`.

## Por que AssertJ e não `assertEquals`

```java
assertThat(greeter.greet("Ada").text()).isEqualTo("Hello, Ada!");
assertThatThrownBy(() -> greeter.greet(" "))
    .isInstanceOf(IllegalArgumentException.class);
```

A mensagem de falha mostra o valor real e o esperado. `assertEquals` da JUnit
funciona; AssertJ é o que você vai ler em code review de empresa.

## Licença

MIT. Veja [LICENSE](LICENSE).
