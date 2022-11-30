
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultasinfo extends conexion{
    
    public boolean registrar(info pro){
        PreparedStatement ps = null; 
        Connection con = getConnection();
        
        String sql = "INSERT INTO info(codigo, nombre, celular, contraseña) VALUES(?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getCelular());
            ps.setString(4, pro.getNombre());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
    
    public boolean modificar(info pro){
        PreparedStatement ps = null; 
        Connection con = getconexion();
        
        String sql = "UPDATE info SET codigo=? nombre=?, celular=?, contraseña=? WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getCelular());
            ps.setString(4, pro.getNombre());
            ps.setInt(5, pro.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
   public boolean eliminar(info pro){
        PreparedStatement ps = null; 
        Connection con = getconexion();
        
        String sql = "DELETE FROM info WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
   
   public boolean buscar(info pro){
        PreparedStatement ps = null; 
        ResultSet rs = null;
        Connection con = getconexion();
        
        String sql = "SELECT * FROM info WHERE codigo=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setCelular(rs.getString("celular"));
                pro.setContraseña(rs.getString("contraseña")); 
                return true; 
            }
            
            
            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }

    private Connection getconexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   
