package mod14.cadastrocliente.scr.br.com.thiagodd;

import mod14.cadastrocliente.scr.br.com.thiagodd.dao.ClientMapDAO;
import mod14.cadastrocliente.scr.br.com.thiagodd.dao.ClientSetDAO;
import mod14.cadastrocliente.scr.br.com.thiagodd.dao.IClientDAO;
import mod14.cadastrocliente.scr.br.com.thiagodd.domain.Client;

import javax.swing.*;

public class App {

    private static IClientDAO iClientDAO;

    public static void main(String[] args) {
        iClientDAO = new ClientSetDAO();

        String option = getOptionMenu();


        while (!isValidOption(option)) {
            if ("".equals(option)) {
                exitProgram();
            }
            option = getOptionMenu();
        }

        while (isValidOption(option)) {
            if (isExitOption(option)) {
                exitProgram();
            }

            if (isRegistrationOption(option)) {
                String data = JOptionPane.showInputDialog(
                        null,
                        """
                                                                    
                                Digite os dados do cliente separado por virgula
                                                                    
                                Exemplo:
                                Nome,  CPF,  Telefone,  Endereço,  Número,  Cidade,  Estado
                                    
                                """,
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE
                );

                register(data);
            }

            if (isFindOption(option)) {
                String data = JOptionPane.showInputDialog(
                        null,
                        """
                                                                
                                Digite o CPF do cliente

                                """,
                        "Consultar cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );
                find(data);
            }

            if (isUpdateOption(option)) {
                String data = JOptionPane.showInputDialog(
                        null,
                        """
                                                                    
                                Digite os dados do cliente separado por virgula
                                                                    
                                Exemplo:
                                Nome,  CPF,  Telefone,  Endereço,  Número,  Cidade,  Estado
                                    
                                """,
                        "Atualizar Cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );

                update(data);
            }

            if (isDeleteOption(option)) {
                String data = JOptionPane.showInputDialog(
                        null,
                        """
                                                                
                                Digite o CPF do cliente

                                """,
                        "Deletar cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );
                delete(data);
            }
            option = getOptionMenu();
        }


        if ("1".equals(option)) {
            JOptionPane.showMessageDialog(null, "Agora galera");
        }
    }

    private static String getOptionMenu() {
        return JOptionPane.showInputDialog(
                null,
                """
                        ESCOLHA UMA OPÇÃO
                                                
                        1 para cadastrar
                        2 para consultar
                        3 para atualizar
                        4 para deletar
                        5 para sair.
                                                
                        """,
                "Green Dinner",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private static void exitProgram() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }


    private static boolean isValidOption(String option) {
        return "1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option);
    }

    private static boolean isRegistrationOption(String option) {
        return "1".equals(option);
    }

    private static boolean isFindOption(String option) {
        return "2".equals(option);
    }

    private static boolean isUpdateOption(String option) {
        return "3".equals(option);
    }

    private static boolean isDeleteOption(String option) {
        return "4".equals(option);
    }

    private static boolean isExitOption(String option) {
        return "5".equals(option);
    }

    private static void register(String data) {
        String[] separateData = data.split(",");

        Client client = new Client(
                separateData[0],
                separateData[1],
                separateData[2],
                separateData[3],
                separateData[4],
                separateData[5],
                separateData[6]);

        boolean isRegistered = iClientDAO.registerClient(client);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void find(String data) {
        Client client = iClientDAO.findByCpf(Long.parseLong(data));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + client, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    private static void update(String data) {
        String[] separateData = data.split(",");



        Client client = new Client(
                separateData[0],
                separateData[1],
                separateData[2],
                separateData[3],
                separateData[4],
                separateData[5],
                separateData[6]);

        iClientDAO.update(client);
    }

    private static void delete(String data) {
        iClientDAO.delete(Long.parseLong(data));
        JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

}
