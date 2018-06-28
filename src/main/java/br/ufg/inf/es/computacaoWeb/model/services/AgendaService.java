/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.computacaoWeb.model.services;
import br.ufg.inf.es.computacaoWeb.model.Connection;
import br.ufg.inf.es.computacaoWeb.model.Contato;

import java.sql.SQLException;
import java.util.List;

public interface AgendaService {

    List<Contato> ATodos(Connection connection);

    void cadastrar(Contato contato, Connection connection) throws SQLException;

    Contato atualizar(Contato contato, Connection connection);

    void remover(Contato contato, Connection connection);

}