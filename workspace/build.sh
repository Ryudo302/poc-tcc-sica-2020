#/bin/bash
mvn clean install -f ./sica-parent/pom.xml
mvn clean install -f ./driver-sensores/pom.xml
mvn clean install -f ./sica-commons/pom.xml
mvn clean package -f ./sica-ativos/pom.xml
mvn clean package -f ./sica-monitoramento/pom.xml
mvn clean package -f ./sica-seguranca/pom.xml
mvn clean package -f ./sica-portal-web/pom.xml
