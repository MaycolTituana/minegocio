PGDMP     9    )                {         	   minegocio    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            	           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            
           1262    16728 	   minegocio    DATABASE     ~   CREATE DATABASE minegocio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Ecuador.1252';
    DROP DATABASE minegocio;
                postgres    false            �            1259    16730    address    TABLE     �   CREATE TABLE public.address (
    id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    main_address boolean,
    province character varying(255),
    fk bigint
);
    DROP TABLE public.address;
       public         heap    postgres    false            �            1259    16729    address_id_seq    SEQUENCE     w   CREATE SEQUENCE public.address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.address_id_seq;
       public          postgres    false    215                       0    0    address_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.address_id_seq OWNED BY public.address.id;
          public          postgres    false    214            �            1259    16739    customer    TABLE       CREATE TABLE public.customer (
    id bigint NOT NULL,
    cellphone character varying(255),
    email character varying(255),
    identification_number character varying(255),
    identification_type character varying(255),
    names character varying(255)
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    16738    customer_id_seq    SEQUENCE     x   CREATE SEQUENCE public.customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.customer_id_seq;
       public          postgres    false    217                       0    0    customer_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;
          public          postgres    false    216            j           2604    16733 
   address id    DEFAULT     h   ALTER TABLE ONLY public.address ALTER COLUMN id SET DEFAULT nextval('public.address_id_seq'::regclass);
 9   ALTER TABLE public.address ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            k           2604    16742    customer id    DEFAULT     j   ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);
 :   ALTER TABLE public.customer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217                      0    16730    address 
   TABLE DATA           P   COPY public.address (id, address, city, main_address, province, fk) FROM stdin;
    public          postgres    false    215   �                 0    16739    customer 
   TABLE DATA           k   COPY public.customer (id, cellphone, email, identification_number, identification_type, names) FROM stdin;
    public          postgres    false    217   D                  0    0    address_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.address_id_seq', 11, true);
          public          postgres    false    214                       0    0    customer_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.customer_id_seq', 5, true);
          public          postgres    false    216            m           2606    16737    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    215            o           2606    16746    customer customer_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    217            q           2606    16748 %   customer uk_tniq2linpy6xp62eo6e9tk487 
   CONSTRAINT     q   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT uk_tniq2linpy6xp62eo6e9tk487 UNIQUE (identification_number);
 O   ALTER TABLE ONLY public.customer DROP CONSTRAINT uk_tniq2linpy6xp62eo6e9tk487;
       public            postgres    false    217            r           2606    16749 #   address fkqpgmlsjtrykint1nrx7nvno5m    FK CONSTRAINT     �   ALTER TABLE ONLY public.address
    ADD CONSTRAINT fkqpgmlsjtrykint1nrx7nvno5m FOREIGN KEY (fk) REFERENCES public.customer(id);
 M   ALTER TABLE ONLY public.address DROP CONSTRAINT fkqpgmlsjtrykint1nrx7nvno5m;
       public          postgres    false    217    3183    215               �   x���;�0E�zfY�)Q�҆�f�8�H�	���c����N�\M�q	pK�Бs�{�+9(�M��E��&�l��HMg}�N-��ʒ�-��*K�hi<UY�E�E���r(>���6��f��L�������/         �   x�e�?�0���=��g3!q�����iRx���7�^L0F+���Ld2/�6��88<\zt>i�gBj������y�Țm�����xm��R��JI���፛��v�km�׃��� �h���?M���~�&("Y-n�`j�p�� �� X�     