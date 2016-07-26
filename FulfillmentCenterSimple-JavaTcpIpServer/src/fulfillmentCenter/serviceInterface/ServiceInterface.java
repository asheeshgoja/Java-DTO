package fulfillmentCenter.serviceInterface;

import fulfillmentCenter.FulfillmentCenterApplication;
import CustomerOrderAndFulfillment.Contract.CustomerOrder;
import CustomerOrderAndFulfillment.Contract.FulfillmentRecord;



public class ServiceInterface
{

	FulfillmentCenterApplication _fulfillmentCenterApplication = null;
	
	public void ConnectApplication(FulfillmentCenterApplication fulfillmentCenterApplication) 
	{
		_fulfillmentCenterApplication = fulfillmentCenterApplication;
	}
	
   	public void Start() 
	{		
		try 
		{
			 TcpIpChannel transport = new TcpIpChannel();
        	 Assembler assembler = new  Assembler(_fulfillmentCenterApplication);	         
        	 
        	 while(true)
	         {	
				 String request = transport.Recieve();
				 CustomerOrder customerOrder = assembler.DeSerializeCustomerOrder(request);
				 System.out.println("Recieved order from CustomerOrder System. Order No = " + customerOrder.OrderNumber);	
				 _fulfillmentCenterApplication.StoreCustomerOrder(customerOrder);
				 
				 FulfillmentRecord fulfillmentRecord = _fulfillmentCenterApplication.GetFulfillmentRecord(customerOrder);
				 String response = assembler.SerializeFulfillmentRecord(fulfillmentRecord);
				 transport.Send(response);
			 
	         }			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
