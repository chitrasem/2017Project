CREATE TABLE public.tb_sequence (
	tbl_nm varchar(30) NOT NULL,
	lst_seq int4 NULL,
	lst_chng_dttm varchar(14) NULL,
	CONSTRAINT tb_uid_seq_pkey PRIMARY KEY (tbl_nm)
)
WITH (
	OIDS=FALSE
) ;
