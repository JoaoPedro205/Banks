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
   - Categorização de links em cinco tipos: **Estudos**, **Receitas**, **Curiosidades**, **Compras**, **Livros**, **Esportes**, **Filmes**, **Series**, **Tecnologia**.

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
- **listas** Uso da classe `ArrayList` para armazenar os links em memória.

---

## **Divisão em Sprints**

### **Sprint 1: Estruturação e Persistência**
**Objetivo**: Criar a estrutura básica do projeto e implementar a funcionalidade de persistência de dados.  
**Tarefas**:
1. Criar a classe `Link` com atributos `nome`, `url` e `categoria`.
2. Implementar o método `toString` para formatar os links para persistência.
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
2. Atualizar automaticamente a tabela após cada operação.
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

## **Possíveis Melhorias Futuras**
- Adicionar um sistema de busca por nome ou categoria.
- Permitir reordenar a tabela com base nas colunas.
- Implementar suporte a outras categorias de links.
- Exportar os links para outros formatos, como CSV ou HTML.

---

## **Contribuidores**
- Desenvolvedor: **João Pedro da Costa Januário**
- RA: 158038-23
- Linguagem utilizada: **Java**
