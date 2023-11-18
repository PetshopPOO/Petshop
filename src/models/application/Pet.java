package models.application;

public class Pet {
    private static int codigo = 0; 
    private String nome;
    private String especie;
    private char sexo;
    
    public Pet(String nome, String especie, char sexo) {
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        codigo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
}
