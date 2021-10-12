insert INTO users (enabled, password, user, name, surname, email) VALUES (true ,'cristian123','cristian1','cristian','garzon','cristiancamilogarzon2@gmail.com');
insert INTO users (enabled, password, user, name, surname, email) VALUES (false,'camilo123','camilo1','camilo','rodriguez','camilo@gmail.com');
insert INTO users (enabled, password, user, name, surname, email) VALUES (false,'cristian12345','cristian','garzon','cristian','cristiancamilogarzon@ucundinamarca.edu.co');
insert INTO users (enabled, password, user, name, surname, email) VALUES (true,'camilo12345','camilo2','rodriguez','camilo','camilo@ucundinamarca.edu.co');

insert INTO roles (name) VALUES ('ROLE_MOD');
insert INTO roles (name) VALUES ('ROLE_ADMIN');
insert INTO roles (name) VALUES ('ROLE_USER');
insert INTO roles (name) VALUES ('ROLE_WRITER');

insert into user_role (id_user, id_role) VALUES (1,1);
insert into user_role (id_user, id_role) VALUES (2,2);
insert into user_role (id_user, id_role) VALUES (3,3);
insert into user_role (id_user, id_role) VALUES (4,4);
