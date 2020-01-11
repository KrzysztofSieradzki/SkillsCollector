-- Testowe umiejętności
INSERT INTO skills (name) VALUES ('Programowanie proceduralne');
INSERT INTO skills (name) VALUES ('Programowanie obiektowe');
INSERT INTO skills (name) VALUES ('Algorytmy i struktury danych');
INSERT INTO skills (name) VALUES ('Strumienie i wyrażenia lambda');
INSERT INTO skills (name) VALUES ('HTML i CSS');
INSERT INTO skills (name) VALUES ('JvaScript');
INSERT INTO skills (name) VALUES ('Servlety i JSP');
INSERT INTO skills (name) VALUES ('JPA i Hibernate');
INSERT INTO skills (name) VALUES ('Spring Framework');
INSERT INTO skills (name) VALUES ('Spring Data');
INSERT INTO skills (name) VALUES ('Spring Security');
INSERT INTO skills (name) VALUES ('Czysty kod');
INSERT INTO skills (name) VALUES ('Wzorce Projektowe');

-- Testowe źródła wiedzy i powiązania z umiejętnościami
INSERT INTO sources (name, description) VALUES ('Java. Podstawy', 'Książka opisująca podstawy języka Java');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (1, 1);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (1, 2);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (1, 3);

INSERT INTO sources (name, description) VALUES ('Java. Programowanie funkcyjne', 'Książka omawiająca programowanie proceduralne i funkcyjne w językuja Java');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (2, 1);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (2, 4);

INSERT INTO sources (name, description) VALUES ('Java. Algorytmy. 2-edycja', 'Książka omawiająca algorytmy klasyczne bazujące na iteracji oraz programowaniu funkcyjnym');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (3, 3);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (3, 4);

INSERT INTO sources (name, description) VALUES ('Podstawy HTML', 'Kurs przygotowujący do podstaw pracy z HTML, CSS i JavaScript');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (4, 5);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (4, 6);

INSERT INTO sources (name, description) VALUES ('Servlety i JPA', 'Tutorial pokazujący tworzenie aplikacji w technologii Servletów i JPA');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (5, 7);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (5, 10);

INSERT INTO sources (name, description) VALUES ('Nowoczesne aplikacje webowe', 'Kurs omawiający tworzenie aplikacji webowych wykorzystujących technologie Servletów i framework Spring');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (6, 7);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (6, 8);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (6, 9);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (6, 10);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (6, 11);

INSERT INTO sources (name, description) VALUES ('Mistrzostwo Programowania', 'Podstawy wzorców projektowych i czystego kodu');
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (7, 12);
INSERT INTO sources_attached_skills (source_id, skill_id) VALUES (7, 13);

-- Testowi użytkownicy z rolami i znanymi źródłami
INSERT INTO users (username, password, first_name, last_name) VALUES ('jnowak', 'jnowak', 'Jan', 'Nowak');
INSERT INTO users_known_sources (user_id, source_id) VALUES (1, 1);
INSERT INTO users_known_sources (user_id, source_id) VALUES (1, 4);
INSERT INTO users_known_sources (user_id, source_id) VALUES (1, 5);

INSERT INTO users (username, password, first_name, last_name) VALUES ('jkowalski', 'jkowalski', 'Jan', 'Kowalski');
INSERT INTO users_known_sources (user_id, source_id) VALUES (2, 1);
INSERT INTO users_known_sources (user_id, source_id) VALUES (2, 2);

INSERT INTO users (username, password, first_name, last_name) VALUES ('anowak', 'anowak', 'Anna', 'Nowak');
INSERT INTO users_known_sources (user_id, source_id) VALUES (3, 1);
INSERT INTO users_known_sources (user_id, source_id) VALUES (3, 2);
INSERT INTO users_known_sources (user_id, source_id) VALUES (3, 4);
INSERT INTO users_known_sources (user_id, source_id) VALUES (3, 5);
INSERT INTO users_known_sources (user_id, source_id) VALUES (3, 6);