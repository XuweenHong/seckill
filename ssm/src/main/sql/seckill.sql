-- 秒杀执行存储过程
DELIMITER $$ -- console ；转换为 $$
-- 定义存储过程
-- 参数：in 输入参数； out 输出参数
-- row_count(): 返回上一条修改类型sql（delete，insert，update）的影响行数
-- row_count: 0:未修改的数据;>0:表示修改的行数；<0:sql错误/未执行修 改的sql
CREATE PROCEDURE `seckill`.`execute_seckill`
  (in v_seckill_id bigint, in v_phone bigint,
    in v_kill_time TIMESTAMP ,out r_result int)
  begin
    DECLARE insert_count int DEFAULT 0;
    START TRANSACTION;
    insert ignore into success_killed
      (seckill_id,user_phone,create_time)
      values (v_seckill_id,v_phone,v_kill_time);
    select row_count() into insert_count;
    IF (insert_count = 0) THEN
      rollback;
      set r_result = -1;
    ElSEIF (insert_count < 0) THEN
    rollback;
    set r_result = -2;
    else
    update seckill
    set number = number -1
    where seckill_id = v_seckill_id
      and end_time > v_kill_time
      and start_time < v_kill_time
      and number > 0;
    select row_count() into insert_count;
    IF (insert_count = 0) then
    rollback;
    set r_result = 0;
    ElSEIF (insert_count < 0) THEN
      rollback;
      set r_result = -2;
    else
      commit;
      set r_result = 1;
      end IF ;
    end IF;
  end;
$$
-- 存储过程结束
DELIMITER ;
set @r_result= -3;
-- 执行存储过程
call execute_seckill(1003,13502178891,now(),@r_result);
-- 获取结果
select @r_result;
