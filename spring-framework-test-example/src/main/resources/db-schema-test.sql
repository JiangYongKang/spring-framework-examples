DROP TABLE IF EXISTS member;
CREATE TABLE member
(
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  email varchar(64) NOT NULL,
  pwd varchar(64) NOT NULL,
  created_time timestamp,
  updated_time timestamp NOT NULL
);
CREATE UNIQUE INDEX member_email_uindex ON member (email);
INSERT INTO `member`(`id`, `email`, `pwd`, `created_time`, `updated_time`) VALUES (1, 'vincent@gmail.com', '123456', '2017-05-06 10:30:07', '2017-05-06 10:30:07');