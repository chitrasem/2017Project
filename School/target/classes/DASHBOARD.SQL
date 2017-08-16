CREATE OR REPLACE VIEW public.dashboard AS
 SELECT ( SELECT count(*) AS tot_stu
           FROM tb_student
          WHERE tb_student.state::text = 'Active'::text) AS tot_stu,
    ( SELECT count(*) AS tot_user
           FROM app_user
          WHERE app_user.state::text = 'Active'::text) AS tot_user,
    ( SELECT count(*) AS tot_staff
           FROM tb_staff
          WHERE tb_staff.state::text = 'Active'::text) AS tot_staff,
    ( SELECT COALESCE(sum(a.pay_dtl_amt_km), 0::numeric) - COALESCE(sum(a.pay_dtl_amt_km), 0::numeric) AS pay_dtl_amt_km
           FROM tb_payment_detail a) AS pay_dtl_amt_km;