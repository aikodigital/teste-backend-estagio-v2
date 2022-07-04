--
-- PostgreSQL database dump
--

-- Dumped from database version 13.5
-- Dumped by pg_dump version 13.5

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

SET default_table_access_method = heap;

--
-- Name: equipment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment (
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    equipment_model_id uuid
);


ALTER TABLE public.equipment OWNER TO postgres;

--
-- Name: equipment_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment_model (
    id uuid NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.equipment_model OWNER TO postgres;

--
-- Name: equipment_model_state_hourly_earnings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment_model_state_hourly_earnings (
    id uuid NOT NULL,
    value real NOT NULL,
    equipment_model_id uuid,
    equipment_state_id uuid
);


ALTER TABLE public.equipment_model_state_hourly_earnings OWNER TO postgres;

--
-- Name: equipment_position_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment_position_history (
    id uuid NOT NULL,
    date timestamp without time zone NOT NULL,
    lat real NOT NULL,
    lon real NOT NULL,
    equipment_id uuid
);


ALTER TABLE public.equipment_position_history OWNER TO postgres;

--
-- Name: equipment_state; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment_state (
    id uuid NOT NULL,
    color character varying(100) NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.equipment_state OWNER TO postgres;

--
-- Name: equipment_state_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment_state_history (
    id uuid NOT NULL,
    date timestamp without time zone NOT NULL,
    equipment_id uuid,
    equipment_state_id uuid
);


ALTER TABLE public.equipment_state_history OWNER TO postgres;

--
-- Data for Name: equipment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment (id, name, equipment_model_id) FROM stdin;
27bb1831-7a6b-4b09-9bcf-0cf180fb6e79	CA-0001	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788
c3a54d1c-f06c-4f67-adeb-7d70038484c6	CA-0002	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788
77037391-dfe4-4fe9-a114-4d9586b65dd2	CA-0003	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788
853ed818-04b2-4e60-9128-0ed824182e83	CA-0004	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788
ec35dbb1-0c08-408a-9925-59f7dedc974a	HV-1001	91fe916a-d581-40ef-89d5-118ed52f5e67
a8cc0622-21eb-4af0-81f9-5ddbf7206de4	HV-1002	91fe916a-d581-40ef-89d5-118ed52f5e67
88467ff8-09b9-4fb1-8142-d3badefb304a	GT-2001	11f9da9c-f699-4620-abc6-85bb3d1d1ef1
3b1d4b37-b0de-4675-8db0-ec111a43b66b	GT-2002	11f9da9c-f699-4620-abc6-85bb3d1d1ef1
db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9	GT-2003	11f9da9c-f699-4620-abc6-85bb3d1d1ef1
\.


--
-- Data for Name: equipment_model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment_model (id, name) FROM stdin;
59deb6a5-5a7f-4eb3-82fd-acdcbcd31788	Caminhão de Carga
91fe916a-d581-40ef-89d5-118ed52f5e67	Harvester
11f9da9c-f699-4620-abc6-85bb3d1d1ef1	Garra traçadora
\.


--
-- Data for Name: equipment_model_state_hourly_earnings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment_model_state_hourly_earnings (id, value, equipment_model_id, equipment_state_id) FROM stdin;
847e8649-6fdd-47c1-a4bc-ee162ad46c00	100	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788	e85e89b0-3f0e-400b-bf62-d753e09c03ca
36f324b4-e00b-4766-ac8c-1c5dceb1204f	-5	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788	e85e89b0-3f0e-400b-bf62-d753e09c03ca
e22c1b2a-1486-4b7f-a65b-b76d9de99fa5	-20	59deb6a5-5a7f-4eb3-82fd-acdcbcd31788	e85e89b0-3f0e-400b-bf62-d753e09c03ca
6b6568b7-db4c-4185-89c5-7673e7f96b5d	200	91fe916a-d581-40ef-89d5-118ed52f5e67	836eb851-c3f2-4dc1-b4e0-420d5fec604e
1ea294fc-c762-4cee-b316-34d61faccfc4	-10	91fe916a-d581-40ef-89d5-118ed52f5e67	836eb851-c3f2-4dc1-b4e0-420d5fec604e
f16d5f96-42eb-4f7b-9820-494f2d0cd96d	-50	91fe916a-d581-40ef-89d5-118ed52f5e67	836eb851-c3f2-4dc1-b4e0-420d5fec604e
fbc2bdf1-a548-4fa2-9911-1e98d41b6cc7	70	11f9da9c-f699-4620-abc6-85bb3d1d1ef1	86ddcf22-d2b8-4f31-8b13-3811ef163843
b7962714-6c0e-41d4-a38c-31c21f50d00c	0	11f9da9c-f699-4620-abc6-85bb3d1d1ef1	86ddcf22-d2b8-4f31-8b13-3811ef163843
b873389d-1c99-426a-9bdb-1836fcdb50fe	-10	11f9da9c-f699-4620-abc6-85bb3d1d1ef1	86ddcf22-d2b8-4f31-8b13-3811ef163843
\.


--
-- Data for Name: equipment_position_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment_position_history (id, date, lat, lon, equipment_id) FROM stdin;
f9e0d355-c633-4566-bda0-b229058c26e9	2021-02-01 03:00:00	-19.126535	-45.947758	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
c269012c-6414-4add-9113-b890b8fca6ff	2021-02-01 15:00:00	-19.264235	-46.092438	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
e70b2d3e-cc10-4cd5-a191-22a33a08f6fe	2021-02-01 16:00:00	-19.171667	-46.04459	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
cc6e02b9-bc97-42e5-baa2-6887cf6935d9	2021-02-01 21:00:00	-19.150549	-45.999157	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
79a7198f-de61-4f42-8326-bdfffaa9f702	2021-02-01 22:00:00	-19.278563	-45.958984	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
f2ac7f62-e0a6-4147-9691-ec3ec15420f3	2021-02-02 09:00:00	-19.258919	-45.95551	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
04c3e5f0-9d7d-4575-ae2f-5b6a5488972d	2021-02-02 20:00:00	-19.126602	-46.095734	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
99785da7-f29a-4990-9b1e-142de12a8c6d	2021-02-03 01:00:00	-19.093422	-46.11474	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
bcaa672f-92fd-4bca-b935-dd0b6bb7fc0c	2021-02-03 06:00:00	-19.15588	-46.068405	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
3a9101c8-4a0c-4155-b334-df9e77b967b1	2021-02-03 20:00:00	-19.252605	-45.962177	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79
094e10ec-6c7d-4bcd-8b9f-40ce412da6fa	2021-02-01 03:00:00	-19.167337	-46.00347	c3a54d1c-f06c-4f67-adeb-7d70038484c6
fd51e1b2-dc88-4c70-a528-5b45d7987f29	2021-02-01 04:00:00	-19.061068	-45.97841	c3a54d1c-f06c-4f67-adeb-7d70038484c6
9bc08455-2e06-41a7-ae5d-55d5b480ed5a	2021-02-01 19:00:00	-19.07747	-45.958733	c3a54d1c-f06c-4f67-adeb-7d70038484c6
9f43b7c1-3fef-42b8-8cde-f7575c731054	2021-02-02 06:00:00	-19.104567	-45.947918	c3a54d1c-f06c-4f67-adeb-7d70038484c6
5d86d4c8-aed3-48e7-a4c6-f440ea0c62fb	2021-02-02 19:00:00	-19.05259	-45.95378	c3a54d1c-f06c-4f67-adeb-7d70038484c6
da4dc82d-402c-4c0d-ad29-539235b3cf2f	2021-02-03 02:00:00	-19.094984	-45.94251	c3a54d1c-f06c-4f67-adeb-7d70038484c6
44622835-c820-4ff7-8682-8ae6ab31a5bb	2021-02-03 05:00:00	-19.157614	-45.87628	c3a54d1c-f06c-4f67-adeb-7d70038484c6
964d2b78-34be-4f93-b338-08db12993bcf	2021-02-03 07:00:00	-19.031874	-45.992203	c3a54d1c-f06c-4f67-adeb-7d70038484c6
98a0b5ff-0fb9-4810-816e-174d34a22d16	2021-02-03 20:00:00	-19.031229	-45.9928	c3a54d1c-f06c-4f67-adeb-7d70038484c6
3df8caa3-2b04-46b0-ab4f-6923048371f6	2021-02-04 12:00:00	-19.151432	-45.898144	c3a54d1c-f06c-4f67-adeb-7d70038484c6
650988cb-a08c-489d-a70c-9025ce1d2a7e	2021-02-01 03:00:00	-19.192595	-46.061073	77037391-dfe4-4fe9-a114-4d9586b65dd2
16c74683-e592-4c6e-941f-af5b5ffc49a1	2021-02-01 04:00:00	-19.08271	-46.133522	77037391-dfe4-4fe9-a114-4d9586b65dd2
de15e963-8194-44cb-a6c2-2c4d677cb614	2021-02-01 13:00:00	-19.223635	-46.136627	77037391-dfe4-4fe9-a114-4d9586b65dd2
eaa4acb2-03b4-4a0b-8f4d-6e5403d2f69f	2021-02-02 02:00:00	-19.170004	-46.035786	77037391-dfe4-4fe9-a114-4d9586b65dd2
aa4cee74-8b01-46e6-8635-4b386b75760c	2021-02-02 05:00:00	-19.233	-46.007153	77037391-dfe4-4fe9-a114-4d9586b65dd2
274cc93d-4765-4136-8058-b6fab52e22c0	2021-02-02 06:00:00	-19.126516	-45.98707	77037391-dfe4-4fe9-a114-4d9586b65dd2
29c91f81-a3f3-4604-b0c2-a732d0350b7d	2021-02-02 13:00:00	-19.229181	-46.058334	77037391-dfe4-4fe9-a114-4d9586b65dd2
1cabbe12-35eb-4107-8131-5c75d3be333f	2021-02-02 14:00:00	-19.09598	-45.9699	77037391-dfe4-4fe9-a114-4d9586b65dd2
10e2059b-cd1c-46a6-bee5-27d3e7e77f71	2021-02-02 21:00:00	-19.226007	-45.980442	77037391-dfe4-4fe9-a114-4d9586b65dd2
cbf7507f-6992-43b5-9dfc-a537b1c2d929	2021-02-03 04:00:00	-19.233423	-45.969704	77037391-dfe4-4fe9-a114-4d9586b65dd2
6ce0ecca-eca7-4645-a65e-79a87d8a29e2	2021-02-01 03:00:00	-19.03822	-45.85623	853ed818-04b2-4e60-9128-0ed824182e83
16a657c5-74c8-4117-b5db-52b6093cfba4	2021-02-01 18:00:00	-19.069426	-45.83276	853ed818-04b2-4e60-9128-0ed824182e83
7c16bb5e-be2d-4ee0-b11a-147e129f7696	2021-02-01 23:00:00	-19.142263	-45.999943	853ed818-04b2-4e60-9128-0ed824182e83
6e8716fa-3362-410c-9ddc-57682e44a96a	2021-02-02 08:00:00	-18.983774	-45.816933	853ed818-04b2-4e60-9128-0ed824182e83
4d4fa554-1a9c-428c-8687-ec5a58537594	2021-02-03 00:00:00	-19.109919	-45.902706	853ed818-04b2-4e60-9128-0ed824182e83
600ebd7a-7cc4-4582-8f10-78f7b9310eed	2021-02-03 01:00:00	-19.146652	-45.938477	853ed818-04b2-4e60-9128-0ed824182e83
0019eb18-89fa-4d50-89b6-d2996a1b8f1e	2021-02-03 03:00:00	-19.14157	-45.919804	853ed818-04b2-4e60-9128-0ed824182e83
52a9517c-f29e-4ff4-a7db-7ab0bf612279	2021-02-03 10:00:00	-18.998554	-45.813488	853ed818-04b2-4e60-9128-0ed824182e83
4edab814-162b-452d-810c-2725bf7e524a	2021-02-03 11:00:00	-19.160852	-45.982788	853ed818-04b2-4e60-9128-0ed824182e83
07498eee-6770-46f8-9a08-d07038ef4bd4	2021-02-03 15:00:00	-19.036213	-45.844307	853ed818-04b2-4e60-9128-0ed824182e83
738a780a-d514-4941-a4b4-42831363837b	2021-02-03 16:00:00	-18.99451	-45.857162	853ed818-04b2-4e60-9128-0ed824182e83
56683749-0bf3-4145-9132-61afc2e32d08	2021-02-01 03:00:00	-19.017807	-45.949722	ec35dbb1-0c08-408a-9925-59f7dedc974a
1503649c-3d80-44dc-a861-fb92dfbdc876	2021-02-01 05:00:00	-19.072704	-46.066845	ec35dbb1-0c08-408a-9925-59f7dedc974a
07c033e1-d5d5-4da7-9e87-1d89c53aca62	2021-02-01 20:00:00	-19.122652	-45.89373	ec35dbb1-0c08-408a-9925-59f7dedc974a
1fa68154-3ab6-47f3-8176-ebebf899ddac	2021-02-01 22:00:00	-18.978928	-45.93131	ec35dbb1-0c08-408a-9925-59f7dedc974a
7d8f15ee-1ba5-40d7-80d8-50fcae1e02eb	2021-02-02 01:00:00	-19.09258	-45.94408	ec35dbb1-0c08-408a-9925-59f7dedc974a
48a05a2b-d7e4-4fc4-b9b5-ccdca3f58bfc	2021-02-02 13:00:00	-19.15399	-45.92752	ec35dbb1-0c08-408a-9925-59f7dedc974a
67abd658-9cd6-404b-b416-5d3b5abb20a0	2021-02-03 03:00:00	-19.106043	-46.040062	ec35dbb1-0c08-408a-9925-59f7dedc974a
48ac56d5-74a1-45a5-b495-7e7bb4cc74f7	2021-02-03 09:00:00	-19.105404	-46.0039	ec35dbb1-0c08-408a-9925-59f7dedc974a
2db71e35-d840-4363-aedf-7768e7ed0464	2021-02-04 00:00:00	-18.987158	-46.037014	ec35dbb1-0c08-408a-9925-59f7dedc974a
13ed71d6-037d-44dc-9dc7-b2d9ec5873a6	2021-02-04 10:00:00	-19.132133	-46.068306	ec35dbb1-0c08-408a-9925-59f7dedc974a
22fcf94a-abef-4459-98a2-e3294acab9cc	2021-02-01 03:00:00	-19.163956	-46.087833	88467ff8-09b9-4fb1-8142-d3badefb304a
b3083eee-fa04-4380-b048-347446b8053d	2021-02-01 15:00:00	-19.157904	-46.100807	88467ff8-09b9-4fb1-8142-d3badefb304a
5d3e7ffd-dc37-4642-ab9a-7eb7fa6a0022	2021-02-02 04:00:00	-19.225784	-46.07859	88467ff8-09b9-4fb1-8142-d3badefb304a
a6759374-27e5-44a8-bbde-6ec199b11765	2021-02-02 14:00:00	-19.284306	-45.95334	88467ff8-09b9-4fb1-8142-d3badefb304a
05fd0072-7033-486c-ac51-22f7d8ff7c86	2021-02-02 21:00:00	-19.194042	-45.953167	88467ff8-09b9-4fb1-8142-d3badefb304a
b35498cd-c9ab-4830-8ff2-6c2311cc97b2	2021-02-03 03:00:00	-19.1624	-45.963646	88467ff8-09b9-4fb1-8142-d3badefb304a
1e2606e2-9fc9-45c8-944e-29203872af08	2021-02-03 10:00:00	-19.335812	-46.028378	88467ff8-09b9-4fb1-8142-d3badefb304a
090f0d07-2eb0-480a-a07d-287485ed2cb5	2021-02-03 22:00:00	-19.316156	-45.9345	88467ff8-09b9-4fb1-8142-d3badefb304a
bcbe7c2d-3aac-4999-a840-8228963da470	2021-02-04 03:00:00	-19.221846	-46.0377	88467ff8-09b9-4fb1-8142-d3badefb304a
f056b95d-fd78-4593-b90c-37c6d16b1498	2021-02-01 03:00:00	-19.215664	-46.040363	3b1d4b37-b0de-4675-8db0-ec111a43b66b
95ab8afc-5379-45ab-b18c-3adf917ba980	2021-02-01 13:00:00	-19.15769	-45.963264	3b1d4b37-b0de-4675-8db0-ec111a43b66b
a09fa094-c66c-4881-8896-0dda126b6106	2021-02-01 23:00:00	-19.145493	-46.08738	3b1d4b37-b0de-4675-8db0-ec111a43b66b
9908e9ac-5ba1-45dd-af74-343e1c30dc25	2021-02-02 02:00:00	-19.098978	-46.079987	3b1d4b37-b0de-4675-8db0-ec111a43b66b
adf26992-13a5-41a4-94d7-10114498ba2e	2021-02-02 12:00:00	-19.049284	-45.98634	3b1d4b37-b0de-4675-8db0-ec111a43b66b
a4b2bcf2-fdd4-4adc-9dd1-e9fd15788d53	2021-02-02 16:00:00	-19.076088	-45.964836	3b1d4b37-b0de-4675-8db0-ec111a43b66b
1c8d3b43-24bf-4be3-9786-0739bbaf6629	2021-02-02 16:00:00	-19.076088	-45.964836	3b1d4b37-b0de-4675-8db0-ec111a43b66b
1dc4bc78-0693-438e-b7c3-d2dcb580b2b6	2021-02-03 06:00:00	-19.137814	-46.02058	3b1d4b37-b0de-4675-8db0-ec111a43b66b
024c329a-9f42-418d-b6cd-483bf7873774	2021-02-03 19:00:00	-19.1769	-46.129913	3b1d4b37-b0de-4675-8db0-ec111a43b66b
52271253-bc51-454b-b793-9429d2df0987	2021-02-04 05:00:00	-19.05604	-45.98565	3b1d4b37-b0de-4675-8db0-ec111a43b66b
0e08031f-2652-4229-baea-6681a56877c3	2021-02-01 03:00:00	-19.272005	-46.043373	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
907f64e7-be26-42b7-8fb4-08b7e223dfa2	2021-02-01 12:00:00	-19.199015	-45.91484	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
6ff4d905-24b0-4efa-81c0-8c41ff50786a	2021-02-01 23:00:00	-19.236496	-45.994675	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
30e1f977-50fb-43f7-9327-7640ac0e9d0e	2021-02-02 08:00:00	-19.223965	-46.035133	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
f6c504d1-c1cb-4c2a-8c39-357cc3dea37c	2021-02-02 12:00:00	-19.276005	-45.941307	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
ed5f50ec-9702-4285-9c0f-edef070a4a50	2021-02-03 00:00:00	-19.287668	-46.074825	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
ada61172-e06f-43ac-a4f3-23b2e3af7554	2021-02-03 10:00:00	-19.273403	-45.9581	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
39af0cba-12cb-4d4c-97d4-b009fc26dd68	2021-02-04 00:00:00	-19.186264	-46.070522	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
690c6076-2975-4892-a560-7a4bacbc6511	2021-02-04 08:00:00	-19.279291	-45.97669	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
021ccf8d-76bc-4e31-87df-40ef92000993	2021-02-04 15:00:00	-19.174877	-45.90855	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9
755b2ccc-bc6e-492d-ab8b-7ba2d0a58a8d	2021-02-01 03:00:00	-19.300732	-46.107544	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
cd9c27fd-ff93-41f0-9dcf-966fddacbb2b	2021-02-01 06:00:00	-19.274424	-46.039814	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
b11001a9-a6c7-490b-94b1-729b5656fb1f	2021-02-01 17:00:00	-19.15557	-46.09363	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
fdc2cb17-0db4-4ac4-977c-e107368cf133	2021-02-02 05:00:00	-19.240734	-46.080067	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
3d73e9a3-ce48-4e0b-8cdc-a915d2dfe27a	2021-02-02 10:00:00	-19.16149	-46.023315	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
91eb1453-39a2-43ab-be00-5bae10f272e9	2021-02-03 02:00:00	-19.233019	-46.08419	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
0bd509f2-2a00-4654-b66b-bd13809325bb	2021-02-03 14:00:00	-19.314041	-46.01901	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
4b938566-5f67-4a99-881e-df2c2f408112	2021-02-04 05:00:00	-19.202932	-45.999203	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
e6cf1ff4-5d73-4e2a-9152-49162ad285ab	2021-02-04 06:00:00	-19.156155	-46.033386	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
4ad2f9f2-17d8-4bb0-9c17-5a99d4fc1729	2021-02-04 07:00:00	-19.201506	-45.97973	a8cc0622-21eb-4af0-81f9-5ddbf7206de4
\.


--
-- Data for Name: equipment_state; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment_state (id, color, name) FROM stdin;
e85e89b0-3f0e-400b-bf62-d753e09c03ca	#2ecc71	Operando
836eb851-c3f2-4dc1-b4e0-420d5fec604e	#e74c3c	Manutenção
86ddcf22-d2b8-4f31-8b13-3811ef163843	#f1c40f	Parado
\.


--
-- Data for Name: equipment_state_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment_state_history (id, date, equipment_id, equipment_state_id) FROM stdin;
e50e9daa-a5f8-4eed-8aca-7a174799f98a	2021-02-06 15:00:00	27bb1831-7a6b-4b09-9bcf-0cf180fb6e79	e85e89b0-3f0e-400b-bf62-d753e09c03ca
0dec61d2-83e5-4171-8575-46d16adc4b03	2021-02-06 19:00:00	c3a54d1c-f06c-4f67-adeb-7d70038484c6	e85e89b0-3f0e-400b-bf62-d753e09c03ca
d40a39fa-a0c2-4b5c-ab91-f8675e988f23	2021-02-06 23:00:00	77037391-dfe4-4fe9-a114-4d9586b65dd2	e85e89b0-3f0e-400b-bf62-d753e09c03ca
2f851fdd-49bf-49a2-9cba-d618b8ec50fd	2021-02-07 00:00:00	853ed818-04b2-4e60-9128-0ed824182e83	836eb851-c3f2-4dc1-b4e0-420d5fec604e
7b2541ce-757c-45e0-83a9-33112fc93919	2021-02-07 08:00:00	ec35dbb1-0c08-408a-9925-59f7dedc974a	836eb851-c3f2-4dc1-b4e0-420d5fec604e
fe154116-a7f8-470d-8d0b-16ae05bc7bb3	2021-02-07 11:00:00	a8cc0622-21eb-4af0-81f9-5ddbf7206de4	836eb851-c3f2-4dc1-b4e0-420d5fec604e
40b3d83d-ce0a-409b-9130-e84511c39a37	2021-02-07 17:00:00	88467ff8-09b9-4fb1-8142-d3badefb304a	86ddcf22-d2b8-4f31-8b13-3811ef163843
af7345f6-89d4-4071-b576-4a3d84d08044	2021-02-07 20:00:00	3b1d4b37-b0de-4675-8db0-ec111a43b66b	86ddcf22-d2b8-4f31-8b13-3811ef163843
af2ff86a-e3fd-4ebd-b7a9-6b6118d8d146	2021-02-08 09:00:00	db566a8a-b0f7-40c6-91f2-f7d5b7cf72d9	86ddcf22-d2b8-4f31-8b13-3811ef163843
\.


--
-- Name: equipment_model equipment_model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_model
    ADD CONSTRAINT equipment_model_pkey PRIMARY KEY (id);


--
-- Name: equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_model_state_hourly_earnings
    ADD CONSTRAINT equipment_model_state_hourly_earnings_pkey PRIMARY KEY (id);


--
-- Name: equipment equipment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT equipment_pkey PRIMARY KEY (id);


--
-- Name: equipment_position_history equipment_position_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_position_history
    ADD CONSTRAINT equipment_position_history_pkey PRIMARY KEY (id);


--
-- Name: equipment_state_history equipment_state_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_state_history
    ADD CONSTRAINT equipment_state_history_pkey PRIMARY KEY (id);


--
-- Name: equipment_state equipment_state_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_state
    ADD CONSTRAINT equipment_state_pkey PRIMARY KEY (id);


--
-- Name: equipment_model_state_hourly_earnings fk4qgsqttbi93giw1dv7wpek7rq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_model_state_hourly_earnings
    ADD CONSTRAINT fk4qgsqttbi93giw1dv7wpek7rq FOREIGN KEY (equipment_model_id) REFERENCES public.equipment_model(id);


--
-- Name: equipment_position_history fka49fh2hu80oj5imjrmqfep9yl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_position_history
    ADD CONSTRAINT fka49fh2hu80oj5imjrmqfep9yl FOREIGN KEY (equipment_id) REFERENCES public.equipment(id);


--
-- Name: equipment_state_history fkbjoisje51kuxlm2j8n47qexas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_state_history
    ADD CONSTRAINT fkbjoisje51kuxlm2j8n47qexas FOREIGN KEY (equipment_id) REFERENCES public.equipment(id);


--
-- Name: equipment fkcuj2jw9cv3p5f9icrqyorc7eb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT fkcuj2jw9cv3p5f9icrqyorc7eb FOREIGN KEY (equipment_model_id) REFERENCES public.equipment_model(id);


--
-- Name: equipment_model_state_hourly_earnings fklvnisfbgnceki5vdcx4007lvf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_model_state_hourly_earnings
    ADD CONSTRAINT fklvnisfbgnceki5vdcx4007lvf FOREIGN KEY (equipment_state_id) REFERENCES public.equipment_state(id);


--
-- Name: equipment_state_history fkw93ox1tgtivyxx9qfwdhx0bd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment_state_history
    ADD CONSTRAINT fkw93ox1tgtivyxx9qfwdhx0bd FOREIGN KEY (equipment_state_id) REFERENCES public.equipment_state(id);


--
-- PostgreSQL database dump complete
--

