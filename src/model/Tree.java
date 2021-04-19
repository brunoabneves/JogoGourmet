/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruno
 */
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Node root;

    public Tree() {
    }

    //nó inicial/ se raiz esta vazia add nova raiz
    public void addRoot(String value) {
        if (this.root == null) {
            this.root = new Node(value);
        }
    }

    //Adiciona novo nó na árvore
    public void add(Node parent, String value, Direction dir) {
        if (parent != null) {
            if (Direction.LEFT.equals(dir)) {
                parent.setLeft(new Node(value));
            } else if (Direction.RIGHT.equals(dir)) {
                parent.setRight(new Node(value));
            }
        }
    }
    
    //Busca em Largura
    public void bfs() {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(this.root);

        while (!nodes.isEmpty()) {
            Node current = nodes.remove();
            System.out.println(current.getData());

            if (current.getLeft() != null) {
                nodes.add(current.getLeft());
            }
            if (current.getRight() != null) {
                nodes.add(current.getRight());
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}