# Lancenment dans Knative

Knative permet de faire du Severless, c'est à dire que l'application est lancée au besoin de manière transparente et arrêté par la suite au bout d'un certain temps.

Cette documentation ne couvre pas l'installation de Knative lui même, pour cela il faut se tourner vers [la doc officielle](https://knative.dev/docs/getting-started/).

## Soit via l'utilitaire [kn](https://knative.dev/docs/getting-started/#install-the-knative-cli) :
```sh
kn service create colisnc-api \
--image optnc/colisnc-api:stable \
--revision-name=stable
```

Puis récupérer l'url du service :
```sh
kn service describe colisnc-api -o url
```
Ou directement appeler le service :
```sh
http $(kn service describe colisnc-api -o url)/colis/CA107308006SI
```

## Soit via [kubectl](https://kubernetes.io/docs/tasks/tools/) :
```sh
kubectl apply -f k8s/knative.yaml
```

Puis récupérer l'url du service :
```sh
kubectl get ksvc colisnc-api --output=custom-columns=NAME:.metadata.name,URL:.status.url
```

## Suivre la mise à l'echelle automatique
```sh
kubectl get pod -l serving.knative.dev/service=colisnc-api -w
```
Si l'application reste trop longtemps inutilisée, Knative la stoppera automatiquement et la réactivera au besoin de manière transparente.

## Supression

```sh
kn service delete colisnc-api
```
