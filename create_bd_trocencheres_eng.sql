-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--
 
 
CREATE TABLE CATEGORIES (
    category_nb   INTEGER IDENTITY(1,1) NOT NULL,
    wording        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES ADD constraint category_pk PRIMARY KEY (category_nb)

CREATE TABLE AUCTION (
    user_nb   INTEGER NOT NULL,
    article_nb       INTEGER NOT NULL,
    auction_date     datetime NOT NULL,
	auction_amount  INTEGER NOT NULL

)

ALTER TABLE AUCTION ADD constraint auction_pk PRIMARY KEY (user_nb, article_nb)

CREATE TABLE WITHDRAWALS (
	article_nb         INTEGER NOT NULL,
    street              VARCHAR(30) NOT NULL,
    postal_code      VARCHAR(15) NOT NULL,
    city            VARCHAR(30) NOT NULL
)

ALTER TABLE WITHDRAWALS ADD constraint withdrawals_pk PRIMARY KEY  (article_nb)

CREATE TABLE USERS (
    user_nb   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    name              VARCHAR(30) NOT NULL,
    surname           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL,
    phone_nb        VARCHAR(15),
    street              VARCHAR(30) NOT NULL,
    postal_code      VARCHAR(10) NOT NULL,
    city            VARCHAR(30) NOT NULL,
    password     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrator   bit NOT NULL
)

ALTER TABLE USERS ADD constraint user_pk PRIMARY KEY (user_nb)


CREATE TABLE SOLD_ARTICLES (
    article_nb                    INTEGER IDENTITY(1,1) NOT NULL,
    article_name                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	auction_start_date           DATE NOT NULL,
    auction_end_date             DATE NOT NULL,
    initial_price                  INTEGER,
    sell_price                   INTEGER,
    user_nb               INTEGER NOT NULL,
    category_nb                 INTEGER NOT NULL
)

ALTER TABLE SOLD_ARTICLES ADD constraint sold_articles_pk PRIMARY KEY (article_nb)

ALTER TABLE SOLD_ARTICLES
    ADD CONSTRAINT auction_user_fk FOREIGN KEY ( user_nb ) REFERENCES USERS ( user_nb )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE AUCTION
    ADD CONSTRAINT auction_sold_articles_fk FOREIGN KEY ( article_nb )
        REFERENCES SOLD_ARTICLES ( article_nb )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE WITHDRAWALS
    ADD CONSTRAINT withdrawals_sold_articles_fk FOREIGN KEY ( article_nb )
        REFERENCES SOLD_ARTICLES ( article_nb )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE SOLD_ARTICLES
    ADD CONSTRAINT sold_articles_category_fk FOREIGN KEY ( category_nb )
        REFERENCES categories ( category_nb )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE SOLD_ARTICLES
    ADD CONSTRAINT user_sells_fk FOREIGN KEY ( user_nb )
        REFERENCES users ( user_nb )
ON DELETE NO ACTION 
    ON UPDATE no action 

