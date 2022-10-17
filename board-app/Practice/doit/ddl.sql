-- member  alarm  id
select * from jang_member, jang_alarm where jang_member.ID= jang_alarm.ID;

-- 관리자 : 알림이 있는 아이디랑 닉네임
select jang_member.ID, jang_member.NNAME, jang_alarm.CONT
from jang_member
join jang_alarm
on jang_member.ID=jang_alarm.ID;

-- 장소 추천 게시글 메인
select jang_so_recommendation.title,
