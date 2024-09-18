package docente;

  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felix
 */

   public class docente extends persona {
    conexion cn;
    private String codigo, nit, salario, fecha_ingreso, fecha_registro;
    private int id;

    public docente() {}
    // Nuevo constructor que incluye el id
    public docente(int id, String codigo, String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento, String salario, String fecha_ingreso, String fecha_registro) {
        super(nit, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id;
        this.codigo = codigo;
        this.nit = nit;
        this.salario = salario;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_registro = fecha_registro;
    }

    // Getters y Setters
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getNit() {return nit;}
    public void setNit(String nit) {this.nit = nit;}

    public String getSalario() {return salario;}
    public void setSalario(String salario) {this.salario = salario;}

    public String getFecha_ingreso() {return fecha_ingreso;}
    public void setFecha_ingreso(String fecha_ingreso) {this.fecha_ingreso = fecha_ingreso;}

    public String getFecha_registro() {return fecha_registro;}
    public void setFecha_registro(String fecha_registro) {this.fecha_registro = fecha_registro;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    // Método para leer registros de la tabla docente
    public DefaultTableModel leer() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new conexion();
            cn.abrir_conexion();
            String query = "SELECT d.id_docente as id, d.codigo, d.nit, d.nombres, d.apellidos, d.direccion, d.telefono, d.fecha_nacimiento, d.salario, d.fecha_ingreso, d.fecha_registro FROM docente as d;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id", "Codigo", "NIT", "Nombres", "Apellidos", "Direccion", "Telefono", "Nacimiento", "Salario", "Ingreso", "Registro"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[11];
            while (consulta.next()) {
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("codigo");
                datos[2] = consulta.getString("nit");
                datos[3] = consulta.getString("nombres");
                datos[4] = consulta.getString("apellidos");
                datos[5] = consulta.getString("direccion");
                datos[6] = consulta.getString("telefono");
                datos[7] = consulta.getString("fecha_nacimiento");
                datos[8] = consulta.getString("salario");
                datos[9] = consulta.getString("fecha_ingreso");
                datos[10] = consulta.getString("fecha_registro");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return tabla;
    }

    // Método para agregar un registro
    public void agregar() {
        try {
            PreparedStatement parametro;
            cn = new conexion();
            cn.abrir_conexion();
            String query = "INSERT INTO docente (codigo, nit, nombres, apellidos, direccion, telefono, fecha_nacimiento, salario, fecha_ingreso, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setString(2, getNit());
            parametro.setString(3, getNombres());
            parametro.setString(4, getApellidos());
            parametro.setString(5, getDireccion());
            parametro.setString(6, getTelefono());
            parametro.setString(7, getFecha_Nacimiento());
            parametro.setString(8, getSalario());
            parametro.setString(9, getFecha_ingreso());
            parametro.setString(10, getFecha_registro());
            int executar = parametro.executeUpdate();
            System.out.println(" Se insertó: " + Integer.toString(executar) + " registro(s)");
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Método para actualizar un registro
    public void actualizar() {
        try {
            PreparedStatement parametro;
            cn = new conexion();
            cn.abrir_conexion();
            String query = "UPDATE docente SET codigo=?, nit=?, nombres=?, apellidos=?, direccion=?, telefono=?, fecha_nacimiento=?, salario=?, fecha_ingreso=?, fecha_registro=? WHERE id_docente = ?;";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setString(2, getNit());
            parametro.setString(3, getNombres());
            parametro.setString(4, getApellidos());
            parametro.setString(5, getDireccion());
            parametro.setString(6, getTelefono());
            parametro.setString(7, getFecha_Nacimiento());
            parametro.setString(8, getSalario());
            parametro.setString(9, getFecha_ingreso());
            parametro.setString(10, getFecha_registro());
            parametro.setInt(11, getId());
            int executar = parametro.executeUpdate();
            System.out.println(" Se actualizó: " + Integer.toString(executar) + " registro(s)");
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Método para eliminar un registro
    public void borrar() {
        try {
            PreparedStatement parametro;
            cn = new conexion();
            cn.abrir_conexion();
            String query = "DELETE FROM docente WHERE id_docente = ?;";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            int executar = parametro.executeUpdate();
            System.out.println(" Se eliminó: " + Integer.toString(executar) + " registro(s)");
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
