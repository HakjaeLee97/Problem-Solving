-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
(Case
    when OUT_DATE is null then '출고미정'
    when OUT_DATE <= '2022-05-01' then '출고완료'
    else '출고대기'
end)
from FOOD_ORDER
order by ORDER_ID
