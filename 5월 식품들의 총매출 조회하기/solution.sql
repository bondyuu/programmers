SELECT A.PRODUCT_ID, B.PRODUCT_NAME, (SUM(A.AMOUNT) * B.PRICE) AS TOTAL_SALES FROM FOOD_ORDER A RIGHT JOIN FOOD_PRODUCT B ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE  A.PRODUCE_DATE LIKE '2022-05%' GROUP BY A.PRODUCT_ID ORDER BY (SUM(A.AMOUNT) * B.PRICE) DESC, A.PRODUCT_ID ASC