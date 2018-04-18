--liquibase formatted sql logicalFilePath:V1_010_STUDENT.sql
--changeset nikileg:1.10 runOnChange:true context:prod

---
ALTER TABLE liga.student
  ADD COLUMN department_id BIGSERIAL;

UPDATE liga.student AS s
SET department_id = (
  SELECT id
  FROM liga.department_id AS d
  WHERE d.title = s.department_name
);

ALTER TABLE liga.student
  DROP COLUMN department_name;



