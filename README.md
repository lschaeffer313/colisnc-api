[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
![Build](https://github.com/opt-nc/colisnc-api/actions/workflows/maven.yml/badge.svg)
[![Docker Image](https://img.shields.io/badge/docker-homepage-blue)](https://hub.docker.com/repository/docker/optnc/colisnc-api)
![Docker Pulls](https://img.shields.io/docker/pulls/optnc/colisnc-api)
![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/optnc/colisnc-api)
![Docker Stars](https://img.shields.io/docker/stars/optnc/colisnc-api)
![Docker Image Version (latest by date)](https://img.shields.io/docker/v/optnc/colisnc-api?arch=amd64&sort=date)

# colisnc-api

API des colis en Nouvelle-Calédonie.

Checker les ressources ci-dessous:

- [Tutorial Katacoda disponible pour déployer sur K8](https://katacoda.com/rastadidi/scenarios/k8s)
- [Dev.to post](https://dev.to/adriens/getting-package-delivery-status-from-docker-at-opt-nc-8d1)
- [Site web officiel de suivi d'où proviennent les données](https://webtracking-nca.ptc.post/)
- [Sur le marketplace d'APIs](https://rapidapi.com/opt-nc-opt-nc-default/api/suivi-colis)

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
