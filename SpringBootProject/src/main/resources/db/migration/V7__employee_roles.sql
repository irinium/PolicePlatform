CREATE TABLE employee_roles
(   employee_id INT NULL,
    role_id INT NULL
);

ALTER TABLE employee_roles
    ADD CONSTRAINT employee_roles_police_employee FOREIGN KEY (employee_id) REFERENCES police_employee(id);
ALTER TABLE employee_roles
    ADD CONSTRAINT employee_roles_roles FOREIGN KEY (role_id) REFERENCES roles(id);