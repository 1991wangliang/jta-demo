package com.codingapi.txlcn;

import org.springframework.boot.jdbc.XADataSourceWrapper;

import javax.sql.DataSource;
import javax.sql.XADataSource;

public class TxLcnXADataSourceWrapper implements XADataSourceWrapper {

    @Override
    public DataSource wrapDataSource(XADataSource dataSource) throws Exception {
        TxlcnDataSourceBean bean = new TxlcnDataSourceBean(dataSource);
        return bean;
    }
}
