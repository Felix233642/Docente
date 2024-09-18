/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docente;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felix
 */
public class persona {
    
    // Atributos
    private String nit;
    private String nombres;
    private String apellidos;
    private String direccion;
    String telefono;
    String fecha_Nacimiento;  // Usar el tipo Date para fechas

    // Constructor
    public persona() {}
    public persona(String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_Nacimiento) {
        this.nit = nit;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    // Getters y Setters
    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFecha_Nacimiento() { return fecha_Nacimiento; }
    public void setFecha_Nacimiento(String fecha_Nacimiento) { this.fecha_Nacimiento = fecha_Nacimiento; }

    // Métodos CRUD (Ejemplos vacíos, los puedes llenar con lógica de base de datos)


    protected DefaultTableModel leer(){ return null;}
    
    
    public void crear() {
        // Lógica para agregar una persona
    }

    public void actualizar() {
        // Lógica para actualizar una persona
    }

    public void borrar() {
        // Lógica para borrar una persona
    }
}

    

