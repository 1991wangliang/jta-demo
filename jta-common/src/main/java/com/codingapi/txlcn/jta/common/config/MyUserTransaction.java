package com.codingapi.txlcn.jta.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.transaction.*;
import java.io.Serializable;

public class MyUserTransaction implements  Serializable, Referenceable, UserTransaction {

    private final static Logger log = LoggerFactory.getLogger(MyUserTransaction.class);

    public MyUserTransaction() {
        log.info("MyUserTransaction");
    }

    @Override
    public Reference getReference() throws NamingException {
        log.info("getReference");
        return null;
    }

    @Override
    public void begin() throws NotSupportedException, SystemException {
        log.info("begin");
    }

    @Override
    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
        log.info("commit");
    }

    @Override
    public int getStatus() throws SystemException {
        log.info("getStatus");
        return 0;
    }


    @Override
    public void rollback() throws IllegalStateException, SecurityException, SystemException {
        log.info("rollback");
    }

    @Override
    public void setRollbackOnly() throws IllegalStateException, SystemException {
        log.info("setRollbackOnly");
    }

    @Override
    public void setTransactionTimeout(int i) throws SystemException {
        log.info("setTransactionTimeout");
    }


}
