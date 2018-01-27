CREATE TABLE SPR_FOOD_OPTION_CONFIG (
  UUID       VARCHAR(36) CONSTRAINT NN00_FOOD_OPTION_CONFIG NOT NULL,
  EVENT_UUID VARCHAR(36) CONSTRAINT NN01_FOOD_OPTION_CONFIG NOT NULL
);

ALTER TABLE SPR_FOOD_OPTION_CONFIG
  ADD CONSTRAINT PK_SPR_FOOD_OPTION_CONFIG PRIMARY KEY (UUID);

CREATE INDEX fk01_SPR_FOOD_OPTION_CONFIG
  ON SPR_FOOD_OPTION_CONFIG (EVENT_UUID);
ALTER TABLE SPR_FOOD_OPTION_CONFIG
  ADD CONSTRAINT fk01_SPR_FOOD_OPTION_CONFIG FOREIGN KEY (EVENT_UUID) REFERENCES SPR_EVENT (UUID);


CREATE TABLE SPR_FOOD_OPTION (
  UUID               VARCHAR(36)  CONSTRAINT NN00_SPR_FOOD_OPTION NOT NULL,
  CONFIGURATION_UUID VARCHAR(36)  CONSTRAINT NN01_SPR_FOOD_OPTION NOT NULL,
  NAME               VARCHAR(255) CONSTRAINT NN02_SPR_FOOD_OPTION NOT NULL,
  PRICE              INTEGER
);

ALTER TABLE SPR_FOOD_OPTION
  ADD CONSTRAINT PK_SPR_FOOD_OPTION PRIMARY KEY (UUID);

CREATE INDEX fk01_SPR_FOOD_OPTION
  ON SPR_FOOD_OPTION (CONFIGURATION_UUID);
ALTER TABLE SPR_FOOD_OPTION
  ADD CONSTRAINT fk01_SPR_FOOD_OPTION FOREIGN KEY (CONFIGURATION_UUID) REFERENCES SPR_FOOD_OPTION_CONFIG (UUID);

