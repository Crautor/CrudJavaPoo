package model.entities;

public class Funcionario {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Integer numeroRegistro;
    private String Turno;
    private String CPF;

    public Funcionario(){

    }
    public Funcionario(Integer id, String nome, Integer numeroRegistro, String turno, String CPF) {
        this.id = id;
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
        Turno = turno;
        this.CPF = CPF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String turno) {
        Turno = turno;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroRegistro=" + numeroRegistro +
                ", Turno='" + Turno + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }


}
