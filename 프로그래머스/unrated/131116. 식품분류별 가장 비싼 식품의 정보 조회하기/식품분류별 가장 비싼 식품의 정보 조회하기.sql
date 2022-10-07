-- 코드를 입력하세요
SELECT distinct f1.CATEGORY, f1.PRICE, f1.PRODUCT_NAME
FROM FOOD_PRODUCT f1
join
(SELECT max(PRICE) as 'max_PRICE'
 from FOOD_PRODUCT
group by CATEGORY
) f2 
on f1.PRICE = f2.MAX_PRICE

where CATEGORY in ('과자','국','김치','식용유')

order by PRICE desc;