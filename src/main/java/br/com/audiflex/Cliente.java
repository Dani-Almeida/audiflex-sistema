package br.com.audiflex;

public class Cliente {

    private String nome;
    private String telefone;
    private String email;
    private String cpfCnpj;

    
    public Cliente(String nome, String telefone, String email, String cpfCnpj){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCpfCnpj(){
        return this.cpfCnpj;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setCpfCnpj(String cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }
}
