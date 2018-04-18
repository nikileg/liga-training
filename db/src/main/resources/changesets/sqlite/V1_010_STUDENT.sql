--liquibase formatted sql logicalFilePath:V1_010_STUDENT.sql
--changeset sanasov:1.10 runOnChange:true context:prod

ALTER TABLE student
  ADD COLUMN department_id INTEGER;

UPDATE student
SET department_id = (
  SELECT id
  FROM department_id
  WHERE title = department_name
);

-- ALTER TABLE student DROP COLUMN department_name;
