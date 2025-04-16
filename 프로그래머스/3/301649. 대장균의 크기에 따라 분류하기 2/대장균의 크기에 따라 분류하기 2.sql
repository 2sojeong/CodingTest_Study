select a.ID,
case 
    when a.per <= 0.25 then 'CRITICAL'
    when a.per <= 0.5 then 'HIGH'
    when a.per <= 0.75 then 'MEDIUM'
    else 'LOW'
end as COLONY_NAME
from(select ID, PERCENT_RANK() over (order by SIZE_OF_COLONY DESC) AS PER
from ECOLI_DATA) as a
order by a.ID

