INSERT INTO ativos.tipo_ativo (id_tipo_ativo, txt_descricao) VALUES (1, 'Sensor de Barragem');
INSERT INTO ativos.tipo_ativo (id_tipo_ativo, txt_descricao) VALUES (2, 'Caminhão de Mineração');
INSERT INTO ativos.tipo_ativo (id_tipo_ativo, txt_descricao) VALUES (3, 'Perfuratriz');
INSERT INTO ativos.tipo_ativo (id_tipo_ativo, txt_descricao) VALUES (4, 'Escavadeira');
INSERT INTO ativos.tipo_ativo (id_tipo_ativo, txt_descricao) VALUES (5, 'Carregadeira');
INSERT INTO ativos.tipo_ativo (id_tipo_ativo, txt_descricao) VALUES (6, 'Barragem de Rejeitos');

INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (1, '2020-02-01', NULL, NULL, 'Medidor de Nível da Água 101', 'sensor1.jpg', 1, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (2, '2020-02-01', NULL, NULL, 'Medidor de Nível da Água 101', 'sensor1.jpg', 1, true);

INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (3, '2020-02-01', NULL, NULL, 'Piezômetro ABC', 'sensor1.jpg', 1, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (4, '2020-02-01', NULL, NULL, 'Piezômetro ABC', 'sensor1.jpg', 1, true);
	
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (5, '2020-02-01', NULL, NULL, 'Inclinômetro ABC', 'sensor1.jpg', 1, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (6, '2020-02-01', NULL, NULL, 'Inclinômetro ABC', 'sensor1.jpg', 1, true);

INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (7, '2020-02-01', NULL, NULL, 'Sensor de deslocamento ABC', 'sensor1.jpg', 1, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (8, '2020-02-01', NULL, NULL, 'Sensor de deslocamento ABC', 'sensor1.jpg', 1, true);

INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (9, '2020-04-01', '2020-05-01 09:00:00', NULL, 'Caminhão de Mineração Caterpillar 785D', 'caminhao1.jpg', 2, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (10, '2020-04-01', '2020-05-01 09:00:00', NULL, 'Caminhão de Mineração Caterpillar 789D', 'caminhao2.jpg', 2, true);
	
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (11, '2020-03-20', '2020-04-20 09:00:00', NULL, 'Escavadeira Grande Caterpillar 336 GC', 'escavadeira1.jpg', 4, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (12, '2020-02-20', '2020-04-20 09:00:00', '2020-03-20 09:00:00', 'Escavadeira Hidráulica de Mineração Caterpillar 6060 AC FS', 'escavadeira2.jpg', 4, true);

INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (13, '2018-02-20', '2020-02-20 08:00:00', '2020-08-20 08:00:00', 'Barragem de Rejeitos de Casa de Pedra', 'barragem1.jpg', 6, true);
INSERT INTO ativos.ativo (id_ativo, dta_aquisicao, dta_proxima_manutencao, dta_ultima_manutencao, txt_descricao, txt_nome_imagem, id_tipo_ativo, ind_em_funcionamento) VALUES (14, '2018-06-10', '2019-12-10 08:00:00', '2020-06-10 08:00:00', 'Barragem de Rejeitos B3 da Mina Mar Azul', 'barragem2.jpg', 6, true);
