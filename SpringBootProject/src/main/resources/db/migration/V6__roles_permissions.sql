CREATE TABLE roles_permissions
(   role_id INT NULL,
    permission_id INT NULL
);

ALTER TABLE roles_permissions
    ADD CONSTRAINT fk_roles_permissions_roles FOREIGN KEY (role_id) REFERENCES roles(id);
ALTER TABLE roles_permissions
    ADD CONSTRAINT fk_roles_permissions_roles_permissions FOREIGN KEY (permission_id) REFERENCES permissions(id);