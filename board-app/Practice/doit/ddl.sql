-- member  alarm  id
select * from jang_member, jang_alarm where jang_member.ID= jang_alarm.ID;

-- 관리자 : 알림이 있는 아이디랑 닉네임
select jang_member.ID, jang_member.NNAME, jang_alarm.CONT
from jang_member
join jang_alarm
on jang_member.ID=jang_alarm.ID;

-- 장바구니 : 장바구니, 전시회 이름, 사진, 수량, 상품금액,
-- 파일 경로
select
    jb.ID, jb.EXNO,je.EXNAME, jb.CNT,
    je.PRICE,
    jef.PATH
from jang_baguni jb
         left join jang_exhibition je
                   on jb.EXNO = je.EXNO
         left join jang_exhibition_file jef
                   on jb.EXNO  = jef.EXNO;



-- 주문결제 페이지 : 전시회 이름, 사진, 수량, 금액
--        구매자 정보 (이름, 전화번호 , 이메일)

select
    jb.EXNO, jb.CNT,

    from jang_baguni jb



-- 결제확인 페이지 : 결제일자, 결제번호, 전시회 사진, 이름, 판매자 ,수량 ,상품금액
--        구매자 정보 (이름, 전화번호 , 이메일)



-- 구매내역 페이지 : 결제일자, 전시회 사진, 이름, 판매자, 수량, 금액



select
    jb.ID,
    jb.CNT,
    jb.EXNO
    from jang_baguni jb
    join jang_exhibition je
    on jb.EXNO = je.EXNO;

select
    jb.ID, jb.EXNO, CNT,
    je.EXNO, EXNAME, PRICE
    from jang_baguni jb
    join jang_exhibition je
    on jb.EXNO = je.EXNO;



