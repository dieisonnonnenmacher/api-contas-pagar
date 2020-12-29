--liquibase formatted sql
--changeset dieison:1

DROP TABLE IF EXISTS `contas`;
CREATE TABLE  `contas` (
 id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 nome varchar(200) NOT NULL,
 valor_original double(10,2) NOT NULL,
 valor_corrigido double(10,2) NOT NULL,
 dias_atraso int(10) NOT NULL,
 data_pagamento date NOT NULL,
 data_vencimento date NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

--rollback drop table `product`;

