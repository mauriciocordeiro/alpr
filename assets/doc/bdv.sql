
CREATE TABLE BDV_PROPRIETARIO
(
	cd_proprietario       INTEGER  NOT NULL ,
	cd_veiculo            INTEGER  NOT NULL ,
	nm_proprietario       VARCHAR(64)  NULL ,
	nr_cpf                VARCHAR(11)  NULL ,
	nr_cnh                VARCHAR(32)  NULL ,
	sg_uf_cnh             VARCHAR(2)  NULL ,
	dt_inicial            TIMESTAMP WITHOUT TIME ZONE  NULL ,
	dt_final              TIMESTAMP WITHOUT TIME ZONE  NULL ,
	st_proprietario       SMALLINT  NULL ,
	tp_proprietario       SMALLINT  NULL 
);



CREATE UNIQUE INDEX XPKBDV_PROPRIETARIO ON BDV_PROPRIETARIO
(cd_proprietario,cd_veiculo);



ALTER TABLE BDV_PROPRIETARIO
	ADD  PRIMARY KEY (cd_proprietario,cd_veiculo);



CREATE TABLE BDV_RESTRICAO
(
	cd_restricao          INTEGER  NOT NULL ,
	cd_veiculo            INTEGER  NOT NULL ,
	txt_restricao         TEXT  NULL ,
	tp_restricao          SMALLINT  NULL ,
	st_restricao          SMALLINT  NULL ,
	dt_restricao          TIMESTAMP WITHOUT TIME ZONE  NULL 
);



CREATE UNIQUE INDEX XPKBDV_RESTRICAO ON BDV_RESTRICAO
(cd_restricao,cd_veiculo);



ALTER TABLE BDV_RESTRICAO
	ADD  PRIMARY KEY (cd_restricao,cd_veiculo);



CREATE TABLE BDV_VEICULO
(
	cd_veiculo            INTEGER  NOT NULL ,
	nr_placa              VARCHAR(7)  NULL ,
	nr_renavan            VARCHAR(11)  NULL ,
	tp_veiculo            SMALLINT  NULL ,
	tp_carroceria         SMALLINT  NULL ,
	nr_ano_modelo         INTEGER  NULL ,
	nr_ano_fabricacao     INTEGER  NULL ,
	nr_codigo_municipio   INTEGER  NULL ,
	nm_municipio          VARCHAR(64)  NULL ,
	sg_estado             VARCHAR(2)  NULL ,
	nr_codigo_marca       INTEGER  NULL ,
	nm_marca_modelo       VARCHAR(128)  NULL ,
	nr_codigo_cor         INTEGER  NULL ,
	nm_cor                VARCHAR(32)  NULL ,
	nr_codigo_especie     INTEGER  NULL ,
	nm_especie            VARCHAR(32)  NULL ,
	nr_codigo_tipo        INTEGER  NULL ,
	nm_categoria          VARCHAR(64)  NULL ,
	dt_informacao         TIMESTAMP WITHOUT TIME ZONE  NULL 
);



CREATE UNIQUE INDEX XPKBDV_VEICULO ON BDV_VEICULO
(cd_veiculo);



ALTER TABLE BDV_VEICULO
	ADD  PRIMARY KEY (cd_veiculo);



ALTER TABLE BDV_PROPRIETARIO
	ADD  FOREIGN KEY (cd_veiculo) REFERENCES BDV_VEICULO(cd_veiculo);



ALTER TABLE BDV_RESTRICAO
	ADD  FOREIGN KEY (cd_veiculo) REFERENCES BDV_VEICULO(cd_veiculo);


