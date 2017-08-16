CREATE OR REPLACE FUNCTION public.fn_tb_uid_seq(tbl character varying)
 RETURNS numeric
 LANGUAGE plpgsql
AS $function$
DECLARE
    SEQ NUMERIC;
BEGIN
    SELECT  LST_SEQ
      INTO  SEQ
      FROM  TB_SEQUENCE
     WHERE  TBL_NM  = $1
       FOR  UPDATE
     ;

    IF SEQ IS NULL THEN
        SEQ = 1;
        INSERT INTO TB_SEQUENCE(TBL_NM, LST_SEQ, LST_CHNG_DTTM)
        VALUES($1, SEQ, TO_CHAR(NOW(), 'YYYYMMDDHH24MISS'));
    ELSE
        SEQ = SEQ + 1;
        UPDATE  TB_SEQUENCE
           SET  LST_SEQ = SEQ
            ,   LST_CHNG_DTTM = TO_CHAR(NOW(), 'YYYYMMDDHH24MISS')
         WHERE  TBL_NM  = $1
        ;
    END IF;

    RETURN SEQ;
END;
$function$
