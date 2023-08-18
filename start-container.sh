#! /usr/bin/env bash

#docker-compose -f authorization_server.yml down
#docker-compose -f authorization_server.yml up -d

docker-compose -f C:/Desenvolvimento/sistemas/study-cliente-flow/infra/localstack/stack.yml down
docker-compose -f C:/Desenvolvimento/sistemas/study-cliente-flow/infra/localstack/stack.yml up -d

echo 'Stack started !'