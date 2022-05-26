/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.examplefacade.facade;

import ac.ucr.b96086.examplefacade.api.AvionApi;
import ac.ucr.b96086.examplefacade.api.HotelApi;
import ac.ucr.b96086.examplefacade.api.TourApi;

/**
 *
 * @author Viviana
 */
public class Facade {
    
	private AvionApi avionAPI;
	private HotelApi hotelAPI;
        private TourApi tourApi;
	
	public Facade() {
		avionAPI = new AvionApi();
		hotelAPI = new HotelApi();
                tourApi = new TourApi();
	}
	
	public void buscar(String fechaIda, String fechaVuelta, String origen, String destino) {
		avionAPI.buscarVuelos(fechaIda, fechaVuelta, origen, destino);
		hotelAPI.buscarHoteles(fechaIda, fechaVuelta, origen, destino);
                tourApi.buscarTour(destino);
	}
}
