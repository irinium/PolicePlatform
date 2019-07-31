CREATE TABLE roles_permissions
(   role_id INT NULL,
    permission_id INT NULL
);

ALTER TABLE roles_permissions
    ADD CONSTRAINT FOREIGN KEY (role_id) REFERENCES roles(id),
    ADD CONSTRAINT FOREIGN KEY (permission_id) REFERENCES permissions(id);