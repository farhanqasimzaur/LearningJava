insert into modules(id, name, total_chapters)
values(1, 'java', 14);
insert into modules(id, name, total_chapters)
values(2, 'c sharp', 20);
insert into modules(id, name, total_chapters)
values(3, 'hadoop', 15);

insert into students(id, name, age)
values (1, 'Max', 20);
insert into students(id, name, age)
values (2, 'Alex', 22);
insert into students(id, name, age)
values (3, 'Soya', 19);
insert into students(id, name, age)
values (4, 'Annie', 21);
insert into students(id, name, age)
values (5, 'cant-think-of-name', 21);

select * from students;

insert into student_modules(id, student_id, module_id)
values(1,1,1);

insert into student_modules(id, student_id, module_id)
values(2,2,1);

insert into student_modules(id, student_id, module_id)
values(3,2,2);

insert into student_modules(id, student_id, module_id)
values(4,3,2);

insert into student_modules(id, student_id, module_id)
values(5,5,2);

select * from student_modules;

insert into chapters(id, name, total_pages, module_id)
values (1, 'Hello java', 10, 1);
insert into chapters(id, name, total_pages, module_id)
values (2, 'Basic java', 15, 1);
insert into chapters(id, name, total_pages, module_id)
values (3, 'hello c#', 20, 2);
insert into chapters(id, name, total_pages, module_id)
values (4, 'basic c#', 15, 2);
insert into chapters(id, name, total_pages, module_id)
values (5, 'Hola hadoop', 50, 3);

select * from chapters;

delete from chapters where id = 5;

update modules set total_chapters = 30 where id = 3;

insert into student_chapters(id, student_id, chapter_id, pages_completed)
values (1, 1, 1, 5);

insert into student_chapters(id, student_id, chapter_id, pages_completed)
values (2, 2, 1, 10);

insert into student_chapters(id, student_id, chapter_id, pages_completed)
values (3, 5, 3, 0);

insert into student_chapters(id, student_id, chapter_id, pages_completed)
values (4, 2, 3, 10);

insert into student_chapters(id, student_id, chapter_id, pages_completed)
values (5, 2, 4, 5);