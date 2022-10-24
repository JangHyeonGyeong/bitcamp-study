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
--   구매자 정보 (이름, 전화번호 , 이메일)

select
   jt.EXTKNO, jt.ID, jt.EXNO, jt.CNT,
   je.EXNAME, jef.PATH,je.PRICE,
   jm.NAME, jm.PNUM, jm.EMAIL
     from jang_exhibition je
             join jang_exhibition_file jef
                       on je.EXNO  = jef.EXNO
                 join jang_ticket jt
                    on je.EXNO = jt.EXNO
             left join jang_member jm on jt.ID = jm.ID;

-- 결제확인 페이지 : 결제일자, 결제번호, 전시회 사진, 이름, 판매자 ,수량 ,상품금액
--        구매자 정보 (이름, 전화번호 , 이메일) /jt.extkno  일댜ㅏㄴ뺌
select
 jt.EXNO, jt.id,  jm.NAME, jm.PNUM, jm.EMAIL,
  jt.cnt,je.PRICE, jt.purdate, jt.payment, jt.ccdate,
 jef.PATH, je.EXNAME
from jang_ticket jt
join  jang_exhibition je
on je.EXNO  = jt.EXNO
join jang_exhibition_file jef
     on je.EXNO  = jef.EXNO
join jang_member jm on jt.ID = jm.ID;

-- 구매내역 페이지 : 결제일자, 전시회 사진, 이름, 판매자, 수량, 금액
select
    jt.EXNO,  jt.id, je.EXNAME, jef.PATH, jt.purdate,
    jt.cnt, je.PRICE
  from jang_ticket jt
         join  jang_exhibition je
               on je.EXNO  = jt.EXNO
         join jang_exhibition_file jef
              on je.EXNO  = jef.EXNO;

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


-- 민구--------------------------------------------------------------------------------
-- 진행중 전시회 목록
select
    jexhb.EXNO, -- 전시회번호
    jexhb.EXNAME, -- 전시회제목
    jexhb.STDATE, -- 시작일
    jexhb.EDDATE, -- 종료일
    jexhbf.EXFNO, -- 전시회게시글첨부파일번호
    jexhbf.PATH -- 전시회게시글첨부파일경로
from
    jang_exhibition jexhb
        join
    jang_exhibition_file jexhbf
    on
            jexhb.EXNO = jexhbf.EXNO
where
    (jexhb.STDATE < CURDATE()) and (jexhb.EDDATE > CURDATE());


-- 진행예정 전시회 목록
select
    jexhb.EXNO, -- 전시회번호
    jexhb.EXNAME, -- 전시회제목
    jexhb.STDATE, -- 시작일
    jexhb.EDDATE, -- 종료일
    jexhbf.EXFNO, -- 전시회게시글첨부파일번호
    jexhbf.PATH -- 전시회게시글첨부파일경로
from
    jang_exhibition jexhb
        join
    jang_exhibition_file jexhbf
    on
            jexhb.EXNO = jexhbf.EXNO
where
        jexhb.STDATE > CURDATE();



-- 진행완료 전시회 목록
select
    jexhb.EXNO, -- 전시회번호
    jexhb.EXNAME, -- 전시회제목
    jexhb.STDATE, -- 시작일
    jexhb.EDDATE, -- 종료일
    jexhbf.EXFNO, -- 전시회게시글첨부파일번호
    jexhbf.PATH -- 전시회게시글첨부파일경로
from
    jang_exhibition jexhb
        join
    jang_exhibition_file jexhbf
    on
            jexhb.EXNO = jexhbf.EXNO
where
        jexhb.EDDATE < CURDATE();

-- --------------------------------------------------------------------------
-- 상세페이지 - 한줄 리뷰
select
    jexhb.*, -- 전시회-전부
    jso.PLNO, -- 장소-장소번호
    jso.PLNAME, -- 장소-장소명
    jso.QCALL, -- 장소-문의번호
    jso.BASICAD, -- 장소-기본주소
    jso.DETAILAD, -- 장소-상세주소
    jexhbrv.*, -- 전시회한줄리뷰-전부
    jexhbf.EXFNO, -- 전시회게시글첨부파일번호
    jexhbf.PATH -- 전시회게시글첨부파일경로
from
    jang_exhibition jexhb
        join
    jang_exhibition_file jexhbf
    on
            jexhb.EXNO = jexhbf.EXNO
        join
    jang_so jso
    on
            jexhb.PLNO = jso.PLNO
        left outer join
    jang_exhibition_review jexhbrv
    on
            jexhb.EXNO = jexhbrv.EXNO;

-- ---------------------------------------------
select count(*)
from jang_follow
where OTHID='user2';

select ID
from jang_follow
where OTHID='user5';

-- 지민-----------------
-- 마이페이지
-- 이름
select NNAME
from jang_member
where ID = 'user1';

-- 사진
select PROFILE
from jang_member
where ID = 'user1';

-- SNS 주소
select SNS
from jang_member
where ID = 'user1';
-- MBTI
select MBTI
from jang_member
where ID = 'user1';
-- 내가 좋아요 한 글 목록
select rec.TITLE
FROM
    jang_so_recommendation rec, jang_like lik
where
        rec.RECONO = lik.RECONO
  and lik.ID = 'user1';
-- 내가 쓴 글 목록 제목, 작성일, 조회수, 좋아요
select rec.TITLE, rec.WDATE, rec.CNT, lik.cn
FROM
    jang_so_recommendation rec,
    (select count(*) cn, ID
     from jang_like
     where ID = x
     GROUP BY RECONO) lik
WHERE
        rec.ID = lik.ID;

-- 내가 쓴 댓글 목록
select com.CONT
from jang_comment com
where com.ID = x;

--  알림
select alram.CONT
from jang_alarm alram, jang_member mem
where alram.ID = mem.ID;

-- follwer cnt
select count(*)
from jang_follow
where ID = 'user1';

-- follwing
select count(*)
from jang_follow
where OTHID = 'user2';

-- 남의 마이페이지 글 목록 +
select rec.TITLE
from jang_so_recommendation rec,
     (select PRVNO from jang_so_review rev )
where rec.ID = 'user4';

select rev.PRVNO
from
    jang_so_recommendation rec, jang_so_review rev
where rec.RECONO = rev.RECONO
limit 1;

-- 사진
select file.PATH
from jang_so_review_file file,
     (select rev.PRVNO
      from
          jang_so_recommendation rec, jang_so_review rev
      where rec.RECONO = rev.RECONO
      limit 1) rev1
where rev1.PRVNO = file.PRVNO;

-- 기본 주소
select js.BASICAD
from jang_so js,
     (select rev.PLNO
      from
          jang_so_recommendation rec, jang_so_review rev
      where
              rec.RECONO = rev.RECONO
      limit 1) rev1
where js.PLNO = rev1.PLNO;


-- 영아

-- 코스추천메인페이지_좋아요순
select
    src.*,(select
               count(*)
           from jang_like sli
           where sli.RECONO = src.RECONO
)like_count
from jang_so_recommendation src
         left outer join jang_like lik on src.RECONO = lik.RECONO
order by like_count desc;
-- 코스추천상세페이지_좋아요수
select
    src.*,(select
               count(*)
           from jang_like sli
           where sli.RECONO = src.RECONO
)like_count
from jang_so_recommendation src
         left outer join jang_like lik on src.RECONO = lik.RECONO;
    -- 코스추천상세페이지_글번호,제목,장소,등록일,조회수,반려동물가능,동행추천,글쓴이사진,닉네임,댓글
select
    src.RECONO,
    src.TITLE,
    src.WDATE,
    src.CNT,
    src.PET,
    src.FRD,
    src.CPLE,
    src.FMLY,
    src.SOLO,
    meb.NNAME,
    meb.PROFILE,
    jcm.ID,
    jcm.CONT
from jang_so_recommendation src
         left outer join jang_member meb on src.ID = meb.ID
         join jang_comment jcm on src.RECONO = jcm.RECONO
where src.RECONO=#{value}

-- 종현
      --메인화면 가장 조회수 높은 3개 코스 추천 글--
SELECT jang_so_recommendation.TITLE, jang_so_recommendation.ID
FROM jang_so_recommendation
ORDER BY CNT DESC
LIMIT 3;

--메인화면 출력 할 가장 ??한 3개 코스 추천 글--

SELECT jang_so_review.CONT, jang_so_review_file.PATH
FROM jang_so_review INNER JOIN jang_so_review_file
                               ON jang_so_review.PRVNO = jang_so_review_file.PRVNO
ORDER BY DESC -- 기준??--
LIMIT 3;

--로그인 및 회원가입 id, password 확인--
SELECT jang_member.ID, jang_member.PWD
FROM jang_member
WHERE AND(jang_member.ID = 'user1');
-- w

, jang_member.PWD = '');