CREATE TABLE police_report
(
    id INT NOT NULL AUTO_INCREMENT,
    EO INT NOT NULL,
    decision VARCHAR(300) NULL,
    story VARCHAR(1000) NULL,
    declarant VARCHAR(45) NULL,
    commission_place VARCHAR(100) NULL,
    full_name VARCHAR(45) NULL,
    results VARCHAR(500) NULL,
    PRIMARY KEY (id)
);