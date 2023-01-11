package com.ramana.accounts.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class CustomerIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        int prefix = LocalDate.EPOCH.getYear();
       try ( Connection connection = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection()){
           Statement statement=connection.createStatement();
           ResultSet rs=statement.executeQuery("select count(account_number) as accNo from account");
           if(rs.next())
           {
               int id=rs.getInt(1) + 101;
               Integer generatedId = prefix + new Integer(id);
               return generatedId;
           }
       }catch (Exception e){
            throw new RuntimeException("Exception Occurred in AccountNumberGenerator class : \n" + e.getMessage());
       }
       return null;
    }
}
