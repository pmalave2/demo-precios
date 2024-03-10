INSERT INTO brand_entity (id, name) VALUES (1, 'ZARA');

INSERT INTO price_list_entity (id, price) VALUES (1, 2.0), (2, 2.3), (3, 3), (4, 3.5);

INSERT INTO prices_entity
  (id, brand_id, price, price_list_id, priority, product_id, end_date, start_date, currency)
VALUES
  ('7197e222-9f2d-4010-b6b0-5ffd1b089296', 1, 35.50, 1, 0, 35455, '2020-12-31 23:59:59', '2020-06-14 00:00:00', 'EUR'),
  ('ef89b5a1-c175-4270-bf7c-08f8241510ee', 1, 25.45, 2, 1, 35455, '2020-06-14 18:30:00', '2020-06-14 15:00:00', 'EUR'),
  ('ee3a5966-7863-445e-aafb-e7b80b6746eb', 1, 30.50, 3, 1, 35455, '2020-06-15 11:00:00', '2020-06-15 00:00:00', 'EUR'),
  ('17fba3e3-1d68-45ee-88c1-1068f57eada8', 1, 38.95, 4, 1, 35455, '2020-12-31 23:59:59', '2020-06-15 16:00:00', 'EUR');
