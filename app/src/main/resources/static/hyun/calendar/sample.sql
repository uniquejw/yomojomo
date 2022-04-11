--소모임1 데이터 추가
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) 
values ("정모6", "7시 강남역1번출구", "www.daum.net", 1, "2022-05-03", "2022-05-03");
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) 
values ("정모7", "7시 구디 4번 출구", "www.naver.com", 1, "2022-05-05", "2022-05-10");
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) 
values ("정모8", "12시 점심약속", "www.naver.com", 1, "2022-05-31", "2022-05-31");
insert into gms_calendar(name, content, g_no, start_dt, end_dt) 
values ("정모9", "12시 점심약속", 1, "2022-05-30", "2022-05-31");
insert into gms_calendar(name, content, g_no, start_dt, end_dt) 
values ("정모10", "약속", 1, "2022-05-26", "2022-05-27");

--소모임3 데이터 추가
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) 
values ("정모1", "강남역1번출구", "www.daum.com", 1, "2022-04-11", "2022-04-11");
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt)
values ("정모2", "놀기", "www.google.com", 1, "2022-04-05", "2022-04-05");
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) 
values ("정모3", "12시 점심약속", "www.naver.com", 1, "2022-04-30", "2022-04-30");

--모임2 모임장 추가
insert into gms_memb(name,pwd,email,tel,post_no,base_addr,addr,type,unsubscribe) 
values('정땡땡','1111','def@naver.com','11112222','1234','봉천동','102호','유형',false);

--일반회원
insert into gms_memb(name,pwd,email,tel,post_no,base_addr,addr,type,unsubscribe) 
values('조땡땡','1111','abc@naver.com','11112222','1234','봉천동','102호','유형',false);

--소모임2 모임장 추가
insert into gms_join_memb(memb_no,g_no,g_memb_grd_no) values (5,2,1);

--조땡땡의 모임가입 1,2,3
insert into gms_join_memb(memb_no,g_no,g_memb_grd_no) values (4,1,2);
insert into gms_join_memb(memb_no,g_no,g_memb_grd_no) values (4,2,2);
insert into gms_join_memb(memb_no,g_no,g_memb_grd_no) values (4,3,2);