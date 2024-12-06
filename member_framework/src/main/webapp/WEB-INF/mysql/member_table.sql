create table member_table(
	id bigint key auto_increment,
    memberEmail varchar(20) unique,
    memberPassword varchar(20),
    memberName varchar(20),
    memberAge int,
    memberMobile varchar(30)
);