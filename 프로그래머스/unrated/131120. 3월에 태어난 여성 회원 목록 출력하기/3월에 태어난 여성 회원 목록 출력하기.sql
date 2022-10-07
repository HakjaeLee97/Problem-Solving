-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH
from MEMBER_PROFILE
where month(DATE_OF_BIRTH ) = 3
and GENDER like 'W'
and TLNO is not null