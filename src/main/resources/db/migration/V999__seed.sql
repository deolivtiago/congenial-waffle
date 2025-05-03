delete from tokens t;
delete from users u;

insert into roles (id, permissions, inserted_at) values
('wizard', default, now()),
('hobbit', '{"GET:auth/info"}', now());

insert into users (id, full_name, email, password, role_id, inserted_at) values
(default, 'gandalf', 'gandalf@istari.inc', 'W1z4rd!', 'wizard', now()),
('532278cd-649f-40dc-94a6-622d2b100871', 'bilbo', 'bilbo@shire.inc', 'Th1ef?', 'hobbit', now()),
('1ec2c622-428b-4adf-842b-a4e4d981eb6f', 'frodo', 'frodo@shire.inc', 'H0bb17!', 'hobbit', now());

insert into tokens (user_id, access, refresh, inserted_at) values
('532278cd-649f-40dc-94a6-622d2b100871', 'bilbo.access.token', 'bilbo.refresh.token', now()),
('1ec2c622-428b-4adf-842b-a4e4d981eb6f', 'frodo.access.token', 'frodo.refresh.token', now());
