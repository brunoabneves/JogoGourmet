/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class Panes {
    //views da aplicação
    public int initPaneFoodThought(String data) {
        return JOptionPane.showConfirmDialog(null, data, "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void initPaneVictory() {
        JOptionPane.showMessageDialog(null, "Acertei de novo", "Jogo Gourmet do Bruno Neves", JOptionPane.INFORMATION_MESSAGE);
    }

    public String initPaneQuestionFood(String data) {
        return JOptionPane.showInputDialog(null, data, "Desisto", JOptionPane.QUESTION_MESSAGE);
    }
    
    public String initPaneAttributeFood(String data){
        return JOptionPane.showInputDialog(null, data ,"Complete",JOptionPane.QUESTION_MESSAGE);
    }
}
