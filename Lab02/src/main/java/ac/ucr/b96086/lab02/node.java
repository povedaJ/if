/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.lab02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Equipo
 */
public class node {
    
    private String name;
    private boolean opinion;
    private boolean published;
    //  List<node> nodes;
    private Set<node> friends;
    private Set<node> friendsWhoAsks;
    // HashSet friends = new HashSet<>();// no perdite tener objetos duplicados 

    public node(String name) {
        this.name = name;
        //  nodes = null;
        friends = new HashSet<>();
        friendsWhoAsks = new HashSet<>();
        this.opinion = false;
        this.published = false;
    }// constructor 

    public String getName() {
        return name;
    }
    
    public boolean getOpinion(node who) {
        
        if (friends.size() == friendsWhoAsks.size()) {// TODO   
            
            return opinion;
        } else {
            friendsWhoAsks.add(who);
            return false;
        }
    }
// events

    public void opinionPosiive() {
        opinion = true;
        friendsWhoAsks.clear();
    }
    
    public void add(node friend) {
        if (friends.add(friend)) {
            friends.add(this);
        };
    }// agregar un nuevo mienbro a la lista verificar si ya esta o si nno agregarlo hacer la conecion de 1 es a 2 y 2 es a 1 

    public void rewiewOpinion() {
        // recorrer la lsita usando lamda y streams  contando las opiniones positivas 
        Long opinion1 = friends.stream().filter(node -> node.getOpinion(this))
                .count();
        // cada vez que hay uno positivo o true lo aggraga para llevar la cuenta 

        // recorrer la lista usando for contando las opiniones positivas 
        Long opinion2 = 0L;
        for (node node : friends) {
            if (node.getOpinion(this)) {
                opinion2++;
            }
        } // las dos anteriores realizan lo mismo pero son dos formas de hacerlo 

        if (friends.size() / 2 >= opinion1) {
            opinionPosiive();
        } // si es mas del 50% pone la opinion psotitiva 

    }// 

    public boolean askOpinion() {      // nodes.iterator()

        Iterator friendsIt = friends.iterator();
        while (friendsIt.hasNext()) {
            System.out.println(friendsIt.next());
        }
        return false;
    }// valora a los amigos para saber su opinion , deberia valorar si published es true y cual es la opinion MIO

    @Override
    public boolean equals(Object obj) {
        return false;
        
    }// metodo equals para evaluar que no tengan repetidos 

}// fin class
