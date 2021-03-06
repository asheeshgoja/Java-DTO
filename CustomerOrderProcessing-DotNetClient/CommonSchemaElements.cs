//Auto generated code
//Code generated by XXsd2Code<http://xxsd2code.sourceforge.net/> XXsd2Code.exe version 1.0.0
//For any comments/suggestions contact code generator author at asheesh.goja@gmail.com
//Auto generated code
//Auto generated code
 
using System;
using System.Collections.Generic;
 
 
 
 
namespace CustomerOrderAndFulfillment
{
	namespace CommonSchemaElements
	{
 
		[Serializable]
		public class	CreditCardDetails : ICloneable
		{
			public	string			CCNumber;
			public	string			ExpirationDate;
			
			//default constructor
			public	CreditCardDetails()
			{
				CCNumber = String.Empty;
				ExpirationDate = String.Empty;
			}
			
			//IClonable Override
			public	virtual	object Clone()
			{
				CreditCardDetails	 instance = new CreditCardDetails() ;
				instance.CCNumber = CCNumber ;
				instance.ExpirationDate = ExpirationDate ;
				return instance;
			}
			
			//DeepCopy
			public	void DeepCopy(CreditCardDetails from)
			{
				CCNumber = from.CCNumber ;
				ExpirationDate = from.ExpirationDate ;
			}
			
		}
 
		[Serializable]
		public class	OrderItem : ICloneable
		{
			public	string			title;
			public	string			note;
			public	int			quantity;
			public	System.Decimal			price;
			
			//default constructor
			public	OrderItem()
			{
				title = String.Empty;
				note = String.Empty;
				quantity = 0 ;
				price = default(decimal) ;
			}
			
			//IClonable Override
			public	virtual	object Clone()
			{
				OrderItem	 instance = new OrderItem() ;
				instance.title = title ;
				instance.note = note ;
				instance.quantity = quantity ;
				instance.price = price ;
				return instance;
			}
			
			//DeepCopy
			public	void DeepCopy(OrderItem from)
			{
				title = from.title ;
				note = from.note ;
				quantity = from.quantity ;
				price = from.price ;
			}
			
		}
 
		[Serializable]
		public class	Address : ICloneable
		{
			public	string			name;
			public	int			zip;
			public	string			city;
			public	string			country;
			
			//default constructor
			public	Address()
			{
				name = String.Empty;
				zip = 0 ;
				city = String.Empty;
				country = String.Empty;
			}
			
			//IClonable Override
			public	virtual	object Clone()
			{
				Address	 instance = new Address() ;
				instance.name = name ;
				instance.zip = zip ;
				instance.city = city ;
				instance.country = country ;
				return instance;
			}
			
			//DeepCopy
			public	void DeepCopy(Address from)
			{
				name = from.name ;
				zip = from.zip ;
				city = from.city ;
				country = from.country ;
			}
			
		}
	}
}


