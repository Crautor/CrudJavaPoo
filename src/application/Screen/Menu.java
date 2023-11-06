package application.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import application.Funcoes;

public class Menu extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;
    private JButton CnaeButton;
    private JButton EixoButton;
    private JButton EnderecoButton;


    public Menu() {
        setTitle("Menu Gráfico");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Crie os painéis para cada opção do menu
        JPanel menuCnaePanel = createMenuCnaePanel();
        JPanel menuEixoPanel = createMenuEixoPanel();
        JPanel menuEnderecoPanel = createMenuEnderecoPanel();


        // Adicione os painéis ao "cards" com nomes para identificá-los
        cards.add(menuCnaePanel, "menuCnae");
        cards.add(menuEixoPanel, "menuEixo");
        cards.add(menuEnderecoPanel, "menuEndereco");


        add(cards);

// Crie botões para selecionar as opções do menu principal
        CnaeButton = new JButton("Cnae");
        EixoButton = new JButton("Eixo");
        EnderecoButton = new JButton("Endereco");


// Associe os botões aos métodos correspondentes
        CnaeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuCnae");

            }
        });
        EixoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuEixo");

            }
        });
        EnderecoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuEndereco");

            }
        });


// Adicione os botões do menu principal
        JPanel menuPrincipalPanel = new JPanel();
        menuPrincipalPanel.add(CnaeButton);
        menuPrincipalPanel.add(EixoButton);
        menuPrincipalPanel.add(EnderecoButton);


        add(menuPrincipalPanel, BorderLayout.NORTH);


        setVisible(true);
    }


    private JPanel createMenuCnaePanel() {
        JPanel panel = new JPanel();

        addCnaeButtons(panel);
        return panel;
    }
    private JPanel createMenuEixoPanel() {
        JPanel panel = new JPanel();

        addEixoButtons(panel);
        return panel;
    }
    private JPanel createMenuEnderecoPanel() {
        JPanel panel = new JPanel();


        addEnderecoButtons(panel);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu();
        });
    }

    private void addCnaeButtons(JPanel menuCnaePanel) {
        JButton cadastrarCnae = new JButton("Cadastrar Cnae");
        JButton findAllCnae = new JButton("Exibir Todos Cnae");
        JButton findIDCnae = new JButton("Exibir Cnae por ID");
        JButton updateCnae = new JButton("Atualizar Cnae");
        JButton deleteCnae = new JButton("Deletar Cnae");

        // Associe esses botões aos métodos correspondentes
        cadastrarCnae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCnae();
            }
        });

        findAllCnae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosCnae();
            }
        });

        findIDCnae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirCnaePeloId();
            }
        });

        updateCnae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCnae();
            }
        });

        deleteCnae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarCnae();
            }
        });

        menuCnaePanel.add(cadastrarCnae);
        menuCnaePanel.add(findAllCnae);
        menuCnaePanel.add(findIDCnae);
        menuCnaePanel.add(updateCnae);
        menuCnaePanel.add(deleteCnae);
    }
    private void addEixoButtons(JPanel menuEixoPanel) {
        JButton cadastrarEixo = new JButton("Cadastrar Eixo");
        JButton findAllEixo = new JButton("Exibir Todos Eixo");
        JButton findIDEixo = new JButton("Exibir Eixo por ID");
        JButton updateEixo = new JButton("Atualizar Eixo");
        JButton deleteEixo = new JButton("Deletar Eixo");

        // Associe esses botões aos métodos correspondentes
        cadastrarEixo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEixo();
            }
        });

        findAllEixo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosEixo();
            }
        });

        findIDEixo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirEixoPeloId();
            }
        });

        updateEixo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEixo();
            }
        });

        deleteEixo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarEixo();
            }
        });

        menuEixoPanel.add(cadastrarEixo);
        menuEixoPanel.add(findAllEixo);
        menuEixoPanel.add(findIDEixo);
        menuEixoPanel.add(updateEixo);
        menuEixoPanel.add(deleteEixo);
    }
    private void addEnderecoButtons(JPanel menuEnderecoPanel) {
        JButton cadastrarEndereco = new JButton("Cadastrar Endereco");
        JButton findAllEndereco = new JButton("Exibir Todos Endereco");
        JButton findIDEndereco = new JButton("Exibir Endereco por ID");
        JButton updateEndereco = new JButton("Atualizar Endereco");
        JButton deleteEndereco = new JButton("Deletar Endereco");

        // Associe esses botões aos métodos correspondentes
        cadastrarEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEndereco();
            }
        });

        findAllEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosEndereco();
            }
        });

        findIDEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirEnderecoPeloId();
            }
        });

        updateEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEndereco();
            }
        });

        deleteEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarEndereco();
            }
        });

        menuEnderecoPanel.add(cadastrarEndereco);
        menuEnderecoPanel.add(findAllEndereco);
        menuEnderecoPanel.add(findIDEndereco);
        menuEnderecoPanel.add(updateEndereco);
        menuEnderecoPanel.add(deleteEndereco);
    }

    private void cadastrarCnae() {
        Funcoes.insertCnae();
    }

    private void exibirTodosCnae() {
        Funcoes.findAllCnae();
    }

    private void exibirCnaePeloId() {
        Funcoes.findIdCnae();
    }

    private void atualizarCnae() {
        Funcoes.updateCnae();
    }

    private void deletarCnae() {
        Funcoes.deleteCnae();
    }
  private void cadastrarEixo() {
        Funcoes.insertEixo();
    }

    private void exibirTodosEixo() {
        Funcoes.findAllEixo();
    }

    private void exibirEixoPeloId() {
        Funcoes.findIdEixo();
    }

    private void atualizarEixo() {
        Funcoes.updateEixo();
    }

    private void deletarEixo() {
        Funcoes.deleteEixo();
    }
    private void cadastrarEndereco() {
        Funcoes.insertEndereco();
    }

    private void exibirTodosEndereco() {
        Funcoes.findAllEndereco();
    }

    private void exibirEnderecoPeloId() {
        Funcoes.findIdEndereco();
    }

    private void atualizarEndereco() {
        Funcoes.updateEndereco();
    }

    private void deletarEndereco() {
        Funcoes.deleteEndereco();
    }

}
