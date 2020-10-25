
DROP TABLE IF EXISTS `bet`;
DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `match`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `userStats`;


CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT, 
`username` varchar(250) UNIQUE,   
`firstname` varchar(250) DEFAULT NULL,   
`lastname` varchar(250) DEFAULT NULL, 
`password` varchar(250) DEFAULT NULL,
`role` varchar(250) DEFAULT NULL,
`is_active` BOOLEAN ,
`totalscore` int(11) DEFAULT 0,  
`description` varchar(250) DEFAULT NULL,
`imageurl` varchar(255) DEFAULT NULL,
`userstats_id` int(11) DEFAULT NULL,
FOREIGN KEY (`userstats_id`) REFERENCES `userstats` (`id`),
PRIMARY KEY (`id`) 
);

CREATE TABLE `team` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(250) DEFAULT NULL,   
`flagimage` varchar(255) DEFAULT NULL,
`description`  varchar(255) DEFAULT NULL,
`status` int(11) DEFAULT 0,
PRIMARY KEY (`id`) 
);


CREATE TABLE `match` (
`id` int(11) NOT NULL AUTO_INCREMENT,   
`hometeam` int(11) NOT NULL,   
`awayteam` int(11) NOT NULL,   
`hometeamscore` int(11) DEFAULT NULL,   
`awayteamscore` int(11) DEFAULT NULL, 
`matchdate` DATE DEFAULT NULL,  
`status` int(11) DEFAULT 0,
`voted` boolean DEFAULT NULL,
FOREIGN KEY (`hometeam`) REFERENCES `team` (`id`),
FOREIGN KEY (`awayteam`) REFERENCES `team` (`id`),
PRIMARY KEY (`id`)  
);

CREATE TABLE `bet` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NOT NULL,
`match_id` int(11) NOT NULL,
`homeTeamBet` int(11)  NOT NULL,   
`awayTeamBet` int(11)  NOT NULL,
`obtainedPoints` int(11)  DEFAULT 0,
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
FOREIGN KEY (`match_id`) REFERENCES `match` (`id`),
PRIMARY KEY (`id`)  
);


CREATE TABLE `userStats` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NOT NULL,
`place` int(11) DEFAULT 0, 
`points` int(11) DEFAULT 0, 
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
PRIMARY KEY (`id`) 
);

CREATE TABLE `user_userstats` (
`id` int(11) NOT NULL auto_increment,
`user_id` int(11) NOT NULL,
`userstats_id` int(11) NOT NULL,

FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
FOREIGN KEY (`userstats_id`) REFERENCES `user` (`id`),
PRIMARY KEY (`id`) 
);
