ALTER TABLE police_report
    ADD assignee INT NULL,
    ADD CONSTRAINT FOREIGN KEY (assignee) REFERENCES police_employee(id);