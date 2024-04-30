CREATE TABLE IF NOT EXISTS 'users' (
    'id' int AUTO_INCREMENT PRIMARY KEY,
    'username' VARCHAR(255) NOT NULL,
    'email' VARCHAR(255) NOT NULL,
    'password' VARCHAR(255) NOT NULL,
    'firstname' VARCHAR(255) NOT NULL,
    'lastname' VARCHAR(255) NOT NULL,
);

CREATE TABLE hike_participants (
    user_id INT,
    hike_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (hike_id) REFERENCES hikes(id),
    PRIMARY KEY (user_id, hike_id)
);

CREATE TABLE IF NOT EXISTS 'parks'
(
    'id' int AUTO_INCREMENT PRIMARY KEY,
    'name' VARCHAR(255) NOT NULL,
    'description' VARCHAR(255) NOT NULL,
    'rating_total' float(53) NOT NULL,
    'rating_count' int NOT NULL,
    'length' float(53) NOT NULL,
    'address' VARCHAR(255) NOT NULL,
    'county' VARCHAR(255) NOT NULL,
    'operator' VARCHAR(255) NOT NULL,
);