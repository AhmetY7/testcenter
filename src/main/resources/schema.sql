create table student(
  id identity,
  name varchar(50) not null,
  surname varchar(50) not null,
  created_at timestamp not null,
  modified_at timestamp
);

create table test(
  id identity,
  name varchar(50),
  description varchar(200),
  created_at timestamp not null,
  modified_at timestamp
);

create table question(
  id identity,
  test_id bigint not null,
  question varchar(1000) not null,
  created_at timestamp not null,
  modified_at timestamp,
  FOREIGN KEY (test_id) REFERENCES test(id)
);

create table question_choice(
  id identity,
  question_id bigint not null,
  choice_symbol CHAR(1) not null,
  choice varchar(500) not null,
  is_right_answer BOOLEAN not null,
  created_at timestamp not null,
  modified_at timestamp,
  FOREIGN KEY (question_id) REFERENCES question(id)
);

create table student_test(
  id identity,
  student_id bigint not null,
  test_id bigint not null,
  question_id bigint not null,
  answer_id bigint not null,
  created_at timestamp not null,
  modified_at timestamp,
  FOREIGN KEY (student_id) REFERENCES student(id),
  FOREIGN KEY (question_id) REFERENCES question(id),
  FOREIGN KEY (answer_id) REFERENCES question_choice(id),
  FOREIGN KEY (test_id) REFERENCES test(id)
);
