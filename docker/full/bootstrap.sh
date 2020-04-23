#!/bin/sh

echo "Iniciando os serviços"
echo "Porta Ativos: $1"
echo "Porta Segurança: $2"
echo "Porta Monitoramento: $3"

cd /opt/app
/usr/bin/java -jar sica-ativos.jar -DlogsDir=logs --server.port=$1 &
/usr/bin/java -jar sica-seguranca.jar -DlogsDir=logs --server.port=$2 &
/usr/bin/java -jar sica-monitoramento.jar -DlogsDir=logs --server.port=$3 &
/usr/bin/java -jar sica-portal-web.jar -DlogsDir=logs