BEGIN;
--ROLLBACK;

DROP TABLE IF EXISTS schema_name."user" CASCADE;
DROP TABLE IF EXISTS schema_name."user_info" CASCADE;
DROP TABLE IF EXISTS schema_name."user_status" CASCADE;
DROP TABLE IF EXISTS schema_name."user_avatar" CASCADE;
DROP TABLE IF EXISTS schema_name."company" CASCADE;
DROP TABLE IF EXISTS schema_name."company_info" CASCADE;
DROP TABLE IF EXISTS schema_name."company_status" CASCADE;
DROP TABLE IF EXISTS schema_name."company_avatar" CASCADE;
DROP TABLE IF EXISTS schema_name."company_alias" CASCADE;
DROP TABLE IF EXISTS schema_name."shelter" CASCADE;
DROP TABLE IF EXISTS schema_name."shelter_type" CASCADE;
DROP TABLE IF EXISTS schema_name."shelter_info" CASCADE;
DROP TABLE IF EXISTS schema_name."shelter_status" CASCADE;
DROP TABLE IF EXISTS schema_name."shelter_avatar" CASCADE;
DROP TABLE IF EXISTS schema_name."tag" CASCADE;
DROP TABLE IF EXISTS schema_name."event" CASCADE;
DROP TABLE IF EXISTS schema_name."event_info" CASCADE;
DROP TABLE IF EXISTS schema_name."company_user" CASCADE;
DROP TABLE IF EXISTS schema_name."company_event" CASCADE;
DROP TABLE IF EXISTS schema_name."user_event" CASCADE;
DROP TABLE IF EXISTS schema_name."shelter_tag" CASCADE;
DROP TABLE IF EXISTS schema_name."email_queue" CASCADE;
DROP TABLE IF EXISTS schema_name."email_queue_attachment" CASCADE;
DROP TABLE IF EXISTS schema_name."email_queue_status" CASCADE;

CREATE TABLE schema_name."user" (
  id                  SERIAL       NOT NULL,
  name                VARCHAR(255) NOT NULL,
  email               VARCHAR(255) NOT NULL,
  pass_hash           VARCHAR      NOT NULL,
  phone_num           VARCHAR(20)  NOT NULL,
  status_id           INTEGER      NOT NULL,
  avatar_id           INTEGER,
  is_superuser        BOOLEAN      NOT NULL,  --default FALSE
  locale_lang         VARCHAR(20) DEFAULT 'ru',
  created_date        TIMESTAMP    NOT NULL,
  created_by_id       INTEGER,
  last_modified_date  TIMESTAMP    NOT NULL,
  last_modified_by_id INTEGER,
  PRIMARY KEY (id),
  UNIQUE (email, phone_num)
);

CREATE TABLE schema_name."user_info" (
  id        SERIAL       NOT NULL,
  user_id   INTEGER      NOT NULL,
  info      VARCHAR(255) NOT NULL,
  info_type VARCHAR(50)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."user_status" (
  id    SERIAL      NOT NULL,
  title VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."user_avatar" (
  id     SERIAL NOT NULL,
  avatar BYTEA  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."company" (
  id                  SERIAL       NOT NULL,
  title               VARCHAR(255) NOT NULL,
  description         TEXT,
  status_id           INTEGER      NOT NULL,
  avatar_id           INTEGER,
  created_date        TIMESTAMP    NOT NULL,
  created_by_id       INTEGER,
  last_modified_date  TIMESTAMP    NOT NULL,
  last_modified_by_id INTEGER,
  PRIMARY KEY (id),
  UNIQUE (title)
);

CREATE TABLE schema_name."company_info" (
  id         SERIAL       NOT NULL,
  company_id INTEGER      NOT NULL,
  info       VARCHAR(255) NOT NULL,
  info_type  VARCHAR(50)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."company_status" (
  id    SERIAL      NOT NULL,
  title VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."company_avatar" (
  id     SERIAL NOT NULL,
  avatar BYTEA  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."company_alias" (
  id         SERIAL  NOT NULL,
  alias      VARCHAR NOT NULL,
  company_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (alias)
);

CREATE TABLE schema_name."shelter" (
  id                  SERIAL       NOT NULL,
  title               VARCHAR(255) NOT NULL,
  description         TEXT,
  type_id             INTEGER      NOT NULL,
  status_id           INTEGER      NOT NULL,
  avatar_id           INTEGER,
  created_date        TIMESTAMP    NOT NULL,
  created_by_id       INTEGER,
  last_modified_date  TIMESTAMP    NOT NULL,
  last_modified_by_id INTEGER,
  PRIMARY KEY (id),
  UNIQUE (title)
);

CREATE TABLE schema_name."shelter_type" (
  id    SERIAL      NOT NULL,
  title VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."shelter_info" (
  id         SERIAL       NOT NULL,
  shelter_id INTEGER      NOT NULL,
  info       VARCHAR(255) NOT NULL,
  info_type  VARCHAR(50)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."shelter_status" (
  id    SERIAL      NOT NULL,
  title VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."shelter_avatar" (
  id     SERIAL NOT NULL,
  avatar BYTEA  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."tag" (
  id    SERIAL      NOT NULL,
  title VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (title)
);

CREATE TABLE schema_name."event" (
  id                  SERIAL       NOT NULL,
  title               VARCHAR(255) NOT NULL,
  description         TEXT,
  shelter_id          INTEGER      NOT NULL,
  date                TIMESTAMP    NOT NULL,
  is_accessible       BOOLEAN      NOT NULL,
  created_date        TIMESTAMP    NOT NULL,
  created_by_id       INTEGER,
  last_modified_date  TIMESTAMP    NOT NULL,
  last_modified_by_id INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."event_info" (
  id        SERIAL       NOT NULL,
  event_id  INTEGER      NOT NULL,
  info      VARCHAR(255) NOT NULL,
  info_type VARCHAR(50)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."company_user" (
  id         SERIAL  NOT NULL,
  user_id    INTEGER NOT NULL,
  company_id INTEGER NOT NULL,
  is_admin   BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."company_event" (
  event_id   INTEGER NOT NULL,
  company_id INTEGER NOT NULL
);

CREATE TABLE schema_name."user_event" (
  event_id INTEGER NOT NULL,
  user_id  INTEGER NOT NULL
);

CREATE TABLE schema_name."shelter_tag" (
  shelter_id INTEGER NOT NULL,
  tag_id     INTEGER NOT NULL
);

CREATE TABLE schema_name."email_queue" (
  email_id      SERIAL             NOT NULL,
  recipient     VARCHAR(255)       NOT NULL,
  sender        VARCHAR(255)       NOT NULL,
  subject       VARCHAR(255)       NOT NULL,
  message_body  TEXT,
  attachment_id INTEGER,
  created_date  TIMESTAMP          NOT NULL,
  status_id     INTEGER            NOT NULL,
  send_date     TIMESTAMP          NOT NULL,

  PRIMARY KEY (email_id)
);

CREATE TABLE schema_name."email_queue_attachment" (
  id         SERIAL  NOT NULL,
  attachment VARCHAR NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE schema_name."email_queue_status" (
  id             SERIAL      NOT NULL,
  message_status VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (message_status)
);

ALTER TABLE schema_name."user"
  ADD FOREIGN KEY (status_id) REFERENCES schema_name."user_status" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."user"
  ADD FOREIGN KEY (avatar_id) REFERENCES schema_name."user_avatar" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE schema_name."user"
  ADD FOREIGN KEY (created_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."user"
  ADD FOREIGN KEY (last_modified_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE schema_name."user_info"
  ADD FOREIGN KEY (user_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."company"
  ADD FOREIGN KEY (status_id) REFERENCES schema_name."company_status" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."company"
  ADD FOREIGN KEY (avatar_id) REFERENCES schema_name."company_avatar" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE schema_name."company"
  ADD FOREIGN KEY (created_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."company"
  ADD FOREIGN KEY (last_modified_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE schema_name."company_info"
  ADD FOREIGN KEY (company_id) REFERENCES schema_name."company" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."company_alias"
  ADD FOREIGN KEY (company_id) REFERENCES schema_name."company" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."shelter"
  ADD FOREIGN KEY (status_id) REFERENCES schema_name."shelter_status" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."shelter"
  ADD FOREIGN KEY (avatar_id) REFERENCES schema_name."shelter_avatar" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE schema_name."shelter"
  ADD FOREIGN KEY (type_id) REFERENCES schema_name."shelter_type" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."shelter"
  ADD FOREIGN KEY (created_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."shelter"
  ADD FOREIGN KEY (last_modified_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE schema_name."shelter_info"
  ADD FOREIGN KEY (shelter_id) REFERENCES schema_name."shelter" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."event"
  ADD FOREIGN KEY (shelter_id) REFERENCES schema_name."shelter" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."event"
  ADD FOREIGN KEY (created_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE schema_name."event"
  ADD FOREIGN KEY (last_modified_by_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE schema_name."event_info"
  ADD FOREIGN KEY (event_id) REFERENCES schema_name."event" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."company_user"
  ADD FOREIGN KEY (user_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE schema_name."company_user"
  ADD FOREIGN KEY (company_id) REFERENCES schema_name."company" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."company_event"
  ADD FOREIGN KEY (event_id) REFERENCES schema_name."event" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE schema_name."company_event"
  ADD FOREIGN KEY (company_id) REFERENCES schema_name."company" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."user_event"
  ADD FOREIGN KEY (event_id) REFERENCES schema_name."event" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE schema_name."user_event"
  ADD FOREIGN KEY (user_id) REFERENCES schema_name."user" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."shelter_tag"
  ADD FOREIGN KEY (shelter_id) REFERENCES schema_name."shelter" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE schema_name."shelter_tag"
  ADD FOREIGN KEY (tag_id) REFERENCES schema_name."tag" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE schema_name."email_queue"
  ADD FOREIGN KEY (attachment_id) REFERENCES schema_name."email_queue_attachment" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE schema_name."email_queue"
  ADD FOREIGN KEY (status_id) REFERENCES schema_name."email_queue_status" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;

COMMIT;