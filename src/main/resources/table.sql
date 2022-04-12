CREATE TABLE IF NOT EXISTS students
(
    Id          SERIAL PRIMARY KEY,
    StudentName CHARACTER VARYING(30),
    LessonName  CHARACTER VARYING(30)
);

CREATE TABLE IF NOT EXISTS  lesson
(
    Id          SERIAL PRIMARY KEY,
    LessonName  CHARACTER VARYING(30),
    StudentName CHARACTER VARYING(30)
);

CREATE TABLE IF NOT EXISTS  student_lesson
(
    student_id int NOT NULL ,
    lesson_id  int NOT NULL,
    PRIMARY KEY(student_id, lesson_id),
    FOREIGN KEY (student_id) REFERENCES students (Id),
    FOREIGN KEY (lesson_id) REFERENCES lesson (Id)
);