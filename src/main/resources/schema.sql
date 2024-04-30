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