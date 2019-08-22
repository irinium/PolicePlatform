ALTER TABLE police_report
    ADD assignee INT NULL;
ALTER TABLE police_report
    ADD CONSTRAINT fk_police_report_assignee FOREIGN KEY (assignee) REFERENCES police_employee (id);