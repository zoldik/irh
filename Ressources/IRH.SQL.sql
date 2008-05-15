-- -----------------------------------------------------------------------------
--             G�n�ration d'une base de donn�es pour
--                      Oracle Version 9i
--                        (2/5/2008 9:13:30)
-- -----------------------------------------------------------------------------
--      Nom de la base : IRH
--      Projet : Accueil Win'Design version 7
--      Auteur : Alex
--      Date de derni�re modification : 2/5/2008 9:13:03
-- -----------------------------------------------------------------------------

DROP TABLE EMPLOI_PRECEDENT CASCADE CONSTRAINTS;

DROP TABLE DROIT CASCADE CONSTRAINTS;

DROP TABLE UTILISATEUR CASCADE CONSTRAINTS;

DROP TABLE PLAN_FORMATION CASCADE CONSTRAINTS;

DROP TABLE CIVILITE CASCADE CONSTRAINTS;

DROP TABLE SITUATION_FAMILIALE CASCADE CONSTRAINTS;

DROP TABLE SESSIONS CASCADE CONSTRAINTS;

DROP TABLE COMPETENCE CASCADE CONSTRAINTS;

DROP TABLE NIVEAU_ETUDE CASCADE CONSTRAINTS;

DROP TABLE CONTRAT CASCADE CONSTRAINTS;

DROP TABLE FORMATION CASCADE CONSTRAINTS;

DROP TABLE METIER CASCADE CONSTRAINTS;

DROP TABLE ORGANISME CASCADE CONSTRAINTS;

DROP TABLE POSTE CASCADE CONSTRAINTS;

DROP TABLE DIPLOME CASCADE CONSTRAINTS;

DROP TABLE EVALUATION CASCADE CONSTRAINTS;

DROP TABLE CATEGORIE CASCADE CONSTRAINTS;

DROP TABLE EMPLOYE CASCADE CONSTRAINTS;

DROP TABLE THEME CASCADE CONSTRAINTS;

DROP TABLE NIVEAU_REQUIS CASCADE CONSTRAINTS;

DROP TABLE NIVEAU_EVAL CASCADE CONSTRAINTS;

DROP TABLE INSCRIPTION CASCADE CONSTRAINTS;

DROP TABLE NIVEAU_FORM CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE IRH;

-- -----------------------------------------------------------------------------
--       TABLE : EMPLOI_PRECEDENT
-- -----------------------------------------------------------------------------

CREATE TABLE EMPLOI_PRECEDENT
   (
    ID NUMBER  NOT NULL,
    ID_CONTRAT NUMBER  NOT NULL,
    ID_EMPLOYE NUMBER  NOT NULL,
    DATE_DEBUT DATE  NOT NULL,
    DATE_FIN DATE  NOT NULL,
    ENTREPRISE VARCHAR2(128)  NOT NULL,
    POSTE VARCHAR2(128)  NOT NULL,
    DESCRIPTION VARCHAR2(255)  NULL
,   CONSTRAINT PK_EMPLOI_PRECEDENT PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EMPLOI_PRECEDENT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EMPLOI_PRECEDENT_CONTRAT
     ON EMPLOI_PRECEDENT (ID_CONTRAT ASC)
    ;

CREATE  INDEX I_FK_EMPLOI_PRECEDENT_EMPLOYE
     ON EMPLOI_PRECEDENT (ID_EMPLOYE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : DROIT
-- -----------------------------------------------------------------------------

CREATE TABLE DROIT
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_DROIT PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : UTILISATEUR
-- -----------------------------------------------------------------------------

CREATE TABLE UTILISATEUR
   (
    ID NUMBER  NOT NULL,
    ID_DROIT NUMBER  NOT NULL,
    NOM VARCHAR2(128)  NOT NULL,
    LOGIN VARCHAR2(128)  NOT NULL,
    PASS VARCHAR2(32)  NOT NULL
,   CONSTRAINT PK_UTILISATEUR PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE UTILISATEUR
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_UTILISATEUR_DROIT
     ON UTILISATEUR (ID_DROIT ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : PLAN_FORMATION
-- -----------------------------------------------------------------------------

CREATE TABLE PLAN_FORMATION
   (
    ANNEE NUMBER(4)  NOT NULL
,   CONSTRAINT PK_PLAN_FORMATION PRIMARY KEY (ANNEE)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : CIVILITE
-- -----------------------------------------------------------------------------

CREATE TABLE CIVILITE
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_CIVILITE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : SITUATION_FAMILIALE
-- -----------------------------------------------------------------------------

CREATE TABLE SITUATION_FAMILIALE
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_SITUATION_FAMILIALE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : SESSIONS
-- -----------------------------------------------------------------------------

CREATE TABLE SESSIONS
   (
    ID NUMBER  NOT NULL,
	ID_FORMATION NUMBER  NOT NULL,
    ANNEE NUMBER(4)  NOT NULL,
    DATE_DEBUT DATE  NOT NULL,
    DATE_FIN DATE  NOT NULL
,   CONSTRAINT PK_SESSIONS PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE SESSIONS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_SESSIONS_PLAN_FORMATION
     ON SESSIONS (ANNEE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : COMPETENCE
-- -----------------------------------------------------------------------------

CREATE TABLE COMPETENCE
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_COMPETENCE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : NIVEAU_ETUDE
-- -----------------------------------------------------------------------------

CREATE TABLE NIVEAU_ETUDE
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_NIVEAU_ETUDE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : CONTRAT
-- -----------------------------------------------------------------------------

CREATE TABLE CONTRAT
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_CONTRAT PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : FORMATION
-- -----------------------------------------------------------------------------

CREATE TABLE FORMATION
   (
    ID NUMBER  NOT NULL,
    ID_ORGANISME NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL,
    PRIX_PAR_PERSONNE NUMBER(7,2)  NOT NULL,
    DUREE CHAR(32)  NOT NULL
,   CONSTRAINT PK_FORMATION PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE FORMATION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_FORMATION_ORGANISME
     ON FORMATION (ID_ORGANISME ASC)
    ;

CREATE  INDEX I_FK_FORMATION_SESSIONS
     ON FORMATION (ID_SESSION ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : METIER
-- -----------------------------------------------------------------------------

CREATE TABLE METIER
   (
    ID NUMBER  NOT NULL,
    ID_CATEGORIE NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_METIER PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE METIER
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_METIER_CATEGORIE
     ON METIER (ID_CATEGORIE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : ORGANISME
-- -----------------------------------------------------------------------------

CREATE TABLE ORGANISME
   (
    ID NUMBER  NOT NULL,
    NOM VARCHAR2(128)  NOT NULL,
    DESCRIPTION VARCHAR2(255)  NULL
,   CONSTRAINT PK_ORGANISME PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : POSTE
-- -----------------------------------------------------------------------------

CREATE TABLE POSTE
   (
    ID NUMBER  NOT NULL,
    ID_METIER NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL,
    ESTOCCUPE NUMBER(1)  NOT NULL
,   CONSTRAINT PK_POSTE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE POSTE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_POSTE_METIER
     ON POSTE (ID_METIER ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : DIPLOME
-- -----------------------------------------------------------------------------

CREATE TABLE DIPLOME
   (
    ID NUMBER  NOT NULL,
    ID_NIVEAU NUMBER  NOT NULL,
    ID_EMPLOYE NUMBER  NOT NULL,
    DENOMINATION VARCHAR2(128)  NOT NULL,
    ETABLISSEMENT VARCHAR2(128)  NULL,
    ANNEE NUMBER(4)  NULL
,   CONSTRAINT PK_DIPLOME PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE DIPLOME
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_DIPLOME_NIVEAU_ETUDE
     ON DIPLOME (ID_NIVEAU ASC)
    ;

CREATE  INDEX I_FK_DIPLOME_EMPLOYE
     ON DIPLOME (ID_EMPLOYE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : EVALUATION
-- -----------------------------------------------------------------------------

CREATE TABLE EVALUATION
   (
    ID NUMBER  NOT NULL,
    ID_EMPLOYE NUMBER  NOT NULL,
    DATE_EVAL DATE  NOT NULL,
    COMMENTAIRE VARCHAR2(255)  NULL
,   CONSTRAINT PK_EVALUATION PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EVALUATION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EVALUATION_EMPLOYE
     ON EVALUATION (ID_EMPLOYE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : CATEGORIE
-- -----------------------------------------------------------------------------

CREATE TABLE CATEGORIE
   (
    ID NUMBER  NOT NULL,
    ID_THEME NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_CATEGORIE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CATEGORIE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CATEGORIE_THEME
     ON CATEGORIE (ID_THEME ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : EMPLOYE
-- -----------------------------------------------------------------------------

CREATE TABLE EMPLOYE
   (
    ID NUMBER  NOT NULL,
    ID_CIVILITE NUMBER  NOT NULL,
    ID_SITUATION_FAMILIALE NUMBER  NOT NULL,
    ID_POSTE NUMBER  NULL,
    NOM VARCHAR2(128)  NOT NULL,
    PRENOM VARCHAR2(128)  NOT NULL,
    TELEPHONE_PRO VARCHAR2(20)  NULL,
    TELEPHONE_MOBILE VARCHAR2(20)  NULL,
    TELEPHONE_PERSO VARCHAR2(20)  NULL,
    FAX VARCHAR2(20)  NULL,
    DATE_NAISSANCE DATE  NOT NULL,
    EMAIL VARCHAR2(128)  NULL,
    ADR_RUE VARCHAR2(255)  NOT NULL,
    ADR_CP VARCHAR2(10)  NOT NULL,
    ADR_VILLE VARCHAR2(128)  NOT NULL,
    DESCRIPTION VARCHAR2(255)  NULL,
    NB_ENFANTS NUMBER(2)  NULL
,   CONSTRAINT PK_EMPLOYE PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EMPLOYE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EMPLOYE_CIVILITE
     ON EMPLOYE (ID_CIVILITE ASC)
    ;

CREATE  INDEX I_FK_EMPLOYE_SITUATION_FAMILIA
     ON EMPLOYE (ID_SITUATION_FAMILIALE ASC)
    ;

CREATE UNIQUE INDEX I_FK_EMPLOYE_POSTE
     ON EMPLOYE (ID_POSTE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : THEME
-- -----------------------------------------------------------------------------

CREATE TABLE THEME
   (
    ID NUMBER  NOT NULL,
    LIBELLE VARCHAR2(128)  NOT NULL
,   CONSTRAINT PK_THEME PRIMARY KEY (ID)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : NIVEAU_REQUIS
-- -----------------------------------------------------------------------------

CREATE TABLE NIVEAU_REQUIS
   (
    ID_POSTE NUMBER  NOT NULL,
    ID_COMPETENCE NUMBER  NOT NULL,
    NIVEAU NUMBER(1)  NOT NULL
,   CONSTRAINT PK_NIVEAU_REQUIS PRIMARY KEY (ID_POSTE, ID_COMPETENCE)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE NIVEAU_REQUIS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_NIVEAU_REQUIS_POSTE
     ON NIVEAU_REQUIS (ID_POSTE ASC)
    ;

CREATE  INDEX I_FK_NIVEAU_REQUIS_COMPETENCE
     ON NIVEAU_REQUIS (ID_COMPETENCE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : NIVEAU_EVAL
-- -----------------------------------------------------------------------------

CREATE TABLE NIVEAU_EVAL
   (
    ID_EVALUATION NUMBER  NOT NULL,
    ID_COMPETENCE NUMBER  NOT NULL,
    NIVEAU NUMBER(1)  NOT NULL
,   CONSTRAINT PK_NIVEAU_EVAL PRIMARY KEY (ID_EVALUATION, ID_COMPETENCE)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE NIVEAU_EVAL
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_NIVEAU_EVAL_EVALUATION
     ON NIVEAU_EVAL (ID_EVALUATION ASC)
    ;

CREATE  INDEX I_FK_NIVEAU_EVAL_COMPETENCE
     ON NIVEAU_EVAL (ID_COMPETENCE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : INSCRIPTION
-- -----------------------------------------------------------------------------

CREATE TABLE INSCRIPTION
   (
    ID_EMPLOYE NUMBER  NOT NULL,
    ID_SESSION NUMBER  NOT NULL,
    ETAT VARCHAR2(128)  NULL,
    PRESENCE NUMBER(1)  NULL
,   CONSTRAINT PK_INSCRIPTION PRIMARY KEY (ID_EMPLOYE, ID_SESSION)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE INSCRIPTION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_INSCRIPTION_EMPLOYE
     ON INSCRIPTION (ID_EMPLOYE ASC)
    ;

CREATE  INDEX I_FK_INSCRIPTION_SESSIONS
     ON INSCRIPTION (ID_SESSION ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : NIVEAU_FORM
-- -----------------------------------------------------------------------------

CREATE TABLE NIVEAU_FORM
   (
    ID_COMPETENCE NUMBER  NOT NULL,
    ID_FORMATION NUMBER  NOT NULL,
    NIVEAU NUMBER(1)  NOT NULL
,   CONSTRAINT PK_NIVEAU_FORM PRIMARY KEY (ID_COMPETENCE, ID_FORMATION)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE NIVEAU_FORM
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_NIVEAU_FORM_COMPETENCE
     ON NIVEAU_FORM (ID_COMPETENCE ASC)
    ;

CREATE  INDEX I_FK_NIVEAU_FORM_FORMATION
     ON NIVEAU_FORM (ID_FORMATION ASC)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE EMPLOI_PRECEDENT ADD (
     CONSTRAINT FK_EMPLOI_PRECEDENT_CONTRAT
          FOREIGN KEY (ID_CONTRAT)
               REFERENCES CONTRAT (ID))   ;

ALTER TABLE EMPLOI_PRECEDENT ADD (
     CONSTRAINT FK_EMPLOI_PRECEDENT_EMPLOYE
          FOREIGN KEY (ID_EMPLOYE)
               REFERENCES EMPLOYE (ID))   ;

ALTER TABLE UTILISATEUR ADD (
     CONSTRAINT FK_UTILISATEUR_DROIT
          FOREIGN KEY (ID_DROIT)
               REFERENCES DROIT (ID))   ;

ALTER TABLE SESSIONS ADD (
     CONSTRAINT FK_SESSIONS_PLAN_FORMATION
          FOREIGN KEY (ANNEE)
               REFERENCES PLAN_FORMATION (ANNEE))   ;

ALTER TABLE FORMATION ADD (
     CONSTRAINT FK_FORMATION_ORGANISME
          FOREIGN KEY (ID_ORGANISME)
               REFERENCES ORGANISME (ID))   ;

ALTER TABLE FORMATION ADD (
     CONSTRAINT FK_FORMATION_SESSIONS
          FOREIGN KEY (ID_SESSION)
               REFERENCES SESSIONS (ID))   ;

ALTER TABLE METIER ADD (
     CONSTRAINT FK_METIER_CATEGORIE
          FOREIGN KEY (ID_CATEGORIE)
               REFERENCES CATEGORIE (ID))   ;

ALTER TABLE POSTE ADD (
     CONSTRAINT FK_POSTE_METIER
          FOREIGN KEY (ID_METIER)
               REFERENCES METIER (ID))   ;

ALTER TABLE DIPLOME ADD (
     CONSTRAINT FK_DIPLOME_NIVEAU_ETUDE
          FOREIGN KEY (ID_NIVEAU)
               REFERENCES NIVEAU_ETUDE (ID))   ;

ALTER TABLE DIPLOME ADD (
     CONSTRAINT FK_DIPLOME_EMPLOYE
          FOREIGN KEY (ID_EMPLOYE)
               REFERENCES EMPLOYE (ID))   ;

ALTER TABLE EVALUATION ADD (
     CONSTRAINT FK_EVALUATION_EMPLOYE
          FOREIGN KEY (ID_EMPLOYE)
               REFERENCES EMPLOYE (ID))   ;

ALTER TABLE CATEGORIE ADD (
     CONSTRAINT FK_CATEGORIE_THEME
          FOREIGN KEY (ID_THEME)
               REFERENCES THEME (ID))   ;

ALTER TABLE EMPLOYE ADD (
     CONSTRAINT FK_EMPLOYE_CIVILITE
          FOREIGN KEY (ID_CIVILITE)
               REFERENCES CIVILITE (ID))   ;

ALTER TABLE EMPLOYE ADD (
     CONSTRAINT FK_EMPLOYE_SITUATION_FAMILIALE
          FOREIGN KEY (ID_SITUATION_FAMILIALE)
               REFERENCES SITUATION_FAMILIALE (ID))   ;

ALTER TABLE EMPLOYE ADD (
     CONSTRAINT FK_EMPLOYE_POSTE
          FOREIGN KEY (ID_POSTE)
               REFERENCES POSTE (ID))   ;

ALTER TABLE NIVEAU_REQUIS ADD (
     CONSTRAINT FK_NIVEAU_REQUIS_POSTE
          FOREIGN KEY (ID_POSTE)
               REFERENCES POSTE (ID))   ;

ALTER TABLE NIVEAU_REQUIS ADD (
     CONSTRAINT FK_NIVEAU_REQUIS_COMPETENCE
          FOREIGN KEY (ID_COMPETENCE)
               REFERENCES COMPETENCE (ID))   ;

ALTER TABLE NIVEAU_EVAL ADD (
     CONSTRAINT FK_NIVEAU_EVAL_EVALUATION
          FOREIGN KEY (ID_EVALUATION)
               REFERENCES EVALUATION (ID))   ;

ALTER TABLE NIVEAU_EVAL ADD (
     CONSTRAINT FK_NIVEAU_EVAL_COMPETENCE
          FOREIGN KEY (ID_COMPETENCE)
               REFERENCES COMPETENCE (ID))   ;

ALTER TABLE INSCRIPTION ADD (
     CONSTRAINT FK_INSCRIPTION_EMPLOYE
          FOREIGN KEY (ID_EMPLOYE)
               REFERENCES EMPLOYE (ID))   ;

ALTER TABLE INSCRIPTION ADD (
     CONSTRAINT FK_INSCRIPTION_SESSIONS
          FOREIGN KEY (ID_SESSION)
               REFERENCES SESSIONS (ID))   ;

ALTER TABLE NIVEAU_FORM ADD (
     CONSTRAINT FK_NIVEAU_FORM_COMPETENCE
          FOREIGN KEY (ID_COMPETENCE)
               REFERENCES COMPETENCE (ID))   ;

ALTER TABLE NIVEAU_FORM ADD (
     CONSTRAINT FK_NIVEAU_FORM_FORMATION
          FOREIGN KEY (ID_FORMATION)
               REFERENCES FORMATION (ID))   ;

-- -----------------------------------------------------------------------------
--       CREATION DES SEQUENCES
-- -----------------------------------------------------------------------------	       
	 
DROP SEQUENCE "IRH"."SEQ_THEME" ;

DROP SEQUENCE "IRH"."SEQ_CATEGORIE" ;

DROP SEQUENCE "IRH"."SEQ_METIER" ;

DROP SEQUENCE "IRH"."SEQ_POSTE" ;

DROP SEQUENCE "IRH"."SEQ_EMPLOYE" ;

DROP SEQUENCE "IRH"."SEQ_DIPLOME" ;

DROP SEQUENCE "IRH"."SEQ_EMPLOI_PRECEDENT" ;

DROP SEQUENCE "IRH"."SEQ_UTILISATEUR" ;

DROP SEQUENCE "IRH"."SEQ_SESSIONS" ;

DROP SEQUENCE "IRH"."SEQ_FORMATION" ;

DROP SEQUENCE "IRH"."SEQ_ORGANISME" ;

DROP SEQUENCE "IRH"."SEQ_COMPETENCE" ;
	       

CREATE SEQUENCE "IRH"."SEQ_THEME" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_CATEGORIE" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_METIER" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_POSTE" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_EMPLOYE" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_DIPLOME" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_EMPLOI_PRECEDENT" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_UTILISATEUR" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_SESSIONS" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_FORMATION" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_ORGANISME" INCREMENT BY 1 START WITH 1 ;

CREATE SEQUENCE "IRH"."SEQ_COMPETENCE" INCREMENT BY 1 START WITH 1 ;

-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------

insert into "IRH"."DROIT" values(1, 'drh');
insert into "IRH"."DROIT" values(2, 'administration');
insert into "IRH"."DROIT" values(3, 'carrieres');
insert into "IRH"."DROIT" values(4, 'formations');

insert into "IRH"."UTILISATEUR" values(1, 1, 'Alex JARNOUX', 'ajarnoux', 'test');
insert into "IRH"."UTILISATEUR" values(2, 1, 'Francois COJEAN', 'fcojean', 'test');
insert into "IRH"."UTILISATEUR" values(3, 1, 'Leila TAMIM', 'ltamim', 'test');

insert into "IRH"."THEME" values(1, 'Agronomie');
insert into "IRH"."THEME" values(2, 'Finance');
insert into "IRH"."THEME" values(3, 'Informatique');

insert into "IRH"."CATEGORIE" values(1, 1, 'Industrie alimentaire');
insert into "IRH"."CATEGORIE" values(2, 1, 'Fertilisation des plantes');
insert into "IRH"."CATEGORIE" values(3, 2, 'Entreprise');
insert into "IRH"."CATEGORIE" values(4, 2, 'Marches');
insert into "IRH"."CATEGORIE" values(5, 3, 'Developpement');
insert into "IRH"."CATEGORIE" values(6, 3, 'Reseau');

insert into "IRH"."METIER" values(1, 2, 'Laborantin');
insert into "IRH"."METIER" values(2, 3, 'Comptable');
insert into "IRH"."METIER" values(3, 5, 'Architecte JEE');
insert into "IRH"."METIER" values(4, 6, 'Administrateur');

insert into "IRH"."CONTRAT" values(1, 'CDI');
insert into "IRH"."CONTRAT" values(2, 'CDD');
insert into "IRH"."CONTRAT" values(3, 'Stage');

insert into "IRH"."CIVILITE" values(1, 'Mr');
insert into "IRH"."CIVILITE" values(2, 'Mme');
insert into "IRH"."CIVILITE" values(3, 'Melle');

insert into "IRH"."COMPETENCE" values(1, 'Framework Spring');
insert into "IRH"."COMPETENCE" values(2, 'Java Entreprise Edition (JEE)');
insert into "IRH"."COMPETENCE" values(3, 'Gestion financiere');

insert into "IRH"."NIVEAU_ETUDE" values(1, 'bepc');
insert into "IRH"."NIVEAU_ETUDE" values(2, 'cap_bep');
insert into "IRH"."NIVEAU_ETUDE" values(3, 'bac');
insert into "IRH"."NIVEAU_ETUDE" values(4, 'bac_2');
insert into "IRH"."NIVEAU_ETUDE" values(5, 'bac_3');
insert into "IRH"."NIVEAU_ETUDE" values(6, 'bac_4');
insert into "IRH"."NIVEAU_ETUDE" values(7, 'bac_5');
insert into "IRH"."NIVEAU_ETUDE" values(8, 'bac_plus');

insert into "IRH"."SITUATION_FAMILIALE" values(1, 'Marie');
insert into "IRH"."SITUATION_FAMILIALE" values(2, 'Concubinage');
insert into "IRH"."SITUATION_FAMILIALE" values(3, 'Celibataire');

insert into "IRH"."POSTE" values(1, 2, 'Responsable Comptabilite', 0);
insert into "IRH"."POSTE" values(2, 1, 'Responsable Laboratoire d''agronomie', 1);
insert into "IRH"."POSTE" values(3, 3, 'Responsable Projet IRH', 1);

insert into "IRH"."EMPLOYE" values(1, 1, 3, 1, 'JARNOUX', 'Alex', '', '', '0674934995', '', '30/04/86', 'alex.jarnoux@gmail.com', '13 rue St Hermeland', '44200', 'Nantes', 'Personne tres agreable, beau physique!', null);

insert into "IRH"."ORGANISME" values(1, 'EPSI', '1 ecole, 6 site. Liens fort avec l''entreprise. Titre certifie au niveau 1 (Ingenieur). Encadrement et suivi des eleves. Remunerations elevees. Ouverture internationale.');