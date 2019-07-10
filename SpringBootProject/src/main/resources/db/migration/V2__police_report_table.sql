ALTER TABLE police_report
(
    id INT NOT NULL AUTO_INCREMENT,
    assignee_id INT NULL,
    EO INT NOT NULL,
    decision VARCHAR(300) NULL,
    story VARCHAR(1000) NULL,
    declarant VARCHAR(45) NULL,
    commission_place VARCHAR(100) NULL,
    full_name VARCHAR(45) NULL,
    results VARCHAR(500) NULL,
    PRIMARY KEY (id)
    FOREIGN KEY (assignee_id) REFERENCES police_employee(id)
);