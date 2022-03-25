drop procedure if EXISTS product_create;
DELIMITER $$
CREATE PROCEDURE product_create(
    in _productName VARCHAR (255),
    in _productCode VARCHAR (100),
    in _description Text,
    in _slug VARCHAR (100),
    in _brandId INTEGER,
    in _price float,
    in _productImage VARCHAR (255),
    in _total_sold INTEGER,
    in _totalProduct INTEGER,
    in _quantityProduct INTEGER,
    in _categoryId INTEGER,
    in _productSize INTEGER
        ) body:

BEGIN
    declare
newId int;
    SET
max_sp_recursion_depth = 255;
    if
(
select count(product.id)
from product
where product.product_code = _productCode) > 0 then
SET @message_text = CONCAT('Product \'', _productCode, '\' already exists');
SIGNAL
SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
else
        insert into product(product_name, product_code, description, slug, brand_id, price, product_image, total_product, toal_sold, quantity_product, category_id, product_size, active_flag, created_date, updated_date)
        values (_productName, _productCode, _description, _slug, _brandId, _price, _productImage,_totalProduct, _total_sold, _quantityProduct, _categoryId, _productSize, 1, NOW(), NOW());
        set
newId = last_insert_id();
end if;
select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS product_update;
DELIMITER $$
CREATE PROCEDURE product_update(
    in _productName VARCHAR (255),
    in _productCode VARCHAR (100),
    in _description Text,
    in _slug VARCHAR (100),
    in _brandId INTEGER,
    in _price float,
    in _productImage VARCHAR (255),
    in _total_sold INTEGER,
    in _totalProduct INTEGER,
    in _quantityProduct INTEGER,
    in _categoryId INTEGER,
    in _productSize INTEGER,
    in _active INTEGER
        ) body:
begin
update product
set product_name = _productName,
    product_code = _productCode,
    description = _description,
    slug = _slug,
    brand_id = _brandId,
    price = _price,
    product_image = _productImage,
    total_sold = _total_sold,
    total_product= _toalProduct,
    quantity_product = _quantityProduct,
    category_id = _categoryId,
    product_size = _productSize,
    active_flag = _active,
    updated_date = NOW();
END$$
DELIMITER ;

drop procedure if EXISTS product_findAll;
DELIMITER $$
CREATE PROCEDURE product_findAll()
begin
select *
from product
where (active_flag = 1
    or active_flag = 0)
order by product_name;
end$$
DELIMITER ;

drop procedure if EXISTS product_findById;
DELIMITER $$
CREATE PROCEDURE product_findById(in _id int)
begin
select *
from product
where id = _id
      and(active_flag = 1
    or active_flag = 0)
order by product_code;
end$$
DELIMITER ;

drop procedure if EXISTS product_findByProductName;
DELIMITER $$
CREATE PROCEDURE product_findByProductName(in _product_name varchar (100))
begin
select *
from product
where product_name = _product_name
      and(active_flag = 1
    or active_flag = 0)
order by product_code;
end$$
DELIMITER ;

drop procedure if EXISTS product_findByCode;
DELIMITER $$
CREATE PROCEDURE product_findByCode(in _code varchar (50))
begin
select *
from product
where product_code = _code
      and(active_flag = 1
    or active_flag = 0)
order by product_code;
end$$
DELIMITER ;

drop procedure if EXISTS product_checkTotalProduct;
DELIMITER $$
CREATE PROCEDURE product_checkTotalProduct()
begin
SELECT IF((
              SELECT count(*) FROM product
              WHERE total_product > 0 )
           ,1,0);
end$$
DELIMITER ;

