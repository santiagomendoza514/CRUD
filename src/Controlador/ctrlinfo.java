
package Controlador;

import Modelo.consultasinfo;
import Modelo.info;
import Vista.frminfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlinfo implements ActionListener{
    private info mod;
    private consultasinfo modC;
    private frminfo frm; 
    
    public ctrlinfo (info mod, consultasinfo modC, frminfo frm){
    this.mod = mod;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnguardar.addActionListener(this);
    this.frm.btnmodificar.addActionListener(this);
    this.frm.btneliminar.addActionListener(this);
    this.frm.btnlimpiar.addActionListener(this);
    this.frm.btnbuscar.addActionListener(this);
}
    
    
    public void iniciar(){
    frm.setTitle("ADMIN_LOG"); 
    frm.setLocationRelativeTo(null);
    frm.txtid.setVisible(false);
}
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frm.btnguardar){
            mod.setCodigo(frm.txtcodigo.getText());
            mod.setNombre(frm.txtnombre.getText());
            mod.setCelular(frm.txtcelular.getText());
            mod.setContraseña(frm.txtcontraseña.getText());
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Resgistro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnmodificar){
            mod.setId(Integer.parseInt(frm.txtid.getText()));
            mod.setCodigo(frm.txtcodigo.getText());
            mod.setNombre(frm.txtnombre.getText());
            mod.setCelular(frm.txtcelular.getText());
            mod.setContraseña(frm.txtcontraseña.getText());
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Resgistro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btneliminar){
            mod.setId(Integer.parseInt(frm.txtid.getText()));
           
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Resgistro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Elimibar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnbuscar){
            mod.setCodigo(frm.txtcodigo.getText());
           
            if(modC.buscar(mod)){
                frm.txtid.setText(String.valueOf(mod.getId()));
                frm.txtcodigo.setText(mod.getCodigo());
                frm.txtnombre.setText(mod.getNombre());
                frm.txtcelular.setText(mod.getCelular());
                frm.txtcontraseña.setText(mod.getContraseña());
               
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el Registro");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnlimpiar){
                limpiar();
        }
    }
    
    
    public void limpiar(){
    frm.txtid.setText(null);
    frm.txtcodigo.setText(null);
    frm.txtnombre.setText(null);
    frm.txtcelular.setText(null);
    frm.txtcontraseña.setText(null);
}
    
}
