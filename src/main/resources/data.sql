INSERT INTO student (name, surname, created_at, modified_at) VALUES ('Ahmet', 'Yılmaz', CURRENT_TIMESTAMP, NULL);
INSERT INTO test (name, description, created_at, modified_at) VALUES ('Genel Kültür', 'Genel Kültür ile ilgili sorular.', CURRENT_TIMESTAMP, NULL);

INSERT INTO question (test_id, question, created_at, modified_at) VALUES (1, 'Türkiye kaç bölgeden oluşmaktadır ?', CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (1, 'A', '5', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (1, 'B', '6', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (1, 'C', '7', TRUE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (1, 'D', '8', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO student_test (student_id, test_id, question_id, answer_id, created_at, modified_at) VALUES (1, 1, 1, 1, CURRENT_TIMESTAMP, NULL);

INSERT INTO question (test_id, question, created_at, modified_at) VALUES (1, '2x3= ?', CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (2, 'A', '5', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (2, 'B', '6', TRUE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (2, 'C', '7', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (2, 'D', '8', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO student_test (student_id, test_id, question_id, answer_id, created_at, modified_at) VALUES (1, 1, 2, 2, CURRENT_TIMESTAMP, NULL);

INSERT INTO question (test_id, question, created_at, modified_at) VALUES (1, 'En küçük asal sayı ?', CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (3, 'A', '5', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (3, 'B', '6', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (3, 'C', '7', FALSE, CURRENT_TIMESTAMP, NULL);
INSERT INTO question_choice (question_id, choice_symbol, choice, is_right_answer, created_at, modified_at) VALUES (3, 'D', '2', TRUE, CURRENT_TIMESTAMP, NULL);
INSERT INTO student_test (student_id, test_id, question_id, answer_id, created_at, modified_at) VALUES (1, 1, 3, 3, CURRENT_TIMESTAMP, NULL);