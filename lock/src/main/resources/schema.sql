CREATE TABLE user (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name       VARCHAR(30)     NOT NULL,
  password   VARCHAR(40)     NOT NULL,
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE tenant (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  houseId    BIGINT UNSIGNED NOT NULL,
  name       VARCHAR(30)     NOT NULL,
  idCard     VARCHAR(18),
  phone      VARCHAR(11),
  gender     VARCHAR(10),
  email      VARCHAR(30),
  used       BOOLEAN         NOT NULL DEFAULT FALSE,
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE build (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name       VARCHAR(30)     NOT NULL,
  code       BIGINT UNSIGNED NOT NULL,
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE unit (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  buildId    BIGINT UNSIGNED NOT NULL,
  name       VARCHAR(30)     NOT NULL,
  code       BIGINT UNSIGNED NOT NULL,
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE house (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  unitId     BIGINT UNSIGNED NOT NULL,
  name       VARCHAR(30)     NOT NULL,
  code       BIGINT UNSIGNED NOT NULL,
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE gateway (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  unitId     BIGINT UNSIGNED NOT NULL,
  sn         VARCHAR(30)     NOT NULL,
  udid       VARCHAR(40)     NOT NULL,
  name       VARCHAR(30)     NOT NULL,
  ip         VARCHAR(40)     NOT NULL,
  port       INT UNSIGNED    NOT NULL,
  remote     VARCHAR(40)     NOT NULL,
  version    VARCHAR(30),
  qrCode     VARCHAR(50),
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE locks (
  id         BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
  gatewayId  BIGINT UNSIGNED  NOT NULL,
  houseId    BIGINT UNSIGNED  NOT NULL,
  uuid       VARCHAR(36)      NOT NULL, /*uuid()方法自动生成*/
  name       VARCHAR(30)      NOT NULL,
  area       TINYINT          NOT NULL DEFAULT -1,
  device     TINYINT UNSIGNED NOT NULL,
  createTime TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE record (
  id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  uuid        VARCHAR(36)     NOT NULL,
  action      VARCHAR(30)     NOT NULL,
  type        VARCHAR(20)     NOT NULL,
  pass        TINYINT UNSIGNED,
  description VARCHAR(50)     NOT NULL,
  eventTime   TIMESTAMP       NOT NULL,
  createTime  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE localrecord (
  id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  uuid        VARCHAR(36)     NOT NULL,
  action      VARCHAR(30)     NOT NULL,
  type        VARCHAR(20)     NOT NULL,
  pass        TINYINT UNSIGNED,
  description VARCHAR(50)     NOT NULL,
  eventTime   TIMESTAMP       NOT NULL,
  createTime  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE status (
  id       BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
  uuid     VARCHAR(36)      NOT NULL,
  locked   TINYINT UNSIGNED NOT NULL,
  upLock   TINYINT UNSIGNED NOT NULL,
  backLock TINYINT UNSIGNED NOT NULL,
  voltage  INT UNSIGNED     NOT NULL,
  online   BOOLEAN          NOT NULL,
  time     TIMESTAMP        NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE sessioninfo (
  id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  uuid       VARCHAR(36)     NOT NULL,
  ip         VARCHAR(36)     NOT NULL,
  tcpport    INT UNSIGNED    NOT NULL,
  udpprot    INT UNSIGNED    NOT NULL,
  curudprot  INT UNSIGNED    NOT NULL,
  createTime TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE credential (
  id         BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
  tenantId   BIGINT UNSIGNED  NOT NULL,
  uuid       VARCHAR(36)      NOT NULL,
  type       VARCHAR(20)      NOT NULL,
  sequence   TINYINT UNSIGNED NOT NULL,
  createTime TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;


ALTER TABLE unit
  ADD CONSTRAINT fk_build FOREIGN KEY (buildId) REFERENCES build (id);
ALTER TABLE house
  ADD CONSTRAINT fk_unit FOREIGN KEY (unitId) REFERENCES unit (id);
