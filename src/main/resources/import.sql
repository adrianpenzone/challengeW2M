----------------------------------------------
--    JWT and Roles
 	
--    user1/password1: rol admin y rol usuario
--    user2/password2: rol operational
--    user3/password3: rol usuario

INSERT INTO USERS (id, name, password) VALUES (1, 'user1', '$2a$04$GJ85Ihcglhbqac2zc3z3A.C3v55FMmN8.qGQ8FlNBCuyLtQ5/TyMO');
INSERT INTO USERS (id, name, password) VALUES (2, 'user2', '$2a$04$XWpgKkCQaVRuXjB5f1hzt.pDa2NAzntroH3bELICZy8R8Q0L0SShO');
INSERT INTO USERS (id, name, password) VALUES (3, 'user3', '$2a$04$bmmWXec6YkFIesIxv2gx7.NbxRcMJ4UoRKT9Qoqk09pKegfcr3Zla');

INSERT INTO ROLES (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO ROLES (id, description, name) VALUES (2, 'User role', 'USER');
INSERT INTO ROLES (id, description, name) VALUES (3, 'Operational role', 'OPERATIONAL');

INSERT INTO USER_ROLES (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (1, 2);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (2, 3);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (3, 2);

----------------------------------------------


INSERT INTO SUPER_HEROES (id, nombre, poder) VALUES(1, 'Superman', 'super hombre');
INSERT INTO SUPER_HEROES (id, nombre, poder) VALUES(2, 'Batman', 'plata');
INSERT INTO SUPER_HEROES (id, nombre, poder) VALUES(3, 'Mujer Maravilla', 'como los de superman');
INSERT INTO SUPER_HEROES (id, nombre, poder) VALUES(4, 'Hulk', 'fuerza bruta');
INSERT INTO SUPER_HEROES (id, nombre, poder) VALUES(5, 'Iron Man', 'plata');


