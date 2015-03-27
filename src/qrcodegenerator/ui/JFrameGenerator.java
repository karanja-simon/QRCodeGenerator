/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuListener;
import qrcodegenerator.QRCodeGenerator;

/**
 *
 * @author RESEARCH_2
 */
public class JFrameGenerator extends javax.swing.JFrame {

    private Point initialClick;
    private boolean showOpen = false;
    private Image image;
    private final JPopupMenu colorMenu = new JPopupMenu();
    private final JPopupMenu helpMenu = new JPopupMenu();
    private final JPanelColorScheme jpcs = new JPanelColorScheme(null);
    private final JPanelAboutMenu jpam = new JPanelAboutMenu();

    /**
     * Creates new form JFrameGenerator
     */
    public JFrameGenerator() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.image = ImageIO.read(new File("icons/bg_l.png"));
        } catch (Exception ex) {
            Logger.getLogger(QRCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        jPanelMiddleRight.setVisible(false);
        jButtonUIColor.setName("btnUIColor");
        setLocationRelativeTo(null);
        jButtonExport.setVisible(false);
        jpcs.setBackground(jButtonUIColor.getBackground());
        jpam.setBackground(jButtonUIColor.getBackground());
        colorMenu.setBorder(new LineBorder(jButtonUIColor.getBackground()));
        helpMenu.setBorder(new LineBorder(jButtonUIColor.getBackground()));

    }

    public String getData() {
        return jTextAreaData.getText();
    }

    /**
     * Register button generate action listener
     *
     * @param al
     */
    public void addBtnGenerateActionPerformed(ActionListener al) {
        jButtonGenerate.addActionListener(al);
    }

    public JPanel getjPanelMiddleRight() {
        return jPanelMiddleRight;
    }

    /**
     * Shows or hides the JPanel
     *
     * @param show
     */
    public void showJPanel(boolean show) {
        jPanelMiddleRight.setVisible(show);
    }

    /**
     * Set text on the jlabel
     *
     * @param text
     */
    public void setPreviewText(String text) {
        jLabelQRPreview.setText(text);
    }

    /**
     * Register button generate action listener
     *
     * @param al
     */
    public void addBtnAboutActionPerformed(ActionListener al) {
        jButtonAbout.addActionListener(al);
    }

    /**
     * Register button generate action listener
     *
     * @param al
     */
    public void addBtnNewQRActionPerformed(ActionListener al) {
        jButtonNewQR.addActionListener(al);
    }

    /**
     * Register button generate action listener
     *
     * @param al
     */
    public void addBtnExitActionPerformed(ActionListener al) {
        jButtonExit.addActionListener(al);
    }

    public JLabel getjLabelQRPreview() {
        return jLabelQRPreview;
    }

    /**
     * Register button generate action listener
     *
     * @param al
     */
    public void addBtnExportActionPerformed(ActionListener al) {
        jButtonExport.addActionListener(al);
    }

    /**
     * Add JPanel on mouse pressed listener
     *
     * @param ml
     */
    public void addPanelOnMousePressed(MouseAdapter ml) {
        jPanelWrapper.addMouseListener(ml);
    }

    /**
     * Add JPanel mouse dragged
     *
     * @param mma
     */
    public void addPanelOnMouseDragged(MouseMotionAdapter mma) {
        jPanelWrapper.addMouseMotionListener(mma);
    }

    /**
     * Show the About dialog
     */
    public void setAboutDialog() {
        JDialogAbout jda = new JDialogAbout(this, true);
        jda.setLocationRelativeTo(this);
        jda.setVisible(true);
    }
    /**
     * Show the License dialog
     */
    public void setLicenseDialog() {
        JDialogLicense jda = new JDialogLicense(this, true);
        jda.setLocationRelativeTo(this);
        jda.setVisible(true);
    }
    /**
     * Show the current location of the JFrame
     *
     * @param p
     */
    public void updateFrameLocation(Point p) {
        jLabelLocation.setText(" X : " + p.getX() + "  Y : " + p.getY() + "    ");
    }

    /**
     * Move the JFame to a new location, based on the JWrapper current location
     * on screen
     *
     * @param evt
     */
    public void moveFrameToNewLoc(MouseEvent evt) {
        // get location of Window
        int thisX = getLocation().x;
        int thisY = getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);

        // Move window to this position
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        setLocation(X, Y);
    }

    /**
     * Set the initial location of the JFrame
     *
     * @param p
     */
    public void setInitialPoint(Point p) {
        initialClick = p;
    }

    /**
     * Set the new QR image on the view
     *
     * @param imagePath
     */
    public void loadNewQRImage(String imagePath) {
        jLabelQRPreview.setIcon(new javax.swing.ImageIcon((imagePath)));
    }

    public JButton getjButtonExport() {
        return jButtonExport;
    }

    /**
     * Show open generated image message
     *
     * @param show
     */
    public void showOpen(boolean show) {
        if (show) {
            jButtonExport.setText("..Open");
        } else {
            jButtonExport.setText("Export");
        }
        showOpen = show;
    }

    /**
     * Clear the text area for a new entry and set the preview icon to default
     */
    public void newQRCode() {
        jButtonExport.setVisible(false);
        jTextAreaData.setText(null);
        jLabelQRPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qrcodegenerator/resources/builder.GIF")));
        jTextAreaData.setOpaque(false);
        repaint();
    }

    /**
     * Clear the text area for a new entry and set the preview icon to default
     */
    public void newQRCode(boolean modify) {
        jButtonExport.setVisible(false);
        jLabelQRPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qrcodegenerator/resources/builder.GIF")));
    }

    /**
     *
     * @return
     */
    public boolean isShowOpen() {
        return showOpen;
    }

    /**
     * Sets the visibility of the export button
     *
     * @param visibility
     */
    public void setExportVisible(boolean visibility) {
        jButtonExport.setVisible(visibility);
    }

    /**
     * Get the jTextArea
     *
     * @return
     */
    public JTextArea getjTextAreaData() {
        return jTextAreaData;
    }

    /**
     * Get the UIColor Button
     *
     * @return
     */
    public JButton getjButtonUIColor() {
        return jButtonUIColor;
    }

    /**
     * *
     * Add mouse listener for all the buttons on the top panel
     *
     * @param ml
     */
    public void addNavBtnMouseListener(MouseListener ml) {
        for (Component comp : jPanelTop.getComponents()) {
            if (comp instanceof JButton) {
                JButton jbtn = (JButton) comp;
                if (!"btnUIColor".equalsIgnoreCase(jbtn.getName())) {
                    jbtn.addMouseListener(ml);
                }

            }

        }
    }

    public JPanelAboutMenu getJpam() {
        return jpam;
    }

    /**
     * Add mouse listener to UI color button
     *
     * @param ml
     */
    public void addColorBtnMouseListener(MouseListener ml) {
        jButtonUIColor.addMouseListener(ml);
    }

    public JPopupMenu getColorMenu() {
        return colorMenu;
    }

    public JPopupMenu getHelpMenu() {
        return helpMenu;
    }

    /**
     * Add mouse listener to UI color button
     *
     * @param ml
     */
    public void addHelpBtnMouseListener(MouseListener ml) {
        jButtonAbout.addMouseListener(ml);
    }
//
//    public JPopupMenu getMenu() {
//        return colorMenu;
//    }

    /**
     * Change the color of components based on the color scheme selected by the
     * user
     *
     * @param color
     */
    public void changeComponentColor(Color color) {
        jButtonBottom.setBackground(color);
        jSeparatorTop.setForeground(color);
        jpcs.setBackground(color);
        jpam.setBackground(color);
        jButtonUIColor.setBackground(color);
        colorMenu.setBorder(new LineBorder(color));
        helpMenu.setBorder(new LineBorder(color));
        jLabelLocation.setBackground(color);
    }

    /**
     * Change the color of components based on the color scheme selected by the
     * user
     *
     * @param colorScheme
     */
    public void setUIColor(String colorScheme) {
        switch (colorScheme) {
            case "color_1":
                changeComponentColor(new Color(229, 77, 66));
                break;
            case "color_2":
                changeComponentColor(new Color(84, 173, 234));
                break;
            case "color_3":
                changeComponentColor(new Color(153, 200, 71));
                break;
            case "color_4":
                changeComponentColor(new Color(128, 138, 146));
                break;
            default:
                changeComponentColor(Color.GRAY);
        }
    }

    public JButton getjButtonAbout() {
        return jButtonAbout;
    }

    /**
     * Get the color of the ui button
     *
     * @return
     */
    public Color getUIColor() {
        return jButtonUIColor.getBackground();
    }

    /**
     * Sets the opaqueness of the about button
     *
     * @param opaque
     */
    public void setHelpOpaqueness(boolean opaque) {
        jButtonAbout.setOpaque(opaque);
        this.repaint();
    }

    /**
     * Gets the color scheme panel
     *
     * @return
     */
    public JPanelColorScheme getJpcs() {
        return jpcs;
    }

    // This method does it all!
    public void showPopup(MouseEvent ae) {
        // Create a JPopupMenu

        // Add JMenuItems to JPopupMenu
        colorMenu.add(jpcs);
        // Get the event source
        Component b = (Component) ae.getSource();

        // Get the location of the point 'on the screen'
        Point p = b.getLocationOnScreen();

        // Show the JPopupMenu via program
        // Parameter desc
        // ----------------
        // this - represents current frame
        // 0,0 is the co ordinate where the popup
        // is shown
        colorMenu.show(this, 0, 0);

        // Now set the location of the JPopupMenu
        // This location is relative to the screen
        colorMenu.setLocation(p.x, p.y + b.getHeight());
    }

    // This method does it all!
    public void showHelpPopup(MouseEvent ae) {
        // Create a JPopupMenu

        // Add JMenuItems to JPopupMenu
        helpMenu.add(jpam);
        // Get the event source
        Component b = (Component) ae.getSource();

        // Get the location of the point 'on the screen'
        Point p = b.getLocationOnScreen();

        // Show the JPopupMenu via program
        // Parameter desc
        // ----------------
        // this - represents current frame
        // 0,0 is the co ordinate where the popup
        // is shown
        helpMenu.show(this, 0, 0);

        // Now set the location of the JPopupMenu
        // This location is relative to the screen
        helpMenu.setLocation(p.x, p.y + b.getHeight());
    }

    /**
     * Adds a popupmenu listener to the help menu button
     *
     * @param pml
     */
    public void addHelpPoupListener(PopupMenuListener pml) {
        helpMenu.addPopupMenuListener(pml);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelWrapper = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonAbout = new javax.swing.JButton();
        jButtonNewQR = new javax.swing.JButton();
        jButtonUIColor = new javax.swing.JButton();
        jSeparatorTop = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabelLocation = new javax.swing.JLabel();
        jButtonBottom = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanelMiddleRight = new javax.swing.JPanel();
        jLabelQRPreview = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonExport = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanelParam = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaData = new JTextArea(){
            public void paintComponent (Graphics g)
            {
                g.drawImage(image, 0, 0, null,this);
                super.paintComponent(g);
            }}
            ;
            jButtonGenerate = new javax.swing.JButton();

            jLabel1.setText("jLabel1");

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            jPanelWrapper.setBackground(new java.awt.Color(255, 255, 255));
            jPanelWrapper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
            jPanelWrapper.setLayout(new java.awt.BorderLayout());

            jPanelTop.setBackground(new java.awt.Color(204, 204, 204));

            jButtonExit.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jButtonExit.setText("Exit");
            jButtonExit.setBorderPainted(false);
            jButtonExit.setContentAreaFilled(false);
            jButtonExit.setFocusPainted(false);
            jButtonExit.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jButtonExitMouseEntered(evt);
                }
            });
            jButtonExit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonExitActionPerformed(evt);
                }
            });

            jButtonAbout.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jButtonAbout.setText("About");
            jButtonAbout.setBorderPainted(false);
            jButtonAbout.setContentAreaFilled(false);
            jButtonAbout.setFocusPainted(false);

            jButtonNewQR.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jButtonNewQR.setText("New QR");
            jButtonNewQR.setBorderPainted(false);
            jButtonNewQR.setContentAreaFilled(false);
            jButtonNewQR.setFocusPainted(false);

            jButtonUIColor.setBackground(new java.awt.Color(153, 153, 0));
            jButtonUIColor.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jButtonUIColor.setBorderPainted(false);
            jButtonUIColor.setContentAreaFilled(false);
            jButtonUIColor.setFocusPainted(false);
            jButtonUIColor.setOpaque(true);
            jButtonUIColor.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonUIColorActionPerformed(evt);
                }
            });

            jSeparatorTop.setBackground(new java.awt.Color(51, 204, 255));
            jSeparatorTop.setForeground(jButtonUIColor.getBackground());
            jSeparatorTop.setOpaque(true);

            javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
            jPanelTop.setLayout(jPanelTopLayout);
            jPanelTopLayout.setHorizontalGroup(
                jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTopLayout.createSequentialGroup()
                    .addComponent(jButtonUIColor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jButtonNewQR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jButtonAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE))
                .addComponent(jSeparatorTop)
            );

            jPanelTopLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAbout, jButtonExit, jButtonNewQR});

            jPanelTopLayout.setVerticalGroup(
                jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTopLayout.createSequentialGroup()
                    .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExit)
                        .addComponent(jButtonAbout)
                        .addComponent(jButtonNewQR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonUIColor))
                    .addGap(0, 0, 0)
                    .addComponent(jSeparatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            jPanelTopLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAbout, jButtonExit, jButtonNewQR, jButtonUIColor});

            jButtonUIColor.getAccessibleContext().setAccessibleName("colorButton");

            jPanelWrapper.add(jPanelTop, java.awt.BorderLayout.NORTH);

            jPanel2.setBackground(new java.awt.Color(51, 51, 51));

            jLabelLocation.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
            jLabelLocation.setForeground(new java.awt.Color(51, 51, 51));
            jLabelLocation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabelLocation.setText(" X : 0 Y: 0   ");
            jLabelLocation.setOpaque(true);

            jButtonBottom.setBackground(getUIColor());
            jButtonBottom.setBorderPainted(false);
            jButtonBottom.setContentAreaFilled(false);
            jButtonBottom.setOpaque(true);

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabelLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButtonBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(jLabelLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jPanelWrapper.add(jPanel2, java.awt.BorderLayout.SOUTH);

            jPanel4.setBackground(new java.awt.Color(255, 255, 255));

            jPanelMiddleRight.setBackground(new java.awt.Color(255, 255, 255));

            jLabelQRPreview.setFont(new java.awt.Font("Segoe UI Semilight", 0, 9)); // NOI18N
            jLabelQRPreview.setForeground(new java.awt.Color(153, 153, 153));
            jLabelQRPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabelQRPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qrcodegenerator/resources/builder.GIF"))); // NOI18N
            jLabelQRPreview.setText("Generating. Hold on!");
            jLabelQRPreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabelQRPreview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabelQRPreview.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Generated QR");

            jButtonExport.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jButtonExport.setText("Export");
            jButtonExport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
            jButtonExport.setContentAreaFilled(false);
            jButtonExport.setFocusPainted(false);
            jButtonExport.setOpaque(true);

            javax.swing.GroupLayout jPanelMiddleRightLayout = new javax.swing.GroupLayout(jPanelMiddleRight);
            jPanelMiddleRight.setLayout(jPanelMiddleRightLayout);
            jPanelMiddleRightLayout.setHorizontalGroup(
                jPanelMiddleRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMiddleRightLayout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelMiddleRightLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelMiddleRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelQRPreview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMiddleRightLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            jPanelMiddleRightLayout.setVerticalGroup(
                jPanelMiddleRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMiddleRightLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(jLabelQRPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            jPanelParam.setBackground(new java.awt.Color(255, 255, 255));

            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            jTextAreaData.setColumns(20);
            jTextAreaData.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jTextAreaData.setLineWrap(true);
            jTextAreaData.setRows(5);
            jTextAreaData.setOpaque(false);
            jTextAreaData.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTextAreaDataMouseClicked(evt);
                }
            });
            jTextAreaData.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    jTextAreaDataFocusLost(evt);
                }
            });
            jScrollPane1.setViewportView(jTextAreaData);

            jButtonGenerate.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
            jButtonGenerate.setText("Generate");
            jButtonGenerate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
            jButtonGenerate.setContentAreaFilled(false);
            jButtonGenerate.setFocusPainted(false);
            jButtonGenerate.setOpaque(true);

            javax.swing.GroupLayout jPanelParamLayout = new javax.swing.GroupLayout(jPanelParam);
            jPanelParam.setLayout(jPanelParamLayout);
            jPanelParamLayout.setHorizontalGroup(
                jPanelParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParamLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParamLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanelParamLayout.setVerticalGroup(
                jPanelParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelParamLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)
                    .addComponent(jPanelMiddleRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelMiddleRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jPanelParam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())))
            );

            jPanelWrapper.add(jPanel4, java.awt.BorderLayout.CENTER);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonUIColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUIColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUIColorActionPerformed

    private void jTextAreaDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaDataMouseClicked
        // TODO add your handling code here:
        jTextAreaData.setOpaque(true);
        repaint();
    }//GEN-LAST:event_jTextAreaDataMouseClicked

    private void jTextAreaDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaDataFocusLost
        if (jTextAreaData.getText().isEmpty()) {
            jTextAreaData.setOpaque(false);
            repaint();
        }
    }//GEN-LAST:event_jTextAreaDataFocusLost

    private void jButtonExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExitMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonExitMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonAbout;
    private javax.swing.JButton jButtonBottom;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonNewQR;
    private javax.swing.JButton jButtonUIColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JLabel jLabelQRPreview;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelMiddleRight;
    private javax.swing.JPanel jPanelParam;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JPanel jPanelWrapper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorTop;
    private javax.swing.JTextArea jTextAreaData;
    // End of variables declaration//GEN-END:variables
}
