DROP TABLE IF EXISTS user_tab;
CREATE TABLE user_tab(
    id INT AUTO_INCREMENT,
    name VARCHAR(20),
    age INT,
    PRIMARY KEY (id)
);
INSERT INTO user_tab(NAME, AGE) VALUES("Lisi", 14);