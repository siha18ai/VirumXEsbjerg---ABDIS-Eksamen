DROP DATABASE IF EXISTS Kirk_Larsen;
create DATABASE kirk_larsen;
Use kirk_larsen;
create table if not exists kunde (
Id int (10) NOT NULL auto_increment,
First_name varchar(255) NOT NULL,
Last_name varchar(255) NOT NULL,
Email varchar(255) NOT NULL DEFAULT 'Insert your email',
Username varchar(55) NOT NULL,
Password varchar(55) NOT NULL,
PRIMARY KEY (Id),
unique KEY Username (Username)
);
Use kirk_larsen;
create table if not exists adresse (
Person_Id int (10) NOT NULL auto_increment,
Ejd_nr int NOT NULL PRIMARY KEY,
Kommune varchar (255) NOT NULL,
Vej_navn varchar(255) NOT NULL,
Nr int NOT NULL,
Etage int,
Side_doer_nr int,
FOREIGN KEY (Person_Id) REFERENCES kunde (Id)
);
Use kirk_larsen;
create table if not exists grundværdi (
Ejd_nr int NOT NULL,
Aar int (4) NOT NULL,
Maksimal_bebyggelse int NOT NULL,
Etage_areal_pris int NOT NULL,
Samlet_areal int NOT NULL,
Faktisk_grund_areal int NOT NULL,
Grundskyld_promille int NOT NULL,
FOREIGN KEY (Ejd_nr) REFERENCES adresse (Ejd_nr)
);
Use kirk_larsen;
create table if not exists medarbejder (
Role varchar(25) NOT NULL,
Username varchar(55) NOT NULL PRIMARY KEY,
Password varchar(55) NOT NULL
);


