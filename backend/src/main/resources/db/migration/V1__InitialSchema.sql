CREATE TABLE IF NOT EXISTS person
(
		personid serial PRIMARY KEY,
		username VARCHAR(16) NOT NULL,
		password VARCHAR(64) NOT NULL,
		role VARCHAR(12) NOT NULL	
);

CREATE TABLE IF NOT EXISTS marks
(
		markid serial PRIMARY KEY,
		studentname VARCHAR(16) NOT NULL,
		subject VARCHAR(14) NOT NULL,
		mark INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS parents
(
		relid serial PRIMARY KEY,
		parentname VARCHAR(16) NOT NULL,
		childname VARCHAR(16) NOT NULL
);