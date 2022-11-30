
package crud;

import Controlador.ctrlinfo;
import Modelo.consultasinfo;
import Modelo.info;
import Vista.frminfo;


public class CRUD {

    
    public static void main(String[] args) {
        info mod = new info();
        consultasinfo modC = new consultasinfo(); 
        frminfo frm = new frminfo();
        ctrlinfo ctrl = new ctrlinfo(mod, modC, frm); 
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
