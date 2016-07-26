using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CustomerOrderAndFulfillment.Contract;
using CustomerOrderAndFulfillment.CommonSchemaElements;


namespace CustomerOrderProcessing
{
    internal class CustomerOrderProcessingApp
    {
        internal void CreateCustomerOrder()
        {
            CustomerOrder customerOrder = new CustomerOrder();

            customerOrder.OrderNumber = "CustomerOrderNo_" + new Random().Next(0, 199);
            customerOrder.AddressInfo.country = "InterGlaticalPlane-WDR";
            customerOrder.AddressInfo.city = "LunarBase24";
            customerOrder.AddressInfo.name = "Klingon-doT";
            customerOrder.Rating = CreditRating.Poor;
            customerOrder.Orders.Add(new OrderItem());
            customerOrder.Orders[0].price = 23.44M;
            customerOrder.Orders[0].quantity = 5;
            customerOrder.Orders[0].title = "Warp Drive";
            customerOrder.CcInfo.CCNumber = "1111222211115555";

            UpdateFulfillmentSystem(customerOrder);
        }

        private void UpdateFulfillmentSystem(CustomerOrder customerOrder)
        {
            ServiceGateway fulfillmentSystemProxy = new ServiceGateway();

            //send customerOrder to  FulfillmentSystem
            fulfillmentSystemProxy.SendCustomerOrder(customerOrder);

            System.Threading.Thread.Sleep(500);

            //get FulfillmentRecord from FulfillmentSystem
            FulfillmentRecord fulfillmentRecord = fulfillmentSystemProxy.GetFulfillmentRecord();

            Console.WriteLine("CustomerID = {0},\n\tFulfillmentRecordID: {1},\tStorageTemperature = {2}\n\n",
                                        fulfillmentRecord.CustomerOrderNo,
                                        fulfillmentRecord.FulfillmentRecordID,
                                        fulfillmentRecord.StorageTemperature);
        }
    }
}
