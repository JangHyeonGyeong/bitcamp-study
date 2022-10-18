-- member  alarm  id
select * from jang_member, jang_alarm where jang_member.ID= jang_alarm.ID;

-- 관리자 : 알림이 있는 아이디랑 닉네임
select jang_member.ID, jang_member.NNAME, jang_alarm.CONT
from jang_member
join jang_alarm
on jang_member.ID=jang_alarm.ID;

-- 장바구니

-- 결제확인 페이지


-- 주문결제 페이지

-- 구매내역 페이지



select jang_so_recommendation.title,

