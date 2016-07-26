using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CustomerOrderAndFulfillment.Contract;

namespace CustomerOrderProcessing
{
    public class ServiceGateway
    {
        CustomerOrderProcessing.Transport.TcpIpChannel _tcpIpChannel = new CustomerOrderProcessing.Transport.TcpIpChannel();
        Assembler assembler = new Assembler();


        public void SendCustomerOrder(CustomerOrder customerOrder)
        {
            //Serialize Customer Order
            String payload = assembler.SerializeCustomerOrder(customerOrder);

            payload = payload.Replace(Environment.NewLine, "");
            payload += Environment.NewLine;
            Byte[] data = System.Text.Encoding.UTF8.GetBytes(payload);
            _tcpIpChannel.Send(data);
        }

        public FulfillmentRecord GetFulfillmentRecord()
        {
            byte[] buffer = _tcpIpChannel.Recieve();
            string response =  System.Text.Encoding.UTF8.GetString(buffer);

            //Deserialize Fulfillment Record
           return assembler.DeSerializeFulfillmentRecord(response);

        }
    }
}
