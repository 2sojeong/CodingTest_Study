select d3.ID
from ECOLI_DATA d1
inner join ECOLI_DATA d2
on d1.ID = d2.PARENT_ID and d1.PARENT_ID is NULL
inner join ECOLI_DATA d3
on d3.PARENT_ID = d2.ID