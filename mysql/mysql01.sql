-- 查询所有数据库
show databases ;

-- 创建数据库
create database db02;

-- DDL: 表结构
-- 创建： 基本语法
create table tb_user(
    id int primary key auto_increment comment 'ID,唯一标识',
    username varchar(20) not null unique comment '昵称',
    name varchar(10) not null comment '姓名',
    age int comment '年龄',
    gender char(1) default '男' comment '性别'
) comment '用户表';

-- 查看： 当前数据库下的表
show tables ;

-- 查看： 查看指定表结构
desc tb_emp;

-- 查看： 数据库的建表语句
show create table tb_emp;

-- 修改：为表tb_emp 添加字段 qq varchar(11)
alter table tb_emp add qq varchar(11) comment 'QQ';

-- 修改：修改 tb_emp 字段类型 qq varchar(13)
alter table tb_emp modify qq varchar(13) comment 'QQ';

-- 修改：修改 tb_emp 字段名 qq 为 qq_num varchar(13)
alter table tb_emp change qq qq_num varchar(13) comment 'QQ';

-- 修改：删除 tb_emp 的 qq_num 字段
alter table tb_emp drop column qq_num;

-- 修改：将 tb_emp 表明修改为 emp
rename table tb_emp to emp;

-- DDL： 删除表结构
-- 删除： 删除 tb_emp 表
drop table if exists tb_emp;

create table tb_emp
(
    id          int auto_increment comment '主键'
        primary key,
    username    varchar(20)                  not null comment '用户名',
    password    varchar(10) default '123456' null comment '密码',
    name        varchar(10)                  null comment '姓名',
    gender      tinyint unsigned             null comment '性别 0 男 1女',
    image       varchar(300)                 null comment '图像',
    job         tinyint unsigned             null comment '职位 1 班主任， 2 讲师， 3 学工主管， 4 教研主管',
    entry_time  date                         null comment '入职日期',
    create_time datetime                     not null comment '创建时间',
    update_time datetime                     not null comment '修改时间'
)
    comment '员工信息';

-- DML: 数据操作语言
-- DML: 插入数据 - insert
-- 1.为 tb_emp表的 username, name , gender 字段插入值
insert into tb_emp (username, name, gender, create_time, update_time) values ('wuji', '张无忌', 0, now(), now());

-- 2. 为tb_emp表的所有字段插入值
insert into tb_emp values (null, '周芷若', '123', 'zhiruo', 1, '1.jpg', 1, '2020-01-01', now(), now());

-- 3. 批量为 tb_emp 表的 username, name, gender 字段插入数据
insert into tb_emp (username, name, gender, create_time, update_time) values
    ('zhaomin', '赵敏', 1, now(), now()),('miejue', '灭绝师太', 1, now(), now());

-- DML: 更新数据 - update
-- 1.将tb_emp 表的ID为1的员工 姓名那么字段更新为’张三‘
update tb_emp set name = '张三', update_time = now() where id = 1;

-- 2.将tb_emp 表的所有员工的入职日期更新为 ’2010-01-01‘
update tb_emp set entry_time = '2010-01-01', update_time = now();

-- DML: 删除数据 - delete
-- 1.删除tb_emp 表中id为1的员工
delete from tb_emp where id = 1;

-- 2.删除tb_emp表中的所有员工
delete from tb_emp;

-- 员工管理(带约束)
create table tb_emp (
                        id int unsigned primary key auto_increment comment 'ID',
                        username varchar(20) not null unique comment '用户名',
                        password varchar(32) default '123456' comment '密码',
                        name varchar(10) not null comment '姓名',
                        gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
                        image varchar(300) comment '图像',
                        job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管',
                        entrydate date comment '入职时间',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '员工表';