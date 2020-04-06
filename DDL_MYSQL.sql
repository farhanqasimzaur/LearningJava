create table learningjava(id int,
                        module varchar(255),
                        chapter int,
                        PRIMARY KEY (id));
drop table learningjava;

create table modules(id int not null,
                        name varchar(255) not null,
                        total_chapters int not null,
                        PRIMARY KEY (id));

create table chapters(id int not null ,
                        name varchar(50) not null,
                        total_pages int not null,
                        module_id int not null,
                        PRIMARY KEY (id),
                        foreign key (module_id) references modules(id));

create table students(id int not null ,
                        name varchar(255) not null ,
                        age int not null);

alter table students add constraint pk_id primary key (id);

create table student_modules(id int not null,
                        student_id int not null,
                        module_id int not null,
                        pages_completed int default 0,
                        primary key (id),
                        foreign key (module_id) references modules(id),
                        foreign key (student_id) references students(id));
                        
alter table student_modules drop column pages_completed;

create table student_chapters(id int not null,
                                student_id int not null,
                                chapter_id int not null,
                                pages_completed int default 0,
                                primary key (id),
                                foreign key (student_id) references students(id),
                                foreign key (chapter_id) references chapters(id));