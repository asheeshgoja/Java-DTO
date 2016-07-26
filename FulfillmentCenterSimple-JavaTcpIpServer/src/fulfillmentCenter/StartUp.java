package fulfillmentCenter;

import fulfillmentCenter.serviceInterface.ServiceInterface;

public class StartUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FulfillmentCenterApplication fulfillmentCenterApplication = new FulfillmentCenterApplication();
		ServiceInterface serviceInterface = new ServiceInterface();

		serviceInterface.ConnectApplication(fulfillmentCenterApplication);
		serviceInterface.Start();
	}

}
