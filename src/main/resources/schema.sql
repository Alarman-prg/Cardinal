CREATE TABLE IF NOT EXISTS 'users' (
    'id' int AUTO_INCREMENT PRIMARY KEY,
    'username' VARCHAR(255) NOT NULL,
    'email' VARCHAR(255) NOT NULL,
    'password' VARCHAR(255) NOT NULL,
    'firstname' VARCHAR(255) NOT NULL,
    'lastname' VARCHAR(255) NOT NULL,
);