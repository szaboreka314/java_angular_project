INSERT INTO tickets(name, description, priority, status, resolution, created_at, created_by, assignee, category) values ('Setup linux', 'Please setup linux for my computer', 3, 'new', 'unresolved', now(), 4, 1, 'IT');
INSERT INTO tickets(name, description, priority, status, resolution, created_at, created_by, assignee, category) values ('Review tickets', 'Please review the tickets', 5, 'new', 'unresolved', now(), 7, 8, 'Management');
INSERT INTO tickets(name, description, priority, status, resolution, created_at, created_by, assignee, category) values ('Some new features', 'Please develope these new features.', 2, 'new', 'unresolved', now(), 7, 5, 'Development');

UPDATE tickets set category = 'IT' where id = 1
