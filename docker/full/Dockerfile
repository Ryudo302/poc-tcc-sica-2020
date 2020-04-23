FROM alpine:edge

LABEL maintainer="th.colbert@gmail.com"
LABEL version="1.0"

RUN apk add --no-cache openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community
RUN mkdir /opt/app /opt/app/logs

COPY /target/sica-ativos.jar /opt/app/
COPY /target/sica-seguranca.jar /opt/app/
COPY /target/sica-monitoramento.jar /opt/app/
COPY /target/sica-portal-web.jar /opt/app/

COPY bootstrap.sh /usr/local/bin/

ENTRYPOINT ["bootstrap.sh"]

CMD ["8081", "8082", "8083"]

EXPOSE 8080 8081 8082 8083
