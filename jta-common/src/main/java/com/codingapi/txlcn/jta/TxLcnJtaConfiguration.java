package com.codingapi.txlcn.jta;

import com.codingapi.txlcn.jta.common.TxLcnXADataSourceWrapper;
import com.codingapi.txlcn.jta.common.config.MyTransactionManager;
import com.codingapi.txlcn.jta.common.config.MyUserTransaction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.autoconfigure.transaction.jta.JtaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.XADataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

@Configuration
@EnableConfigurationProperties({JtaProperties.class })
@ConditionalOnClass({ JtaTransactionManager.class})
@ConditionalOnMissingBean(PlatformTransactionManager.class)
public class TxLcnJtaConfiguration {

    private final JtaProperties jtaProperties;

    private final TransactionManagerCustomizers transactionManagerCustomizers;


    public TxLcnJtaConfiguration(JtaProperties jtaProperties, TransactionManagerCustomizers transactionManagerCustomizers) {
        this.jtaProperties = jtaProperties;
        this.transactionManagerCustomizers = transactionManagerCustomizers;
    }


    @Bean
    @ConditionalOnMissingBean
    public MyTransactionManager myTransactionManager() throws Exception {
        MyTransactionManager manager = new MyTransactionManager();
        return manager;
    }

    @Bean
    @ConditionalOnMissingBean
    public MyUserTransaction myUserTransaction() throws Exception {
        MyUserTransaction manager = new MyUserTransaction();
        return manager;
    }

    @Bean
    @ConditionalOnMissingBean(XADataSourceWrapper.class)
    public TxLcnXADataSourceWrapper xaDataSourceWrapper() {
        return new TxLcnXADataSourceWrapper();
    }



    @Bean
    public JtaTransactionManager transactionManager(UserTransaction userTransaction,
                                                    TransactionManager transactionManager) {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager(
                userTransaction, transactionManager);
        if (this.transactionManagerCustomizers != null) {
            this.transactionManagerCustomizers.customize(jtaTransactionManager);
        }
        return jtaTransactionManager;
    }

}
