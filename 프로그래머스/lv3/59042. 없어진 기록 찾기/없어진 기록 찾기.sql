-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_INS i 
right outer join ANIMAL_OUTS o
on o.ANIMAL_ID = i.ANIMAL_ID
where i.INTAKE_CONDITION is null;

# SELECT *
# from ANIMAL_INS ;