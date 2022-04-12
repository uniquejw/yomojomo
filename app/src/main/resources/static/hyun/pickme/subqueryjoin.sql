-- 초대받은 사람 이름 서브쿼리
select
	ib.invite_no,
	ib.title,
	ib.content,
	ib.confirm,
	ib.reg_dt,
  (select memb_no from gms_memb where memb_no=ib.memb_no) as invitedNo,
	(select name from gms_memb where memb_no=ib.memb_no) as invitedName,
	ib.memb_no2 invitee,
	ib.g_no
from gms_invite_box ib
where 
	ib.memb_no = 1
order by 
	ib.invite_no asc;

  -- 초대하는 사람 이름, 멤버번호 서브 쿼리
select
	ib.invite_no,
	ib.title,
	ib.content,
	ib.confirm,
	ib.reg_dt,
  (select memb_no from gms_memb where memb_no=ib.memb_no) as invitedNo,
	(select name from gms_memb where memb_no=ib.memb_no) as invitedName,
  (select memb_no from gms_memb where memb_no=ib.memb_no2) as invitedNo,
  (select name from gms_memb where memb_no=ib.memb_no2) as inviteeName,
  ib.g_no as groupNo
from gms_invite_box ib
where 
	ib.memb_no = 1
order by 
	ib.invite_no asc;

  -- 초대하는 사람의 선택한 모임과 모임 이름 가져오기
  select
    (select memb_no from gms_memb where memb_no=ib.memb_no2) as invitedNo,
    (select name from gms_memb where memb_no=ib.memb_no2) as inviteeName,
    ib.g_no
  from gms_invite_box ib
  where 
	ib.memb_no = 1

-- 모임 번호와 모임 이름 가져오기(가상테이블)
select 
  jm.g_no,
  (select g_no from gms_group g where jm.g_no = g.g_no) as groupno,
  (select name from gms_group g where jm.g_no = g.g_no) as groupName
from gms_join_memb jm


  -- 초대하는 사람 이름, 멤버번호 서브 쿼리 & 소모임 이름 붙이기
select distinct
	ib.invite_no,
	ib.title,
	ib.content,
	ib.confirm,
	ib.reg_dt,
  (select memb_no from gms_memb where memb_no=ib.memb_no) as invitedNo,
	(select name from gms_memb where memb_no=ib.memb_no) as invitedName,
  (select memb_no from gms_memb where memb_no=ib.memb_no2) as inviteeNo,
  (select name from gms_memb where memb_no=ib.memb_no2) as inviteeName,
  g.g_no,
  g.groupName
from gms_invite_box ib
  join (
    select 
      jm.g_no,
      (select g_no from gms_group g where jm.g_no = g.g_no) as groupno,
      (select name from gms_group g where jm.g_no = g.g_no) as groupName
    from gms_join_memb jm
  ) as g on ib.g_no=g.g_no
where 
	ib.memb_no = #{member.no}
order by 
	ib.invite_no asc;



