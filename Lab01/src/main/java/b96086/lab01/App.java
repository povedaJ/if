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
public class App {

    public static void main(String arg[]) {
//
//        LotteryNumber today = new LotteryNumber();
//        today.number = 98;
//        LotteryNumber tomorrow = new LotteryNumber();
//        tomorrow.number = 03;
//        today.add(tomorrow);
//        

        LotteryNumber first = new LotteryNumber(98);
        first.add(new LotteryNumber(03));
        first.add(new LotteryNumber(33));
        first.add(new LotteryNumber(45));
        first.add(new LotteryNumber(67));
        first.add(new LotteryNumber(98));
        
        first.print();
        System.out.println( first.find(778));

    }// main 

}//  class
