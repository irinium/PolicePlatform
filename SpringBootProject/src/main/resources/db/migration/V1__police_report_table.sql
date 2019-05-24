CREATE TABLE police_report_table
(
    № INT NOT NULL AUTO_INCREMENT,
    ЄО № INT NOT NULL,
    рішення VARCHAR(300) NULL,
    фабула VARCHAR(1000) NULL,
    заявник VARCHAR(45) NULL,
    місце_скоєння VARCHAR(100) NULL,
    ПІБ_співробітник VARCHAR(45) NULL,
    Результати VARCHAR(500) NULL,
    PRIMARY KEY (№)
);
--CREATE TABLE persons
--(
--    id INT NOT NULL AUTO_INCREMENT,
--    PRIMARY KEY (id)
--);