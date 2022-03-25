drop procedure if EXISTS productCategory_create;
DELIMITER $$
CREATE PROCEDURE productCategory_create(
    in _productId integer,
    in _categoryId integer
) body:

BEGIN
    declare
newId int;
    SET
max_sp_recursion_depth = 255;
    if
(
select count(product_category.id)
from product_category
where product_category.product_id = _productId and category_id = _categoryId) > 0 then
SET @message_text = CONCAT('Product Category \'', _size, '\' already exists');
SIGNAL
SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
else
        insert into product_category(product_id, category_id,  active_flag, created_date, updated_date)
        values (_productId, _categoryId, 1, NOW(), NOW());
        set
newId = last_insert_id();
end if;
select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS productCategory_update;
DELIMITER $$
CREATE PROCEDURE productCategory_update(
    in _productId INTEGER,
    in _categoryId INTEGER,
    in _active INTEGER
) body:
begin
update product_category
set product_id = _productId,
    category_Id = _categoryId,
    active_flag = _active,
    updated_date = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS productCategory_findAll;
DELIMITER $$
CREATE PROCEDURE productCategory_findAll()
begin
select *
from product_category
where (active_flag = 1
    or active_flag = 0)
order by size;
end$$
DELIMITER ;

drop procedure if EXISTS productCategory_findByProductIdAndCategoryId;
DELIMITER $$
CREATE PROCEDURE productCategory_findByProductIdAndCategoryId(in _productId integer ,in _categoryId integer)
begin
select *
from product_category
where product_id = _productId and category_id = _category_id
  and (active_flag = 1
   or active_flag = 0)
order by id;
end$$
DELIMITER ;