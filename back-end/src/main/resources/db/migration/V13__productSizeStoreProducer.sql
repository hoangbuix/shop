drop procedure if EXISTS productSize_create;
DELIMITER $$
CREATE PROCEDURE productSize_create(
    in _size VARCHAR(100),
    in _sizeCode VARCHAR(100),
    in _quantity VARCHAR(100),
    in _gender VARCHAR(100)
        ) body:

BEGIN
    declare
newId int;
    SET
max_sp_recursion_depth = 255;
    if
(
select count(product_size.id)
from product_size
where product_size.size_code = _sizeCode and product_size.size = _size and product_size.gender = _gender) > 0 then
SET @message_text = CONCAT('Product Size \'', _sizeCode,' and ', _gender, '\' already exists');
SIGNAL
SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
else
        insert into product_size(size, size_code, quantity, gender,  active_flag, created_date, updated_date)
        values (_size, _sizeCode, _quantity, _gender, 1, NOW(), NOW());
        set
newId = last_insert_id();
end if;
select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS productSize_update;
DELIMITER $$
CREATE PROCEDURE productSize_update(
    in _id INTEGER,
    in _size VARCHAR(100),
    in _sizeCode VARCHAR(100),
    in _quantity VARCHAR(100),
    in _gender VARCHAR(100),
    in _active INTEGER
        ) body:
begin
update product_size
set size = _size,
    size_code = _sizeCode,
    quantity = _quantity,
    gender = _gender,
    active_flag = _active,
    updated_date = NOW()
where id = _id;
END$$
DELIMITER ;

drop procedure if EXISTS productSize_findAll;
DELIMITER $$
CREATE PROCEDURE productSize_findAll()
begin
select *
from product_size
where (active_flag = 1
    or active_flag = 0)
order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findById;
DELIMITER $$
CREATE PROCEDURE productSize_findById(in _id int)
begin
select *
from product_size
where id = _id
      and(active_flag = 1
    or active_flag = 0)
order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findByQuantity;
DELIMITER $$
CREATE PROCEDURE productSize_findByQuantity(in _quantity VARCHAR(100))
begin
select *
from product_size
where quantity = _quantity
      and(active_flag = 1
    or active_flag = 0)
order by quantity;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findBySize;
DELIMITER $$
CREATE PROCEDURE productSize_findBySize(in _size VARCHAR(100))
begin
select *
from product_size
where size = _size
  and (active_flag = 1
   or active_flag = 0)
order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findByGender;
DELIMITER $$
CREATE PROCEDURE productSize_findByGender(in _gender VARCHAR(100))
begin
select *
from product_size
where gender = _gender
  and (active_flag = 1
    or active_flag = 0)
order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productSize_findBySizeCodeAndGender;
DELIMITER $$
CREATE PROCEDURE productSize_findBySizeCodeAndGender(in _sizeCode VARCHAR(100),in _gender VARCHAR(100))
begin
select *
from product_size
where gender = _gender or size_code = _sizeCode
  and (active_flag = 1
   or active_flag = 0)
order by size;
end$$
DELIMITER ;

