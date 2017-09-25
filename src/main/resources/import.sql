DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` INT AUTO_INCREMENT COMMENT 'ID',
  `username` VARCHAR(50) COMMENT '用户名',
  `password` VARCHAR(30) COMMENT '密码',
  `deleted` BIT COMMENT '是否删除 0：未删除 1：已删除',
  `version` INT COMMENT '版本编号',
  `created_by` INT COMMENT '创建者ID',
  `created_date` DATETIME COMMENT '创建时间',
  `last_modified_by` INT COMMENT '最后修改者ID',
  `last_modified_date` DATETIME COMMENT '最后修改者ID',
  PRIMARY KEY (`id`)
);

INSERT INTO `t_user`(`id`,`username`,`password`,`deleted`,`version`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) 
VALUES (1,'admin','admin',0,0,1,NOW(),1,NOW());

DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail` (
  `id` INT AUTO_INCREMENT COMMENT 'ID',
  `user_id` INT COMMENT '用户ID',
  `nickname` VARCHAR(50) COMMENT '昵称',
  `phone` VARCHAR(20) COMMENT '电话',
  `gender` CHAR(1) COMMENT '性别',
  `age` INT COMMENT '年龄',
  `realname` VARCHAR(50) COMMENT '真实姓名',
  `birthday` DATETIME COMMENT '生日',
  `deleted` BIT COMMENT '是否删除 0：未删除 1：已删除',
  `version` INT COMMENT '版本编号',
  `created_by` INT COMMENT '创建者ID',
  `created_date` DATETIME COMMENT '创建时间',
  `last_modified_by` INT COMMENT '最后修改者ID',
  `last_modified_date` DATETIME COMMENT '最后修改者ID',
  PRIMARY KEY (`id`)
);

INSERT INTO `t_user_detail`(`id`,`user_id`,`nickname`,`phone`,`gender`,`age`,`realname`,`birthday`,`deleted`,`version`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) 
VALUES (1,1,'小米','13631557000','0',20,'小明','1990-01-01',0,0,1,NOW(),1,NOW());


DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` INT AUTO_INCREMENT COMMENT 'ID',
  `user_id` INT COMMENT '用户ID',
  `body_wrap_id` INT COMMENT '内容ID',
  `pubdate` DATETIME COMMENT '内容ID',
  `like_count` INT COMMENT '喜欢人数',
  `message_count` INT COMMENT '留言人数',
  `deleted` BIT COMMENT '是否删除 0：未删除 1：已删除',
  `version` INT COMMENT '版本编号',
  `created_by` INT COMMENT '创建者ID',
  `created_date` DATETIME COMMENT '创建时间',
  `last_modified_by` INT COMMENT '最后修改者ID',
  `last_modified_date` DATETIME COMMENT '最后修改者ID',
  PRIMARY KEY (`id`) 
);

INSERT INTO `t_article`(`id`,`user_id`,`body_wrap_id`,`pubdate`,`like_count`,`message_count`,`deleted`,`version`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) 
VALUES (1,1,1,'2017-05-27 00:00:00',0,0,0,0,1,NOW(),1,NOW());




DROP TABLE IF EXISTS `t_text_wrap`;
CREATE TABLE `t_text_wrap` (
  `id` INT AUTO_INCREMENT COMMENT 'ID',
  `text` LONGTEXT COMMENT '文本',
  `deleted` BIT COMMENT '是否删除 0：未删除 1：已删除',
  `version` INT COMMENT '版本编号',
  `created_by` INT COMMENT '创建者ID',
  `created_date` DATETIME COMMENT '创建时间',
  `last_modified_by` INT COMMENT '最后修改者ID',
  `last_modified_date` DATETIME COMMENT '最后修改者ID',
  PRIMARY KEY (`id`) 
);

INSERT INTO `t_text_wrap`(`id`,`text`,`deleted`,`version`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) 
VALUES (1,'admin',0,0,1,NOW(),1,NOW());



