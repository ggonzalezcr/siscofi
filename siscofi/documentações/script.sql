CREATE TABLE controle(
	
   classe varchar(30) NOT NULL,
   quantidade int NOT NULL,
   ultimo int NOT NULL,
   PRIMARY KEY(classe)
);

INSERT INTO controle (classe, quantidade, ultimo) VALUES ('segunda Via', 1, 1);
