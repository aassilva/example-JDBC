/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.computacaoWeb.model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private String url;
    private String user;
    private String password;
    private Connection connection;

    public Connection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
       return (Connection) DriverManager.getConnection(url, user, password);
    }
}
