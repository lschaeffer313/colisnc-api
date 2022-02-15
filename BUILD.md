# Developpement

## Spring-native

La doc est [ici](https://docs.spring.io/spring-native/docs/0.11.2/reference/htmlsingle/)

### Lancement de la génération native en local (pour le débogage)

Des prérequis sont nécessaires, tout est décrit [ici]https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/#getting-started-native-build-tools()

```bash
mvn clean -Pspring-native -Pbuild-native-image -DskipTests package
```
