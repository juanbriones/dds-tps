package tests;

import static persistance.ModelManager.beginTransaction;
import static persistance.ModelManager.commit;
import static persistance.ModelManager.rollback;

import org.junit.After;
import org.junit.Before;

public abstract class PersistentTest {
	
	@Before
	public void init(){
		beginTransaction();		
	}
		
	@After
	public void finish() {
		//rollback();
		commit();
	}
	
}
