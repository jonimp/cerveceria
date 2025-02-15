package prog2.cerveceria;

public class CervezaDTO implements java.io.Serializable {

    private String marca;
    private String color;
    private String foto;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    @Override
    public String toString() {
        return "CervezaDTO [marca=" + marca + ", color=" + color + ", foto=" + foto + "]";
    }
}
