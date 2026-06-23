package model;

public class Tarefa {
    private String descricao;
    private boolean concluida;
    private boolean emAndamento;
    private String prioridade;
    
    public Tarefa(String descricao){
        this.descricao = descricao;
        this.concluida = false;
        this.emAndamento = false;
        this.prioridade = "Média"; 
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
    public boolean isEmAndamento(){
        return emAndamento;
    }
        
    public boolean isConcluida(){
        return concluida;
    }
    
    public void comecar(){
        this.emAndamento = true;
    }
    
    public void concluir(){
        this.concluida = true;
        this.emAndamento = false;
    }
    
    @Override
    public String toString() {
        String status;
        if (concluida) {
            status = "[X]";
        } else if (emAndamento) {
            status = "[~]";
        } else {
            status = "[]";
        }
        
        return status + " " + descricao + " (" + prioridade + ")";
    }
}
