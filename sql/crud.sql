-- users

-- insert
insert into users values(user_seq.nextval, '안대혁', 'kickscar@gmail.com', '1234', 'male');

-- delete
delete from users;
commit;

-- select(login)
select no, name
from users
where email='kickscar@gmaiol.com' and
	  password='1234';
	  
select *
from users;
	  
-- board

-- view
select no, title, content
from board
where no=2;

update board set hit = hit + 1 where  no=2;		-- 조회수 늘리기

-- list (ceil(cur_page/5)-1)*5+1;
select count(*)
from board;

select rownum, no, title, hit, reg_date, name, users_no
from (  select a.no, a.title, a.hit, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') as reg_date, b.name, a.users_no
		from board a, users b
		where a.users_no=b.no
		--  and title like '%kwd%' or content like '%kwd%'
		order by group_no desc, order_no asc)
where (1-1)*2+1 <= rownum and		-- front_1->current page, 2-> page_size
	   rownum <= 1*2;
	   
select *
from (select rownum as rn, no, title, hit, reg_date, name, users_no
	  from (  select a.no, a.title, a.hit, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') as reg_date, b.name, a.users_no
				from board a, users b
				where a.users_no=b.no
				--  and title like '%kwd%' or content like '%kwd%'
				order by group_no desc, order_no asc))
where (3-1)*2+1 <= rn and		-- front_3->current page, 2-> page_size
	   rn <= 3*2;;



-- 새글
insert into board values(board_seq.nextval, '안녕', '안녕', sysdate, 0, nvl((select max(group_no) from board), 0) + 1, 1, 0, 2);

insert into board values(board_seq.nextval, '점심머먹지', '냉무', sysdate, 0, nvl((select max(group_no) from board), 0) + 1, 1, 0, 2);

insert into board values(board_seq.nextval, '배고프다 그만', '냉무', sysdate, 0, nvl((select max(group_no) from board), 0) + 1, 1, 0, 2);

select max(group_no)
from board;

-- 답글
update board set order_no = order_no + 1 where group_no = 2 and order_no > 1;

insert into board values(board_seq.nextval, '짬뽕', '냉무', sysdate, 0,
							 2,  -- 부모글의 그룹
							 2,	 -- 부모글 순서 + 1
							 1,	 -- 부모글 깊이 + 1
							 2);

update board set order_no = order_no + 1 where group_no = 2 and order_no > 2;

insert into board values(board_seq.nextval, '짬뽕', '냉무', sysdate, 0,
							 2,  -- 부모글의 그룹
							 3,	 -- 부모글 순서 + 1
							 2,	 -- 부모글 깊이 + 1
							 2);

update board set order_no = order_no + 1 where group_no = 2 and
												order_no > 1;		-- 부모 글 순서

insert into board values(board_seq.nextval, '짬뽕', '냉무', sysdate, 0,
							 2,  -- 부모글의 그룹
							 2,	 -- 부모글 순서 + 1
							 1,	 -- 부모글 깊이 + 1
							 2);

commit;