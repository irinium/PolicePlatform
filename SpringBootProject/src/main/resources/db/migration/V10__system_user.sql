INSERT INTO `database`.permissions(id, permission_name) values(1, 'CREATE_EMPLOYEE');
INSERT INTO `database`.permissions(id, permission_name) values(2, 'UPDATE_EMPLOYEE');
INSERT INTO `database`.permissions(id, permission_name) values(3, 'GET_EMPLOYEE');
INSERT INTO `database`.permissions(id, permission_name) values(4, 'DELETE_EMPLOYEE');
INSERT INTO `database`.permissions(id, permission_name) values(5, 'SEARCH_EMPLOYEE');

INSERT INTO `database`.roles(id, role_name) values(1, 'ROLE_ADMIN');
INSERT INTO `database`.roles(id, role_name) values(2, 'ROLE_EMPLOYEE');

INSERT INTO `database`.`police_employee` (`id`, `UUID`, `name`, `password`) VALUES (1, 'system', 'SYSTEM', '$2a$10$OReIVA7c8/R2YUVxWaDfg.IS/hZpnlxuKDN5ayCDJiWQ84zVA5f/y');

INSERT INTO `database`.roles_permissions(role_id, permission_id) values(1, 1);
INSERT INTO `database`.roles_permissions(role_id, permission_id) values(1, 2);
INSERT INTO `database`.roles_permissions(role_id, permission_id) values(1, 3);
INSERT INTO `database`.roles_permissions(role_id, permission_id) values(1, 4);
INSERT INTO `database`.roles_permissions(role_id, permission_id) values(1, 5);

INSERT INTO `database`.roles_permissions(role_id, permission_id) values(2, 2);
INSERT INTO `database`.roles_permissions(role_id, permission_id) values(2, 5);

INSERT INTO `database`.employee_roles(employee_id, role_id) values(1, 1);
