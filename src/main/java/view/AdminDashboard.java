package view;

import dao.*;
import entite.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class AdminDashboard extends javax.swing.JFrame {

    // private JComboBox<Client> ComboClients = new JComboBox<>();
    private DefaultTableModel mart, tableCL, tableF, tablecCOMENcLI, tableCMDf;
    private GestionDesProduitsDAO produit;
    private GérerLesClientsDAO client;
    private GérerLesFoumisseursDAO Foumisseurs;
    private GestiondesCommandesFournisseursDAO fourniseeurCMD;
    private GestionDesCommandesClientsDAO commandeCLI;
    private int currentProductId;

    public AdminDashboard() {
        initComponents();
        comboCategorie.removeAllItems();
        ComboProduit.removeAllItems();
        txtprixCommandesClients.setEditable(false);
        comboListeDESproduitF.setEditable(false);
        try {
            produit = new GestionDesProduitsDAO();
            for (Produit c : produit.getCategorie()) {
                comboCategorie.addItem(c.getNomCategorie());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

        definirLargeurColonnes();
        mart = (DefaultTableModel) TableProduit.getModel();
        tableCL = (DefaultTableModel) tableClient.getModel();
        tableF = (DefaultTableModel) tableFournisseur.getModel();
        tablecCOMENcLI = (DefaultTableModel) tableCoMenDeclient.getModel();
        tableCMDf = (DefaultTableModel) tableCMDfournisseur.getModel();
        try {
            
            chargerLesCommandesDesFournisseurs();
            remplirComboProduits();
            chargerLesProduit();
            chargerLesClients();
            chargerLesFournisseurs();
            chargerLesCommandesDesClient();
            remplirComboClients();
            remplirComboFournisseurs();
            remplirComboProduitsFournisseur();
            resetChamps();
            resetChampsFournisseurs();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remplirComboFournisseurs() {
        try {
            ArrayList<Fournisseur> Fournisseurs = GérerLesFoumisseursDAO.getFournisseurs();
            if (Fournisseurs != null && !Fournisseurs.isEmpty()) {
                combolisteDESfournisseurs.removeAllItems();
                Map<String, Integer> FournisseurIdMap = new HashMap<>();
                for (Fournisseur Fournisseur : Fournisseurs) {
                    String nomFournisseur = Fournisseur.getNom();
                    combolisteDESfournisseurs.addItem(nomFournisseur);
                    FournisseurIdMap.put(nomFournisseur, Fournisseur.getIdFournisseur());
                }
                combolisteDESfournisseurs.putClientProperty("FournisseurIdMap", FournisseurIdMap);
            } else {
                JOptionPane.showMessageDialog(null, "Aucun Fournisseur trouvé", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getFournisseurSelectione() {
        String nomSlectionne = (String) combolisteDESfournisseurs.getSelectedItem();
        Map<String, Integer> FournisseurIdMap
                = (Map<String, Integer>) combolisteDESfournisseurs.getClientProperty("FournisseurIdMap");
        return FournisseurIdMap.get(nomSlectionne);
    }

    public void remplirComboClients() {
        try {
            ArrayList<Client> clients = GérerLesClientsDAO.getClient();

            if (clients != null && !clients.isEmpty()) {
                ComboClients.removeAllItems();

                Map<String, Integer> clientIdMap = new HashMap<>();

                for (Client client : clients) {
                    String nomClient = client.getNom();
                    ComboClients.addItem(nomClient);

                    clientIdMap.put(nomClient, client.getIdClient());
                }

                ComboClients.putClientProperty("clientIdMap", clientIdMap);
            } else {
                JOptionPane.showMessageDialog(null, "Aucun client trouvé", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getClientSelectionne() {
        String nomSelectionne = (String) ComboClients.getSelectedItem();
        Map<String, Integer> clientIdMap
                = (Map<String, Integer>) ComboClients.getClientProperty("clientIdMap");

        return clientIdMap.get(nomSelectionne);
    }

    private void definirLargeurColonnes() {

        TableProduit.setRowHeight(50);
        tableClient.setRowHeight(50);
        tableFournisseur.setRowHeight(50);
        tableCoMenDeclient.setRowHeight(50);
        tableCMDfournisseur.setRowHeight(50);
        TableColumnModel columnModel = TableProduit.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(150);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNomProduit = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtQenStock = new javax.swing.JTextField();
        txtPrix = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        comboCategorie = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmdAjouter = new javax.swing.JButton();
        cmdModifier = new javax.swing.JButton();
        cmdSuprimer = new javax.swing.JButton();
        enregistremodificationCMD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProduit = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nomClient = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        adresseClient = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        teleClient = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        emailClient = new javax.swing.JTextField();
        cmdAjouterClient = new javax.swing.JButton();
        cmdSuprimerClient = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFournisseur = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nomFournisseur = new javax.swing.JTextField();
        cantactFournisseur = new javax.swing.JTextField();
        adresseFournisseur = new javax.swing.JTextField();
        cmdAjouterFOURNISSEUR = new javax.swing.JButton();
        cmdSuprimerFournisseur = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCoMenDeclient = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        ComboClients = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ComboProduit = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtQUANTITEcommandeClients = new javax.swing.JTextField();
        txtprixCommandesClients = new javax.swing.JTextField();
        ajouterCMD = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        combolisteDESfournisseurs = new javax.swing.JComboBox<>();
        comboListeDESproduitF = new javax.swing.JComboBox<>();
        quantiterDUcommandeFOURNISSEUR = new javax.swing.JTextField();
        PrixPRODUITFournisseur = new javax.swing.JTextField();
        EnregistrerCommandeFournisseur = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCMDfournisseur = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1000, 600));

        jPanel2.setBackground(new java.awt.Color(0, 180, 180));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 180, 180));
        jLabel3.setText("Gestion des Produits");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("description");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("quantite En Stock");

        jLabel6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Categorie");

        jLabel7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nom du Produit");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 180, 180));
        jLabel2.setText("search by category");

        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });
        txtCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryKeyReleased(evt);
            }
        });

        comboCategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategorieActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Prix");

        cmdAjouter.setBackground(new java.awt.Color(0, 180, 180));
        cmdAjouter.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cmdAjouter.setForeground(new java.awt.Color(0, 0, 0));
        cmdAjouter.setText("AJOUTER");
        cmdAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAjouterActionPerformed(evt);
            }
        });

        cmdModifier.setBackground(new java.awt.Color(0, 180, 180));
        cmdModifier.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cmdModifier.setForeground(new java.awt.Color(0, 0, 0));
        cmdModifier.setText("MODIFIER");
        cmdModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModifierActionPerformed(evt);
            }
        });

        cmdSuprimer.setBackground(new java.awt.Color(0, 180, 180));
        cmdSuprimer.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cmdSuprimer.setForeground(new java.awt.Color(0, 0, 0));
        cmdSuprimer.setText("SUPPRIMER");
        cmdSuprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuprimerActionPerformed(evt);
            }
        });

        enregistremodificationCMD.setBackground(new java.awt.Color(0, 180, 180));
        enregistremodificationCMD.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        enregistremodificationCMD.setForeground(new java.awt.Color(0, 0, 0));
        enregistremodificationCMD.setText("Enregistrer Modification");
        enregistremodificationCMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistremodificationCMDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomProduit)
                                    .addComponent(txtDescription)
                                    .addComponent(txtQenStock)
                                    .addComponent(txtPrix)
                                    .addComponent(comboCategorie, 0, 233, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmdModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cmdSuprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(enregistremodificationCMD)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQenStock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSuprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(enregistremodificationCMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(500, 600));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("La liste du produit");

        TableProduit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Description", "Prix", "quantiteEnStock", "Categorie", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableProduit);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 356, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(209, 209, 209))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Espace des produits", jPanel2);

        jPanel1.setBackground(new java.awt.Color(12, 45, 72));

        jPanel5.setBackground(new java.awt.Color(0, 180, 180));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel10.setText("Gestion des Client");

        jLabel11.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nom ");

        jLabel12.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Adresse");

        jLabel16.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Téléphone");

        jLabel17.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Email");

        cmdAjouterClient.setBackground(new java.awt.Color(12, 45, 72));
        cmdAjouterClient.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        cmdAjouterClient.setForeground(new java.awt.Color(255, 255, 255));
        cmdAjouterClient.setText("Enregistrer");
        cmdAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAjouterClientActionPerformed(evt);
            }
        });

        cmdSuprimerClient.setBackground(new java.awt.Color(12, 45, 72));
        cmdSuprimerClient.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        cmdSuprimerClient.setForeground(new java.awt.Color(255, 255, 255));
        cmdSuprimerClient.setText("Supprimer");
        cmdSuprimerClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuprimerClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(167, 167, 167)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adresseClient)
                            .addComponent(nomClient)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cmdAjouterClient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailClient)
                            .addComponent(teleClient))))
                .addGap(40, 40, 40))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(cmdSuprimerClient, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(adresseClient, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(teleClient, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(emailClient, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAjouterClient, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(cmdSuprimerClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(700, 600));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("La liste des Fournisseurs");

        jLabel20.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("La liste des Clients");

        tableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Adresse", "Téléphone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableClient);

        tableFournisseur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Contact", "Adresse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableFournisseur);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(12, 45, 72));
        jPanel8.setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel13.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gestion des Fournisseurs");

        jLabel14.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nom ");

        jLabel15.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Contact");

        jLabel18.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Adresse");

        cmdAjouterFOURNISSEUR.setBackground(new java.awt.Color(0, 180, 180));
        cmdAjouterFOURNISSEUR.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        cmdAjouterFOURNISSEUR.setForeground(new java.awt.Color(255, 255, 255));
        cmdAjouterFOURNISSEUR.setText("Enregistrer");
        cmdAjouterFOURNISSEUR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAjouterFOURNISSEURActionPerformed(evt);
            }
        });

        cmdSuprimerFournisseur.setBackground(new java.awt.Color(0, 180, 180));
        cmdSuprimerFournisseur.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        cmdSuprimerFournisseur.setForeground(new java.awt.Color(255, 255, 255));
        cmdSuprimerFournisseur.setText("Supprimer");
        cmdSuprimerFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuprimerFournisseurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cmdAjouterFOURNISSEUR, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nomFournisseur)
                                .addComponent(cantactFournisseur)
                                .addComponent(adresseFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(cmdSuprimerFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))))
                .addGap(33, 33, 33))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantactFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(23, 23, 23)
                        .addComponent(adresseFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cmdAjouterFOURNISSEUR, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSuprimerFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("adminstration des ventes est dachat", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(204, 0, 51));
        jPanel10.setPreferredSize(new java.awt.Dimension(440, 606));

        jLabel26.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Liste des commandes");

        tableCoMenDeclient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nm de commande", "Client", "Date", "Montant total "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableCoMenDeclient);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 180, 180));
        jPanel11.setPreferredSize(new java.awt.Dimension(880, 606));

        jLabel21.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Gestion des Commandes Clients ");

        jPanel12.setBackground(new java.awt.Color(12, 45, 72));

        ComboClients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Liste des produits  :");

        jLabel23.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Liste des Client :");

        ComboProduit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel24.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Prix  :");

        jLabel25.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Quantité :");

        ajouterCMD.setBackground(new java.awt.Color(255, 255, 255));
        ajouterCMD.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        ajouterCMD.setForeground(new java.awt.Color(0, 0, 0));
        ajouterCMD.setText("Enregistrer Commande");
        ajouterCMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterCMDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addGap(104, 104, 104)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboClients, 0, 195, Short.MAX_VALUE)
                    .addComponent(ComboProduit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQUANTITEcommandeClients)
                    .addComponent(txtprixCommandesClients))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ajouterCMD, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(486, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ComboClients, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQUANTITEcommandeClients, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprixCommandesClients, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(ajouterCMD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(374, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGap(314, 314, 314))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gestion des Commandes Clients", jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(12, 45, 72));
        jPanel13.setPreferredSize(new java.awt.Dimension(808, 606));

        jPanel15.setBackground(new java.awt.Color(0, 180, 180));

        jLabel29.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Liste des produits ");

        jLabel30.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Liste du fournisseur  ");

        jLabel31.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Quantité");

        jLabel32.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Prix");

        combolisteDESfournisseurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboListeDESproduitF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        EnregistrerCommandeFournisseur.setBackground(new java.awt.Color(255, 255, 255));
        EnregistrerCommandeFournisseur.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        EnregistrerCommandeFournisseur.setForeground(new java.awt.Color(0, 0, 0));
        EnregistrerCommandeFournisseur.setText("Enregistrer Commande");
        EnregistrerCommandeFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnregistrerCommandeFournisseurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combolisteDESfournisseurs, 0, 228, Short.MAX_VALUE)
                    .addComponent(comboListeDESproduitF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantiterDUcommandeFOURNISSEUR)
                    .addComponent(PrixPRODUITFournisseur))
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EnregistrerCommandeFournisseur)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combolisteDESfournisseurs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboListeDESproduitF, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantiterDUcommandeFOURNISSEUR, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrixPRODUITFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(EnregistrerCommandeFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel27.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel27.setText("Gestion des Commandes Fournisseurs ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(494, 606));

        jLabel28.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Liste des commandes");

        tableCMDfournisseur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nm  de commande", "Fournisseur", "Date", "Montant total "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableCMDfournisseur);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gestion des Commandes Fournisseurs", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryKeyReleased
        mart.setNumRows(0);
        try {
            for (Iterator<Produit> it = produit.getByCat(txtCategory.getText()).iterator(); it.hasNext();) {
                Produit p = it.next();
                mart.addRow(new Object[]{p.getNomProduit(), p.getDescription(), p.getPrix(), p.getQuantiteEnStock(), p.getNomCategorie(), p.getIdProduit()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtCategoryKeyReleased
    private void chargerLesProduit() throws ClassNotFoundException {
        mart.setNumRows(0);
        produit = new GestionDesProduitsDAO();
        for (Produit p : produit.getAll()) {
            mart.addRow(new Object[]{p.getNomProduit(), p.getDescription(), p.getPrix(), p.getQuantiteEnStock(), p.getNomCategorie(), p.getIdProduit()});
        }

    }

    private void chargerLesFournisseurs() throws ClassNotFoundException {
        tableF.setNumRows(0);
        Foumisseurs = new GérerLesFoumisseursDAO();
        for (Fournisseur f : Foumisseurs.getAll()) {
            tableF.addRow(new Object[]{f.getIdFournisseur(), f.getNom(), f.getContact(), f.getAdresse()});
        }
    }

    private void chargerLesCommandesDesClient() {
        tablecCOMENcLI.setNumRows(0);
        commandeCLI = new GestionDesCommandesClientsDAO();
        for (CommandeClient c : commandeCLI.getAll()) {
            tablecCOMENcLI.addRow(new Object[]{c.getIdCommande(), c.getNom(), c.getDateCommande(), c.getPrix() + " DH"});
        }
    }

    private void chargerLesCommandesDesFournisseurs() {
        tableCMDf.setNumRows(0);
        fourniseeurCMD = new GestiondesCommandesFournisseursDAO();
        for (CommandeFournisseurs c : fourniseeurCMD.getAll()) {
            tableCMDf.addRow(new Object[]{c.getIdCommande(), c.getNom(), c.getDateCommande(), c.getPrix() + " DH"});
        }
    }

    private void chargerLesClients() throws ClassNotFoundException {
        tableCL.setNumRows(0);
        client = new GérerLesClientsDAO();
        for (Client c : client.getAll()) {
            tableCL.addRow(new Object[]{c.getIdClient(), c.getNom(), c.getAdresse(), c.getTele(), c.getEmail()});
        }

    }
    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void cmdModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModifierActionPerformed
        int selectedRow = TableProduit.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int productId = (int) TableProduit.getValueAt(selectedRow, TableProduit.getColumnCount() - 1);

                String nom = (String) TableProduit.getValueAt(selectedRow, 0);
                String description = (String) TableProduit.getValueAt(selectedRow, 1);
                float prix = Float.parseFloat(TableProduit.getValueAt(selectedRow, 2).toString());
                int quantite = Integer.parseInt(TableProduit.getValueAt(selectedRow, 3).toString());
                String categorie = (String) TableProduit.getValueAt(selectedRow, 4);

                txtNomProduit.setText(nom);
                txtDescription.setText(description);
                txtPrix.setText(String.valueOf(prix));
                txtQenStock.setText(String.valueOf(quantite));

                for (int i = 0; i < comboCategorie.getItemCount(); i++) {
                    if (comboCategorie.getItemAt(i).toString().equals(categorie)) {
                        comboCategorie.setSelectedIndex(i);
                        break;
                    }
                }
                this.currentProductId = productId;

            } catch (Exception ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des informations du produit: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un produit à modifier.");
        }
    }//GEN-LAST:event_cmdModifierActionPerformed

    private void comboCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategorieActionPerformed


    }//GEN-LAST:event_comboCategorieActionPerformed

    private void cmdAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAjouterActionPerformed
        try {

            String nom = txtNomProduit.getText().trim();
            String description = txtDescription.getText().trim();
            int qte = Integer.parseInt(txtQenStock.getText());
            float prix = Float.parseFloat(txtPrix.getText());
            int index = comboCategorie.getSelectedIndex() + 1;
            produit = new GestionDesProduitsDAO();
            if (produit.ajouterProduit(nom, description, prix, qte, index)) {
                JOptionPane.showMessageDialog(this, "Insertion réussie !");
            }

        } catch (ClassNotFoundException e) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, e);

        }
    }//GEN-LAST:event_cmdAjouterActionPerformed

    private void cmdSuprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuprimerActionPerformed
        int selectedRow = TableProduit.getSelectedRow();
        if (selectedRow != -1) {
            int productId = (int) TableProduit.getValueAt(selectedRow, TableProduit.getColumnCount() - 1);

            try {
                if (produit.suprimerProduit(productId)) {
                    chargerLesProduit();
                    JOptionPane.showMessageDialog(this, "Produit supprimé avec succès !");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un produit à supprimer.");
        }
    }//GEN-LAST:event_cmdSuprimerActionPerformed


    private void enregistremodificationCMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistremodificationCMDActionPerformed
        try {

            String nom = txtNomProduit.getText();
            String description = txtDescription.getText();
            float prix = Float.parseFloat(txtPrix.getText());
            int quantite = Integer.parseInt(txtQenStock.getText());
            int idCategorie = comboCategorie.getSelectedIndex() + 1;

            if (produit.ModifierProduit(this.currentProductId, nom, description, prix, quantite, idCategorie)) {

                chargerLesProduit();
                JOptionPane.showMessageDialog(this, "Produit modifié avec succès !");
                resetFields();
            } else {
                JOptionPane.showMessageDialog(this, "Échec de la modification du produit.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs numériques valides pour le prix et la quantité.");
        } catch (Exception ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification du produit: " + ex.getMessage());
        }
    }

    private void resetFields() {
        txtNomProduit.setText("");
        txtDescription.setText("");
        txtPrix.setText("");
        txtQenStock.setText("");
        comboCategorie.setSelectedIndex(0);
        this.currentProductId = -1;
    }

    private int getSelectedCategoryId() {

        return 0;
    }//GEN-LAST:event_enregistremodificationCMDActionPerformed

    private void cmdAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAjouterClientActionPerformed
        try {
            String nom = nomClient.getText().trim();
            String adresse = adresseClient.getText().trim();
            String tele = teleClient.getText().trim();
            String email = emailClient.getText().trim();
            client = new GérerLesClientsDAO();
            if (client.ajouterClient(nom, adresse, tele, email)) {
                JOptionPane.showMessageDialog(this, "Insertion réussie !");
                chargerLesClients();
                nomClient.setText("");
                adresseClient.setText("");
                teleClient.setText("");
                emailClient.setText("");
            }

        } catch (HeadlessException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cmdAjouterClientActionPerformed

    private void cmdSuprimerClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuprimerClientActionPerformed

        int selectedRow = tableClient.getSelectedRow();
        if (selectedRow != -1) {
            int productId = (int) tableClient.getValueAt(selectedRow, 0);
            client = new GérerLesClientsDAO();
            try {
                if (client.suprimer(productId)) {
                    JOptionPane.showMessageDialog(this, "client supprimé avec succès !");
                    chargerLesClients();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un client à supprimer.");
        }
    }//GEN-LAST:event_cmdSuprimerClientActionPerformed

    private void cmdAjouterFOURNISSEURActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAjouterFOURNISSEURActionPerformed
        try {
            String nom = nomFournisseur.getText().trim();
            String Contact = cantactFournisseur.getText().trim();
            String adresse = adresseFournisseur.getText().trim();
            Foumisseurs = new GérerLesFoumisseursDAO();
            if (Foumisseurs.ajouterFournisseur(nom, Contact, adresse)) {
                JOptionPane.showMessageDialog(this, "Insertion réussie !");
                chargerLesFournisseurs();
                nomFournisseur.setText("");
                cantactFournisseur.setText("");
                adresseFournisseur.setText("");

            }

        } catch (HeadlessException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cmdAjouterFOURNISSEURActionPerformed

    private void cmdSuprimerFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuprimerFournisseurActionPerformed
        int selectedRow = tableFournisseur.getSelectedRow();
        if (selectedRow != -1) {
            int productId = (int) tableFournisseur.getValueAt(selectedRow, 0);
            Foumisseurs = new GérerLesFoumisseursDAO();
            try {
                if (Foumisseurs.suprimerFournisseur(productId)) {
                    JOptionPane.showMessageDialog(this, "Foumisseurs supprimé avec succès !");
                    chargerLesFournisseurs();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un Foumisseurs à supprimer.");
        }

    }//GEN-LAST:event_cmdSuprimerFournisseurActionPerformed

    private void ajouterCMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterCMDActionPerformed
        ajouterCommandeClient();
        resetChamps();
        chargerLesCommandesDesClient();

    }//GEN-LAST:event_ajouterCMDActionPerformed

    private void EnregistrerCommandeFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnregistrerCommandeFournisseurActionPerformed
       
         try {

            Integer idFournisseur = getFournisseurSelectione();

            if (idFournisseur == null) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez sélectionner un Fournisseur",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer idProduit = getProduitFournisseurSelectionne();

            if (idProduit == null) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez sélectionner un produit",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String quantiteStr = quantiterDUcommandeFOURNISSEUR.getText().trim();

            int quantite;
            try {
                quantite = Integer.parseInt(quantiteStr);
                if (quantite <= 0) {
                    throw new NumberFormatException("Quantité invalide");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez entrer une quantité valide (nombre entier positif)",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Float prix = getPrixProduitFournisseurSelectionne();

            if (prix == null) {
                JOptionPane.showMessageDialog(null,
                        "Erreur de récupération du prix",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean succes = GestiondesCommandesFournisseursDAO.ajouterCMDFournisseurs(idFournisseur, idProduit, quantite, prix);

            if (succes) {
                JOptionPane.showMessageDialog(null,
                        "Commande ajoutée avec succès",
                        "Succès",
                        JOptionPane.INFORMATION_MESSAGE);
               chargerLesCommandesDesFournisseurs();
                resetChampsFournisseurs();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Échec de l'ajout de la commande",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur : " + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_EnregistrerCommandeFournisseurActionPerformed
    public void remplirComboProduits() {
        try {
            ArrayList<Produit> produits = GestionDesProduitsDAO.getProduit();

            if (produits != null && !produits.isEmpty()) {
                ComboProduit.removeAllItems();

                Map<String, Integer> produitIdMap = new HashMap<>();
                Map<String, Float> produitPrixMap = new HashMap<>();

                for (Produit produit : produits) {
                    String nomProduit = produit.getNomProduit();
                    ComboProduit.addItem(nomProduit);

                    produitIdMap.put(nomProduit, produit.getIdProduit());
                    produitPrixMap.put(nomProduit, produit.getPrix());
                }

                ComboProduit.putClientProperty("produitIdMap", produitIdMap);
                ComboProduit.putClientProperty("produitPrixMap", produitPrixMap);

                ComboProduit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String produitSelectionne = (String) ComboProduit.getSelectedItem();
                        if (produitSelectionne != null) {
                            Map<String, Float> produitPrixMap
                                    = (Map<String, Float>) ComboProduit.getClientProperty("produitPrixMap");

                            Float prix = produitPrixMap.get(produitSelectionne);
                            if (prix != null) {
                                txtprixCommandesClients.setText(String.format("%.2f", prix));
                            }
                        }
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Aucun produit trouvé", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getProduitSelectionne() {
        String nomSelectionne = (String) ComboProduit.getSelectedItem();
        Map<String, Integer> produitIdMap
                = (Map<String, Integer>) ComboProduit.getClientProperty("produitIdMap");

        return produitIdMap.get(nomSelectionne);
    }
   

    public Float getPrixProduitSelectionne() {
        String nomSelectionne = (String) ComboProduit.getSelectedItem();
        Map<String, Float> produitPrixMap
                = (Map<String, Float>) ComboProduit.getClientProperty("produitPrixMap");

        return produitPrixMap.get(nomSelectionne);
    }

    public void ajouterCommandeClient() {
        try {

            Integer idClient = getClientSelectionne();

            if (idClient == null) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez sélectionner un client",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer idProduit = getProduitSelectionne();

            if (idProduit == null) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez sélectionner un produit",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String quantiteStr = txtQUANTITEcommandeClients.getText().trim();

            int quantite;
            try {
                quantite = Integer.parseInt(quantiteStr);
                if (quantite <= 0) {
                    throw new NumberFormatException("Quantité invalide");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez entrer une quantité valide (nombre entier positif)",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Float prix = getPrixProduitSelectionne();

            if (prix == null) {
                JOptionPane.showMessageDialog(null,
                        "Erreur de récupération du prix",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean succes = GestionDesCommandesClientsDAO.ajouterCMDclient(idClient, idProduit, quantite, prix);

            if (succes) {
                JOptionPane.showMessageDialog(null,
                        "Commande ajoutée avec succès",
                        "Succès",
                        JOptionPane.INFORMATION_MESSAGE);

                resetChamps();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Échec de l'ajout de la commande",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur : " + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void resetChamps() {
        ComboClients.setSelectedIndex(-1);
        ComboProduit.setSelectedIndex(-1);
        txtQUANTITEcommandeClients.setText("");
        txtprixCommandesClients.setText("");
    }
    private void resetChampsFournisseurs() {
        comboListeDESproduitF.setSelectedIndex(-1);
        combolisteDESfournisseurs.setSelectedIndex(-1);
        PrixPRODUITFournisseur.setText("");
        quantiterDUcommandeFOURNISSEUR.setText("");
    }
    public void remplirComboProduitsFournisseur() {
    try {
        ArrayList<Produit> produits = GestionDesProduitsDAO.getProduit();
        if (produits != null && !produits.isEmpty()) {
            comboListeDESproduitF.removeAllItems();
            Map<String, Integer> produitIdMap = new HashMap<>();
            Map<String, Float> produitPrixMap = new HashMap<>();
            for (Produit produit : produits) {
                String nomProduit = produit.getNomProduit();
                comboListeDESproduitF.addItem(nomProduit);
                produitIdMap.put(nomProduit, produit.getIdProduit());
                produitPrixMap.put(nomProduit, produit.getPrix());
            }
            comboListeDESproduitF.putClientProperty("produitIdMap", produitIdMap);
            comboListeDESproduitF.putClientProperty("produitPrixMap", produitPrixMap);
            comboListeDESproduitF.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String produitSelectionne = (String) comboListeDESproduitF.getSelectedItem();
                    if (produitSelectionne != null) {
                        Map<String, Float> produitPrixMap
                                = (Map<String, Float>) comboListeDESproduitF.getClientProperty("produitPrixMap");
                        Float prix = produitPrixMap.get(produitSelectionne);
                        if (prix != null) {
                            PrixPRODUITFournisseur.setText(String.format("%.2f", prix));
                        }
                    }
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Aucun produit trouvé", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public Integer getProduitFournisseurSelectionne() {
    String nomSelectionne = (String) comboListeDESproduitF.getSelectedItem();
    Map<String, Integer> produitIdMap
            = (Map<String, Integer>) comboListeDESproduitF.getClientProperty("produitIdMap");
    return produitIdMap.get(nomSelectionne);
}

public Float getPrixProduitFournisseurSelectionne() {
    String nomSelectionne = (String) comboListeDESproduitF.getSelectedItem();
    Map<String, Float> produitPrixMap
            = (Map<String, Float>) comboListeDESproduitF.getClientProperty("produitPrixMap");
    return produitPrixMap.get(nomSelectionne);
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboClients;
    private javax.swing.JComboBox<String> ComboProduit;
    private javax.swing.JButton EnregistrerCommandeFournisseur;
    private javax.swing.JTextField PrixPRODUITFournisseur;
    private javax.swing.JTable TableProduit;
    private javax.swing.JTextField adresseClient;
    private javax.swing.JTextField adresseFournisseur;
    private javax.swing.JButton ajouterCMD;
    private javax.swing.JTextField cantactFournisseur;
    private javax.swing.JButton cmdAjouter;
    private javax.swing.JButton cmdAjouterClient;
    private javax.swing.JButton cmdAjouterFOURNISSEUR;
    private javax.swing.JButton cmdModifier;
    private javax.swing.JButton cmdSuprimer;
    private javax.swing.JButton cmdSuprimerClient;
    private javax.swing.JButton cmdSuprimerFournisseur;
    private javax.swing.JComboBox<String> comboCategorie;
    private javax.swing.JComboBox<String> comboListeDESproduitF;
    private javax.swing.JComboBox<String> combolisteDESfournisseurs;
    private javax.swing.JTextField emailClient;
    private javax.swing.JButton enregistremodificationCMD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField nomClient;
    private javax.swing.JTextField nomFournisseur;
    private javax.swing.JTextField quantiterDUcommandeFOURNISSEUR;
    private javax.swing.JTable tableCMDfournisseur;
    private javax.swing.JTable tableClient;
    private javax.swing.JTable tableCoMenDeclient;
    private javax.swing.JTable tableFournisseur;
    private javax.swing.JTextField teleClient;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtNomProduit;
    private javax.swing.JTextField txtPrix;
    private javax.swing.JTextField txtQUANTITEcommandeClients;
    private javax.swing.JTextField txtQenStock;
    private javax.swing.JTextField txtprixCommandesClients;
    // End of variables declaration//GEN-END:variables
}
