
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `bet`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `match`;
DROP TABLE IF EXISTS `team`;



CREATE TABLE `users` (
`id` int(11) NOT NULL AUTO_INCREMENT, 
`username` varchar(250) UNIQUE,   
`firstName` varchar(250) DEFAULT NULL,   
`lastName` varchar(250) DEFAULT NULL, 
`password` varchar(250) DEFAULT NULL,
`enabled` BOOLEAN DEFAULT true,
`gender` enum('man','woman','other'),
`totalScore` int(11) DEFAULT 0,  
`description` TINYTEXT DEFAULT NULL,
`profileImage` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE authorities (
  username VARCHAR(250) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
  
);
 
CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);
  


insert into users (username, firstName, lastName, password, totalscore, description, profileImage) values ('Alphonse', 'Alphonse', 'Radborne', 'paswoord1',  25,'Revision of Infusion Device in Cranial Cav, Extern Approach', 'http://dummyimage.com/142x164.bmp/5fa2dd/ffffff');
insert into users (username, firstName, lastName, password, totalscore, description, profileImage) values ('Curcio', 'Curcio', 'Neagle', 'paswoord1', 15,'Drainage of Intracranial Vein with Drain Dev, Perc Approach', 'http://dummyimage.com/108x236.png/5fa2dd/ffffff');
insert into users (username, firstName, lastName, password, totalscore, description, profileImage) values ('Delainey', 'Delainey', 'Learoyde', 'paswoord1', 10,'Restrict of L Com Carotid with Extralum Dev, Perc Approach', 'http://dummyimage.com/104x199.jpg/5fa2dd/ffffff');
insert into users (username, firstName, lastName, password, totalscore, description, profileImage) values ('Whitney', 'Whitney', 'Theuss', 'paswoord1', 12,'Drainage of Bilateral Breast, Endo', 'http://dummyimage.com/196x138.png/5fa2dd/ffffff');
insert into users (username, firstName, lastName, password, totalscore,  description, profileImage) values ('Melesa', 'Melesa', 'Grishanov', 'paswoord1', 40,'Revision of Infusion Device in Ovary, Open Approach', 'http://dummyimage.com/248x215.bmp/5fa2dd/ffffff');

INSERT INTO authorities (username, authority) values ('Alphonse', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('Curcio', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('Delainey', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('Whitney', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('Melesa', 'ROLE_USER');

CREATE TABLE `team` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(250) DEFAULT NULL,   
`flagImage` varchar(255) DEFAULT NULL,
`description` TINYTEXT DEFAULT NULL,
`status` int(11) DEFAULT 0,
PRIMARY KEY (`id`) 
);

insert into team (name, flagImage, description) values ('China', 'http://dummyimage.com/159x149.bmp/ff4444/ffffff', 'Dilate Up Art, Bifurc, w 4+ Intralum Dev, Perc');
insert into team (name, flagImage, description) values ('Indonesia', 'http://dummyimage.com/158x102.jpg/5fa2dd/ffffff', 'Drainage of L Metatarsotars Jt with Drain Dev, Open Approach');
insert into team (name, flagImage, description) values ('Poland', 'http://dummyimage.com/228x184.jpg/dddddd/000000', 'Removal of Intralum Dev from Pancreat Duct, Via Opening');
insert into team (name, flagImage, description) values ('Philippines', 'http://dummyimage.com/156x200.jpg/cc0000/ffffff', 'Drainage of Cystic Duct, Percutaneous Approach, Diagnostic');
insert into team (name, flagImage, description) values ('Sweden', 'http://dummyimage.com/157x101.bmp/cc0000/ffffff', 'Extraction of Left Trunk Bursa and Ligament, Perc Approach');

CREATE TABLE `match` (
`id` int(11) NOT NULL AUTO_INCREMENT,   
`hometeam_id` int(11) NOT NULL,   
`awayteam_id` int(11) NOT NULL,   
`hometeamscore` int(11) DEFAULT NULL,   
`awayteamscore` int(11) DEFAULT NULL, 
`matchdate` DATE DEFAULT NULL,  
`status` int(11) DEFAULT 0,
FOREIGN KEY (`hometeam_id`) REFERENCES `team` (`id`),
FOREIGN KEY (`awayteam_id`) REFERENCES `team` (`id`),
PRIMARY KEY (`id`)  
);
insert into `match` (hometeam_id, awayteam_id, hometeamscore, awayteamscore, matchdate, status) values (2, 1, 0, 3, '2021-09-01 20:00:00', 1);
insert into `match` (hometeam_id, awayteam_id, hometeamscore, awayteamscore, matchdate, status) values (4, 3, 4, 5, '2021-09-02 16:00:00', 2);
insert into `match` (hometeam_id, awayteam_id, hometeamscore, awayteamscore, matchdate, status) values (2, 1, 2, 3, '2021-09-03 18:00:00', 0);
insert into `match` (hometeam_id, awayteam_id, hometeamscore, awayteamscore, matchdate, status) values (1, 2, 4, 1, '2021-09-04 22:00:00', 2);
insert into `match` (hometeam_id, awayteam_id, hometeamscore, awayteamscore, matchdate, status) values (1, 2, 5, 3, '2021-09-05 14:00:00', 3);


CREATE TABLE `bet` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NOT NULL,
`match_id` int(11) NOT NULL,
`homeTeamBet` int(11)  NOT NULL,   
`awayTeamBet` int(11)  NOT NULL,
`obtainedPoints` int(11)  DEFAULT 0,
FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
FOREIGN KEY (`match_id`) REFERENCES `match` (`id`),
PRIMARY KEY (`id`)  
);

insert into bet (user_id, match_id, homeTeamBet, awayTeamBet, obtainedPoints) values (4, 1, 2, 3, 0);
insert into bet (user_id, match_id, homeTeamBet, awayTeamBet, obtainedPoints) values (3, 3, 1, 4, 0);
insert into bet (user_id, match_id, homeTeamBet, awayTeamBet, obtainedPoints) values (3, 4, 1, 6, 0);
insert into bet (user_id, match_id, homeTeamBet, awayTeamBet, obtainedPoints) values (1, 3, 2, 4, 0);
insert into bet (user_id, match_id, homeTeamBet, awayTeamBet, obtainedPoints) values (2, 2, 4, 7, 0);