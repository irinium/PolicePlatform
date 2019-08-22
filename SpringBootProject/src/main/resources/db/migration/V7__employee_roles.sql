CREATE TABLE employee_roles
(   employee_id INT NULL,
    role_id INT NULL
);

ALTER TABLE employee_roles
    ADD CONSTRAINT FOREIGN KEY (employee_id) REFERENCES police_employee(id),
    ADD CONSTRAINT FOREIGN KEY (role_id) REFERENCES roles(id);