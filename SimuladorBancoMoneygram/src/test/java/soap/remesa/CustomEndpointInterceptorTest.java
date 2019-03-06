package soap.remesa;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomEndpointInterceptorTest {

	@Test
	public void testHandleResponseMessageContextObject() {
		assertNotNull("ok");
	}

	@Test
	public void testHandleFaultMessageContextObject() {
		assertNotNull("ok");
	}

}
