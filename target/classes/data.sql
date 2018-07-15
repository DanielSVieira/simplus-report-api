--company data 
insert into company(id, name) values (1, 'Empresa de Produtos Para Banho');
insert into company(id, name) values (2, 'Empresa de Produtos Higiênicos');

--product data
insert into product(id, gtin, description, last_update, company_id)
            values(1, '7891000200001', 'Sabonete', '2018-06-01', 1);
insert into product(id, gtin, description, last_update, company_id)
			values(2, '7891000200002', 'Shampoo', '2018-05-01', 1);
insert into product(id, gtin, description, last_update, company_id)
			values(3, '78910002000021', 'Caixa Shampoo', '2018-05-02', 1);
insert into product(id, gtin, description, last_update, company_id)
			values(4, '78910002000011', 'Caixa Sabonete', '2018-05-03', 1);
insert into product(id, gtin, description, last_update, company_id)
			values(5, '7891000200003', 'Escova de dente', '2018-05-01', 2);
insert into product(id, gtin, description, last_update, company_id)
			values(6, '78910002000031', 'Caixa Escova', '2018-05-02', 2);