package fulfillmentCenter.serviceInterface;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.enums.EnumConverter;

public class CustomSingleValueConverter< T extends Enum<T> > extends EnumConverter implements SingleValueConverter 
{
	private Class<T> enumType;
	
	public static <V extends Enum<V>> SingleValueConverter create(Class<V> enumClass) { return new CustomSingleValueConverter<V>(enumClass); }
	
	private CustomSingleValueConverter(Class<T> newEnumType) { this.enumType = newEnumType; }
	
	@SuppressWarnings("unchecked")
	public boolean canConvert(Class type) { return type == enumType; }
	
	public Object fromString(String str) {
		Object r = null;
		
		try {
			Method m = enumType.getMethod("fromValue", String.class);
			r = m.invoke(null, str);		
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return r;	
	}
	
	public String toString(Object obj) 
	{ 
		return obj.toString();
	}	
}

