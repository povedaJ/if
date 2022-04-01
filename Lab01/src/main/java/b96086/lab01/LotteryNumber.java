/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b96086.lab01;

/**
 *
 * @author Equipo
 */
public class LotteryNumber {

    int number = 0;

    public LotteryNumber(int number) {
        this.number = number;
    }// contrustor

    LotteryNumber next = null;

    public void add(LotteryNumber next) {

        if (this.next == null) {
            this.next = next;
        } else {
            this.next.add(next);
        }//else 

    }//  add

    public void print(){
        System.out.println(number);
        
//    if (this.next!= null){
//        System.out.print(this.number);}
//    else{
//    this.next.add(next);}

if(next!=null){
next.print();}//if
    
    }// print

    public boolean find(int number){

        if (this.number==number){
            return true;
        }else {
            if (this.next != null) {
                return next.find(number);
            } else {
                return false;
            }//else
        }//else
    }//find


}// class
