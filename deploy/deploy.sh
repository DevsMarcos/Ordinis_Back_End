#!/bin/bash
set -e  # para o script imediatamente se qualquer comando falhar

# Script de deploy da aplicacao via container Docker
# Executado na instancia EC2 pelo pipeline de CD apos o build da imagem

IMAGE="$DOCKERHUB_USERNAME/sistema-ordem-servico:latest"
CONTAINER_NAME="app"

echo "Baixando a imagem mais recente..."
docker pull "$IMAGE"

echo "Parando o container anterior (se existir)..."
docker stop "$CONTAINER_NAME" 2>/dev/null || true
docker rm "$CONTAINER_NAME" 2>/dev/null || true

echo "Subindo o novo container..."
docker run -d \
  --name "$CONTAINER_NAME" \
  -p 8080:8080 \
  --restart unless-stopped \
  -e SPRING_DATASOURCE_URL="jdbc:mysql://${DB_HOST}:3306/ordem_servico" \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD="$DB_PASSWORD" \
  "$IMAGE"

echo "Deploy concluido. Verificando status..."
docker ps --filter "name=$CONTAINER_NAME"