/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.computacaoWeb.model.services.implementation;

import br.ufg.inf.es.computacaoWeb.model.Connection;
import br.ufg.inf.es.computacaoWeb.model.Contato;
import br.ufg.inf.es.computacaoWeb.model.services.AgendaService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Agenda implements AgendaService{

    @Override
    public List<Contato> ATodos(Connection connection) {
        return null;
    }

    @Override
    public void cadastrar(Contato contato, Connection connection) throws SQLException {
        String sql = "insert into contato (nome, telefone, email) values (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, contato.getNome());
        pstmt.setString(2, contato.getTelefone());
        pstmt.setString(3, contato.getEmail());
        pstmt.execute();
    }

    @Override
    public Contato atualizar(Contato contato, Connection connection) {
        return null;
    }

    @Override
    public void remover(Contato contato, Connection connection) {

    }
}
