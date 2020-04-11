--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.17
-- Dumped by pg_dump version 9.6.17

-- Started on 2020-04-08 03:44:18

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
-- TOC entry 2129 (class 0 OID 17188)
-- Dependencies: 190
-- Data for Name: ativo; Type: TABLE DATA; Schema: ativos; Owner: sica_ativos
--

INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_imagem, id_tipo_ativo) VALUES (1, '2020-04-01', '2020-05-01 00:00:00', NULL, 'Caminhão de Mineração Caterpillar 785D', 123, 2);


-- Completed on 2020-04-08 03:44:19

--
-- PostgreSQL database dump complete
--

