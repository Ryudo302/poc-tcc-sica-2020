-- Schemas

CREATE SCHEMA ativos;

CREATE SCHEMA monitoramento;

CREATE SCHEMA seguranca;

-- Usuários

CREATE USER sica_ativos WITH PASSWORD 'sica_ativos';

CREATE USER sica_monitoramento WITH PASSWORD 'sica_monitoramento';

CREATE USER sica_seguranca WITH PASSWORD 'sica_seguranca';

-- Owners

ALTER SCHEMA ativos OWNER TO sica_ativos;

ALTER SCHEMA monitoramento OWNER TO sica_monitoramento;

ALTER SCHEMA seguranca OWNER TO sica_seguranca;
