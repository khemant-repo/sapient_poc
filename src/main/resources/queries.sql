-- find second largest salary
select max(salary) As secondHighestSalary
from Employee
where salary <
(select max(salary) from Employee);



-- find nth largest salary

-- sql version
select salary from
(select distinct salary from test.employees order by salary desc limit 2 )
As Results order by salary limit 1;

--find duplicate rows from table .
-- ex. multiple transactionId in Transaction table.

select last_name , count(*) from test.person
group by last_name
having count(*) > 1;


