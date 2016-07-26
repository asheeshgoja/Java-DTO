using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;
using CustomerOrderAndFulfillment.Contract;

namespace CustomerOrderProcessing
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomerOrderProcessingApp customerOrderProcessing = new CustomerOrderProcessingApp();

            for (int i = 0; i < 1000; i++)
            {
                customerOrderProcessing.CreateCustomerOrder();              
            }            
        }
    }
}















