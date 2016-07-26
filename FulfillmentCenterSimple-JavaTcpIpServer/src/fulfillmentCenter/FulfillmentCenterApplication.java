package fulfillmentCenter;

import java.util.List;
import java.util.UUID;

import CustomerOrderAndFulfillment.Contract.CustomerOrder;
import CustomerOrderAndFulfillment.Contract.FulfillmentRecord;
import CustomerOrderAndFulfillment.Contract.FuzzyCondition;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;


public class FulfillmentCenterApplication {
	
	@SuppressWarnings("serial")
	public FulfillmentRecord GetFulfillmentRecordForCustomerOrder(final CustomerOrder custOrder)
	{
		List<FulfillmentRecord> fulfillmentRecords = PersistanceManager.getContainer().query(new Predicate<FulfillmentRecord>() {
			@Override
			public boolean match(FulfillmentRecord fr) {
				return fr.CustomerOrderNo.equals(custOrder.OrderNumber);
			}
		});
		
		return fulfillmentRecords.get(0);
	}
	
	public void StoreCustomerOrder(CustomerOrder custOrder)
	{
		PersistanceManager.getContainer().store(custOrder);
		PersistanceManager.getContainer().commit();
	}
		
	public void CreateSampleFulfillmentRecords()
	{
		
		ObjectSet<FulfillmentRecord> result = PersistanceManager.getContainer().query(FulfillmentRecord.class);          

		if(result.size() != 0) return;
		
		System.out.println("Creating sample Fulfillment Records please wait...");
		
		CustomerOrder customerOrder = new CustomerOrder();
		for(Integer i = 0; i < 200;i++)
		{
			customerOrder.OrderNumber = "CustomerOrderNo_" + i.toString();
			FulfillmentRecord fulfillmentRecord = CreateFulfillmentRecord(customerOrder);
			PersistanceManager.getContainer().store(fulfillmentRecord);
			PersistanceManager.getContainer().commit();
			System.out.println("Created Fulfillment Records No : " + fulfillmentRecord.FulfillmentRecordID);
		}
	}
   
	public FulfillmentRecord CreateFulfillmentRecord(CustomerOrder customerOrder)
    {
    	FulfillmentRecord fulfillmentRecord = new FulfillmentRecord();
    	fulfillmentRecord.CustomerOrderNo = customerOrder.OrderNumber;
    	fulfillmentRecord.FulfillmentRecordID = UUID.randomUUID().toString();
    	fulfillmentRecord.IsBackOrder = false;
    	fulfillmentRecord.StorageTemperature = FuzzyCondition.fromValue( String.format("%d",RandomWithinRange(0,3)*100));
    	return  fulfillmentRecord;
    }
	
	
    public FulfillmentRecord GetFulfillmentRecord(CustomerOrder customerOrder)
    {
    	FulfillmentRecord fulfillmentRecord = new FulfillmentRecord();
    	fulfillmentRecord =  GetFulfillmentRecordForCustomerOrder(customerOrder);
    	return  fulfillmentRecord;
    }	
    
	
	public Integer RandomWithinRange(int min, int max) 
    {
    	Integer randomNumber = 0;
        for (int i = 0; i < 500; i++) {
        	randomNumber = (int) (Math.random() * (max - min + 1) ) + min;
        }

        return randomNumber;
    } 
    	
}
