# FullCalendar

https://fullcalendar.io/

설치  
`npm install fullcalendar` 실행
`npm install @fullcalendar/core @fullcalendar/interaction @fullcalendar/daygrid` 실행

설명 블로그
https://m.blog.naver.com/lifetripper/221930938974  
  
https://velog.io/@conda/fullcalendar  
-> DB 예시까지 있음  

### db 변경
```
alter table gms_calendar
  add column start_dt date not null;
alter table gms_calendar
  add column end_dt date;
```

샘플데이터
```
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) values ("정모1", "7시 강남역1번출구", "www.naver.com", 1, "2022-04-03", "20220403");
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) values ("정모2", "7시 구디 4번 출구", "www.naver.com", 1, "2022-04-03", "2022-04-03");
insert into gms_calendar(name, content, result_url, g_no, start_dt, end_dt) values ("정모3", "12시 점심약속", "www.naver.com", 1, "2022-04-03", "2022-04-03");
```

