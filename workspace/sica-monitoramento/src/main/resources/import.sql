INSERT INTO monitoramento.classificacao_barragem (cod_classificacao, txt_descricao) VALUES ('A', 'Apresenta categoria de risco e dano potencial altos e cujas anomalias necessitam intervenção de curto prazo para manutenção das condições de segurança.');
INSERT INTO monitoramento.classificacao_barragem (cod_classificacao, txt_descricao) VALUES ('B', 'Apresenta categoria de risco ou dano potencial altos e cujas anomalias, se presentes, devem ser controladas, monitoradas e as intervenções podem ser implementadas ao longo do tempo para manutenção das condições de segurança.');
INSERT INTO monitoramento.classificacao_barragem (cod_classificacao, txt_descricao) VALUES ('C', 'Apresenta categoria de risco e dano potencial médio ou baixo e não apresenta anomalias e as existentes não comprometem a segurança.');

INSERT INTO monitoramento.nivel_emergencia (num_nivel,txt_descricao) VALUES (0,'Sem anomalias detectadas.');
INSERT INTO monitoramento.nivel_emergencia (num_nivel,txt_descricao) VALUES (1,'Quando detectada anomalia que resulte na pontuação máxima quanto ao estado de conservação ou para qualquer outra situação com potencial comprometimento de segurança da estrutura, que demanda inspeções especiais (diárias).');
INSERT INTO monitoramento.nivel_emergencia (num_nivel,txt_descricao) VALUES (2,'Quando o resultado das ações adotadas na anomalia referida do nível 1 for classificada como “não controlada” ou “não extinta”, necessitando de novas inspeções especiais e intervenções.');
INSERT INTO monitoramento.nivel_emergencia (num_nivel,txt_descricao) VALUES (3,'Situação de ruptura iminente ou está ocorrendo.');

INSERT INTO monitoramento.barragem (id_barragem,num_altura_macico,num_capacidade_total,id_ativo,txt_nome,num_volume,num_nivel_emergencia) VALUES (1,76,50000000,10,'Barragem de Rejeitos de Casa de Pedra',30000000,0);
INSERT INTO monitoramento.barragem (id_barragem,num_altura_macico,num_capacidade_total,id_ativo,txt_nome,num_volume,num_nivel_emergencia) VALUES (2,55,5000000,11,'Barragem de Rejeitos B3 da Mina Mar Azul',3000000,2);

INSERT INTO monitoramento.tipo_sensor (id_tipo_sensor,txt_descricao) VALUES (1,'Medidor de nível d''água');
INSERT INTO monitoramento.tipo_sensor (id_tipo_sensor,txt_descricao) VALUES (2,'Piezômetro');
INSERT INTO monitoramento.tipo_sensor (id_tipo_sensor,txt_descricao) VALUES (3,'Inclinômetro');
INSERT INTO monitoramento.tipo_sensor (id_tipo_sensor,txt_descricao) VALUES (4,'Sensor de deslocamento');

INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (1,1,'nvla01a',1,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (2,null,'nvla01b',1,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (3,2,'nvla02a',1,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (4,null,'nvla02b',1,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (5,3,'pres01a',2,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (6,null,'pres01b',2,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (7,4,'pres02a',2,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (8,null,'pres02b',2,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (9,5,'incl01a',3,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (10,null,'incl01b',3,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (11,6,'incl02a',3,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (12,null,'incl02b',3,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (13,7,'desl01a',4,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (14,null,'desl01b',4,1);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (15,8,'desl02a',4,2);
INSERT INTO monitoramento.sensor (id_sensor,id_ativo,txt_id_hardware,id_tipo_sensor,id_barragem) VALUES (16,null,'desl02b',4,2);
