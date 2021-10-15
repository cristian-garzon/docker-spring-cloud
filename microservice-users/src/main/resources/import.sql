insert INTO users (enabled, password, user, name, surname, email) VALUES (true ,'$2a$10$LiXYS2XQH6GP.Z8eeSzZFumqpev.zStDxJ9W1MKptOVB1rPqPphoq','cristian1','cristian','garzon','cristiancamilogarzon2@gmail.com');
insert INTO users (enabled, password, user, name, surname, email) VALUES (false,'$2a$10$Z5Cljz.0nNA0DYm1vg9NK.mlxvLyHPT9QExiysrEkckiYV1qq0PjK','camilo1','camilo','rodriguez','camilo@gmail.com');
insert INTO users (enabled, password, user, name, surname, email) VALUES (false,'$2a$10$FKoL55KlGojAGhUJkaoXV.E5.xifLyVITSd4O7YXUmvMyrecFaGrG','cristian','garzon','cristian','cristiancamilogarzon@ucundinamarca.edu.co');
insert INTO users (enabled, password, user, name, surname, email) VALUES (true,'$2a$10$Am2dYTxcsEwK6njvDdJC/eM7aH3McNnsyQ/DBdD.OPuqiwwhvlmyq','camilo2','rodriguez','camilo','camilo@ucundinamarca.edu.co');

insert INTO roles (name) VALUES ('ROLE_MOD');
insert INTO roles (name) VALUES ('ROLE_ADMIN');
insert INTO roles (name) VALUES ('ROLE_USER');
insert INTO roles (name) VALUES ('ROLE_WRITER');

insert into user_role (id_user, id_role) VALUES (1,1);
insert into user_role (id_user, id_role) VALUES (2,2);
insert into user_role (id_user, id_role) VALUES (3,3);
insert into user_role (id_user, id_role) VALUES (4,4);
