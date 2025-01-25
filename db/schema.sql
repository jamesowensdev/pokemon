--
-- PostgreSQL database dump
--

-- Dumped from database version 14.13 (Homebrew)
-- Dumped by pg_dump version 17.0

-- Started on 2025-01-25 23:43:44 GMT

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

--
-- TOC entry 6 (class 2615 OID 16417)
-- Name: catalogue; Type: SCHEMA; Schema: -; Owner: jamesowens
--

CREATE SCHEMA catalogue;


ALTER SCHEMA catalogue OWNER TO jamesowens;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: jamesowens
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO jamesowens;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 16446)
-- Name: cards; Type: TABLE; Schema: catalogue; Owner: jamesowens
--

CREATE TABLE catalogue.cards (
    card_id character varying(50) NOT NULL,
    card_name character varying(255) NOT NULL,
    card_type character varying(100) NOT NULL,
    set_id character varying(50) NOT NULL,
    rarity character varying(100) NOT NULL,
    card_image_link text NOT NULL
);


ALTER TABLE catalogue.cards OWNER TO jamesowens;

--
-- TOC entry 212 (class 1259 OID 16432)
-- Name: sets; Type: TABLE; Schema: catalogue; Owner: jamesowens
--

CREATE TABLE catalogue.sets (
    set_id character varying(50) NOT NULL,
    set_name character varying(255) NOT NULL,
    series character varying(255) NOT NULL,
    card_total integer NOT NULL,
    release_date date NOT NULL,
    symbol_image_link text NOT NULL
);


ALTER TABLE catalogue.sets OWNER TO jamesowens;

--
-- TOC entry 215 (class 1259 OID 16471)
-- Name: owned_cards; Type: TABLE; Schema: public; Owner: jamesowens
--

CREATE TABLE public.owned_cards (
    owned_card_id integer NOT NULL,
    owner_id bigint NOT NULL,
    card_id character varying(50) NOT NULL,
    condition character varying(50),
    graded boolean NOT NULL,
    rating integer
);


ALTER TABLE public.owned_cards OWNER TO jamesowens;

--
-- TOC entry 214 (class 1259 OID 16470)
-- Name: owned_cards_owned_card_id_seq; Type: SEQUENCE; Schema: public; Owner: jamesowens
--

CREATE SEQUENCE public.owned_cards_owned_card_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.owned_cards_owned_card_id_seq OWNER TO jamesowens;

--
-- TOC entry 3645 (class 0 OID 0)
-- Dependencies: 214
-- Name: owned_cards_owned_card_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jamesowens
--

ALTER SEQUENCE public.owned_cards_owned_card_id_seq OWNED BY public.owned_cards.owned_card_id;


--
-- TOC entry 211 (class 1259 OID 16391)
-- Name: users; Type: TABLE; Schema: public; Owner: jamesowens
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    username character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(50) DEFAULT 'USER'::character varying
);


ALTER TABLE public.users OWNER TO jamesowens;

--
-- TOC entry 210 (class 1259 OID 16390)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: jamesowens
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO jamesowens;

--
-- TOC entry 3646 (class 0 OID 0)
-- Dependencies: 210
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jamesowens
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 3468 (class 2604 OID 16474)
-- Name: owned_cards owned_card_id; Type: DEFAULT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.owned_cards ALTER COLUMN owned_card_id SET DEFAULT nextval('public.owned_cards_owned_card_id_seq'::regclass);


--
-- TOC entry 3466 (class 2604 OID 16394)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 3482 (class 2606 OID 16452)
-- Name: cards cards_pkey; Type: CONSTRAINT; Schema: catalogue; Owner: jamesowens
--

ALTER TABLE ONLY catalogue.cards
    ADD CONSTRAINT cards_pkey PRIMARY KEY (card_id);


--
-- TOC entry 3480 (class 2606 OID 16438)
-- Name: sets sets_pkey; Type: CONSTRAINT; Schema: catalogue; Owner: jamesowens
--

ALTER TABLE ONLY catalogue.sets
    ADD CONSTRAINT sets_pkey PRIMARY KEY (set_id);


--
-- TOC entry 3490 (class 2606 OID 16476)
-- Name: owned_cards owned_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.owned_cards
    ADD CONSTRAINT owned_cards_pkey PRIMARY KEY (owned_card_id);


--
-- TOC entry 3472 (class 2606 OID 16404)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 3474 (class 2606 OID 16400)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3476 (class 2606 OID 16402)
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- TOC entry 3483 (class 1259 OID 16491)
-- Name: idx_cards_card_name; Type: INDEX; Schema: catalogue; Owner: jamesowens
--

CREATE INDEX idx_cards_card_name ON catalogue.cards USING btree (card_name);


--
-- TOC entry 3484 (class 1259 OID 16492)
-- Name: idx_cards_rarity; Type: INDEX; Schema: catalogue; Owner: jamesowens
--

CREATE INDEX idx_cards_rarity ON catalogue.cards USING btree (rarity);


--
-- TOC entry 3485 (class 1259 OID 16490)
-- Name: idx_cards_set_id; Type: INDEX; Schema: catalogue; Owner: jamesowens
--

CREATE INDEX idx_cards_set_id ON catalogue.cards USING btree (set_id);


--
-- TOC entry 3477 (class 1259 OID 16496)
-- Name: idx_sets_release_date; Type: INDEX; Schema: catalogue; Owner: jamesowens
--

CREATE INDEX idx_sets_release_date ON catalogue.sets USING btree (release_date);


--
-- TOC entry 3478 (class 1259 OID 16489)
-- Name: idx_sets_set_name; Type: INDEX; Schema: catalogue; Owner: jamesowens
--

CREATE INDEX idx_sets_set_name ON catalogue.sets USING btree (set_name);


--
-- TOC entry 3486 (class 1259 OID 16494)
-- Name: idx_owned_cards_card_id; Type: INDEX; Schema: public; Owner: jamesowens
--

CREATE INDEX idx_owned_cards_card_id ON public.owned_cards USING btree (card_id);


--
-- TOC entry 3487 (class 1259 OID 16495)
-- Name: idx_owned_cards_condition; Type: INDEX; Schema: public; Owner: jamesowens
--

CREATE INDEX idx_owned_cards_condition ON public.owned_cards USING btree (condition);


--
-- TOC entry 3488 (class 1259 OID 16493)
-- Name: idx_owned_cards_owner_id; Type: INDEX; Schema: public; Owner: jamesowens
--

CREATE INDEX idx_owned_cards_owner_id ON public.owned_cards USING btree (owner_id);


--
-- TOC entry 3469 (class 1259 OID 16488)
-- Name: idx_users_email; Type: INDEX; Schema: public; Owner: jamesowens
--

CREATE UNIQUE INDEX idx_users_email ON public.users USING btree (email);


--
-- TOC entry 3470 (class 1259 OID 16487)
-- Name: idx_users_username; Type: INDEX; Schema: public; Owner: jamesowens
--

CREATE UNIQUE INDEX idx_users_username ON public.users USING btree (username);


--
-- TOC entry 3491 (class 2606 OID 16453)
-- Name: cards cards_set_id_fkey; Type: FK CONSTRAINT; Schema: catalogue; Owner: jamesowens
--

ALTER TABLE ONLY catalogue.cards
    ADD CONSTRAINT cards_set_id_fkey FOREIGN KEY (set_id) REFERENCES catalogue.sets(set_id) ON DELETE CASCADE;


--
-- TOC entry 3492 (class 2606 OID 16482)
-- Name: owned_cards owned_cards_card_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.owned_cards
    ADD CONSTRAINT owned_cards_card_id_fkey FOREIGN KEY (card_id) REFERENCES catalogue.cards(card_id) ON DELETE CASCADE;


--
-- TOC entry 3493 (class 2606 OID 16477)
-- Name: owned_cards owned_cards_owner_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: jamesowens
--

ALTER TABLE ONLY public.owned_cards
    ADD CONSTRAINT owned_cards_owner_id_fkey FOREIGN KEY (owner_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- TOC entry 3644 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: jamesowens
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2025-01-25 23:43:44 GMT

--
-- PostgreSQL database dump complete
--

