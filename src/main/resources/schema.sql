CREATE TABLE training
(
    id       INT NOT NULL AUTO_INCREMENT,
    part     VARCHAR(100) NOT NULL,
    menu     VARCHAR(500) NOT NULL,
    datetime DATETIME NOT NULL,
    PRIMARY KEY (id)
);
