select d.DEPT_ID, d.DEPT_NAME_EN, round(avg(e.SAL),0) as AVG_SAL
from HR_DEPARTMENT d
inner join HR_EMPLOYEES e
on d.DEPT_ID = e.DEPT_ID
group by d.DEPT_ID
order by round(avg(e.SAL),0) DESC