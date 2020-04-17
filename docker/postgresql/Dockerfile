FROM postgres:9.4

LABEL maintainer="th.colbert@gmail.com"
LABEL version="1.0"

ADD ./sql/*.sql /docker-entrypoint-initdb.d/

RUN localedef -i pt_BR -c -f UTF-8 -A /usr/share/locale/locale.alias pt_BR.UTF-8

ENTRYPOINT ["docker-entrypoint.sh"]

EXPOSE 5432

CMD ["postgres"]
