use mytest_1
create table if not exists `user`
(
		`username`  varchar(10) 	not null COMMENT 	'用户名',
		`password`  varchar(20)  	not null COMMENT  '密码',
		`uid`				varchar(30)  	primary key COMMENT  '用户id'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;