-- query.sql
SELECT *
FROM persons
WHERE LOWER(city_of_living) = :city_of_living;