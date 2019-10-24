CREATE DATABASE IF NOT EXISTS politicaldb2;
use politicaldb2;

CREATE TABLE IF NOT EXISTS userauth 
(
id				VARCHAR(45)		primary key,
username		VARCHAR(45)	NOT NULL,
userPassword	VARCHAR(45)	NOT NULL
);


CREATE TABLE IF NOT EXISTS party
(
partyname		varchar(45)		primary key,
numincongress	varchar(45)		not null,
numinsenate		varchar(45)		not null
);


CREATE TABLE IF NOT EXISTS politician
(
polid	varchar(45)	primary key unique,
polname	varchar(45)	NOT null unique,
party	varchar(45)	NOT null,
job		varchar(45)	NOT null
);

CREATE TABLE IF NOT EXISTS bill
(
billname	varchar(45)	primary key
);

-- relationship table where if a politician votes in favor of a bill, id and
-- bill name are added
CREATE TABLE IF NOT EXISTS politician_bill
(
polid_fk		int,
bill_name_fk	varchar(45),
yea				varchar(45),
foreign key (polid_fk) references politician(polid)
on delete cascade on update cascade,
foreign key (bill_name_fk) references bill(billname)
on delete cascade on update cascade,
primary key(polid_fk, bill_name_fk)
);	


CREATE TABLE IF NOT EXISTS house 
(
house_id				int			primary key,
house_majority_party	varchar(45)	NOT null unique,
house_majority_leader	varchar(45)	NOT null unique,
house_majority_whip		varchar(45)	NOT null unique,
house_minority_leader	varchar(45)	NOT null unique,
house_minority_whip		varchar(45)	NOT null unique,
foreign key (house_majority_party) references party(partyname)
on delete cascade on update cascade,
foreign key (house_majority_leader) references politician(polname)
on delete cascade on update cascade,
foreign key (house_majority_whip) references politician(polname)
on delete cascade on update cascade,
foreign key (house_minority_leader) references politician(polname)
on delete cascade on update cascade,
foreign key (house_minority_whip) references politician(polname)
on delete cascade on update cascade
);

CREATE TABLE IF NOT EXISTS politician_house
(
house_polid_fk		int,
houseid_fk			varchar(45),
foreign key (house_polid_fk) references politician(polid)
on update cascade on delete cascade,
foreign key (houseid_fk) references house(house_id)
on update cascade on delete cascade,
primary key(houseid_fk, house_bill_fk)
);

CREATE TABLE IF NOT EXISTS senate
(
senate_id	int	NOT null,
senate_majority_party	varchar(45)	NOT null,
senate_majority_leader	varchar(45)	NOT null,
senate_majority_whip	varchar(45)	NOT null,
senate_minority_leader	varchar(45)	NOT null,
senate_minority_whip	varchar(45)	NOT null,
foreign key (senate_majority_party) references party(partyname)
on delete cascade on update cascade,
foreign key (senate_majority_leader) references politician(polname)
on delete cascade on update cascade,
foreign key (senate_majority_whip) references politician(polname)
on delete cascade on update cascade,
foreign key (senate_minority_leader) references politician(polname)
on delete cascade on update cascade,
foreign key (senate_minority_whip) references politician(polname)
on delete cascade on update cascade
);

CREATE TABLE IF NOT EXISTS politician_senate
(
sen_polid_fk	int,
senid_fk		varchar(45),
foreign key (sen_polid_fk) references politician(polid)
on update cascade on delete cascade,
foreign key (senid_fk) references senate(senate_id)
on update cascade on delete cascade,
primary key(sen_polid_fk, senid_fk)
);





  


