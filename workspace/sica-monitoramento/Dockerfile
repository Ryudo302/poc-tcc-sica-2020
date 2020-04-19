FROM alpine:edge

LABEL maintainer="th.colbert@gmail.com"
LABEL version="1.0"

RUN apk add --no-cache openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community
RUN mkdir /opt/app /opt/app/logs

COPY target/sica-monitoramento.jar /opt/app

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar", "/opt/app/sica-monitoramento.jar", "-DlogsDir=/opt/app/logs"]

EXPOSE 8080
