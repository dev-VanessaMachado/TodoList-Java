package service;

import java.util.List;
import java.util.ArrayList;
import model.Tarefa;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;

public class GerenciadorTarefas {
    
    private List<Tarefa> tarefas;
    
    public GerenciadorTarefas(){
        tarefas = new ArrayList<>();
    }
    
    public int contarTotal(){
        return tarefas.size();
    }
    
    public int contarConcluidas(){
        int count = 0;
        
        for (Tarefa t: tarefas){
            if (t.isConcluida()){
                count++;
            }
        }
        return count;
    }
    
    public int contarEmAndamento(){
        int count = 0;
        
        for (Tarefa t : tarefas){
            if (t.isEmAndamento()){
                count++;
            }
        }
        return count;
    
    }
    public void adicionar(String descricao){
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
    }
    
    public void comecar(int indice){
        tarefas.get(indice).comecar();
    }
    
    public void concluir(int indice){
        tarefas.get(indice).concluir();
    }
    
    public void remover(int indice){
        if(indice >= 0 && indice < tarefas.size()){
            tarefas.remove(indice);
        }
    }
    
    public void editar(int indice, String novaDescricao) {
        if (indice >= 0 && indice < tarefas.size()){
            tarefas.get(indice).setDescricao(novaDescricao);
        }
    }
    
    public List<Tarefa> getTarefas(){
        return tarefas;
    }
    
    public void salvar() {
        try (PrintWriter writer = new PrintWriter("tarefas.txt")) {
            for (Tarefa t : tarefas) {
                String sufixo = " | " + t.getPrioridade();
                if (t.isConcluida()) {
                    writer.println("[X] " + t.getDescricao().trim() + sufixo);
                } else if (t.isEmAndamento()) {
                    writer.println("[~] " + t.getDescricao().trim() + sufixo);
                } else {
                    writer.println("[] " + t.getDescricao().trim() + sufixo);
                }
            }
            System.out.println("Arquivo salvo com prioridades!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
    
    public void carregar() {
        File arquivo = new File("tarefas.txt");

        if (!arquivo.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            tarefas.clear();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.isBlank()) continue;

                // 1. Separa a prioridade do resto da linha usando a barra '|'
                String prioridadeCarregada = "Média"; // Padrão caso não ache
                if (linha.contains("|")) {
                    String[] partes = linha.split("\\|");
                    linha = partes[0].trim(); // Guarda apenas a parte da tarefa (esquerda)
                    prioridadeCarregada = partes[1].trim(); // Guarda a prioridade (direita)
                }

                // 2. Agora decodifica o status e o nome normalmente
                if (linha.startsWith("[X]")) {
                    String descricao = linha.substring(3).trim();
                    Tarefa t = new Tarefa(descricao);
                    t.concluir(); 
                    t.setPrioridade(prioridadeCarregada); // <--- Define a prioridade certa
                    tarefas.add(t);
                } else if (linha.startsWith("[~]")) {
                    String descricao = linha.substring(3).trim();
                    Tarefa t = new Tarefa(descricao);
                    t.comecar(); 
                    t.setPrioridade(prioridadeCarregada); // <--- Define a prioridade certa
                    tarefas.add(t);
                } else if (linha.startsWith("[]")) {
                    String descricao = linha.substring(2).trim();
                    Tarefa t = new Tarefa(descricao);
                    t.setPrioridade(prioridadeCarregada); // <--- Define a prioridade certa
                    tarefas.add(t);
                } else {
                    Tarefa t = new Tarefa(linha.trim());
                    t.setPrioridade(prioridadeCarregada);
                    tarefas.add(t);
                }
            }
            System.out.println("Arquivo lido com prioridades!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
    }
    
    public void mudarPrioridade(int indice, String novaPrioridade) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).setPrioridade(novaPrioridade);
        }
    }
    
    public void limparTudo() {
        tarefas.clear(); // Esvazia a lista por completo
    }
}
