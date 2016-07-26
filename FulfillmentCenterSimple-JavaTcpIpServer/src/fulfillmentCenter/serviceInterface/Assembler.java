package fulfillmentCenter.serviceInterface;


import CustomerOrderAndFulfillment.CommonSchemaElements.Address;
import CustomerOrderAndFulfillment.CommonSchemaElements.OrderItem;
import CustomerOrderAndFulfillment.Contract.CreditRating;
import CustomerOrderAndFulfillment.Contract.CustomerOrder;
import CustomerOrderAndFulfillment.Contract.FulfillmentRecord;
import CustomerOrderAndFulfillment.Contract.FuzzyCondition;

import com.thoughtworks.xstream.XStream;

import fulfillmentCenter.FulfillmentCenterApplication;


public class Assembler {
	 
		FulfillmentCenterApplication _fulfillmentCenterApplication = null;
		
		public Assembler(FulfillmentCenterApplication fulfillmentCenterApplication)
		{
			_fulfillmentCenterApplication = fulfillmentCenterApplication;
			_fulfillmentCenterApplication.CreateSampleFulfillmentRecords();
		}
		
    
	    public void RegisterXstreamConverters(XStream xs)
	    {
	    	xs.registerConverter(CustomSingleValueConverter.create(CreditRating.class));
	        xs.registerConverter(CustomSingleValueConverter.create(FuzzyCondition.class));
	        
	        xs.aliasType("CustomerOrderDTO",  CustomerOrder.class);
	        xs.aliasType("FulfillmentRecordDTO",  FulfillmentRecord.class);        
	        xs.aliasType("CustomerOrder",  CustomerOrder.class);
	        xs.aliasType("OrderItem",  OrderItem.class);
	        xs.aliasType("FulfillmentRecord",  FulfillmentRecord.class);        
	        xs.aliasType("Address",  Address.class);        
	        
	        xs.setMode(XStream.NO_REFERENCES);    
	    }
	    
	    public CustomerOrder DeSerializeCustomerOrder(String request)
	    {
	        XStream serializer = new XStream();
	        RegisterXstreamConverters(serializer);
	        return (CustomerOrder) serializer.fromXML(request);
	    }

	    public String SerializeFulfillmentRecord(FulfillmentRecord fulfillmentRecord)
	    {
	        XStream serializer = new XStream();
	        RegisterXstreamConverters(serializer);
	        return serializer.toXML(fulfillmentRecord);        
	    }
		
}
