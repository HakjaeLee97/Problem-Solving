-- 코드를 입력하세요
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, r.REVIEW_DATE from REST_REVIEW r join MEMBER_PROFILE m 
on r.MEMBER_ID = m.MEMBER_ID
where m.MEMBER_ID = 

(select MEMBER_ID from REST_REVIEW group by MEMBER_ID order by count(*) desc limit 1)

order by r.REVIEW_DATE;

