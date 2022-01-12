CREATE SEQUENCE if not exists departments_sequence
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20;

CREATE SEQUENCE if not exists lectors_sequence
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20;

CREATE TABLE if not exists departments
(
    department_id  bigint not null default nextval('departments_sequence'),
    name           varchar(255),
    department_head bigint,
    PRIMARY KEY (department_id)
);

CREATE TABLE IF NOT EXISTS lectors
(
    lector_id bigint not null default nextval('lectors_sequence'),
    name      varchar(255),
    degree    varchar(255),
    salary    int,
    PRIMARY KEY (lector_id)
);

CREATE TABLE IF NOT EXISTS departments_lectors
(
    department_id bigint not null,
    lector_id     bigint not null,
    PRIMARY KEY (department_id, lector_id),
    FOREIGN KEY (department_id) REFERENCES departments (department_id),
    FOREIGN KEY (lector_id) REFERENCES lectors (lector_id)
);


INSERT INTO lectors (name, degree, salary)
VALUES ('Liam Smith', 'ASSOCIATE_PROFESSOR', 8000),
       ('Noah Johnson', 'ASSISTANT', 2500),
       ('Oliver Williams', 'ASSISTANT', 3500),
       ('Elijah Brown', 'ASSISTANT', 3000),
       ('James Jones', 'PROFESSOR', 13000),
       ('Olivia Garcia', 'ASSOCIATE_PROFESSOR', 7500),
       ('Emma Miller', 'ASSOCIATE_PROFESSOR', 6500),
       ('Ava Davis', 'ASSISTANT', 5000),
       ('Charlotte Rodriguez', 'PROFESSOR', 12000),
       ('Sophia Martinez', 'PROFESSOR', 15000);

INSERT INTO departments (name, department_head)
SELECT 'Chemistry Department', lector_id
FROM lectors
WHERE name = 'James Jones';

INSERT INTO departments (name, department_head)
SELECT 'Computer Science Department', lector_id
FROM lectors
WHERE name = 'Sophia Martinez';

INSERT INTO departments (name, department_head)
SELECT 'Medicine Department', lector_id
FROM lectors
WHERE name = 'Charlotte Rodriguez';

INSERT INTO departments_lectors
SELECT dep.department_id, l.lector_id
FROM departments dep
         CROSS JOIN lectors l
WHERE (dep.name = 'Chemistry Department'
    AND l.name IN ('James Jones', 'Liam Smith', 'Noah Johnson', 'Oliver Williams', 'Elijah Brown', 'Ava Davis'))
   OR (dep.name = 'Computer Science Department'
    AND l.name IN ('Charlotte Rodriguez', 'Olivia Garcia', 'Oliver Williams', 'Emma Miller', 'Ava Davis'))
   OR (dep.name = 'Medicine Department'
    AND l.name IN ('Sophia Martinez', 'Emma Miller', 'Elijah Brown', 'Ava Davis', 'Noah Johnson', 'Olivia Garcia'))

-- DROP TABLE if exists  departments CASCADE;
-- DROP TABLE if exists  lectors CASCADE ;
-- DROP TABLE if exists  departments_lectors CASCADE ;
-- DROP SEQUENCE if exists departments_sequence;
-- DROP SEQUENCE if exists lectors_sequence;






