package com.codingapi.txlcn.jta.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.*;
import javax.transaction.xa.XAResource;

public class MyTransaction implements Transaction {

    private static final Logger log = LoggerFactory.getLogger(MyTransaction.class);

    @Override
    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
        log.info("commit");
    }

    @Override
    public boolean delistResource(XAResource xaRes, int flag) throws IllegalStateException, SystemException {
        log.info("delistResource");
        return false;
    }

    @Override
    public boolean enlistResource(XAResource xaRes) throws RollbackException, IllegalStateException, SystemException {
        log.info("enlistResource");
        return false;
    }

    @Override
    public int getStatus() throws SystemException {
        log.info("getStatus");
        return Status.STATUS_NO_TRANSACTION;
    }

    @Override
    public void registerSynchronization(Synchronization sync) throws RollbackException, IllegalStateException, SystemException {
        log.info("registerSynchronization");
    }

    @Override
    public void rollback() throws IllegalStateException, SystemException {
        log.info("rollback");
    }

    @Override
    public void setRollbackOnly() throws IllegalStateException, SystemException {
        log.info("setRollbackOnly");
    }
}
