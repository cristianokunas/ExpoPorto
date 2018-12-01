package kunas.app.expoporto.model;


public class Programacao {

    private int id;
    private int favorito;
    private String titulo;
    private String descricao;
    private Long data;
    private String hora;

    public Programacao(String titulo, String descricao, String hora, Long data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.hora = hora;
        this.data = data;
    }

    public Programacao(int id, int favorito, String titulo, String descricao, Long data) {
        this.id = id;
        this.favorito = favorito;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }
}
