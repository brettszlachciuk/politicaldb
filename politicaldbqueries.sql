use politicaldb2;

DELIMITER $$
CREATE FUNCTION passedsenate(billname varchar(45)) 
RETURNS BOOLEAN
DETERMINISTIC
BEGIN

DECLARE N1 INT; 

DECLARE N2 INT;

SELECT count(*) INTO N1 FROM politician_bill pb, politician_senate ps
WHERE billname = pb.bill_name_fk AND pb.polid_fk = ps.sen_polid_fk AND pb.yea = "yea";

SELECT count(*) INTO N1 FROM politician_bill pb
WHERE billname = pb.bill_name_fk AND pb.polid_fk = ps.sen_polid_fk AND pb.yea = "nay";

IF N1 = 0 AND N2 = 0 THEN SET VAL = false; 
ELSEIF N1 > N2 THEN SET VAL = true;
ELSE SET VAL = false;
END IF;
RETURN (VAL);
END $$

DELIMITER &&
CREATE FUNCTION passedhouse(billname varchar(45)) 
RETURNS BOOLEAN
DETERMINISTIC
BEGIN

DECLARE N1 INT; 

DECLARE N2 INT;

SELECT count(*) INTO N1 FROM politician_bill pb, politician_house ph
WHERE billname = pb.bill_name_fk AND pb.polid_fk = ph.house_polid_fk AND pb.yea = "yea";

SELECT count(*) INTO N1 FROM politician_bill pb
WHERE billname = pb.bill_name_fk AND pb.polid_fk = ph.house_polid_fk AND pb.yea = "nay";
 
IF N1 = 0 AND N2 = 0 THEN SET VAL = false; 
ELSEIF N1 > N2 THEN SET VAL = true;
ELSE SET VAL = false;
END IF;
RETURN (VAL);
END &&









