#!/bin/bash

docker compose down

json_file="./config/browsers.json"

images=$(jq -r '.. | objects | select(.image) | .image' "$json_file")

# Пробегаем по каждому образу и выполняем docker pull
for image in $images; do
    echo "Pulling $image..."
    docker pull "$image"
done

echo ">>> Запуск Docker Compose"
docker compose up -d

