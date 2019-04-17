DROP TABLE IF EXISTS user_tab;
CREATE TABLE IF NOT EXISTS user_tab(
    id INT AUTO_INCREMENT,
    name VARCHAR(20),
    age INT,
    PRIMARY KEY (id)
);
