package ucb.edu.bo.storebackend.mapping;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.Objects;
>>>>>>> 39bc52ecacf7860627ae3aab9872f9e945196e54

@Entity
@Table(name = "usuario", schema = "tienda_online", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
<<<<<<< HEAD
    @Column(name = "id_usuario")
    private int id_usuario;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "contraseña")
    private String contraseña;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "email")
    private String email;



    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
=======
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
    @Basic
    @Column(name = "nombre", nullable = true, length = 35)
    private String nombre;
    @Basic
    @Column(name = "contraseña", nullable = false, length = 40)
    private String contraseña;
    @Basic
    @Column(name = "apellido", nullable = true, length = 35)
    private String apellido;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
>>>>>>> 39bc52ecacf7860627ae3aab9872f9e945196e54
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
<<<<<<< HEAD
    public int hashCode() {
        return super.hashCode();
=======
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario && Objects.equals(nombre, that.nombre) && Objects.equals(contraseña, that.contraseña) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, contraseña, apellido, email);
>>>>>>> 39bc52ecacf7860627ae3aab9872f9e945196e54
    }
}
