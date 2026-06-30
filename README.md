# 📝 ToDoList - Gerenciador de Tarefas em Java

Bem-vindo ao **ToDoList**, uma aplicação desktop completa desenvolvida em Java Swing para gerenciamento de tarefas diárias. O projeto foi construído focando em uma arquitetura limpa, separando a interface gráfica da lógica de negócios, e implementando persistência de dados local de forma eficiente.

---

## 🚀 Funcionalidades

O aplicativo conta com um ecossistema completo para produtividade:

* **Gerenciamento CRUD:** Adicione, edite, liste e remova tarefas de forma intuitiva.
* **Estados da Tarefa:** Alterne o status de cada item entre *Pendente*, *Em Andamento* e *Concluída*.
* **Níveis de Prioridade:** Classifique suas urgências entre *Alta*, *Média* e *Baixa* prioridade.
* **Ordenação Customizada:** Organize sua lista visualmente movendo as tarefas para cima ou para baixo.
* **Filtros Inteligentes:** Visualize dinamicamente apenas o que importa através de uma caixa de seleção (ComboBox) filtrando por status.
* **Limpeza Rápida:** Botão para zerar a lista com caixa de diálogo para confirmação de segurança.
* **Persistência em Arquivo:** Todas as tarefas e configurações são salvas automaticamente em um arquivo local `.txt`, garantindo que os dados não se percam ao fechar o app.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 22
* **Interface Gráfica (GUI):** Java Swing & AWT
* **IDE:** NetBeans
* **Controle de Versão:** Git & GitHub

---

## 📁 Estrutura do Código Lógico

O projeto foi estruturado seguindo boas práticas de Orientação a Objetos:

* `Tarefa.java`: Classe que modela a entidade da tarefa, encapsulando dados como descrição, status e prioridade, além de tratar a formatação textual no método `toString()`.
* `GerenciadorTarefas.java`: O "motor" do app. Centraliza a lista na memória (`ArrayList`), manipula as operações de reordenação (`Collections.swap`) e gerencia a leitura/escrita do arquivo local usando `Scanner` e `PrintWriter` com tratamento de exceções.
* `TelaPrincipal.java`: Camada de apresentação visual que escuta os eventos do usuário e renderiza dinamicamente as informações filtradas.

---

## 🔧 Como Executar o Projeto

1. Clone este repositório em sua máquina local:
   ```bash
   git clone [https://github.com/dev-VanessaMachado/TodoList-Java.git](https://github.com/dev-VanessaMachado/TodoList-Java.git)


2. Abra o NetBeans (ou sua IDE Java de preferência).

3. Importe o projeto.

4. Execute a classe TelaPrincipal.java.

