INSERT INTO seguranca.nivel_emergencia (num_nivel,txt_descricao) VALUES (0,'Sem anomalias detectadas.');
INSERT INTO seguranca.nivel_emergencia (num_nivel,txt_descricao) VALUES (1,'Quando detectada anomalia que resulte na pontuação máxima quanto ao estado de conservação ou para qualquer outra situação com potencial comprometimento de segurança da estrutura, que demanda inspeções especiais (diárias).');
INSERT INTO seguranca.nivel_emergencia (num_nivel,txt_descricao) VALUES (2,'Quando o resultado das ações adotadas na anomalia referida do nível 1 for classificada como “não controlada” ou “não extinta”, necessitando de novas inspeções especiais e intervenções.');
INSERT INTO seguranca.nivel_emergencia (num_nivel,txt_descricao) VALUES (3,'Situação de ruptura iminente ou está ocorrendo.');

INSERT INTO seguranca.barragem (id_barragem,id_ativo,txt_nome,num_nivel_emergencia,DTA_ULTIMA_ATUALIZACAO) VALUES (1,10,'Barragem de Rejeitos de Casa de Pedra',0,'2020-04-15 15:00:00');
INSERT INTO seguranca.barragem (id_barragem,id_ativo,txt_nome,num_nivel_emergencia,DTA_ULTIMA_ATUALIZACAO) VALUES (2,11,'Barragem de Rejeitos B3 da Mina Mar Azul',2,'2020-04-15 15:00:00');

INSERT INTO seguranca.procedimento_seguranca (id_procedimento,txt_descricao,txt_nome_procedimento) VALUES (1,null,'Comunicar equipe de segurança');
INSERT INTO seguranca.procedimento_seguranca (id_procedimento,txt_descricao,txt_nome_procedimento) VALUES (2,'Acionar sirenes de evacuação da Zona de Autossalvamento (ZAS)','Sirenes - ZAS');
INSERT INTO seguranca.procedimento_seguranca (id_procedimento,txt_descricao,txt_nome_procedimento) VALUES (3,'Acionar sirenes de evacuação de toda a área - Zona de Autossalvamento (ZAS) e Zona de Segurança Secundária (ZSS)','Sirenes - Todas');
INSERT INTO seguranca.procedimento_seguranca (id_procedimento,txt_descricao,txt_nome_procedimento) VALUES (4,'Comunicar a diretoria da empresa sobre a situação da barragem','Comunicar diretoria');

INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (1, 1);
INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (2, 1);
INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (2, 2);
INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (3, 1);
INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (3, 2);
INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (3, 3);
INSERT INTO seguranca.procedimento_nivel_emergencia (num_nivel_emergencia, id_procedimento) VALUES (3, 4);
