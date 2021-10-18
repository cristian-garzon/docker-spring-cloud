insert INTO users (enabled, password, username, name, surname, email) VALUES (true ,'$2a$10$VmqRkHaNxCt179fPyfTvQ.1UdWvD/my5WGp2wBHDrGW4yvSuL2l.K','cristian1','cristian','garzon','cristiancamilogarzon2@gmail.com');
insert INTO users (enabled, password, username, name, surname, email) VALUES (true,'$2a$10$U3ilRDFh4t4JrrpABxc6W..qbogGp7NUbKgW5KS7OtIMvdk5q/qci','camilo1','camilo','rodriguez','camilo@gmail.com');
insert INTO users (enabled, password, username, name, surname, email) VALUES (false,'$2a$10$bBqIY9fPVVi4YeuYSgJW3eKyAS3joYtsGyI1E0xGFsjYz/9nxoRF6','cristian','garzon','cristian','cristiancamilogarzon@ucundinamarca.edu.co');
insert INTO users (enabled, password, username, name, surname, email) VALUES (true,'$2a$10$4L2/kqt2mCEUlviXMmj7res2xEeGRVbf8PT8KdhKJS0iamLjvqrA6','camilo2','rodriguez','camilo','camilo@ucundinamarca.edu.co');

insert INTO roles (name) VALUES ('ROLE_MOD');
insert INTO roles (name) VALUES ('ROLE_ADMIN');
insert INTO roles (name) VALUES ('ROLE_USER');
insert INTO roles (name) VALUES ('ROLE_WRITER');

insert into user_role (id_user, id_role) VALUES (1,1);
insert into user_role (id_user, id_role) VALUES (2,2);
insert into user_role (id_user, id_role) VALUES (3,3);
insert into user_role (id_user, id_role) VALUES (4,4);
