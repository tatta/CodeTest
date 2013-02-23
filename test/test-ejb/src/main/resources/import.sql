-- You can use this file to load seed data into the database using SQL statements
insert into Header values ('Generella frågor')
insert into Header values ('Ledarskap')

insert into Question(statement, header) values ('Vi har effektiva arbetsrutiner i min arbetsgrupp.','Generella frågor')

insert into Answer(userName,questionId, answerOption) values ('Anders', 1, 'ONE')


