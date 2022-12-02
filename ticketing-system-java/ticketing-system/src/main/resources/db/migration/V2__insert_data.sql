INSERT INTO groups(name) VALUES ('IT');
INSERT INTO groups(name) VALUES ('Development');
INSERT INTO groups(name) VALUES ('Management');

INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Wilbur Saunders', 'wilbur.saunders@dummy.com', false, 1);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Jacques Ellison', 'jacques.ellison@dummy.com', false, 1);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Courteney Sweeney', 'courteney.sweeney@dummy.com', true, 2);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Shannan Vance', 'shannan.vance@dummy.com', false, 2);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Lylah Reid', 'lylah.reid@dummy.com', false, 2);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Salim Cooper', 'salim.cooper@dummy.com', true, 3);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Kobi Wyatt', 'kobi.wyatt@dummy.com', true, 3);
INSERT INTO dummy_users(name, email, is_manager, group_id) VALUES ('Reanna Keenan', 'reanna.keenan@dummy.com', false, 3);



