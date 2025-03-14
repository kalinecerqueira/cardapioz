/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Conexao {
    public String porta="3306";
    public String nomServidor="localhost";
    public String db="bdprodutos";
    public String user="root";
    public String pass="";
    Connection conn=null;
    
    public Connection conectar(){
        try {
            String ruta="jdbc:mysql://";
            String servidor=nomServidor+":"+porta+"/";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ruta+servidor+db,user,pass);
            if(conn!=null){
                System.out.println("Conexão ao BD... Pronto!!!");
            }else if(conn==null){
                throw new SQLException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Seu produto ta errado. error: "+e.getMessage());
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, " Seu produto ta errado. error: "+e.getMessage());
        }finally{
            return conn;
        }
    }
        public void desconectar(){
        conn = null;
        System.out.println("Desconexion... listo!!!");
    }
}