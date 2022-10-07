-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO
where (FOOD_TYPE, FAVORITES) in 
(select FOOD_TYPE, max(favorites) as max_fav
 from rest_info
 group by FOOD_TYPE)
 order by FOOD_TYPE desc
 