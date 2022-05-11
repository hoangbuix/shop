drop procedure if EXISTS notification_create;
DELIMITER $$
CREATE PROCEDURE notification_create(
    in _notificationName VARCHAR(100),
    in _seen BIT(1),
    in _userId INTEGER,
    in _postId INTEGER
        )
    body:
BEGIN
    declare
newId int;
    SET
max_sp_recursion_depth = 255;
    if
(
select count(id)
from notification
where id) > 0 then
SET @message_text = CONCAT('Notification \'', _notificationName, '\' already exists');
SIGNAL
SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
else
        insert into notification(notification_name, seen, user_id, post_id, active_flag, created_date, updated_date)
        values (_notificationName, _seen, _userId, _postId, 1, NOW(), NOW());
        set
newId = last_insert_id();
end if;
select newId;
END$$
DELIMITER ;

-- update
drop procedure if EXISTS notification_update;
DELIMITER $$
CREATE PROCEDURE notification_update(
    in _id INTEGER,
    in _notificationName VARCHAR(100),
    in _seen BIT(1),
    in _userId INTEGER,
    in _postId INTEGER,
    in _active_flag INTEGER
        )
    body:
begin
update notification
set
    notification_name = _notificationName,
    seen   = _seen,
    user_id = _userId,
    post_id = _postId,
    active_flag   = _active_flag,
    updated_date  = NOW()
    where  id = _id;
END$$
DELIMITER ;
--
drop procedure if EXISTS notification_delete;
DELIMITER $$
CREATE PROCEDURE notification_delete(
    in _id INTEGER
        )
    body:
begin
update notification
set
    active_flag   = 0,
    updated_date  = NOW()
where id = _id;
END$$
DELIMITER ;

drop procedure if EXISTS notification_findAll;
DELIMITER $$
CREATE PROCEDURE notification_findAll()
begin
select n.*, p.*, u.*
from notification n, post p, user u
where p.id = n.post_id
  and u.id = n.user_id
      and (n.active_flag = 1
    or n.active_flag = 0)
order by n.id;
end$$
DELIMITER ;


drop procedure if EXISTS notification_findById;
DELIMITER $$
CREATE PROCEDURE notification_findById(in _id int)
begin
select n.*, p.*, u.*
from notification n, post p, user u
where p.id = n.post_id
      and u.id = n.user_id
      and n.id = _id
      and (n.active_flag = 1
    or n.active_flag = 0)
order by n.id;
end$$
DELIMITER ;

drop procedure if EXISTS notification_findAllByUserId;
DELIMITER $$
CREATE PROCEDURE notification_findAllByUserId(in _id integer)
begin
select n.*, u1.*, p.* from notification n, user u1, post p
where n.user_id in (select u.id from user u where u.id = _id )
    and u1.id = n.user_id
    and p.id = n.post_id
      and (n.active_flag= 1
    or n.active_flag = 0);
end$$
DELIMITER ;