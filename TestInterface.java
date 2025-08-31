select name, age, dept, count(*) from employee where salary>50000 group by dept having count(*)>5 order by salary desc limit 5;

group by vantha apply aggregate function use pananum
