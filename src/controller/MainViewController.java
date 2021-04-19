/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import model.Direction;
import model.Node;
import model.Tree;
import view.Panes;

/**
 *
 * @author Bruno
 */
public class MainViewController {

    //Strings dos fluxos de respostas
    private static final String MESSAGE_QUESTION = "O prato que você pensou é $?";
    private static final String MESSAGE_QUESTION_FOOD_THOUGHT  = "Qual prato você pensou?";
    private static final String MESSAGE_COMPLETE = "$1 é _______ mas $2 não.";
   
    public Panes pane;

    private final Tree tree;

    public MainViewController() {
        this.tree = new Tree();
        this.tree.addRoot("Massa");
        this.tree.add(this.tree.getRoot(), "Lasanha", Direction.LEFT);
        this.tree.add(this.tree.getRoot(), "Bolo de Chocolate", Direction.RIGHT);
    }

    private void startGame() {
        pane = new Panes();
        Queue<Node> nodes = new LinkedList<>();
        //pilha recebe a raiz da arvore
        nodes.add(this.tree.getRoot());

        while (!nodes.isEmpty()) {
            //current recebe elemento(prato) removido da pilha
            Node current = nodes.remove();
            //result recebe 0/sim ou 1/não nao para o prato mostrado (current)
            int result = pane.initPaneFoodThought(MESSAGE_QUESTION.replace("$", current.getData()));

            switch (result) {
                //sim
                case JOptionPane.YES_OPTION:
                    //se nó atual não tem filho a esquerda, entao é prato
                    if (current.getLeft() == null) {
                        pane.initPaneVictory();
                    } else {
                        //se nó atual tem filho a esquerda, é descricao do prato nao o prato
                        nodes.add(current.getLeft());
                        //System.out.println("Passou aqui");
                    }
                    break;
                //não
                case JOptionPane.NO_OPTION:
                    if (current.getRight() == null) {
                        String food = null;
                        String attribute = null;
                        
                        //campo food recebe prato digitado
                        //while garante que o campo seja preenchido
                        while (food == null || "".equals(food.trim())) {
                            food = pane.initPaneQuestionFood(MESSAGE_QUESTION_FOOD_THOUGHT);
                        }

                        //campo attribute recebe descricao do prato
                        //while garante que o campo seja preenchido
                        while (attribute == null || "".equals(attribute.trim())) {
                            attribute = pane.initPaneAttributeFood(MESSAGE_COMPLETE.replace("$1", food).replace("$2", current.getData()));
                        }
                        
                        //value recebe nó atual
                        String value = current.getData();
                        //nó atual recebe novo atributo
                        current.setData(attribute);
                        //add novo prato e seu atributo
                        this.tree.add(current, food, Direction.LEFT);
                        this.tree.add(current, value, Direction.RIGHT);
                    } else {
                        nodes.add(current.getRight());
                    }
                    break;
            }
        }
    }

    public void start() {

        startGame();

    }
}
