# colisnc-api

API des colis en Nouvelle-Calédonie.

Checker les ressources ci-dessous:

- [Tutorial Katacoda disponible pour déployer sur K8](https://katacoda.com/rastadidi/scenarios/k8s)
- [Dev.to post](https://dev.to/adriens/getting-package-delivery-status-from-docker-at-opt-nc-8d1)

# Utilisation

## Démarrer le service

```bash
mvn spring-boot:run
```

## Endpoint

```
/ : swagger documentation
/colis/{itemId}
/colis/{itemId}/latest
/colis/{itemId}/count
```

# Image use

```bash
docker pull optnc/colisnc-api:latest
docker images
docker run --net=host -d -p 8080:8080 optnc/colisnc-api:latest
sudo apt-get install jq -y

curl -sS http://localhost:8080/colis/CA107308006SI/latest | jq -r '.localisation'
curl -sS http://localhost:8080/colis/CA107308006SI/latest | less
curl -sS http://localhost:8080/colis/CA107308006SI/ | less

# requires httpie
http http://localhost:8080/colis/CA107308006SI/latest
```
