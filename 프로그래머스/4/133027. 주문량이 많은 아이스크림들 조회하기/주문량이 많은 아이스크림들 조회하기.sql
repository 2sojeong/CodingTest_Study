select h.FLAVOR
from FIRST_HALF h
join JULY j
on h.FLAVOR = j.FLAVOR
group by h.FLAVOR
order by SUM(h.TOTAL_ORDER) DESC
LIMIT 3