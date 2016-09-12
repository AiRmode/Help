BEGIN;

INSERT INTO shemaName."user_status" (id, title)
VALUES
  (1, 'ACTIVE'),
  (777, 'BOSS')
ON CONFLICT (id)
  DO NOTHING;

INSERT INTO shemaName."user" (id, name, email, pass_hash, phone_num, status_id,
                            is_superuser, created_date, created_by_id, last_modified_date, last_modified_by_id)
VALUES
  (1, 'admin', 'example@mail.com', '120b6ae92e26693f1f0f77a9cc91e87a',
      '+38 097 777 77 77', 1, TRUE, '2000-01-01 00:00:00', 1, '2000-01-01 00:00:00', 1)
ON CONFLICT (id)
  DO UPDATE SET
    name	 = EXCLUDED.name,
    pass_hash	 = EXCLUDED.pass_hash,
    phone_num	 = EXCLUDED.phone_num,
    email 	 = EXCLUDED.email;

--pass_hash = (MD5) adm1npass
--if exist -> update name, pass_hash, phone_num, email

COMMIT;
