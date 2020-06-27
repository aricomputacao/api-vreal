/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ari
 * Created: 21/06/2020
 */

--   create table public.empresa (
--        id int8 not null,
--         cnpj varchar(255) not null,
--         data_atualizacao timestamp not null,
--         data_criacao timestamp not null,
--         razao_social varchar(255) not null,
--         primary key (id)
--     )
-- create table public.funcionario (
--        id int8 not null,
--         cpf varchar(255) not null,
--         data_atualizacao timestamp not null,
--         data_criacao timestamp not null,
--         email varchar(255) not null,
--         nome varchar(255) not null,
--         perfil varchar(255) not null,
--         qtd_horas_almoco float4,
--         qtd_horas_trabalho_dia float4,
--         senha varchar(255) not null,
--         valor_hora numeric(19, 2),
--         empresa_id int8,
--         primary key (id)
--     )
-- create table public.lancamento (
--        id int8 not null,
--         data timestamp not null,
--         data_atualizacao timestamp not null,
--         data_criacao timestamp not null,
--         descricao varchar(255),
--         localizacao varchar(255),
--         tipo varchar(255) not null,
--         funcionario_id int8,
--         primary key (id)
--     )
-- 
--  
--     alter table if exists public.funcionario 
--        add constraint FK4cm1kg523jlopyexjbmi6y54j 
--        foreign key (empresa_id) 
--        references public.empresa;
-- 
--  alter table if exists public.lancamento 
--        add constraint FK46i4k5vl8wah7feutye9kbpi4 
--        foreign key (funcionario_id) 
--        references public.funcionario;