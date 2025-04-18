select b.CATEGORY, sum(s.SALES) as TOTAL_SALES
from BOOK b
left join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID and s.SALES_DATE like "2022-01%"
group by b.CATEGORY
order by b.CATEGORY