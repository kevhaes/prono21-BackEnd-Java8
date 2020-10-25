
INSERT INTO user (id, username, firstname, lastname, password, role, is_active , totalscore, description, imageurl) VALUES 
(1,'user01',  'Alphonse', 'Radborne',	'$2a$10$mnk86JKIy5Jpbs1CVnTO5.Tg/S1yU2skV23l97WLBoP4.5vaY6MJ.',	'admin',1,	75, 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.',		'https://randomuser.me/api/portraits/lego/1.jpg'	),
(2,'user02', 	'Curcio', 'Neagle',		'$2a$10$qxp240XlBML3LoznG6.sx./C1D3biyy46GlPgENoOffUyWbB2SGw2',	'user',	1,	84, 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus.',																																																	'https://randomuser.me/api/portraits/lego/2.jpg'	),
(3,'user03', 	'Delainey', 'Learoyde',	'$2a$10$OpGEzF6GjW3Y5./ka6HikORomLwDrZm1d5au62gvpBRWmFMPPTq6u',	'user',	1,	52, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://randomuser.me/api/portraits/lego/3.jpg'	),
(4,'user05',	'Whitney', 'Theuss',	'$2a$10$W34GbT/RJexmYqJNWUbLoORaNJ02jI839oVNNli6SehvDv8Tsrnq6',	'user',	1,	51, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://randomuser.me/api/portraits/lego/5.jpg'	),
(5,'user06',	'Melesa', 'Grishanov',	'$2a$10$W34GbT/RJexmYqJNWUbLoORaNJ02jI839oVNNli6SehvDv8Tsrnq6',	'user',	1,	88, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://randomuser.me/api/portraits/lego/6.jpg'	),
(6,'user07',	'Stéphanie', 'Fairham',	'$2a$10$W34GbT/RJexmYqJNWUbLoORaNJ02jI839oVNNli6SehvDv8Tsrnq6',	'user',	1,	12, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://randomuser.me/api/portraits/lego/7.jpg'	),
(7,'user08',	'Aloïs', 'Laurenson',	'$2a$10$W34GbT/RJexmYqJNWUbLoORaNJ02jI839oVNNli6SehvDv8Tsrnq6',	'user',	1,	87, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://randomuser.me/api/portraits/lego/8.jpg'	),
(8,'user09',	'Erwéi', 'Bradie',		'$2a$10$W34GbT/RJexmYqJNWUbLoORaNJ02jI839oVNNli6SehvDv8Tsrnq6',	'user',	1,	95, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://randomuser.me/api/portraits/lego/9.jpg'	),
(9,'user10',	'Françoise', 'Dermott',	'$2a$10$W34GbT/RJexmYqJNWUbLoORaNJ02jI839oVNNli6SehvDv8Tsrnq6',	'user',	0,	87, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget','https://www.uic.mx/posgrados/files/2018/05/default-user-300x300.png'	);
                
INSERT INTO  `team` (name, flagimage, description, status) VALUES 
( 'Indonesia','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.', 1),
( 'Denmark','http://dummyimage.com/20x20.jpg/ff4444/ffffff', 	 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae, Mauris viverra diam vitae quam. Suspendisse potenti.', 2),
('Russia','http://dummyimage.com/20x20.jpg/ff4444/ffffff', 	 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.', 0),
( 'Germany','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Proin at turpis a pede posuere nonummy. Integer non velit.', 2),
( 'Sweden','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Donec posuere metus vitae ipsum. Aliquam non mauris.', 2),
( 'Brazil','http://dummyimage.com/20x20.jpg/dddddd/000000', 	 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 1),
( 'France','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae, Mauris viverra diam vitae quam. Suspendisse potenti.', 1),
( 'Belgium','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', 0),
( 	'Spain','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff',  'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 2),
('Ecuador', 'http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Sed accumsan felis. Ut at dolor quis odio consequat varius.', 1),
( 	'Italy', 'http://dummyimage.com/20x20.jpg/cc0000/ffffff', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', 0),
( 	'France','http://dummyimage.com/20x20.jpg/ff4444/ffffff',  'Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', 2),
( 	'Czech Republic','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff',  'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 2),
( 'China', 'http://dummyimage.com/20x20.jpg/cc0000/ffffff', 	'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 2),
( 	'England', 'http://dummyimage.com/20x20.jpg/cc0000/ffffff', 'Maecenas pulvinar lobortis est. Phasellus sit amet erat.', 2),
( 'Indonesia','http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	 'Etiam vel augue. Vestibulum rutrum rutrum neque.', 2),
( 'China','http://dummyimage.com/20x20.jpg/cc0000/ffffff', 	 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 0),
( 	'Peru','http://dummyimage.com/20x20.jpg/dddddd/000000',  'Morbi a ipsum. Integer a nibh.', 1),
( 'Cyprus', 'http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	'Fusce consequat. Nulla nisl.', 2),
( 'Morocco', 'http://dummyimage.com/20x20.jpg/5fa2dd/ffffff', 	'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', 1);


          
--                                                                                                              
INSERT INTO  `match` (hometeam, awayteam, hometeamscore, awayteamscore, matchdate, status) VALUES 
(5,7,5,4,'2021-09-22 16:03:49',0);     


INSERT INTO `bet` (user_id, match_id, homeTeamBet, awayTeamBet, obtainedpoints) VALUES
(4, 1, 2, 3, 0);   

INSERT INTO `userStats` (place, points, user_id ) VALUES
(4, 1, 2);           