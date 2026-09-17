# Security

This is a starting template, not a shipped product. Before you treat a
project derived from it as production software:

- Keep dependencies current (`./mvnw versions:display-dependency-updates`).
- Do not log secrets or put credentials in `src/main/resources`.
- Prefer fail-fast validation (`Objects.requireNonNull`, domain records)
  over returning null.
- Report vulnerabilities privately to the repository owner rather than
  opening a public issue.
