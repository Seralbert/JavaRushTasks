package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
//import javax.swing.event.ChangeListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by USER-PC on 06.09.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
        /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }*/

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit(){controller.exit();}

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "Новый":{controller.createNewDocument();break;}
            case "Открыть":{controller.openDocument();break;}
            case "Сохранить":{controller.saveDocument();break;}
            case "Сохранить как...":{controller.saveDocumentAs();break;}
            case "Выход":{controller.exit();break;}
            case "О программе":{showAbout();break;}

        }
    }


    //--------------------------------------------
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPaneHtml = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML",scrollPaneHtml);
        JScrollPane scrollPaneText = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPaneText);
        tabbedPane.setPreferredSize(new Dimension(300,300));


        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane,BorderLayout.CENTER);


    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){
        int currentTab = tabbedPane.getSelectedIndex();
        if(currentTab==0){
          controller.setPlainText(plainTextPane.getText());
        }
        if(currentTab==1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){return undoManager.canRedo();}

    public void undo(){
        try{
        undoManager.undo();}
        catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try{
            undoManager.redo();}
        catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){

        return tabbedPane.getSelectedIndex()==0;
        //return false;
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        //tabbedPane.setSelectedComponent(htmlTextPane);
        //tabbedPane.

        resetUndo();
    }


    public void update(){
        htmlTextPane.setDocument(controller.getDocument());

    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this,"About","Title",JOptionPane.INFORMATION_MESSAGE);

    }
}
