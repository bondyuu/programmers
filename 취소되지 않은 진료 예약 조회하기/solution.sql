SELECT A.APNT_NO, B.PT_NAME, A.PT_NO, A.MCDP_CD, C.DR_NAME, A.APNT_YMD FROM APPOINTMENT AS A
INNER JOIN PATIENT AS B ON A.PT_NO = B.PT_NO
INNER JOIN DOCTOR AS C ON A.MDDR_ID = C.DR_ID
WHERE A.APNT_YMD LIKE '2022-04-13%' AND A.MCDP_CD = 'CS' AND A.APNT_CNCL_YN = 'N'
ORDER BY A.APNT_YMD ASC