package blogics;

import java.sql.*;

import java.sql.*;
import java.util.ArrayList;
import services.databaseservice.*;
import services.databaseservice.exception.DuplicatedRecordDBException;
import services.databaseservice.exception.NotFoundDBException;
import services.databaseservice.exception.ResultSetDBException;

public class User {
    public String Email;
    public String Nome;
    public String Cognome;

    public User( String Email, String Nome, String Cognome)
    {            
        this.Email=Email;
        this.Nome=Nome;
        this.Cognome=Cognome;
    }

    public User(ResultSet resultSet) 
    {           
        try {Email=resultSet.getString("Email");} catch (SQLException sqle) {}
        try {Nome=resultSet.getString("Nome");} catch (SQLException sqle) {}
        try {Cognome=resultSet.getString("Cognome");} catch (SQLException sqle) {}
    }
    
    public void insert(DataBase database)
        throws NotFoundDBException,DuplicatedRecordDBException,ResultSetDBException {

        String sql="";

        sql+=" INSERT INTO utente(Email,Nome,Cognome"
            +" VALUES ('"+Email+"','"+Nome+"','"+Cognome+"')";
        database.modify(sql);
    }
    
    public void delete(DataBase database) 
            throws NotFoundDBException ,ResultSetDBException 
    {
        String sql = "";
        sql+=   " DELETE FROM utente "+
                " WHERE Email='"+Email+"'";                
        
        database.modify(sql); 
    }
    
    public void update(DataBase database)
        throws NotFoundDBException,ResultSetDBException {
        
        String sql = "";
        sql +=  " UPDATE utente "+
                " SET Nome = '" + Nome + "',"+
                " Cognome = '" + Cognome +"'"+     
                " WHERE Email='"+Email+"'";        
        
        database.modify(sql);  
    }   
  
} 
 