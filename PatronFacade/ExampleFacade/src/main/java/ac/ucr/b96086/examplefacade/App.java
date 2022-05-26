/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.examplefacade;

import ac.ucr.b96086.examplefacade.facade.Facade;

/**
 *
 * @author Viviana
 */
public class App {

    public static void main(String[] args) {
		Facade cliente1 = new Facade();
                
		cliente1.buscar("02/07/2022", "08/07/2022", "Costa Rica", "USA");
	}

}
