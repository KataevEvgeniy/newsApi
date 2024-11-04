--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0
-- Dumped by pg_dump version 17.0

-- Started on 2024-11-04 08:25:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 221 (class 1259 OID 24633)
-- Name: article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article (
    article_id bigint NOT NULL,
    title character varying NOT NULL,
    author_id bigint NOT NULL
);


ALTER TABLE public.article OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 24684)
-- Name: article_article_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.article ALTER COLUMN article_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.article_article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 24646)
-- Name: article_image_block; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article_image_block (
    article_image_block_id bigint NOT NULL,
    article_id bigint NOT NULL,
    "position" bigint NOT NULL,
    image_url character varying NOT NULL,
    caption character varying
);


ALTER TABLE public.article_image_block OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24645)
-- Name: article_image_block_article_image_block_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.article_image_block ALTER COLUMN article_image_block_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.article_image_block_article_image_block_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 227 (class 1259 OID 24672)
-- Name: article_quote_block; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article_quote_block (
    article_quote_block_id bigint NOT NULL,
    article_id bigint NOT NULL,
    "position" bigint NOT NULL,
    quote character varying NOT NULL,
    author character varying
);


ALTER TABLE public.article_quote_block OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24671)
-- Name: article_quote_block_article_quote_block_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.article_quote_block ALTER COLUMN article_quote_block_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.article_quote_block_article_quote_block_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 24659)
-- Name: article_text_block; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article_text_block (
    article_text_block_id bigint NOT NULL,
    article_id bigint NOT NULL,
    "position" bigint NOT NULL,
    content character varying NOT NULL
);


ALTER TABLE public.article_text_block OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 24658)
-- Name: article_text_block_article_text_block_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.article_text_block ALTER COLUMN article_text_block_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.article_text_block_article_text_block_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 24620)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    role_id bigint NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24619)
-- Name: role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.role ALTER COLUMN role_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 24612)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    user_id bigint NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24627)
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."user" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4886 (class 0 OID 24633)
-- Dependencies: 221
-- Data for Name: article; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.article (article_id, title, author_id) FROM stdin;
1	gaming	4
3	hohoho	4
4	hohoho	4
\.


--
-- TOC entry 4888 (class 0 OID 24646)
-- Dependencies: 223
-- Data for Name: article_image_block; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.article_image_block (article_image_block_id, article_id, "position", image_url, caption) FROM stdin;
\.


--
-- TOC entry 4892 (class 0 OID 24672)
-- Dependencies: 227
-- Data for Name: article_quote_block; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.article_quote_block (article_quote_block_id, article_id, "position", quote, author) FROM stdin;
\.


--
-- TOC entry 4890 (class 0 OID 24659)
-- Dependencies: 225
-- Data for Name: article_text_block; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.article_text_block (article_text_block_id, article_id, "position", content) FROM stdin;
\.


--
-- TOC entry 4884 (class 0 OID 24620)
-- Dependencies: 219
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (role_id, name) FROM stdin;
1	user
2	admin
\.


--
-- TOC entry 4882 (class 0 OID 24612)
-- Dependencies: 217
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (user_id, username, password, role_id) FROM stdin;
1	111	$2a$10$rA9o03pEHI7kG.FoSQ4Vmekk/az5t9GZrx1a4NJECph.1P.wtkOa.	1
2	1121	$2a$10$n1N85N73BkVUI7tlL5rn9.EdnuXbMf8jUUlsWDPYFmQrK6hmpRW8y	1
3	11221	$2a$10$XQX5gXLtY5CbtaGPDPJdXe4R6vejtjEwhEL5xPjBG.NciIgWk94pa	1
4	1122d1	$2a$10$KWls8VRsRVPdVynVcT.MTOOteac0hrQu3.suDgj2Y8PEsoDt/a8Mi	1
5	1111	$2a$10$wsHjWSHQsFf1kvbdpx7CVeimmwUqS0EMvL9URtQCg2no0feN5mCJi	1
\.


--
-- TOC entry 4899 (class 0 OID 0)
-- Dependencies: 228
-- Name: article_article_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.article_article_id_seq', 5, true);


--
-- TOC entry 4900 (class 0 OID 0)
-- Dependencies: 222
-- Name: article_image_block_article_image_block_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.article_image_block_article_image_block_id_seq', 1, false);


--
-- TOC entry 4901 (class 0 OID 0)
-- Dependencies: 226
-- Name: article_quote_block_article_quote_block_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.article_quote_block_article_quote_block_id_seq', 1, false);


--
-- TOC entry 4902 (class 0 OID 0)
-- Dependencies: 224
-- Name: article_text_block_article_text_block_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.article_text_block_article_text_block_id_seq', 1, false);


--
-- TOC entry 4903 (class 0 OID 0)
-- Dependencies: 218
-- Name: role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_role_id_seq', 2, true);


--
-- TOC entry 4904 (class 0 OID 0)
-- Dependencies: 220
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_user_id_seq', 5, true);


--
-- TOC entry 4727 (class 2606 OID 24652)
-- Name: article_image_block article_image_block_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_image_block
    ADD CONSTRAINT article_image_block_pkey PRIMARY KEY (article_image_block_id);


--
-- TOC entry 4725 (class 2606 OID 24639)
-- Name: article article_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT article_pkey PRIMARY KEY (article_id);


--
-- TOC entry 4731 (class 2606 OID 24678)
-- Name: article_quote_block article_quote_block_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_quote_block
    ADD CONSTRAINT article_quote_block_pkey PRIMARY KEY (article_quote_block_id);


--
-- TOC entry 4729 (class 2606 OID 24665)
-- Name: article_text_block article_text_block_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_text_block
    ADD CONSTRAINT article_text_block_pkey PRIMARY KEY (article_text_block_id);


--
-- TOC entry 4723 (class 2606 OID 24626)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);


--
-- TOC entry 4721 (class 2606 OID 24618)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- TOC entry 4733 (class 2606 OID 24640)
-- Name: article article_author_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT article_author_id_fkey FOREIGN KEY (author_id) REFERENCES public."user"(user_id);


--
-- TOC entry 4734 (class 2606 OID 24653)
-- Name: article_image_block article_image_block_article_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_image_block
    ADD CONSTRAINT article_image_block_article_id_fkey FOREIGN KEY (article_id) REFERENCES public.article(article_id);


--
-- TOC entry 4736 (class 2606 OID 24679)
-- Name: article_quote_block article_quote_block_article_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_quote_block
    ADD CONSTRAINT article_quote_block_article_id_fkey FOREIGN KEY (article_id) REFERENCES public.article(article_id);


--
-- TOC entry 4735 (class 2606 OID 24666)
-- Name: article_text_block article_text_block_article_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_text_block
    ADD CONSTRAINT article_text_block_article_id_fkey FOREIGN KEY (article_id) REFERENCES public.article(article_id);


--
-- TOC entry 4732 (class 2606 OID 24628)
-- Name: user user_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(role_id) NOT VALID;


-- Completed on 2024-11-04 08:25:47

--
-- PostgreSQL database dump complete
--

