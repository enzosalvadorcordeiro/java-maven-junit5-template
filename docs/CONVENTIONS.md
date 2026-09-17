# Convenções Java

Regras para este template. São as mesmas que um time Java espera num
serviço novo em 2026.

## Pacotes

- Reverse-DNS, só minúsculas, sem underscore, sem camelCase.
- `com.github.enzosalvadorcordeiro.app` — entrada do processo.
- `com.github.enzosalvadorcordeiro.greeting` — um conceito de domínio.
- Não crie `util`, `helpers`, `misc`. Se a coisa tem nome, ela tem pacote.
- O diretório em disco **é** o pacote. `package` no arquivo tem que bater.

Grupo Maven (`groupId`) e pacote-raiz costumam coincidir. `artifactId` é
o nome curto do projeto (`app`, `t1-grafos`, `catalog-service`).

## Tipos

- Classe: PascalCase. Um tipo público por arquivo, arquivo = nome do tipo.
- `final` em classes que não foram desenhadas para herança (`Greeter`, `App`).
- Construtor privado em classes só com estáticos (`App`).
- Record para dados imutáveis (`Greeting`). Validação no compact constructor.
- Enum para conjuntos fechados. Sem “string mágica” para estado.
- Sem Lombok neste template. Java 21 já cobre o que a faculdade pede
  (records, compact ctor, text blocks). Lombok entra só se o time do
  estágio usar.

## Métodos e campos

- Métodos e campos de instância: camelCase.
- Constantes `static final`: SCREAMING_SNAKE.
- Booleanos: `isEmpty`, `hasNext`, nunca `getIsEmpty`.
- Sem `get`/`set` em records — o acessor é o nome do componente (`text()`).
- Prefira `List<String> names` a `String[]` em API nova.
- `Objects.requireNonNull(arg, "arg")` na borda. Não devolva `null` de
  domínio: lance, ou use `Optional` só quando a ausência é um resultado
  honesto.

## Testes

- JUnit 5. Nada de `junit.framework` nem `@org.junit.Test` (JUnit 4).
- Nome da classe: `GreeterTest`, `AppIT`. Nunca `TestGreeter`.
- Surefire pega `*Test`. Failsafe pega `*IT` (e `*ITCase`) no `verify`.
- Métodos: comportamento em camelCase, `@DisplayName` quando a frase
  ajuda o relatório.
- AssertJ: `assertThat` / `assertThatThrownBy`.
- `@Nested` para agrupar (validação, caminho feliz).
- `@ParameterizedTest` + `@ValueSource` / `@CsvSource` em vez de copiar
  o mesmo teste três vezes.
- Não teste getters de record. Teste regra de negócio.

## Build

- A fonte da verdade é o `pom.xml` e o `./mvnw`. A IDE importa o POM,
  não o contrário.
- `./mvnw test` no ciclo curto. `./mvnw verify` antes do push — é o que
  o GitHub Actions roda.
- `./mvnw spotless:apply` formata. Não discuta indentação no PR: o
  Google Java Format já decidiu (2 espaços, 100 colunas).
- Versões de plugin e dependência em `<properties>`. BOM do JUnit para
  não dessincronizar Jupiter e params.

## Git

- Commits em inglês, modo imperativo: `Add Greeter validation tests`.
- Não commitar `target/`, `.idea/`, `*.iml`, `hs_err_pid*`.
- `.vscode/settings.json` compartilhado sim; settings pessoais não.

## O que não fazer

- `public static void main` em três classes. Um `App`.
- Lógica no construtor além de validar invariantes.
- Herança para reutilizar dois métodos — extraia um tipo.
- `catch (Exception e) {}`.
- Compilar pelo botão da IDE e nunca rodar `./mvnw verify`. O CI não
  conhece o seu botão.
