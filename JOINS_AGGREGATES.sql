# get students who aren't associated to a module yet
select * from students s left join student_modules sm on s.id = sm.student_id where sm.id is null;

# get students who associated to module(s)
select * from students s join student_modules sm on s.id = sm.student_id order by student_id;

#get students who are associated to module(s) yet haven't started chapters
select * from students s
    join student_modules sm on s.id = sm.student_id
    left join student_chapters sc on s.id = sc.student_id
where sc.student_id is null or (sc.student_id is not null and sc.pages_completed = 0);
#     join student_chapters sc2 on s.id = sc2.student_id

# full outer join
select * from students left join student_modules sm on students.id = sm.student_id
union
select * from students right join student_modules sm on students.id = sm.student_id;

# Number of chapters each module has
select count(c.id), m.name from chapters c join modules m on c.module_id = m.id group by m.id;

# Number of page completed by a student
select  sum(sc.pages_completed) as total_pages_completed, s.name, m.name from students s
    join student_chapters sc on s.id = sc.student_id
    join chapters c on sc.chapter_id = c.id
    join modules m on c.module_id = m.id
    group by c.module_id, s.name;