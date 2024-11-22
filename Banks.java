import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Enum para representar as categorias dos links
enum Categoria {
    ESTUDOS, RECEITAS, CURIOSIDADES, COMPRAS, LIVROS, ESPORTES, FILMES, SERIES, TECNOLOGIA
}

// Classe para armazenar informações de cada link
class Link {
    private String nome, url; // Nome e URL do link
    private Categoria categoria; // Categoria do link

    // Construtor da classe
    public Link(String nome, String url, Categoria categoria) {
        this.nome = nome;
        this.url = url;
        this.categoria = categoria;
    }

    // Getters para acessar as informações
    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Representação do objeto em formato de texto para salvar no arquivo
    @Override
    public String toString() {
        return nome + "|" + url + "|" + categoria;
    }

    // Método para criar um objeto Link a partir de uma linha de texto lida do arquivo
    public static Link fromString(String line) {
        String[] parts = line.split("\\|"); // Divide a linha pelo delimitador "|"
        return new Link(parts[0], parts[1], Categoria.valueOf(parts[2]));
    }
}

// Classe principal que implementa a interface gráfica
public class Banks extends JFrame {
    private final List<Link> links = new ArrayList<>(); // Lista de links armazenados
    private final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nome", "URL", "Categoria"}, 0); // Modelo para a tabela
    private final String FILE_NAME = "Banks.txt"; // Nome do arquivo onde os links serão salvos

    // Construtor principal da interface
    public Banks() {
        setTitle("Banks - Banco de Links Uteis"); // Título da janela
        setSize(800, 400); // Dimensões da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento de fechar o programa ao fechar a janela

        // Cria a tabela para exibir os links
        JTable tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER); // Adiciona a tabela com barra de rolagem ao centro da janela

        // Painel para os botões
        JPanel botoes = new JPanel();
        String[] acoes = {"Adicionar", "Editar", "Remover"}; // Ações disponíveis
        for (String acao : acoes) {
            JButton botao = new JButton(acao); // Cria um botão para cada ação
            botao.addActionListener(e -> realizarAcao(acao, tabela.getSelectedRow())); // Associa ação ao botão
            botoes.add(botao); // Adiciona o botão ao painel
        }
        add(botoes, BorderLayout.SOUTH); // Adiciona o painel de botões na parte inferior

        carregarLinks(); // Carrega os links do arquivo ao iniciar
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true); // Torna a janela visível
    }

    // Realiza a ação escolhida (Adicionar, Editar ou Remover)
    private void realizarAcao(String acao, int linhaSelecionada) {
        switch (acao) {
            case "Adicionar" -> adicionarLink();
            case "Editar" -> editarLink(linhaSelecionada);
            case "Remover" -> removerLink(linhaSelecionada);
        }
    }

    // Adiciona um novo link
    private void adicionarLink() {
        Link link = abrirFormulario(null); // Abre o formulário sem informações (novo link)
        if (link != null) {
            links.add(link); // Adiciona o link à lista
            atualizarTabela(); // Atualiza a tabela
            salvarLinks(); // Salva os links no arquivo
        }
    }

    // Edita um link selecionado
    private void editarLink(int linhaSelecionada) {
        if (linhaSelecionada >= 0) {
            Link linkAtual = links.get(linhaSelecionada); // Obtém o link da linha selecionada
            Link linkEditado = abrirFormulario(linkAtual); // Abre o formulário com as informações do link
            if (linkEditado != null) {
                links.set(linhaSelecionada, linkEditado); // Substitui o link na lista
                atualizarTabela(); // Atualiza a tabela
                salvarLinks(); // Salva os links no arquivo
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um link para editar."); // Mensagem de erro caso nenhuma linha esteja selecionada
        }
    }

    // Remove o link selecionado
    private void removerLink(int linhaSelecionada) {
        if (linhaSelecionada >= 0) {
            links.remove(linhaSelecionada); // Remove o link da lista
            atualizarTabela(); // Atualiza a tabela
            salvarLinks(); // Salva os links no arquivo
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um link para remover."); // Mensagem de erro caso nenhuma linha esteja selecionada
        }
    }

    // Abre o formulário para adicionar ou editar um link
    private Link abrirFormulario(Link link) {
        // Campos do formulário
        JTextField campoNome = new JTextField(link != null ? link.getNome() : "");
        JTextField campoUrl = new JTextField(link != null ? link.getUrl() : "");
        JComboBox<Categoria> comboCategoria = new JComboBox<>(Categoria.values());
        if (link != null) comboCategoria.setSelectedItem(link.getCategoria());

        // Exibe o formulário em um diálogo
        int option = JOptionPane.showConfirmDialog(
                this,
                new Object[]{"Nome:", campoNome, "URL:", campoUrl, "Categoria:", comboCategoria},
                link == null ? "Adicionar Link" : "Editar Link",
                JOptionPane.OK_CANCEL_OPTION
        );

        // Retorna o novo link se o usuário confirmou e preencheu os campos
        if (option == JOptionPane.OK_OPTION && !campoNome.getText().isEmpty() && !campoUrl.getText().isEmpty()) {
            return new Link(campoNome.getText().trim(), campoUrl.getText().trim(), (Categoria) comboCategoria.getSelectedItem());
        }
        return null; // Retorna null se o formulário foi cancelado
    }

    // Atualiza os dados da tabela
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Link link : links) {
            tableModel.addRow(new Object[]{link.getNome(), link.getUrl(), link.getCategoria()}); // Adiciona cada link à tabela
        }
    }

    // Salva os links no arquivo
    private void salvarLinks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Link link : links) writer.write(link + "\n"); // Escreve cada link no arquivo
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os links."); // Exibe erro em caso de falha
        }
    }

    // Carrega os links do arquivo
    private void carregarLinks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) links.add(Link.fromString(line)); // Adiciona cada link lido à lista
            atualizarTabela(); // Atualiza a tabela com os dados carregados
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado: Começa com lista vazia
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os links."); // Exibe erro em caso de falha
        }
    }

    // Método principal que inicia o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Banks::new); // Executa a interface gráfica
    }
}