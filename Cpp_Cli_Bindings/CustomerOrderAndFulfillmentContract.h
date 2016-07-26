//Auto generated code
//Code generated by XXsd2Code<http://xxsd2code.sourceforge.net/> XXsd2Code.exe version 1.0.0
//For any comments/suggestions contact code generator author at asheesh.goja@gmail.com
//Auto generated code
//Auto generated code
 
#pragma once
using System::String;
using System::ICloneable;
using System::Collections::Generic::List;
using System::SerializableAttribute;
 
 
#include "CommonSchemaElements.h"
 
 
using namespace CustomerOrderAndFulfillment::CommonSchemaElements;
 
 
namespace CustomerOrderAndFulfillment
{
	namespace Contract
	{
 
		//enumeration	CreditRating
		public enum class	CreditRating
		{
			[System::Xml::Serialization::XmlEnum(Name = "700")] Good = 700,
			[System::Xml::Serialization::XmlEnum(Name = "750")] VeryGood = 750,
			[System::Xml::Serialization::XmlEnum(Name = "790")] ExtremelyGood = 790,
			[System::Xml::Serialization::XmlEnum(Name = "300")] Poor = 300
			
		};
 
		//enumeration	FuzzyCondition
		public enum class	FuzzyCondition
		{
			[System::Xml::Serialization::XmlEnum(Name = "100")] Hot = 100,
			[System::Xml::Serialization::XmlEnum(Name = "200")] VeryHot = 200,
			[System::Xml::Serialization::XmlEnum(Name = "300")] ExtremelyHot = 300,
			[System::Xml::Serialization::XmlEnum(Name = "0")] Cold = 0
			
		};
 
		[SerializableAttribute]
		public ref class	FulfillmentRecord: public ICloneable
		{
		public:
			String^			FulfillmentRecordID;
			bool IsBackOrder;
			FuzzyCondition			StorageTemperature;
			String^			CustomerOrderNo;
			
			//default constructor
			FulfillmentRecord()
			{
				FulfillmentRecordID = String::Empty;
				IsBackOrder = false ;
				StorageTemperature = CustomerOrderAndFulfillment::Contract::FuzzyCondition::Hot ;
				CustomerOrderNo = String::Empty;
			}
			
			//copy constuctor
			FulfillmentRecord( FulfillmentRecord%  rhs){*this = rhs;}
			
			//IClonable Override
			virtual	Object^ Clone()
			{
				FulfillmentRecord^	 instance = gcnew FulfillmentRecord() ;
				*instance = *this ;
				return instance;
			}
			
			//= operator
			FulfillmentRecord% operator = ( FulfillmentRecord%  rhs)
			{
				FulfillmentRecordID = rhs.FulfillmentRecordID ;
				IsBackOrder = rhs.IsBackOrder ;
				StorageTemperature = rhs.StorageTemperature ;
				CustomerOrderNo = rhs.CustomerOrderNo ;
				return *this;
			}
			
			//DeepCopy
			void	DeepCopy ( FulfillmentRecord^  from)
			{
				FulfillmentRecordID = from->FulfillmentRecordID ;
				IsBackOrder = from->IsBackOrder ;
				StorageTemperature = from->StorageTemperature ;
				CustomerOrderNo = from->CustomerOrderNo ;
			}
			
		};
 
		[SerializableAttribute]
		public ref class	CustomerOrder: public ICloneable
		{
		public:
			String^			OrderNumber;
			CreditRating			Rating;
			CustomerOrderAndFulfillment::CommonSchemaElements::Address^			AddressInfo;

			typedef List<CustomerOrderAndFulfillment::CommonSchemaElements::OrderItem^>		OrderItem_VECTOR;
			OrderItem_VECTOR^			Orders;
			CustomerOrderAndFulfillment::CommonSchemaElements::CreditCardDetails^			CcInfo;
			
			//default constructor
			CustomerOrder()
			{
				OrderNumber = String::Empty;
				Rating = CustomerOrderAndFulfillment::Contract::CreditRating::Good ;
				AddressInfo = gcnew CustomerOrderAndFulfillment::CommonSchemaElements::Address() ;
				Orders = gcnew OrderItem_VECTOR() ;
				CcInfo = gcnew CustomerOrderAndFulfillment::CommonSchemaElements::CreditCardDetails() ;
			}
			
			//copy constuctor
			CustomerOrder( CustomerOrder%  rhs){*this = rhs;}
			
			//IClonable Override
			virtual	Object^ Clone()
			{
				CustomerOrder^	 instance = gcnew CustomerOrder() ;
				*instance = *this ;
				return instance;
			}
			
			//= operator
			CustomerOrder% operator = ( CustomerOrder%  rhs)
			{
				OrderNumber = rhs.OrderNumber ;
				Rating = rhs.Rating ;
				AddressInfo = safe_cast<CustomerOrderAndFulfillment::CommonSchemaElements::Address^>(rhs.AddressInfo->Clone()) ;
				Orders->AddRange(rhs.Orders) ;
				CcInfo = safe_cast<CustomerOrderAndFulfillment::CommonSchemaElements::CreditCardDetails^>(rhs.CcInfo->Clone()) ;
				return *this;
			}
			
			//DeepCopy
			void	DeepCopy ( CustomerOrder^  from)
			{
				OrderNumber = from->OrderNumber ;
				Rating = from->Rating ;
				AddressInfo->DeepCopy(from->AddressInfo) ;
				Orders->AddRange(from->Orders) ;
				CcInfo->DeepCopy(from->CcInfo) ;
			}
			
		};
	}
}


