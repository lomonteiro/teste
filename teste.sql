--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7 (Ubuntu 11.7-0ubuntu0.19.10.1)
-- Dumped by pg_dump version 11.7 (Ubuntu 11.7-0ubuntu0.19.10.1)

-- Started on 2020-02-20 02:27:01 -03

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16519)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id integer NOT NULL,
    data_cadastro timestamp without time zone,
    id_cliente integer,
    nome_produto character varying(255),
    numero_controle integer,
    quantidade_produto integer,
    total numeric(19,2),
    valor_produto numeric(19,2)
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16526)
-- Name: pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_seq OWNER TO postgres;

--
-- TOC entry 2938 (class 0 OID 16519)
-- Dependencies: 196
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (id, data_cadastro, id_cliente, nome_produto, numero_controle, quantidade_produto, total, valor_produto) FROM stdin;
\.


--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 197
-- Name: pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_seq', 1, false);


--
-- TOC entry 2814 (class 2606 OID 16523)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2816 (class 2606 OID 16525)
-- Name: pedido uk_83tkdvmgme3ld191f1aq1ek0w; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT uk_83tkdvmgme3ld191f1aq1ek0w UNIQUE (numero_controle);


-- Completed on 2020-02-20 02:27:01 -03

--
-- PostgreSQL database dump complete
--

