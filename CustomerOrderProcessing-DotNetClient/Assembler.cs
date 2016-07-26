using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Xml.Serialization;
using CustomerOrderAndFulfillment.Contract;



namespace CustomerOrderProcessing
{
    internal class Assembler
    {
        internal string SerializeCustomerOrder(CustomerOrder customerOrder)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(CustomerOrder));
            using (MemoryStream memoryStream = new MemoryStream())
            {
                serializer.Serialize(memoryStream, customerOrder);
                return Encoding.UTF8.GetString(memoryStream.ToArray());
            }
        }

        internal FulfillmentRecord DeSerializeFulfillmentRecord(string stream)
        {
            try
            {
                byte[] buffer = Encoding.UTF8.GetBytes(stream);
                XmlSerializer serializer = new XmlSerializer(typeof(FulfillmentRecord));
                using (MemoryStream memoryStream = new MemoryStream(buffer))
                {
                    return serializer.Deserialize(memoryStream) as FulfillmentRecord;
                }
            }
            catch (Exception)
            {
                FulfillmentRecord fr = new FulfillmentRecord();
                fr.CustomerOrderNo = "Failed to process response!!";
                return fr; ;
            }
        }
    }
}
