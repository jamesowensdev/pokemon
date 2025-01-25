--
-- PostgreSQL database dump
--

-- Dumped from database version 14.13 (Homebrew)
-- Dumped by pg_dump version 14.15 (Homebrew)

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
-- Name: catalogue; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA catalogue;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cards; Type: TABLE; Schema: catalogue; Owner: -
--

CREATE TABLE catalogue.cards (
    card_id character varying(50) NOT NULL,
    card_name character varying(255) NOT NULL,
    card_type character varying(100) NOT NULL,
    set_id character varying(50) NOT NULL,
    rarity character varying(100) NOT NULL,
    card_image_link text NOT NULL
);


--
-- Name: sets; Type: TABLE; Schema: catalogue; Owner: -
--

CREATE TABLE catalogue.sets (
    set_id character varying(50) NOT NULL,
    set_name character varying(255) NOT NULL,
    series character varying(255) NOT NULL,
    card_total integer NOT NULL,
    release_date date NOT NULL,
    symbol_image_link text NOT NULL
);


--
-- Name: owned_cards; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.owned_cards (
    owned_card_id integer NOT NULL,
    owner_id bigint NOT NULL,
    card_id character varying(50) NOT NULL,
    condition character varying(50),
    graded boolean NOT NULL,
    rating integer
);


--
-- Name: owned_cards_owned_card_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.owned_cards_owned_card_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: owned_cards_owned_card_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.owned_cards_owned_card_id_seq OWNED BY public.owned_cards.owned_card_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    username character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(50) DEFAULT 'USER'::character varying
);


--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- Name: owned_cards owned_card_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.owned_cards ALTER COLUMN owned_card_id SET DEFAULT nextval('public.owned_cards_owned_card_id_seq'::regclass);


--
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- Name: cards cards_pkey; Type: CONSTRAINT; Schema: catalogue; Owner: -
--

ALTER TABLE ONLY catalogue.cards
    ADD CONSTRAINT cards_pkey PRIMARY KEY (card_id);


--
-- Name: sets sets_pkey; Type: CONSTRAINT; Schema: catalogue; Owner: -
--

ALTER TABLE ONLY catalogue.sets
    ADD CONSTRAINT sets_pkey PRIMARY KEY (set_id);


--
-- Name: owned_cards owned_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.owned_cards
    ADD CONSTRAINT owned_cards_pkey PRIMARY KEY (owned_card_id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: idx_cards_card_name; Type: INDEX; Schema: catalogue; Owner: -
--

CREATE INDEX idx_cards_card_name ON catalogue.cards USING btree (card_name);


--
-- Name: idx_cards_rarity; Type: INDEX; Schema: catalogue; Owner: -
--

CREATE INDEX idx_cards_rarity ON catalogue.cards USING btree (rarity);


--
-- Name: idx_cards_set_id; Type: INDEX; Schema: catalogue; Owner: -
--

CREATE INDEX idx_cards_set_id ON catalogue.cards USING btree (set_id);


--
-- Name: idx_sets_release_date; Type: INDEX; Schema: catalogue; Owner: -
--

CREATE INDEX idx_sets_release_date ON catalogue.sets USING btree (release_date);


--
-- Name: idx_sets_set_name; Type: INDEX; Schema: catalogue; Owner: -
--

CREATE INDEX idx_sets_set_name ON catalogue.sets USING btree (set_name);


--
-- Name: idx_owned_cards_card_id; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_owned_cards_card_id ON public.owned_cards USING btree (card_id);


--
-- Name: idx_owned_cards_condition; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_owned_cards_condition ON public.owned_cards USING btree (condition);


--
-- Name: idx_owned_cards_owner_id; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_owned_cards_owner_id ON public.owned_cards USING btree (owner_id);


--
-- Name: idx_users_email; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX idx_users_email ON public.users USING btree (email);


--
-- Name: idx_users_username; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX idx_users_username ON public.users USING btree (username);


--
-- Name: cards cards_set_id_fkey; Type: FK CONSTRAINT; Schema: catalogue; Owner: -
--

ALTER TABLE ONLY catalogue.cards
    ADD CONSTRAINT cards_set_id_fkey FOREIGN KEY (set_id) REFERENCES catalogue.sets(set_id) ON DELETE CASCADE;


--
-- Name: owned_cards owned_cards_card_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.owned_cards
    ADD CONSTRAINT owned_cards_card_id_fkey FOREIGN KEY (card_id) REFERENCES catalogue.cards(card_id) ON DELETE CASCADE;


--
-- Name: owned_cards owned_cards_owner_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.owned_cards
    ADD CONSTRAINT owned_cards_owner_id_fkey FOREIGN KEY (owner_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

