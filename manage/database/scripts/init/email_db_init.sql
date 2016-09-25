BEGIN;
--ROLLBACK;
DROP TABLE IF EXISTS schema_name."email_queue" CASCADE;
DROP TABLE IF EXISTS schema_name."email_queue_attachment" CASCADE;
DROP TABLE IF EXISTS schema_name."email_queue_status" CASCADE;

CREATE TABLE schema_name."email_queue" (
  email_id      SERIAL             NOT NULL,
  recepient     VARCHAR(255)       NOT NULL,
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


ALTER TABLE schema_name."email_queue"
  ADD FOREIGN KEY (attachment_id) REFERENCES schema_name."email_queue_attachment" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE schema_name."email_queue"
  ADD FOREIGN KEY (status_id) REFERENCES schema_name."email_queue_status" (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT;


COMMIT;