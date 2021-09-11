INSERT INTO account (account_id, city, company_name, country, employee_count, industry_type) VALUES
('1', 'Yonkers', 'Eco Focus', 'US', '11', 'PRODUCE'),
('2', 'Lichfield', 'Innovation Arch', 'UK', '12', 'ECOMMERCE'),
('3', 'East Liverpool', 'Strat Security', 'US', '50', 'MANUFACTURING'),
('4', 'Warwick', 'Inspire Fitness Co', 'US', '14', 'MEDICAL'),
('5', 'Shanklin', 'Cogent Data', 'UK', '15', 'OTHER');

INSERT INTO contact (contact_id, company_name, email, name, phone_number) VALUES
('1', 'Eco Focus', 'hello@eco.com', 'Zsófika Kleid', '300852848'),
('2', 'Innovation Arch', 'office@innovation.com', 'Chrysanthos Acciaio', '442048531'),
('3', 'Strat Security', 'ceo@strat.com', 'Emma Heymans', '836344880'),
('4', 'Inspire Fitness Co', 'offer@inspire.com', 'Marthe Owen', '777478897'),
('5', 'Cogent Data', 'contact@cogent.com', 'Tenzing Bentsen', '167374623');

INSERT INTO sales_rep (sales_rep_id, name) VALUES
('1', 'Maia Rojas'),
('2', 'Kirby Winograd'),
('3', 'Jovanka Filep'),
('4', 'Guifré Ó Caoimh'),
('5', 'Dalia Chlebek');

INSERT INTO lead_contact (lead_id, company_name, email, name, phone_number, sales_rep_id) VALUES
('1', 'Eco Focus', 'hello@eco.com', 'Zsófika Kleid', '191296327', '1'),
('2', 'Innovation Arch', 'office@innovation.com', 'Chrysanthos Acciaio', '323537633', '2'),
('3', 'Strat Security', 'ceo@strat.com', 'Emma Heymans', '706125377', '3'),
('4', 'Inspire Fitness Co', 'offer@inspire.com', 'Marthe Owen', '322756757', '4'),
('5', 'Cogent Data', 'contact@cogent.com', 'Tenzing Bentsen', '706196470', '5');

INSERT INTO opportunity (opportunity_id, product_type, quantity, status, account_id, contact_id, sales_rep_id) VALUES
('1', 'HYBRID', '1', 'OPEN', '1', '1', '1'),
('2', 'FLATBED', '2', 'OPEN', '1', '2', '2'),
('3', 'BOX', '3', 'OPEN', '3', '2', '3'),
('4', 'HYBRID', '4', 'OPEN', '2', '4', '4'),
('5', 'FLATBED', '5', 'OPEN', '2', '5', '5');