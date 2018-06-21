/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.computacaoWeb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/agenta/pessoa")
public class AgendaController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        op = (op == null ? "" : op);

        AgendaModel agenda = new AgendaModel();
        agenda.setNome(request.getParameter("nome"));
        agenda.setTelefone(request.getParameter("telefone"));
        String idString = request.getParameter("id");
        idString = (idString == null ? "0" : idString);
        agenda.setId(Integer.parseInt(idString));

        List<AgendaModel> contatos = null;
        try {
            if (op.equals("incluir")) {
                agenda.incluir();
            } else if (op.equals("salvar")) {
                agenda.salvar();
            } else if (op.equals("excluir")) {
                agenda.excluir();
            }

            agenda = AgendaModel.listar();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Adiciona a variável na requisição para o JSP trabalhar.
        request.setAttribute("agenda", agenda);

        //Redireciona requisição para o JSP.
        request.
                getRequestDispatcher("/venda-mvc/venda-view.jsp").
                forward(request, response);
    }
}
