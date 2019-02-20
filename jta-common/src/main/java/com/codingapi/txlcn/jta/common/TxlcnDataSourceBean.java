package com.codingapi.txlcn.jta.common;

import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class TxlcnDataSourceBean implements DataSource {

    private XADataSource xaDataSource;

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(TxlcnDataSourceBean.class);

    public TxlcnDataSourceBean(XADataSource xaDataSource) {
        this.xaDataSource = xaDataSource;
        log.info("init ->{}",xaDataSource);
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection =  xaDataSource.getXAConnection().getConnection();
        log.info("getConnection->{}",connection);
        return connection;
    }

    @Override
    public Connection getConnection(String user, String password) throws SQLException {

        Connection connection =  xaDataSource.getXAConnection(user, password).getConnection();
        log.info("getConnection->{}",connection);
        return connection;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return xaDataSource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        xaDataSource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        xaDataSource.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return xaDataSource.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return xaDataSource.getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
