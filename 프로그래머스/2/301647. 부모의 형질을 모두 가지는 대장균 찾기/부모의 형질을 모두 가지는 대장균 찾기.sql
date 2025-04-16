select a.ID, a.GENOTYPE, b.GENOTYPE AS PARENT_GENOTYPE
from ECOLI_DATA a
inner join ECOLI_DATA b 
on a.PARENT_ID = b.ID
where (a.GENOTYPE & b.GENOTYPE) = b.GENOTYPE
order by a.ID ASC