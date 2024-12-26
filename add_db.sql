create table public.tests (
	n_test_id int4 primary key,
	c_name varchar not null
	);

comment on table public.tests is 'Таблица с тестами';
comment on column public.tests.n_test_id is 'Идентификатор теста';
comment on column public.tests.c_name is 'Название теста';

create table public.questions (
	n_question_id int4 primary key,
	c_name varchar not null,
	n_answer_id int4 null
	);

comment on table public.questions is 'Таблица с вопросами';
comment on column public.questions.n_question_id is 'Идентификатор вопроса';
comment on column public.questions.c_name is 'Вопрос';
comment on column public.questions.n_answer_id is 'Ссылка на правильный ответ';

create table public.test_question (
	n_test_id int4 not null,
	n_question_id int4 not null,
	primary key (n_test_id, n_question_id), 
	foreign key (n_test_id) references public.tests (n_test_id),
	foreign key (n_question_id) references public.questions (n_question_id)
	);

comment on table public.test_question is 'Таблица для сязи тестов со своими вопросами';
comment on column public.test_question.n_test_id is 'Идентификатор теста';
comment on column public.test_question.n_question_id is 'Идентификатор вопроса�';

create table public.answers (
	n_answer_id int4 primary key,
	c_name varchar not null,
	n_question_id int4 not null,
	foreign key (n_question_id) references public.questions (n_question_id)
	);

comment on table public.answers is 'Таблица ответов на вопросы';
comment on column public.answers.n_answer_id is 'Идентификатор варианта ответа на вопрос';
comment on column public.answers.c_name is 'Вариант ответа на вопрос';
comment on column public.answers.n_question_id is 'Ссылка на вопрос ответа';

 alter table public.questions 
	add foreign key (n_answer_id) references public.answers (n_answer_id);