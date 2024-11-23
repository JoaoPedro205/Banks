# **Banks - Banco de Links Úteis**

## **Descrição Geral**
O Banks é um programa em Java que implementa um gerenciador de links úteis com interface gráfica utilizando a biblioteca **Swing**. Ele permite que o usuário armazene, edite, visualize e remova links categorizados de maneira organizada. Os links são persistidos em um arquivo de texto local (`Banks.txt`), garantindo que os dados sejam mantidos entre sessões.

---

## **Funcionalidades Principais**
1. **Gerenciamento de Links**:
   - Adicionar novos links, incluindo nome, URL e categoria.
   - Editar links existentes.
   - Remover links.

2. **Exibição e Organização**:
   - Exibir links em uma tabela com as colunas **Nome**, **URL** e **Categoria**.
   - Categorização de links em nove tipos: **Estudos**, **Receitas**, **Curiosidades**, **Compras**, **Livros**, **Esportes**, **Filmes**, **Series**, **Tecnologia**.

3. **Persistência de Dados**:
   - Salvar automaticamente os links em um arquivo (`Banks.txt`).
   - Carregar links automaticamente ao iniciar o programa.

4. **Interface Gráfica**:
   - Utiliza a biblioteca Swing para criar uma interface interativa e amigável.
   - Diálogos de entrada para adicionar ou editar links.

---

## **Tecnologias Utilizadas**
- **Java**: Linguagem de programação principal.
- **Swing**: Biblioteca para a interface gráfica.
- **I/O (Input/Output)**: Manipulação de arquivos para salvar e carregar os dados.
- **ArrayList**: Uso da classe `ArrayList` para armazenar os links em memória.

---

## **Divisão em Sprints**

### **Sprint 1: Estruturação e Persistência**
**Objetivo**: Criar a estrutura básica do projeto e implementar a funcionalidade de persistência de dados.  
**Tarefas**:
1. Criar a classe `Link` com atributos `nome`, `url` e `categoria`.
2. Implementar o método `toString` para formatar os links no arquivo texto.
3. Implementar `fromString` para reconstruir os objetos a partir do arquivo.
4. Criar métodos para salvar (`salvarLinks`) e carregar (`carregarLinks`) os dados em `Banks.txt`.

**Entrega**: 
- Código que lê e escreve links em um arquivo texto.

---

### **Sprint 2: Criação da Interface Gráfica**
**Objetivo**: Desenvolver a interface gráfica inicial para visualizar e interagir com os links.  
**Tarefas**:
1. Criar a classe `BancoDeLinks` extendendo `JFrame`.
2. Implementar uma tabela (`JTable`) com as colunas `Nome`, `URL` e `Categoria`.
3. Configurar layout utilizando `BorderLayout`.
4. Adicionar um painel para botões básicos: **Adicionar**, **Editar** e **Remover**.

**Entrega**:
- Interface gráfica básica com exibição de uma tabela de links.

---

### **Sprint 3: Implementação de CRUD**
**Objetivo**: Permitir adicionar, editar e remover links diretamente pela interface gráfica.  
**Tarefas**:
1. Criar o método `adicionarLink` para adicionar novos links.
2. Criar o método `editarLink` para atualizar links existentes.
3. Criar o método `removerLink` para excluir links.
4. Implementar o método `abrirFormulario` para exibir um formulário para entrada de dados do link.

**Entrega**:
- Funcionalidade completa de CRUD integrada à interface gráfica.

---

### **Sprint 4: Integração com Arquivo e Otimizações**
**Objetivo**: Garantir que os dados persistam entre sessões e melhorar a interface.  
**Tarefas**:
1. Integrar as operações de CRUD com os métodos de persistência (`salvarLinks` e `carregarLinks`).
2. Atualizar automaticamente a tabela e o arquivo texto após cada operação.
3. Tratar exceções relacionadas a arquivos e entradas inválidas do usuário.
4. Melhorar mensagens exibidas ao usuário (ex.: erros ou confirmações).

**Entrega**:
- CRUD funcional com persistência completa em `Banks.txt`.

---

### **Sprint 5: Refinamento Final**
**Objetivo**: Ajustar a interface, melhorar a usabilidade e documentar o projeto.  
**Tarefas**:
1. Centralizar a janela principal na tela do usuário.
2. Adicionar validação para evitar que os campos de nome ou URL fiquem vazios.
3. Atualizar este README com instruções detalhadas.
4. Realizar testes finais para garantir o correto funcionamento.

**Entrega**:
- Interface refinada e documentação completa do projeto.

---

# **Manual de Uso do Sistema Banks**

O sistema **Banks - Banco de Links Úteis** permite gerenciar links de forma organizada, categorizada e com persistência entre sessões. Este manual detalha como utilizar cada funcionalidade do sistema.

---

## **Funcionalidades Principais**

### **1. Adicionar um Link**
- Clique no botão **"Adicionar"**.
- Uma janela será exibida com os campos:
  - **Nome:** Título do link.
  - **URL:** Endereço do link.
  - **Categoria:** Selecione uma das categorias disponíveis no menu suspenso.
- Após preencher, clique em **"OK"**.
- O link será adicionado à tabela e salvo no arquivo.

---

### **2. Editar um Link**
- Selecione o link desejado na tabela clicando sobre ele.
- Clique no botão **"Editar"**.
- A janela de edição será aberta, permitindo alterar:
  - Nome, URL e/ou Categoria.
- Após fazer as alterações, clique em **"OK"**.
- O link será atualizado na tabela e no arquivo.

---

### **3. Remover um Link**
- Selecione o link desejado na tabela.
- Clique no botão **"Remover"**.
- O link será removido da tabela e do arquivo.

---

### **4. Salvar e Carregar Links**
- **Salvar:** Os links são salvos automaticamente após qualquer modificação. Não é necessário realizar nenhuma ação adicional.
- **Carregar:** Ao iniciar o programa, todos os links previamente salvos no arquivo `Banks.txt` serão exibidos automaticamente na tabela.

---

## **Categorias Disponíveis**
Os links podem ser organizados nas seguintes categorias:
1. **Estudos**
2. **Receitas**
3. **Curiosidades**
4. **Compras**
5. **Livros**
6. **Esportes**
7. **Filmes**
8. **Séries**
9. **Tecnologia**

---

## **Fechando o Programa**
- Feche a janela do programa normalmente.
- Todos os links na tabela serão automaticamente salvos no arquivo `Banks.txt`.

---

## **Contribuidores**
- Desenvolvedor: **João Pedro da Costa Januário**
- Linguagem utilizada: **Java**
