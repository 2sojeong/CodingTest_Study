select a.ID, count(b.ID) AS CHILD_COUNT
from ECOLI_DATA a
left join ECOLI_DATA b
on a.ID = b.PARENT_ID
group by a.ID
order by a.ID

