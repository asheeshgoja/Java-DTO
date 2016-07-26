package fulfillmentCenter;

import java.io.File;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class PersistanceManager {
    
	private static ObjectContainer _container = null;
    
	public static ObjectContainer getContainer()
	{
		synchronized (PersistanceManager.class) {
			if(_container == null)
			{
		        String curDir = System.getProperty("user.dir");
		        _container = Db4oEmbedded.openFile(curDir + File.separator +  "FulfillmentCenter.dbo");
			}
		}
		return _container;
	}

}
