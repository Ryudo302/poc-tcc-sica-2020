#!/bin/bash

echo "Movendo JARs para diret�rio Docker"
mv workspace/sica-ativos/target/sica-ativos.jar docker/full/target/
mv workspace/sica-seguranca/target/sica-seguranca.jar docker/full/target/
mv workspace/sica-monitoramento/target/sica-monitoramento.jar docker/full/target/
mv workspace/sica-portal-web/target/sica-portal-web.jar docker/full/target/