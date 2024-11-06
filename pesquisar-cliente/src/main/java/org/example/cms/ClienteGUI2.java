package org.example.cms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ClienteGUI2 extends JFrame {
    private JTable table;
    JTextField textField;
    private DefaultTableModel tableModel;
    private BufferDeClientes bufferDeClientes;
    private final int TAMANHO_BUFFER = 10000;
    private int registrosCarregados = 0; // Contador de registros já carregados
    private String arquivoSelecionado;
    private boolean arquivoCarregado = false; // Para verificar se o arquivo foi carregado

    public ClienteGUI2() {
        setTitle("Gerenciamento de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        bufferDeClientes = new BufferDeClientes();
        criarInterface();
    }

    private void carregarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivoSelecionado = fileChooser.getSelectedFile().getAbsolutePath();
            bufferDeClientes.associaBuffer(new ArquivoCliente()); // Substitua por sua implementação
            bufferDeClientes.inicializaBuffer("leitura", arquivoSelecionado); // Passa o nome do arquivo aqui
            tableModel.setRowCount(0); // Limpa a tabela
            carregarMaisClientes(); // Carrega os primeiros clientes
            arquivoCarregado = true; // Marca que o arquivo foi carregado
        }
    }

    private void criarInterface() {
        JPanel panel = new JPanel(new BorderLayout());
        JButton btnCarregar = new JButton("Carregar Clientes");
        tableModel = new DefaultTableModel(new String[]{"#", "Nome", "Sobrenome", "Telefone", "Endereço", "Credit Score"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        textField = new JTextField();
        JButton btnText = new JButton("Procurar cliente");
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(textField, BorderLayout.CENTER);
        textPanel.add(btnText, BorderLayout.EAST);

        // Adiciona um listener ao JScrollPane para carregar mais clientes ao rolar
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!scrollPane.getVerticalScrollBar().getValueIsAdjusting()) {
                    // Verifica se estamos no final da tabela e se o arquivo foi carregado
                    if (arquivoCarregado &&
                        tableModel.getRowCount() >= TAMANHO_BUFFER &&
                        scrollPane.getVerticalScrollBar().getValue() +
                        scrollPane.getVerticalScrollBar().getVisibleAmount() >=
                        scrollPane.getVerticalScrollBar().getMaximum()) {
                            carregarMaisClientes();
                    }
                }
            }
        });

        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarArquivo();
            }
        });

        btnText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pesquisarCliente();
            }
        });

        panel.add(btnCarregar, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void carregarMaisClientes() {
        // Carrega apenas 10.000 registros de cada vez
        Cliente[] clientes = bufferDeClientes.proximosClientes(TAMANHO_BUFFER); // Chama o método com o tamanho do buffer
        if (clientes != null && clientes.length > 0) {
            for (Cliente cliente : clientes) {
                if (cliente != null) { // Verifica se o cliente não é nulo
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, cliente.getNome(), cliente.getSobrenome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCreditScore()});
                }
            }
            registrosCarregados += clientes.length; // Atualiza o contador
        }
    }

    public void pesquisarCliente() {
        if (arquivoSelecionado != null) {

            bufferDeClientes.inicializaBuffer("leitura", arquivoSelecionado);
            tableModel.setRowCount(0);
            String pesquisa = textField.getText().trim().toLowerCase();
            if (pesquisa.isEmpty()) {
                carregarMaisClientes();
                return;
            }

            Cliente[] clientes = bufferDeClientes.proximosClientes(TAMANHO_BUFFER);
            while (clientes != null && clientes.length > 0) {
                for (Cliente cliente : clientes) {
                    String nome = cliente.getNome().toLowerCase();
                    if (pesquisa.equals(nome)) {
                        tableModel.addRow(new Object[]{
                                tableModel.getRowCount() + 1,
                                cliente.getNome(),
                                cliente.getSobrenome(),
                                cliente.getTelefone(),
                                cliente.getEndereco(),
                                cliente.getCreditScore()
                        });
                        return;
                    }
                }
                clientes = bufferDeClientes.proximosClientes(TAMANHO_BUFFER);
            }
            JOptionPane.showMessageDialog(this,"Not found.");
        }

        JOptionPane.showMessageDialog(this,"No file selected.");
    }


}
