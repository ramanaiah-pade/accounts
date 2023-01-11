package com.ramana.accounts.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class AccountNumberGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Long prefix = 20000000l;
       try ( Connection connection = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection()){
           Statement statement=connection.createStatement();
           ResultSet rs=statement.executeQuery("select count(account_number) as accNo from account");
           if(rs.next())
           {
               Long id=rs.getLong(1) + 101;
               Long generatedId = prefix + new Long(id);
               return generatedId;
           }
       }catch (Exception e){
            throw new RuntimeException("Exception Occurred in AccountNumberGenerator class : \n" + e.getMessage());
       }
       return null;
    }
}
