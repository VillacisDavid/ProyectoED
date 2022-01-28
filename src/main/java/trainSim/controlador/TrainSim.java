
package trainSim.controlador;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.ImageIcon;

//importar modulo actual
import trainSim.modelo.*;
import trainSim.vista.*;



/**
 *
 * @author David
 */
public class TrainSim {
    
    private Grafo g = new Grafo();
    private SeleccionRuta seleccionar;
    private CrearRuta crear;
    stackEstaciones stack = new stackEstaciones();
    
    
    public TrainSim() throws IOException{
        
            
    }
    
    
    public void initSeleccionRuta(){
        seleccionar = new SeleccionRuta();
        seleccionar.setLocationRelativeTo(null);
        seleccionar.setVisible(true);
        seleccionar.setAlwaysOnTop(true);
        /*
        *   Label: imagen del mapa del grafo
        */
        seleccionar.lblMapa.setIcon(new ImageIcon("recursos\\mapaGrafo.png"));
        
        /*
        *   Llenar combo box
        */
        for(EstacionTren estacion: g.getEstaciones()){
           seleccionar.cbxOrigen.addItem(estacion.getName());
           seleccionar.cbxDestino.addItem(estacion.getName());
        }        
        /*
        *   Accion del boton Obtener ruta
        */
        seleccionar.btnObtenerRuta.addActionListener((ActionEvent e) -> {
            //  To do: obtener origen y destino de los combo box
            
            final String origen = (String)seleccionar.cbxOrigen.getSelectedItem();
            final String destino = (String)seleccionar.cbxDestino.getSelectedItem();
            
            // Obtener lista
            stack = g.dijkstra(origen, destino);
            Integer distancia = g.getPesos()[g.getIndexOf(origen)][g.getIndexOf(destino)];
            seleccionar.txtRuta.setText(stack.mostrar()+distancia.toString());
            seleccionar.txtRuta.setEditable(false);
            
        });
        
    }
    
    public void initCrearRuta() {
        crear = new CrearRuta();
        stackEstaciones stack = new stackEstaciones();
        crear.setLocationRelativeTo(null);
        crear.setVisible(true);
        crear.setAlwaysOnTop(true);
        
        
        /*
        *   Label: imagen del mapa del grafo
        */
        crear.lblMapa.setIcon(new ImageIcon("recursos\\mapaGrafo.png"));
        
        /*
        *   Llenar combo box
        */
        for(EstacionTren estacion: g.getEstaciones()){
            crear.cbxParadas.addItem(estacion.getName());
        }
        
        /*
        *   Accion del boton Agregar parada
        */
        crear.btnAgregarEstacion.addActionListener((ActionEvent e) -> {
            Integer itemindex = g.getIndexOf((String)crear.cbxParadas.getSelectedItem());
            stack.push(g.getEstaciones().get(itemindex));
            
            // Vaciar combobox
            crear.cbxParadas.removeAllItems();
            //rellenarlo con posibles paradas
            for(int i=0; i < g.getSize();i++){
                if(g.getRelaciones()[itemindex][i]==1){
                    crear.cbxParadas.addItem(g.getEstaciones().get(i).getName());
                }
            }
            //mostrar en el area de texto
            crear.jTextArea1.setText(stack.mostrar());
            
        });
        
        /*
        *   Accion del boton deshacer
        */
        crear.btnDeshacer.addActionListener((ActionEvent e) -> {
            stack.popDelete();
            if(stack.getLongitud()>1){
                int index = g.getIndexOf(stack.top().getName());
                // Vaciar combobox
                crear.cbxParadas.removeAllItems();
                //rellenarlo con posibles paradas

                for(int i=0; i < g.getSize();i++){
                    if(g.getRelaciones()[index][i]==1){
                        crear.cbxParadas.addItem(g.getEstaciones().get(i).getName());
                    }
                }
                //mostrar en el area de texto
                crear.jTextArea1.setText(stack.mostrar());
            }else{
                // Vaciar combobox
                crear.cbxParadas.removeAllItems();
                //rellenar con todas las estaciones
                for(EstacionTren estacion: g.getEstaciones()){
                    crear.cbxParadas.addItem(estacion.getName());
                }
                //mostrar en el area de texto
                crear.jTextArea1.setText(stack.mostrar());
            }
            
        });
        
    }
    
    
    public int getGraphSize(){
        return g.getSize();
    }
    
    /*
    *   @return String con informacion del grafo
    */
    
    public String getStringGrafo(){
        return g.toString();
    }

    /**
     * @return the g
     */
    public Grafo getG() {
        return g;
    }

    /**
     * @return the SeleccionRuta
     */
    public SeleccionRuta getSeleccionar() {
        return seleccionar;
    }

    /**
     * @return the crear
     */
    public CrearRuta getCrear() {
        return crear;
    }
    
}
