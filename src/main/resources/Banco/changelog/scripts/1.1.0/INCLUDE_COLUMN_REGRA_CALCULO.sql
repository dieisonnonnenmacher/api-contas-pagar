--liquibase formatted sql
--changeset dieison:2
alter table contas add column `regra_calculo` varchar(255);