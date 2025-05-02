insert into roles (id, permissions, inserted_at) values
('user', '{GET:auth/info}'::text[], now()),
('root', default, now());
