-- member  alarm  id
select * from jang_member, jang_alarm where jang_member.ID= jang_alarm.ID;

-- 알림 보냄 확인
select jang_member.ID, jang_member.NNAME, jang_alarm.CONT
from jang_member
left outer join jang_alarm
on jang_member.ID=jang_alarm.ID;

