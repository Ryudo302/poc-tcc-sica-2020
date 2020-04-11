--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.17
-- Dumped by pg_dump version 9.6.17

-- Started on 2020-04-08 02:16:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2120 (class 0 OID 0)
-- Dependencies: 2119
-- Name: DATABASE sica; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE sica IS 'Base de dados centralizada do Sistema de Controle Ambiental (SICA).';


--
-- TOC entry 4 (class 2615 OID 17144)
-- Name: ativos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA ativos;


ALTER SCHEMA ativos OWNER TO postgres;

--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA ativos; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA ativos IS 'Schema do módulo de Ativos.';


--
-- TOC entry 8 (class 2615 OID 17145)
-- Name: monitoramento; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA monitoramento;


ALTER SCHEMA monitoramento OWNER TO postgres;

--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 8
-- Name: SCHEMA monitoramento; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA monitoramento IS 'Schema do módulo de monitoramento.';


--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2127 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2122 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA ativos; Type: ACL; Schema: -; Owner: postgres
--

GRANT USAGE ON SCHEMA ativos TO sica_ativos;


--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 8
-- Name: SCHEMA monitoramento; Type: ACL; Schema: -; Owner: postgres
--

GRANT USAGE ON SCHEMA monitoramento TO sica_monitoramento;


--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT USAGE ON SCHEMA public TO sica_ativos;
GRANT USAGE ON SCHEMA public TO sica_monitoramento;


-- Completed on 2020-04-08 02:16:24

--
-- PostgreSQL database dump complete
--

